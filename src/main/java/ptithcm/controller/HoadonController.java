package ptithcm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.*;

@Transactional
@Controller
@RequestMapping("/hoadon/")
public class HoadonController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("show")
	public String show(ModelMap model, HttpServletRequest request, @ModelAttribute("hoadon") HOADON hoadon) {
		Session session = factory.getCurrentSession();
		String hql = "from HOADON where TRANGTHAI = TRUE";
		Query query = session.createQuery(hql);
		List<HOADON> list = query.list();
		PagedListHolder pagedListHolder1 = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder1.setPage(page);
		pagedListHolder1.setMaxLinkedPages(5);
		pagedListHolder1.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder1);
		return "hoadon/show";
	}

	@RequestMapping("show2")
	public String show1(ModelMap model, HttpServletRequest request, @ModelAttribute("hoadon") HOADON hoadon) {
		Session session = factory.getCurrentSession();
		String hql = "from HOADON where TRANGTHAI = FALSE";
		Query query = session.createQuery(hql);
		List<HOADON> list = query.list();
		PagedListHolder pagedListHolder1 = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder1.setPage(page);
		pagedListHolder1.setMaxLinkedPages(5);
		pagedListHolder1.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder1);
		return "hoadon/show2";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("hoadon", new HOADON());
		return "hoadon/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("hoadon") HOADON hoadon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			hoadon.setTRANGTHAI(true);
			hoadon.setNGAYLAPHD(new Date());
			hoadon.setTIENDICHVU(0);
			hoadon.setTIENPHONG(0);
			hoadon.setTONGTIEN(0);
			session.save(hoadon);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công!");
			model.addAttribute("check", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại!");
		} finally {
			session.close();
		}
		return "hoadon/insert";
	}

	@RequestMapping("hoadon/delete/{MAHOADON}.htm")
	public String delete(ModelMap model, @ModelAttribute("hoadon") HOADON hoadon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(hoadon);
			t.commit();
			model.addAttribute("message", "Xoá thành công!");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xoá thất bại!");
		} finally {
			session.close();
		}
		return "hoadon/noti";
	}

	@RequestMapping("hoadon/thanhtoan/{MAHOADON}.htm")
	public String thanhtoanForm(ModelMap model, @PathVariable String MAHOADON) {

		Session session = factory.openSession();

		String hql = "from HOADON WHERE MAHOADON='" + MAHOADON + "'";
		Query query = session.createQuery(hql);
		HOADON hd = (HOADON) query.list().get(0);
		model.addAttribute("hoadon", hd);

		return "hoadon/thanhtoan";
	}

	@RequestMapping("hoadon/thanhtoan/updated.htm")
	public String thanhtoan(ModelMap model, @ModelAttribute("MAHOADON") HOADON hd) {

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		hd.setTRANGTHAI(false);
		try {
			session.update(hd);
			t.commit();
			model.addAttribute("message", "Đã thanh toán!");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thanh toán thất bại!");
		} finally {
			session.close();
		}
		return "hoadon/noti";
	}

	@ModelAttribute("hopdongs")
	public List<HOPDONG> getHOPDONG() {
		Session session = factory.getCurrentSession();
		String hql = "FROM HOPDONG where TRANGTHAI = TRUE";
		Query query = session.createQuery(hql);
		List<HOPDONG> list = query.list();
		return list;
	}
	String k = "";
	@RequestMapping(value = "search")
	public String searchPro(HttpServletRequest request, ModelMap model, @ModelAttribute("MAHOADON") HOADON hd) {
		String n = request.getParameter("searchInput");
		if (n != null && n.equals(k) == false) {
			k = n;
		}
		PagedListHolder pagedListHolder = new PagedListHolder(this.searchP(k));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "hoadon/search";
	}
	@RequestMapping(value = "search2")
	public String searchPro2(HttpServletRequest request, ModelMap model, @ModelAttribute("MAHOADON") HOADON hd) {
		String n = request.getParameter("searchInput");
		if (n != null && n.equals(k) == false) {
			k = n;
		}
		PagedListHolder pagedListHolder = new PagedListHolder(this.searchP2(k));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "hoadon/search2";
	}

	public List<HOADON> searchP(String string) {
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
//		String hql = "FROM HOADON where TRANGTHAI = TRUE and hopdong.MAHOPDONG LIKE :p OR HTTT LIKE  :p ";
		
		String hql = "FROM HOADON where TRANGTHAI = TRUE and  HTTT LIKE :p ";
		Query query = session.createQuery(hql);
		query.setParameter("p", "%" + string + "%");
		List<HOADON> list = query.list();
		return list;
	}
	public List<HOADON> searchP2(String string) {
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM HOADON where TRANGTHAI = FALSE and HTTT LIKE  :p ";
		Query query = session.createQuery(hql);
		query.setParameter("p", "%" + string + "%");
		List<HOADON> list = query.list();
		return list;
	}
	
}
