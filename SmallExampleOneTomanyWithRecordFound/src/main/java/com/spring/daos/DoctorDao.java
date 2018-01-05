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
import com.spring.model.Doctor;
import com.spring.model.Drugs;
//import com.spring.model.Parent;
import com.spring.model.DrugsDoctorMapping;

@Component
public class DoctorDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/*@Transactional
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
	}*/
	
	

	/*public Parent find(Parent parent, int id) {
		System.out.println("find id"+id);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		parent = (Parent) session.get(Parent.class, id);
		System.out.println("parent is:"+parent.getId());
	
		
		return parent;
		
		
	}*/

	public int addDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id =(Integer) session.save(doctor);
		//int id = child.getId();
		//System.out.println("addChild() child id:"+child.getId());
		tx.commit();
		session.close();
		System.out.println("inserted doctor successfully");
		return id;
	}
	
	
	public int addDrug(Drugs drugs) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int id =(Integer) session.save(drugs);
		//int id = child.getId();
		//System.out.println("addChild() child id:"+child.getId());
		tx.commit();
		session.close();
		System.out.println("inserted drugs successfully");
		return id;
	}
	/*@Transactional
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
	}*/
	/*@SuppressWarnings("unchecked")
	public ArrayList<Child> showChild() {
		Session session =sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		Query query =  session.createQuery("from Child");
		ArrayList<Child> childList = (ArrayList<Child>) query.list();
		return childList;
	}*/
	 /*@SuppressWarnings("unchecked")
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
	}*/


	public Drugs readDrug(String drugsname) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Drugs WHERE drugsname = '"+drugsname+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		Drugs obj = null;
		if(results.size()==0){
			return new Drugs();
		}else{
			obj = (Drugs) results.get(0);
		}
		session.close();
		return obj;
	}


	public Doctor readDoctor(String firstName) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Doctor WHERE firstname = '"+firstName+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		Doctor obj = null;
		if(results.size()==0){
			return new Doctor();
		}else{
			obj = (Doctor) results.get(0);
		}
		session.close();
		return obj;
	}


	public Doctor find(Doctor doctor, int id) {
		System.out.println("find id"+id);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		doctor = (Doctor) session.get(Doctor.class, id);
		System.out.println("parent is:"+doctor.getId());
	
		
		return doctor;
	}


	public Drugs find(Drugs durgs, Integer id) {
		System.out.println("find id"+id);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		durgs = (Drugs) session.get(Drugs.class, id);
		System.out.println("parent is:"+durgs.getId());
	
		
		return durgs;
	}


	public Integer addDrugsDoctorMapping(DrugsDoctorMapping ddm) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Integer id =(Integer) session.save(ddm);
		//int id = child.getId();
		System.out.println("addDrugsDoctorMapping() DrugsDoctorMapping id:"+id);
		tx.commit();
		session.close();
		System.out.println("inserted drugs successfully");
		return id;
		
	}


	public DrugsDoctorMapping find(DrugsDoctorMapping ddm, Integer ddmId) {
		System.out.println("find id"+ddmId);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ddm = (DrugsDoctorMapping) session.get(DrugsDoctorMapping.class, ddmId);
		System.out.println("DrugsDoctorMapping is:"+ddm.getId());
		return ddm;
	}


	public int updateAfterVal(Integer id, String provideDrug, String beforeTotal) {
			Integer before=Integer.parseInt(beforeTotal);
			Integer provideD=Integer.parseInt(provideDrug);
			String afterD = String.valueOf(before-provideD);
			System.out.println("afterD  :: "+afterD);
		 	Session session= sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "Update Drugs set aftertotal = :provideDrug where id = "+id;
			Query query = session.createQuery(hql);
			query.setParameter("provideDrug",afterD);
			int i = query.executeUpdate();
			System.out.println("i is :::"+i);
			
			tx.commit();
			
			if(i>0){
				i = 1;
			}else{
				i=0;
			}
			  session.close();
			return i;
		
	}

	@SuppressWarnings("unchecked")
	public List<Drugs> showAllDrugList() {
		Session session =sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		Query query =  session.createQuery("from Drugs");
		List<Drugs> drugList = (List<Drugs>) query.list();
		return drugList;
	}


	


	/*public Drugs readDrug(String drugsname) {
		// TODO Auto-generated method stub
		return null;
	}*/



	/*public Parent readparent(String lastName) {
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
		
	}*/



	/*public Parent mergestock(Parent parent) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Parent parent1 =(Parent) session.merge(parent);
		//int id = child.getId();
		//System.out.println("addChild() child id:"+child.getId());
		tx.commit();
		session.close();
		System.out.println("inserted Child successfully");
		return parent1;
	}*/
	
}
