package Hb18HqlJoinOneToOneMapping;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class HQLClientTest {

	public static void main(String[] args) {
		//getEmployeeAndAdressByEmployeeId();
		//getEmployeeAndAdressByAddressId();
                
                getEmployeeAndAdressByEmployeeId2();
	    
	  }

	private static void getEmployeeAndAdressByAddressId() {

	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	String HQL="FROM AddressJoin addr LEFT OUTER JOIN FETCH addr.employee WHERE addr.addressId=:addrId";
	    	AddressJoin address = session.createQuery(HQL, AddressJoin.class).setParameter("addrId", 1).uniqueResult();
	    	System.out.println(address);
	    	System.out.println(address.getEmployee());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}

	private static void getEmployeeAndAdressByEmployeeId() {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	String HQL="FROM EmployeeJoin emp LEFT JOIN FETCH emp.address WHERE  emp.employeeId=:empId";
	    	Query<EmployeeJoin> query = session.createQuery(HQL, EmployeeJoin.class);
	    	query.setParameter("empId", 1);
	    	EmployeeJoin employee = query.uniqueResult();
	    	System.out.println(employee);
	    	AddressJoin address = employee.getAddress();
	    	System.out.println(address);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
        
        private static void getEmployeeAndAdressByEmployeeId2() {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	String HQL="SELECT emp.employeeName,emp.doj,emp.salary,addr.city,addr.pincode "
	    			+ "FROM EmployeeJoin emp LEFT JOIN  emp.address addr WHERE  emp.employeeId=:empId";
	    	 Query<Object[]> query = session.createQuery(HQL);
	    	 query.setParameter("empId", 1);
	    	 List<Object[]> list = query.list();
	    	for (Object[] objects : list) {
				String employeeName =(String)objects[0];
				Date doj=(Date)objects[1];
				Double sal =(Double)objects[2];
				String city=(String)objects[3];
				Long pincode=(Long)objects[4];
				
				System.out.println(employeeName+"\t"+doj+"\t"+sal+"\t"+city+"\t"+pincode);
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
