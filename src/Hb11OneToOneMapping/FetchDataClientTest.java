/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb11OneToOneMapping;


import entity.AddressOneToOne;
import entity.EmployeeOneToOne;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class FetchDataClientTest {
    public static void main(String[] args) {
		EmployeeOneToOne employee = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	employee = session.get(EmployeeOneToOne.class, 1);
	    	System.out.println(employee);
	    	AddressOneToOne address = employee.getAddress();
	    	System.out.println(address);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	    
}
}
