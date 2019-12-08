package Hb18HqlJoinOneToOneMapping;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class SaveDataClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
	    	EmployeeJoin employee= new EmployeeJoin();
			employee.setEmployeeName("Barry Bingel");
			employee.setEmail("barry.cs2017@gmail.com");
			employee.setSalary(50000.00);
			employee.setDoj(new Date());
			
			AddressJoin address1 = new AddressJoin();
			address1.setCity("Chennai");
			address1.setPincode(9087727L);
			address1.setState("Tamilnadu");
			address1.setStreet("Park Street");
			
			employee.setAddress(address1);
			//Integer id =(Integer)session.save(employee);
			//System.out.println("Employee is created  with Id::"+id);
			//session.save(address1);
			//session.save(employee);
			
			session.persist(employee);
			//session.save(address1);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}
