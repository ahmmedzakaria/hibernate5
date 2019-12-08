package Hb19HqlJoinOneToMany;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class SaveDataClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
	    	EmployeeJoinOTM employee= new EmployeeJoinOTM();
			employee.setEmployeeName("Barry Bingel");
			employee.setEmail("barry.cs2017@gmail.com");
			employee.setSalary(50000.00);
			employee.setDoj(new Date());
			
			AddressJoinOTM address1 = new AddressJoinOTM();
			address1.setCity("Chennai");
			address1.setPincode(9087727L);
			address1.setState("Tamilnadu");
			address1.setStreet("Park Street");
			
			AddressJoinOTM address2 = new AddressJoinOTM();
			address2.setCity("Pune");
			address2.setPincode(9000027L);
			address2.setState("MH");
			address2.setStreet("XYZ Street");
			
			employee.getAddressList().add(address1);
			employee.getAddressList().add(address2);
			
			address1.setEmployee(employee);
			address2.setEmployee(employee);
			
			session.persist(employee);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}
