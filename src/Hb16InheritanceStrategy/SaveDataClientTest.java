package Hb16InheritanceStrategy;



import java.math.BigDecimal;
import java.text.ParseException;

import org.hibernate.HibernateException;
import org.hibernate.Session;



public class SaveDataClientTest {

	public static void main(String[] args) throws ParseException {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	Person person = new Person();
			person.setName("Sudha Verma");
			person.setGender("Female");
			EmployeeInheritance employee = new EmployeeInheritance();
			employee.setBonus(new BigDecimal("277.389"));
			employee.setDeptName("IT");
			employee.setDoj(Util.getDoj("18/12/2015"));
			employee.setEmail("dipesh.cs@gmail.com");
			employee.setName("Dipesh");
			employee.setSalary(80000.2872);
			employee.setGender("Male");
			
			Student student = new Student();
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
