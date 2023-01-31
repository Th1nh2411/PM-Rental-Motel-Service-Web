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
@RequestMapping("/phong/")
public class PhongController {
	@Autowired
	SessionFactory factory;

	@Transactional
	@RequestMapping("show")
	public String show(ModelMap model, HttpServletRequest request, @ModelAttribute("phong") PHONG phong) {
		Session session = factory.getCurrentSession();
		String hql = "FROM PHONG " + "WHERE SONGUOIHIENTAI < loaiphong.SONGUOITOIDA";
		Query query = session.createQuery(hql);
		List<PHONG> list = query.list();

		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "phong/show";
	}

	@RequestMapping("show2")
	public String show2(ModelMap model, HttpServletRequest request, @ModelAttribute("phong") PHONG phong) {
		Session session = factory.getCurrentSession();
		String hql = "FROM PHONG " + "WHERE SONGUOIHIENTAI = 0";
		Query query = session.createQuery(hql);
		List<PHONG> list = query.list();

		PagedListHolder pagedListHolder = new PagedListHolder(list);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		model.addAttribute("pagedListHolder", pagedListHolder);
		return "phong/show2";
	}
//	@RequestMapping("show")
//	public String show(ModelMap model ) {
//    	List<PHONG> list = getGiaphong();
//		  model.addAttribute("phongs", list);
//         return "phong/show";
//    }

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("phong", new PHONG());
		return "phong/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("phong") PHONG phong) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			phong.setTRANGTHAI(true);
			phong.setSONGUOIHIENTAI(0);
			session.save(phong);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công!");
			model.addAttribute("check", 1);
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại!");
		} finally {
			session.close();
		}
		return "phong/insert";
	}

	@RequestMapping("phong/update/{MAPHONG}.htm")
	public String updateForm(ModelMap model, @PathVariable String MAPHONG) {

		Session session = factory.openSession();

		String hql = "from PHONG WHERE MAPHONG='" + MAPHONG + "'";
		Query query = session.createQuery(hql);
		PHONG p = (PHONG) query.list().get(0);
		model.addAttribute("phong", p);
		model.addAttribute("nameP", MAPHONG);

		return "phong/update";
	}

	@RequestMapping("phong/update/updated.htm")
	public String updateForm(ModelMap model, @ModelAttribute("MAPHONG") PHONG p) {

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		try {
			session.update(p);
			t.commit();
			model.addAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Cập nhật thất bại!");
		} finally {
			session.close();
		}
		return "phong/noti";
	}

	String k = "";

	@RequestMapping(value = "search")
	public String searchPro(HttpServletRequest request, ModelMap model, @ModelAttribute("phong") PHONG phong) {
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

		return "phong/search";
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

		return "phong/search2";
	}

	public List<PHONG> searchP(String p) {
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM PHONG where SONGUOIHIENTAI < loaiphong.SONGUOITOIDA  and loaiphong.TENLOAIPHONG LIKE :p ";
		Query query = session.createQuery(hql);
		query.setParameter("p", "%" + p + "%");
		List<PHONG> list = query.list();
		return list;
	}
	public List<PHONG> searchP2(String p) {
		Session session = factory.getCurrentSession();
		// String hql = "FROM ProductsEntity where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM PHONG where SONGUOIHIENTAI = 0 and loaiphong.TENLOAIPHONG LIKE :p ";
		Query query = session.createQuery(hql);
		query.setParameter("p", "%" + p + "%");
		List<PHONG> list = query.list();
		return list;
	}

//    public List<PHONG> getGiaphong() {
//    	Session session = factory.getCurrentSession();
//    	String hql= "FROM PHONG";
//    	Query query = session.createQuery(hql);
//    	List<PHONG> list = query.list();
//    	return list;
//    }

	@ModelAttribute("loaiphongs")
	public List<LOAIPHONG> getLOAIPHONG() {
		Session session = factory.getCurrentSession();
		String hql = "FROM LOAIPHONG";
		Query query = session.createQuery(hql);
		List<LOAIPHONG> list = query.list();
		return list;
	}
}
