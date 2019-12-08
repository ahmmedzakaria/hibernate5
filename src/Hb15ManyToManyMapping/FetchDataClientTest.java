/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb15ManyToManyMapping;

import entity.EmployeeMayToMany;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class FetchDataClientTest {

   public static void main(String[] args) {
		getEmployeeAndAdressByEmployeeId();
	    
	  }

	private static void getEmployeeAndAdressByEmployeeId() {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	EmployeeMayToMany employee2 = session.get(EmployeeMayToMany.class , 1);
	    	System.out.println(employee2);
	    	if(employee2 != null){
	    		employee2.getAddressList().forEach(System.out::println);
	    	}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
}
}
