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
@RequestMapping("/sudungdv/")
public class SudungdvController {
	@Autowired
	SessionFactory factory;

	@Transactional
	@RequestMapping("show")
	public String show(ModelMap model, HttpServletRequest request, @ModelAttribute("sudungdv") SUDUNGDV sudungdv) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SUDUNGDV WHERE NGAYKETTHUCSDDV > current_date()";
		Query query = session.createQuery(hql);
		List<SUDUNGDV> list = query.list();
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "sudungdv/show";
	}

	@RequestMapping("show2")
	public String show2(ModelMap model, HttpServletRequest request, @ModelAttribute("sudungdv") SUDUNGDV sudungdv) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SUDUNGDV WHERE NGAYKETTHUCSDDV <= current_date()";
		Query query = session.createQuery(hql);
		List<SUDUNGDV> list = query.list();
		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "sudungdv/show2";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("sudungdv", new SUDUNGDV());
		return "sudungdv/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("sudungdv") SUDUNGDV sudungdv) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(sudungdv);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công!");
			model.addAttribute("check", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại!");
		} finally {
			session.close();
		}
		return "sudungdv/insert";
	}

	@ModelAttribute("phongs")
	public List<PHONG> getPHONG() {
		Session session = factory.getCurrentSession();
		String hql = "FROM PHONG";
		Query query = session.createQuery(hql);
		List<PHONG> list = query.list();
		return list;
	}

	@ModelAttribute("dichvus")
	public List<DICHVU> getDICHVU() {
		Session session = factory.getCurrentSession();
		String hql = "FROM DICHVU";
		Query query = session.createQuery(hql);
		List<DICHVU> list = query.list();
		return list;
	}

	String k = "";

	@RequestMapping(value = "search")
	public String searchPro(HttpServletRequest request, ModelMap model, @ModelAttribute("sudungdv") SUDUNGDV sudungdv) {
		String n = request.getParameter("searchInput");
		if (n != null && n.equals(k) == false) {
			k = n;
		}
		System.out.print(k);
		PagedListHolder pagedListHolder = new PagedListHolder(this.searchP(k));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "sudungdv/search";
	}

	@RequestMapping(value = "search2")
	public String searchPro2(HttpServletRequest request, ModelMap model, @ModelAttribute("phong") PHONG phong) {
		String n = request.getParameter("searchInput");
		if (n != null && n.equals(k) == false) {
			k = n;
		}
		System.out.print(k);
		PagedListHolder pagedListHolder = new PagedListHolder(this.searchP2(k));
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);

		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);

		return "sudungdv/search2";
	}

	public List<SUDUNGDV> searchP(String p) {
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM SUDUNGDV WHERE NGAYKETTHUCSDDV > current_date()  and phong.MAPHONG LIKE :p ";
		Query query = session.createQuery(hql);
		query.setParameter("p", "%" + p + "%");
		List<SUDUNGDV> list = query.list();
		return list;
	}

	public List<SUDUNGDV> searchP2(String p) {
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM SUDUNGDV WHERE NGAYKETTHUCSDDV <= current_date() and phong.MAPHONG LIKE :p ";
		Query query = session.createQuery(hql);
		query.setParameter("p", "%" + p + "%");
		List<SUDUNGDV> list = query.list();
		return list;
	}
}
