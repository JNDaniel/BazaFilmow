/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Daniel
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testjpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		//System.out.println("SIEMA");
		//em.persist();
		//em.getTransaction().commit();
		em.close();
    }
    
}
