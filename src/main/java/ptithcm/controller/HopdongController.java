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
@RequestMapping("/hopdong/")
public class HopdongController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("show")
	public String show(ModelMap model, HttpServletRequest request, @ModelAttribute("hopdong") HOPDONG hopdong) {
		Session session = factory.getCurrentSession();
		String hql = "from HOPDONG where TRANGTHAI = TRUE";
		Query query = session.createQuery(hql);
		List<PHONG> list = query.list();

		PagedListHolder pagedListHolder1 = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder1.setPage(page);
		pagedListHolder1.setMaxLinkedPages(5);
		pagedListHolder1.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder1);
		return "hopdong/show";
	}

	@RequestMapping("show2")
	public String show1(ModelMap model, HttpServletRequest request, @ModelAttribute("hopdong") HOPDONG hopdong) {
		Session session = factory.getCurrentSession();
		String hql = "from HOPDONG where TRANGTHAI = FALSE";
		Query query = session.createQuery(hql);
		List<HOPDONG> list = query.list();
		PagedListHolder pagedListHolder1 = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder1.setPage(page);
		pagedListHolder1.setMaxLinkedPages(5);
		pagedListHolder1.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder1);
		return "hopdong/show2";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("hopdong", new HOPDONG());
		return "hopdong/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("hopdong") HOPDONG hopdong) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			hopdong.setTRANGTHAI(true);
			session.save(hopdong);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công!");
			model.addAttribute("check", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại!");
		} finally {
			session.close();
		}
		return "hopdong/insert";
	}

	@RequestMapping("hopdong/traphong/{MAHOPDONG}.htm")
	public String traphongForm(ModelMap model, @PathVariable String MAHOPDONG) {

		Session session = factory.openSession();

		String hql = "from HOPDONG WHERE MAHOPDONG='" + MAHOPDONG + "'";
		Query query = session.createQuery(hql);
		HOPDONG hdong = (HOPDONG) query.list().get(0);
		model.addAttribute("hopdong", hdong);

		return "hopdong/traphong";
	}

	@RequestMapping("hopdong/traphong/updated.htm")
	public String traphong(ModelMap model, @ModelAttribute("MAHOPDONG") HOPDONG hdong) {

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		hdong.setTRANGTHAI(false);
		hdong.setNGAYTRA(new Date());
		try {
			session.update(hdong);
			t.commit();
			model.addAttribute("message", "Trả phòng thành công!");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Trả phòng thất bại!");
		} finally {
			session.close();
		}
		return "hopdong/noti";
	}

	@RequestMapping("hopdong/delete/{MAHOPDONG}.htm")
	public String delete(ModelMap model, @ModelAttribute("hopdong") HOPDONG hopdong) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(hopdong);
			t.commit();
			model.addAttribute("message", "Xoá thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xoá thất bại !");
		} finally {
			session.close();
		}
		return "hopdong/noti";
	}

	@ModelAttribute("khachs")
	public List<KHACH> getKHACH() {
		Session session = factory.getCurrentSession();
		String hql = "FROM KHACH";
		Query query = session.createQuery(hql);
		List<KHACH> list = query.list();
		return list;
	}

	@ModelAttribute("phongs")
	public List<PHONG> getPHONG() {
		Session session = factory.getCurrentSession();
		String hql = "FROM PHONG WHERE SONGUOIHIENTAI < loaiphong.SONGUOITOIDA";
		Query query = session.createQuery(hql);
		List<PHONG> list = query.list();
		return list;
	}


	String k = "";
	@RequestMapping(value = "search")
	public String searchPro(HttpServletRequest request, ModelMap model, @ModelAttribute("hopdong") HOPDONG hopdong) {
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

		return "hopdong/search";
	}
	@RequestMapping(value = "search2")
	public String searchPro2(HttpServletRequest request, ModelMap model, @ModelAttribute("hopdong") HOPDONG hopdong) {
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

		return "hopdong/search2";
	}

public List<HOPDONG> searchP(String string) {
	Session session = factory.getCurrentSession();
	// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
	// "%'";
	String hql = "FROM HOPDONG where TRANGTHAI = TRUE AND  khach.MAKHACH LIKE  :p ";
	Query query = session.createQuery(hql);
	query.setParameter("p", "%" + string + "%");
	List<HOPDONG> list = query.list();
	return list;
}
public List<HOPDONG> searchP2(String string) {
	Session session = factory.getCurrentSession();
	// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
	// "%'";
	String hql = "FROM HOPDONG where TRANGTHAI = FALSE AND  khach.MAKHACH LIKE  :p ";
	Query query = session.createQuery(hql);
	query.setParameter("p", "%" + string + "%");
	List<HOPDONG> list = query.list();
	return list;
}
}
