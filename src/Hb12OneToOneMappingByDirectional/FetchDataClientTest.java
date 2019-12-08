/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb12OneToOneMappingByDirectional;

import entity.AddressOneToOneByDirectional;
import entity.EmployeeOneToOneByDirectional;
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

            AddressOneToOneByDirectional address = session.get(AddressOneToOneByDirectional.class, 1);
            System.out.println(address);
            System.out.println(address.getEmployee());
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    private static void getEmployeeAndAdressByEmployeeId() {
        EmployeeOneToOneByDirectional employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(EmployeeOneToOneByDirectional.class, 1);
            System.out.println(employee);
            AddressOneToOneByDirectional address = employee.getAddress();
            System.out.println(address);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
