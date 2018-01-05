package com.spring.daos;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



//import com.mkyong.stock.Stock;
//import com.mkyong.util.HibernateUtil;
//import com.spring.model.Child;
//import com.spring.model.Parent;

@Component
public class SimpleDao {
/*	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public int addParent(Parent parent) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id =(Integer) session.save(parent);
		//int id = parent.getId();
		//System.out.println("dao"+id);
		tx.commit();
		session.close();
		System.out.println("inserted data successfully");
		return id;
	}
	
	

	public Parent find(Parent parent, int id) {
		System.out.println("find id"+id);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		parent = (Parent) session.get(Parent.class, id);
		System.out.println("parent is:"+parent.getId());
	
		
		return parent;
		
		
	}

	public int addChild(Child child) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id =(Integer) session.save(child);
		//int id = child.getId();
		//System.out.println("addChild() child id:"+child.getId());
		tx.commit();
		session.close();
		System.out.println("inserted Child successfully");
		return id;
	}
	@Transactional
	public Parent addAll(Parent parent) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(parent);
		int id = parent.getId();
		System.out.println("addAll() parent id:"+id);
		tx.commit();
		session.close();
		System.out.println("inserted Paent successfully");
		return parent;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Child> showChild() {
		Session session =sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		Query query =  session.createQuery("from Child");
		ArrayList<Child> childList = (ArrayList<Child>) query.list();
		return childList;
	}
	 @SuppressWarnings("unchecked")
	public ArrayList<Parent> find1(Parent parent) {
		
		Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		Query query = session.createQuery("form Parent");
		ArrayList<Parent> parentList = (ArrayList<Parent>) query.list();
		System.out.println("parent is:"+parent.getId());
		for (Parent parent2 : parentList) {
			System.out.println("parent id :"+parentList.add((Parent) Restrictions.eqOrIsNull( "id", parent2.getId())));
			System.out.println("Last name :"+parentList.add((Parent) Restrictions.eqOrIsNull( "lastname", parent2.getLastname())));
		}
		
		return parentList;
	}



	public Parent readparent(String lastName) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Parent WHERE LastName = '"+lastName+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		Parent obj = null;
		if(results.size()==0){
			return new Parent();
		}else{
			obj = (Parent) results.get(0);
		}
		session.close();
		return obj;
		
	}



	public Parent mergestock(Parent parent) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Parent parent1 =(Parent) session.merge(parent);
		//int id = child.getId();
		//System.out.println("addChild() child id:"+child.getId());
		tx.commit();
		session.close();
		System.out.println("inserted Child successfully");
		return parent1;
	}
*/




	
}
