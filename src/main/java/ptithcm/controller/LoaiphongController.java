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

@Controller
@RequestMapping("/loaiphong/")
public class LoaiphongController {
	@Autowired
    SessionFactory factory;
    @Transactional
	@RequestMapping("show")
	public String show(ModelMap model ) {
		  Session session = factory.getCurrentSession(); 
		  String hql = "from LOAIPHONG";
		  Query query = session.createQuery(hql); 
		  List<LOAIPHONG> list = query.list();
		  model.addAttribute("loaiphongs", list);
         return "loaiphong/show";
    }
    
    @RequestMapping(value="insert", method=RequestMethod.GET)
    public String insert(ModelMap model) {
          model.addAttribute("loaiphong", new LOAIPHONG());
          return "loaiphong/insert";
    }
    
    @RequestMapping(value="insert", method=RequestMethod.POST)
    public String insert(ModelMap model, @ModelAttribute("loaiphong") LOAIPHONG loaiphong) {
          Session session = factory.openSession();
          Transaction t = session.beginTransaction();
          try {
                session.save(loaiphong);
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
          return "loaiphong/insert";
    }
    
    @RequestMapping("loaiphong/update/{MALOAIPHONG}.htm")
    public String updateForm(ModelMap model, @PathVariable String MALOAIPHONG) {
    	
          Session session = factory.openSession();
          
          String hql = "from LOAIPHONG WHERE MALOAIPHONG='"+MALOAIPHONG+"'";
		  Query query = session.createQuery(hql); 
		  LOAIPHONG lp = (LOAIPHONG) query.list().get(0);
		  model.addAttribute("loaiphong", lp);

    return "loaiphong/update";
    }
    
    @RequestMapping("loaiphong/update/updated.htm")
    public String updateForm(ModelMap model, @ModelAttribute("MALOAIPHONG") LOAIPHONG lp) {
    	
          Session session = factory.openSession();
          
          Transaction t = session.beginTransaction();
          try {
                session.update(lp);
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
    return "loaiphong/noti";
    }
    
    @RequestMapping("loaiphong/delete/{MALOAIPHONG}.htm")
    public String delete(ModelMap model, @ModelAttribute("loaiphong") LOAIPHONG loaiphong) {
    Session session = factory.openSession();
    Transaction t = session.beginTransaction();
    try {
         session.delete(loaiphong);
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
    return "loaiphong/noti";
    }
}
