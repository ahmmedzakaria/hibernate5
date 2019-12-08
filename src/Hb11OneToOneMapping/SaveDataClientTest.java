/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb11OneToOneMapping;


import entity.AddressOneToOne;
import entity.EmployeeOneToOne;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class SaveDataClientTest {
    public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createEmployeeOneToOne(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }

	private static void createEmployeeOneToOne(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getEmployeeOneToOne());
		System.out.println("EmployeeOneToOne is created  with Id::"+id);
		session.getTransaction().commit();
		
	}
	
	private static EmployeeOneToOne getEmployeeOneToOne(){
		EmployeeOneToOne employee= new EmployeeOneToOne();
		employee.setEmployeeName("Barry Bingel");
		employee.setEmail("barry.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		
		AddressOneToOne address1 = new AddressOneToOne();
		address1.setCity("Chennai");
		address1.setPincode(9087727L);
		address1.setState("Tamilnadu");
		address1.setStreet("Park Street");
		
		employee.setAddress(address1);
		
		return employee;
}
}
