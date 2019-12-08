/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb03Save;

import entity.Employee;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;




public class ClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	Employee employee = getEmployee();
	    	session.beginTransaction();
	    	
	    	//session.persist(employee);
	    	Integer id =(Integer)session.save(employee);
	    	System.out.println("Employee is created  with Id::"+id);
	    	
	    	session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Zakaria Ahmmed");
		employee.setEmail("zakaria@gmail.com");
		employee.setSalary(80000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
