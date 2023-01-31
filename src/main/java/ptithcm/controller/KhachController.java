package ptithcm.controller;

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
@RequestMapping("/khach/")
public class KhachController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("show")
	public String show(ModelMap model, HttpServletRequest request, @ModelAttribute("khach") KHACH khach) {
		Session session = factory.getCurrentSession();
		String hql = "from KHACH";
		Query query = session.createQuery(hql);
		List<PHONG> list = query.list();

		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "k", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "khach/show";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("khach", new KHACH());
		return "khach/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("khach") KHACH khach) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(khach);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công!");
			model.addAttribute("check",1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại!");
		} finally {
			session.close();
		}
		return "khach/insert";
	}

	@RequestMapping("khach/delete/{MAKHACH}.htm")
	public String delete(ModelMap model, @ModelAttribute("khach") KHACH khach) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(khach);
			t.commit();
			model.addAttribute("message", "Xoá thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xoá thất bại !");
		} finally {
			session.close();
		}
		return "khach/noti";
	}

	@RequestMapping("khach/update/{MAKHACH}.htm")
	public String updateForm(ModelMap model, @PathVariable String MAKHACH) {

		Session session = factory.openSession();

		String hql = "from KHACH WHERE MAKHACH='" + MAKHACH + "'";
		Query query = session.createQuery(hql);
		KHACH k = (KHACH) query.list().get(0);
		/*
		 * System.out.println("Dich vu: "+dv.getMADV());
		 * System.out.println("Dich vu: "+dv.getTENDV());
		 * System.out.println("Dich vu: "+dv.getDONGIA());
		 */

		model.addAttribute("khach", k);

		return "khach/update";
	}

	@RequestMapping("khach/update/updated.htm")
	public String updateForm(ModelMap model, @ModelAttribute("MAKHACH") KHACH k) {

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		try {
			session.update(k);
			t.commit();
			model.addAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Cập nhật thất bại!");
		} finally {
			session.close();
		}
		return "khach/noti";
	}
	String k = "";
	@RequestMapping(value = "search")
	public String searchK(HttpServletRequest request, ModelMap model, @ModelAttribute("khach") KHACH khach) {
		String n = request.getParameter("searchInput");

		if (n != null && n.equals(k) == false) {
			k = n;
		}
		System.out.print(k);
		PagedListHolder pagedListHolder = new PagedListHolder(this.searchK(k));
		int page = ServletRequestUtils.getIntParameter(request, "k", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);

		pagedListHolder.setPageSize(5);
		model.addAttribute("btnName", "Thêm");
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "khach/search";
	}
	public List<KHACH> getlist() {
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM KHACH";
		Query query = session.createQuery(hql);
		List<KHACH> list = query.list();
		return list;
	}
	public List<KHACH> searchK(String p) {
		if (p == null || p.isEmpty()) {
			getlist();
		}
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM KHACH where HOVATEN LIKE :p or GIOITINH LIKE :p or NGHENGHIEP LIKE :p or DIACHI LIKE :p";
		Query query = session.createQuery(hql);
		query.setParameter("p", "%" + p + "%");
		List<KHACH> list = query.list();
		return list;
	}
}