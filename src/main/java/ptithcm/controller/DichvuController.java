package ptithcm.controller;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.*;
@Transactional
@Controller
@RequestMapping("/dichvu/")
public class DichvuController {
	@Autowired
    SessionFactory factory;
	@RequestMapping("show")
	public String show(ModelMap model ) {
		  Session session = factory.getCurrentSession(); 
		  String hql = "from DICHVU";
		  Query query = session.createQuery(hql); 
		  List<DICHVU> list = query.list();
		  model.addAttribute("dichvus", list);
         return "dichvu/show";
    }
    
    @RequestMapping(value="insert", method=RequestMethod.GET)
    public String insert(ModelMap model) {
          model.addAttribute("dichvu", new DICHVU());
          return "dichvu/insert";
    }
    
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String insert(ModelMap model, @ModelAttribute("dichvu") DICHVU dichvu) {
          Session session = factory.openSession();
          Transaction t = session.beginTransaction();
          try {
                session.save(dichvu);
                t.commit();
                model.addAttribute("message", "Thêm mới thành công!");
                model.addAttribute("check",1);
          }
          catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Thêm mới thất bại!");
          }
          finally {
                session.close();
          }
          return "dichvu/insert";
    }
    
    @RequestMapping("dichvu/delete/{MADV}.htm")
    public String delete(ModelMap model, @ModelAttribute("dichvu") DICHVU dichvu) {
    Session session = factory.openSession();
    Transaction t = session.beginTransaction();
    try {
         session.delete(dichvu);
         t.commit();
         model.addAttribute("message", "Xoá thành công !");
	      }
	      catch (Exception e) {
	           t.rollback();
	           model.addAttribute("message", "Xoá thất bại !");
	      }
	      finally {
	           session.close();
	      }
    return "dichvu/noti";
    }
       
    @RequestMapping("dichvu/update/{MADV}.htm")
    public String updateForm(ModelMap model, @PathVariable String MADV) {
    	
          Session session = factory.openSession();
          
          String hql = "from DICHVU WHERE MADV='"+MADV+"'";
		  Query query = session.createQuery(hql); 
		  DICHVU dv = (DICHVU) query.list().get(0);
			/*
			 * System.out.println("Dich vu: "+dv.getMADV());
			 * System.out.println("Dich vu: "+dv.getTENDV());
			 * System.out.println("Dich vu: "+dv.getDONGIA());
			 */
          
		  model.addAttribute("dichvu", dv);

    return "dichvu/update";
    }
    
    @RequestMapping("dichvu/update/updated.htm")
    public String updateForm(ModelMap model, @ModelAttribute("MADV") DICHVU dv) {
    	
          Session session = factory.openSession();
          
          Transaction t = session.beginTransaction();
          try {
                session.update(dv);
                t.commit();
                model.addAttribute("message", "Cập nhật thành công!");
          }
          catch (Exception e) {
                t.rollback();
                model.addAttribute("message", "Cập nhật thất bại!");
          }
          finally {
                session.close();
          }
    return "dichvu/noti";
    }
    
}
