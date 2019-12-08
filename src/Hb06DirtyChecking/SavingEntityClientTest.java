/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb06DirtyChecking;

import entity.Employee;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class SavingEntityClientTest {
    public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			createEmployee(session);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
	  }

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getEmployee());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
	}
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Martin Bingel");
		employee.setEmail("martin.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
}
}
