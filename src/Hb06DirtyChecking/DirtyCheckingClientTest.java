/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb06DirtyChecking;

import entity.Employee;
import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class DirtyCheckingClientTest {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Employee employee = session.get(Employee.class, 1);
            if (employee != null) {
                session.beginTransaction();
                employee.setSalary(70000.00);
                employee.setEmployeeName("Arif Mridha");
                //session.update(employee);
                session.getTransaction().commit();
                //employee.setEmployeeName("Martin Bingel2");
            } else {
                System.out.println("Employee doesn't exist with provided Id..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
