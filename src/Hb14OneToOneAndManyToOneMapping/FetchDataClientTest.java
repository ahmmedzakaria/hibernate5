/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb14OneToOneAndManyToOneMapping;

import entity.AddressOneToOneOneToMany;
import entity.EmployeeOneToOneAndOneToMany;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class FetchDataClientTest {

    public static void main(String[] args) {
        //getEmployeeAndAdressByEmployeeId();
        getEmployeeAndAdressByAddressId();

    }

    private static void getEmployeeAndAdressByAddressId() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            AddressOneToOneOneToMany address = session.get(AddressOneToOneOneToMany.class, 1);
            System.out.println(address);
            if (address != null) {
                System.out.println(address.getEmployee());
            }
            System.out.println();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    private static void getEmployeeAndAdressByEmployeeId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            EmployeeOneToOneAndOneToMany employee2 = session.get(EmployeeOneToOneAndOneToMany.class, 1);
            System.out.println(employee2);
            if (employee2 != null) {
                employee2.getAddressList().forEach(System.out::println);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
