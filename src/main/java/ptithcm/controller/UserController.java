package ptithcm.controller;


import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javassist.expr.NewArray;

import ptithcm.entity.TaiKhoan;

@Transactional
@Controller
@RequestMapping("/login/")
public class UserController {

	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String showLogin(ModelMap model, @ModelAttribute("user") TaiKhoan taiKhoan) {
		return "index";
	}

	@RequestMapping(value = "index", method = RequestMethod.POST)
	public String showIndex(ModelMap model, @ModelAttribute("user") TaiKhoan taiKhoan, HttpSession ss) {
		
		try {
			taiKhoan = this.getDangNhap(taiKhoan.getTaiKhoan(), taiKhoan.getMatKhau());
			model.addAttribute("user", taiKhoan);
			
			ss.setAttribute("DangNhap", "user");

			return "redirect:/phong/show.htm";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Sai mật khẩu hoặc tài khoản!");

			model.addAttribute("check", 0);
			return "index";
		}
	}

	
	
	@RequestMapping("exit")
	public String logout(HttpSession ss) {
		ss.removeAttribute("DangNhap");
		return "redirect:/login/index.htm";
	}
	public TaiKhoan getDangNhap(String taiKhoan, String matKhau) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan d WHERE d.taiKhoan= :taiKhoan AND d.matKhau= :matKhau";
		Query query = session.createQuery(hql);
		query.setParameter("taiKhoan", taiKhoan);
		query.setParameter("matKhau", matKhau);
		TaiKhoan dangNhap = (TaiKhoan) query.list().get(0);
		return dangNhap;
	}
	public TaiKhoan getDangNhapbyTaiKhoan(String taiKhoan) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan d WHERE d.taiKhoan= :taiKhoan ";
		Query query = session.createQuery(hql);
		query.setParameter("taiKhoan", taiKhoan);
		TaiKhoan dangNhap = (TaiKhoan) query.list().get(0);
		return dangNhap;
	}


	@RequestMapping(value = "forgotpw", method = RequestMethod.GET)
	public String showFormForgotpw(ModelMap model) {
		model.addAttribute("show", "sendCode");
		return "login/forgotpw";
	}

	@Autowired
	JavaMailSender mailer;
	public static String checkCode;
	public static String tk;
	@RequestMapping(value = "sendcode", method = RequestMethod.POST)
	public String send(ModelMap model, @RequestParam("taiKhoan") String id ) {
		TaiKhoan taiKhoan;
		try {
			taiKhoan = this.getDangNhapbyTaiKhoan(id);
			
			 
		} catch (Exception e) {
			model.addAttribute("message","Tài khoản không tồn tại !");
			model.addAttribute("show", "sendCode");
			return "login/forgotpw";
		}
		tk = id;
			
		System.out.println("a1");
		
		// Random VerifyCode
		checkCode = RandomStringUtils.randomAlphanumeric(9);
		String body = "Your confirm code: " + checkCode;
		String subject = "Validation Code";
		try {
			// Create mail
			MimeMessage mail = mailer.createMimeMessage();
			// Use class Helper
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom("Admin", "Admin");
			helper.setTo("Undisclosed Recipients"+"<"+taiKhoan.getTaiKhoan()+">");
			helper.setSubject(subject);
			helper.setText(body, true);
			// Send mail
			
			mailer.send(mail);
			model.addAttribute("message", "Đã gửi mã xác nhận đến " + taiKhoan.getTaiKhoan());
			System.out.println("b");
			model.addAttribute("show", "confirmCode");
			System.out.println("a");
			model.addAttribute("check", "success");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("message", "Send code fail");
			
			model.addAttribute("show", "sendCode");
		}
		return "login/forgotpw";
	}

	@RequestMapping(value = "confirmcode.htm", method=RequestMethod.POST)
	public String confirm(ModelMap model,
			@RequestParam("confirmCode") String confirmCode) {
		
		confirmCode=confirmCode.trim();
		//System.out.println(confirmCode);
		
		if (confirmCode.equals(checkCode)) {
			model.addAttribute("show", "newPassword");
		} else {
			model.addAttribute("message", "Mã xác nhận không hợp lế!");
			model.addAttribute("show", "confirmCode");
		}
		return "login/forgotpw";
	}

	@RequestMapping(value = "newpw.htm", method=RequestMethod.POST)
	public String newpw(ModelMap model, @RequestParam("newpw") String newpw,
			@RequestParam("confirmpw") String confirmpw) {
		
		if (newpw.equals(confirmpw)) {
			TaiKhoan dangNhap = this.getDangNhapbyTaiKhoan(tk);
			dangNhap.setMatKhau(newpw);
			Integer update = this.updateDangNhap(dangNhap);
			model.addAttribute("message", "Mật khẩu đã được thay đổi!");
			model.addAttribute("check","success");
		} else {
			model.addAttribute("message", "Mật khẩu xác nhận phải trùng với mật khẩu mới!");
			model.addAttribute("check","fail");
		}
		model.addAttribute("show", "newPassword");
		return "login/forgotpw";
	}

//
//	public NhanVien getNhanVienByID(Integer id) {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM NhanVien n WHERE n.maNV= :id";
//		Query quey = session.createQuery(hql);
//		quey.setParameter("id", id);
//
//		NhanVien nhanVien = (NhanVien) quey.list().get(0);
//		return nhanVien;
//	}
//
//	public Integer updateDangNhap(DangNhap dangNhap) {
//		Session session = factory.openSession();
//		Transaction t = session.beginTransaction();
//		try {
//			session.update(dangNhap);
//			t.commit();
//		} catch (Exception e) {
//			t.rollback();
//			e.printStackTrace();
//			return 0;
//		} finally {
//			session.close();
//		}
//		return 1;
//	}
	
	
	public Integer updateDangNhap(TaiKhoan dangNhap) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(dangNhap);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			// TODO: handle finally clause
			session.close();
		}
		return 1;
	}
}

