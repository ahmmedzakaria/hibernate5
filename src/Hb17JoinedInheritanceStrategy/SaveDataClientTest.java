package Hb17JoinedInheritanceStrategy;

import java.math.BigDecimal;
import java.text.ParseException;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class SaveDataClientTest {

	public static void main(String[] args) throws ParseException {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	PersonJI person = new PersonJI();
			person.setName("Sudha Verma");
			person.setGender("Female");
			
			EmployeeJI employee = new EmployeeJI();
			employee.setBonus(new BigDecimal("277.389"));
			employee.setDeptName("IT");
			employee.setDoj(Util.getDoj("18/12/2015"));
			employee.setEmail("dipesh.cs@gmail.com");
			employee.setName("Dipesh");
			employee.setSalary(80000.2872);
			employee.setGender("Male");
			
			StudentJI student = new StudentJI();
			student.setName("Shuruti");
			student.setGender("Female");
			student.setFee(20000.00f);
			student.setSchoolName("DPS");
			student.setSectionName("12th Std");
			
			session.beginTransaction();
			session.save(person);
			session.save(student);
			session.save(employee);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}
