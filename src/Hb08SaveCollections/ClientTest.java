/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb08SaveCollections;

import entity.Address;
import entity.EmployeeAddressCollections;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClientTest {

    public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createEmployeeAddressCollections(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }

	private static void createEmployeeAddressCollections(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getEmployeeAddressCollections());
		System.out.println("EmployeeAddressCollections is created  with Id::"+id);
		session.getTransaction().commit();
		
	}
	
	private static EmployeeAddressCollections getEmployeeAddressCollections(){
		EmployeeAddressCollections employee= new EmployeeAddressCollections();
		employee.setEmployeeName("Barry Bingel");
		employee.setEmail("barry.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		
		Address address1 = new Address();
		address1.setCity("Chennai");
		address1.setPincode(9087727L);
		address1.setState("Tamilnadu");
		address1.setStreet("Park Street");
		
		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setPincode(90870988L);
		address2.setState("MH");
		address2.setStreet("XYZ Street");
		
		employee.getAddressList().add(address1);
		employee.getAddressList().add(address2);
		
		return employee;
}
}
