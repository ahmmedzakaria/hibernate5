/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb10LazyAndEagerLoading;

import entity.EmployeeAddressCollectionPk;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class FetchDataClientTest {

    public static void main(String[] args) throws Exception {
        getEmployeeWithAddresses();
        
        //For Eger Load you Have to enable @ElementCollection(fetch = FetchType.EAGER) in EmployeeAddressCollectionPk class
        //hibernate will perform join querey
        //egerLoad ();
    }

    private static void getEmployeeWithAddresses() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            EmployeeAddressCollectionPk employee = session.get(EmployeeAddressCollectionPk.class, 1);
            System.out.println(employee);
            if(employee!=null){
                employee.getAddressList().forEach(System.out::println);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void egerLoad() throws Exception {
        EmployeeAddressCollectionPk employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            employee = session.get(EmployeeAddressCollectionPk.class, 1);
            System.out.println(employee);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        if (employee != null) {
            employee.getAddressList().forEach(System.out::println);
        }
    }
}
