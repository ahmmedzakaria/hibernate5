/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb02WithoutCfgFile;

 import org.hibernate.HibernateException;
import org.hibernate.Session;


public class ClintTest {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
             // Check MySQL database version
             String sql = "select version()";

             String result = (String) session.createNativeQuery(sql).getSingleResult();
             System.out.println("MySql Database Version is:::");
             System.out.println(result);
         } catch (HibernateException e) {
             e.printStackTrace();
         }
      }
}
