/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demoisellebehave.serpro.treino.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author 03397040477
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;  
    public static String status = "-";  
      
    static   
    {  
        try  
        {  
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();  
        } catch (Throwable e) {   
              e.printStackTrace();
        }  
    }  
  
    public static Session openSession()  throws HibernateException {
            return sessionFactory.openSession();
    }  
    
    public static Session getCurrentSession() throws HibernateException { 
           return sessionFactory.getCurrentSession(); 
    }  
}
