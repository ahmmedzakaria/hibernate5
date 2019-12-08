/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb07EmbeddingObject;

import entity.Address;
import entity.EmployeeEmbed;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClientTest {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            createEmployeeEmbed(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployeeEmbed(Session session) {
        session.beginTransaction();
        Integer id = (Integer) session.save(getEmployeeEmbed());
        System.out.println("EmployeeEmbed is created  with Id::" + id);
        session.getTransaction().commit();

    }

    private static EmployeeEmbed getEmployeeEmbed() {
        EmployeeEmbed employee = new EmployeeEmbed();
        employee.setEmployeeName("Rubel");
        employee.setEmail("rublel@gmail.com");
        employee.setSalary(50000.00);
        employee.setDoj(new Date());

        Address address = new Address();
        address.setCity("Chennai");
        address.setPincode(9087727L);
        address.setState("Foridpur");
        address.setStreet("Park Street");
        employee.setAddress(address);
        return employee;
    }
}
