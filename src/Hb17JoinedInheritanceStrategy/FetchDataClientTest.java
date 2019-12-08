/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb17JoinedInheritanceStrategy;

import org.hibernate.Session;

/**
 *
 * @author Zakaria
 */
public class FetchDataClientTest {

    public static void main(String[] args) {
        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            PersonJI person=session.get(PersonJI.class, 1);
            //PersonJI person=session.get(PersonJI.class, 2);
           // PersonJI person=session.get(PersonJI.class, 3);
            if((person instanceof PersonJI) && !(person instanceof EmployeeJI) && !(person instanceof StudentJI)){
                System.out.println("Person: "+person);
            }else if((person instanceof PersonJI) && (person instanceof EmployeeJI)){
                System.out.println("Employee: "+person);
            }else if((person instanceof PersonJI) && (person instanceof StudentJI)){
                System.out.println("Student: "+person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
