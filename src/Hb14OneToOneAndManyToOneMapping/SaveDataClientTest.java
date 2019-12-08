/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb14OneToOneAndManyToOneMapping;

import entity.AddressOneToOneOneToMany;
import entity.EmployeeOneToOneAndOneToMany;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class SaveDataClientTest {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            EmployeeOneToOneAndOneToMany employee = new EmployeeOneToOneAndOneToMany();
            employee.setEmployeeName("Barry Bingel");
            employee.setEmail("barry.cs2017@gmail.com");
            employee.setSalary(50000.00);
            employee.setDoj(new Date());

            AddressOneToOneOneToMany address1 = new AddressOneToOneOneToMany();
            address1.setCity("Chennai");
            address1.setPincode(9087727L);
            address1.setState("Tamilnadu");
            address1.setStreet("Park Street");

            AddressOneToOneOneToMany address2 = new AddressOneToOneOneToMany();
            address2.setCity("Pube");
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
