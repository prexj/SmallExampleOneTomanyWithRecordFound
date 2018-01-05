package com.spring.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.daos.DoctorDao;
//import com.mkyong.stock.StockDailyRecord;
import com.spring.daos.SimpleDao;
//import com.spring.model.Child;
import com.spring.model.Doctor;
import com.spring.model.Drugs;
import com.spring.model.DrugsDoctorMapping;
//import com.spring.model.Parent;
import com.spring.model.ParentModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	//private SimpleDao simpleDao = new SimpleDao();
	private DoctorDao doctorDao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	
		
		return "doctor";
	}
	
	@RequestMapping(value = "doctorPage", method = RequestMethod.GET)
	public String doctorPage(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	
		
		return "doctor";
	}
	
	@RequestMapping(value = "drugPage", method = RequestMethod.GET)
	public String drugPage(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	
		
		return "drugs";
	}
	/*@RequestMapping(value = "insertData", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String insertData(@RequestParam("FirstName")String FirstName,
			@RequestParam("LastName")String LastName, Model model) {
		logger.info("Welcome insertData()");
		logger.info("FirstName"+FirstName);
		logger.info("LastName"+LastName);
		Drugs durgs = null;
		String result="";
		durgs = simpleDao.readparent(LastName);
		if(durgs.getId()==null || durgs.getId() == 0){
		
			durgs =new Drugs();
			durgs.setDrugsname(LastName);
								
								int id =simpleDao.addParent(parent);
								System.out.println("add parent id :"+id);
								System.out.println("parent id :"+parent.getId());
								//System.out.println("controller"+id);
								parent =simpleDao.find(parent,id);
								
								Child child = new Child();
								child.setFirstname(FirstName);
								child.setParent(parent);
								parent.getChildren().add(child);
								int id1= simpleDao.addChild(child);
								if((id>0)&&(id1>0)){
									System.out.println("Data Inserted SuccessFully");
									result="1";
								}else{
									System.out.println("Data don't inserted SuccessFully");
									result="1";
								}
							}else{
								
								Child child = new Child();
								child.setFirstname(FirstName);
								child.setParent(parent);
								int id =simpleDao.addChild(child);
								if(id>0){
									System.out.println("Data Inserted SuccessFully");
									result="1";
								}else{
									System.out.println("Data don't inserted SuccessFully");
									result="1";
								}
			
		}
		
		return result;
	}*/
	//insertDataDoctor
	
	@RequestMapping(value = "insertDataDoctor", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String insertDataDoctor(@RequestParam("FirstName")String FirstName,
			@RequestParam("ProvideDrug")String ProvideDrug,
			@RequestParam("drugsname")String drugsname, Model model) {
		logger.info("Welcome insertData()");
		logger.info("FirstName"+FirstName);
		logger.info("ProvideDrug"+ProvideDrug);
		logger.info("drugsname"+drugsname);
		Drugs durgs = null;
		Doctor doctor = null;
		String result="";
		int id=0;
		durgs = doctorDao.readDrug(drugsname);
		if(durgs.getId() !=null || durgs.getId() != 0) {
			doctor = doctorDao.readDoctor(FirstName);
			if(doctor.getId() ==null || doctor.getId() == 0) {
				System.out.println("doctor is new entry");
				doctor = new Doctor();
				doctor.setFirstname(FirstName);
				doctor.setProvideDrug(ProvideDrug);
				id =doctorDao.addDoctor(doctor);
				doctor =doctorDao.find(doctor,id);
				durgs = doctorDao.find(durgs,durgs.getId());
				DrugsDoctorMapping ddm = new DrugsDoctorMapping();
				ddm.setDoctor(doctor);
				ddm.setDrugs(durgs);
				doctor.getDrugsDoctorMapping().add(ddm);
				Integer ddmId1 = doctorDao.addDrugsDoctorMapping(ddm);
				DrugsDoctorMapping ddm1 = doctorDao.find(ddm, ddmId1);
				System.out.println("ddm1  id ::"+ddm1.getId());
				System.out.println("ddm1  id ::"+ddm1.getDoctor());
				System.out.println("ddm1  id ::"+ddm1.getDrugs());
				int i =doctorDao.updateAfterVal(ddm1.getDrugs().getId(),ProvideDrug,durgs.getBefortotal());
				if((ddmId1>0)&&(id>0)&&(i>0)){
					System.out.println("Data Inserted SuccessFully");
					result="1";
				}else{
					System.out.println("Data don't inserted SuccessFully");
					result="0";
				}
			}else {
				System.out.println("doctor is old entry");
				DrugsDoctorMapping ddm = new DrugsDoctorMapping();
				ddm.setDoctor(doctor);
				ddm.setDrugs(durgs);
				Integer ddmId1 = doctorDao.addDrugsDoctorMapping(ddm);
				DrugsDoctorMapping ddm1 = doctorDao.find(ddm, ddmId1);
				System.out.println("ddm1  id ::"+ddm1.getId());
				System.out.println("ddm1  id ::"+ddm1.getDoctor().getId());
				System.out.println("ddm1  id ::"+ddm1.getDrugs().getId());
				int i =doctorDao.updateAfterVal(ddm1.getDrugs().getId(),ProvideDrug,durgs.getAftertotal());
				if(ddmId1>0){
					System.out.println("Data Inserted SuccessFully");
					result="1";
				}else{
					System.out.println("Data don't inserted SuccessFully");
					result="0";
				}
			}
		}
		
		
		
		return result;
	
		
		
	}
	//drugsname,befortotal
	@RequestMapping(value = "insertDataDrug", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public String insertDataDrug(@RequestParam("drugsname")String drugsname,
			@RequestParam("befortotal")String befortotal, Model model) {
		logger.info("Welcome insertData()");
		logger.info("drugsname"+drugsname);
		logger.info("befortotal"+befortotal);
		Drugs durgs = null;
		String result="";
		
		Drugs drug = new Drugs();
		drug.setDrugsname(drugsname);
		drug.setBefortotal(befortotal);
		int id =doctorDao.addDrug(drug);
		if(id>0){
			System.out.println("Data Inserted SuccessFully");
			result="1";
		}else{
			System.out.println("Data don't inserted SuccessFully");
			result="1";
		}
		
		return result;
	
		
		
	}
	@RequestMapping(value = "showAllDrugs", method = RequestMethod.GET , produces="application/json")
	@ResponseBody
	public List<Drugs> showAllDrugs(Locale locale, Model model) {
		logger.info("Welcome showchild()");
	//	model.addAttribute("show", simpleDao.showChild());
		List<Drugs> drugslist= doctorDao.showAllDrugList();
		
		return drugslist;
	}
	@RequestMapping(value = "showAllDoctor", method = RequestMethod.GET , produces="application/json")
	@ResponseBody
	public List<Drugs> showAllDoctor(Locale locale, Model model) {
		logger.info("Welcome showchild()");
	//	model.addAttribute("show", simpleDao.showChild());
		List<Drugs> drugslist= doctorDao.showAllDrugList();
		
		return drugslist;
	}
	/*@RequestMapping(value = "showAllDrugs", method = RequestMethod.GET)
	public String showchild(Locale locale, Model model) {
		logger.info("Welcome showchild()");
		model.addAttribute("show", simpleDao.showChild());
	
		
		return "showStudent";
	}*/
	/*@RequestMapping(value = "addData", method = RequestMethod.POST)
	public String addData(@RequestParam("FirstName")String FirstName,
			@RequestParam("LastName")String LastName, Model model) {
		logger.info("Welcome addData()");
		logger.info("FirstName"+FirstName);
		logger.info("LastName"+LastName);
		Parent parent = null;
		
		parent = simpleDao.readparent(LastName);
		if(parent.getId()==null || parent.getId() == 0){
		
								parent =new Parent();
								parent.setLastname(LastName);
								
								
								
								int id =simpleDao.addParent(parent);
								System.out.println("add parent id :"+id);
								System.out.println("parent id :"+parent.getId());
								//System.out.println("controller"+id);
								parent =simpleDao.find(parent,id);
								
								Child child = new Child();
								child.setFirstname(FirstName);
								child.setParent(parent);
								parent.getChildren().add(child);
								simpleDao.addChild(child);
							}else{
								
								Child child = new Child();
								child.setFirstname(FirstName);
								child.setParent(parent);
								simpleDao.addChild(child);
			
		}
		return "redirect:showchild";
	}*/
	
	/*@RequestMapping(value = "showchild", method = RequestMethod.GET)
	public String showchild(Locale locale, Model model) {
		logger.info("Welcome showchild()");
		model.addAttribute("show", simpleDao.showChild());
	
		
		return "showStudent";
	}
	@RequestMapping(value = "showAll", method = RequestMethod.GET , produces="application/json")
	@ResponseBody
	public ArrayList<Child> showAll(Locale locale, Model model) {
		logger.info("Welcome showchild()");
	//	model.addAttribute("show", simpleDao.showChild());
		ArrayList<Child> childlist= simpleDao.showChild();
		
		return childlist;
	}*/
	
	/*@RequestMapping(value = "addAll", method = RequestMethod.POST)
	public String addAll(@RequestParam("FirstName")String FirstName,
			@RequestParam("LastName")String LastName, Model model) {
		logger.info("Welcome addAll()");
		logger.info("FirstName"+FirstName);
		logger.info("LastName"+LastName);
		
		Parent parent =new Parent();
		parent.setLastname(LastName);
		
		simpleDao.addAll(parent);
		
		System.out.println("aaa First Name ==="+FirstName);
		
		Child child = new Child();
		child.setParent(parent);
		child.setFirstname(FirstName);
		List<Child> clist = new ArrayList<Child>();
		child.setParent(parent);//
		clist.add(child);
		parent.setChildren(clist);
		//simpleDao.addChild(9,child);
		//simpleDao.addParent(parent);
		
		System.out.println("OK");
		
		return "redirect:showchild";
	}*/
}
