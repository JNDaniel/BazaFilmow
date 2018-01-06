/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.postgresql.util.PSQLException;

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
                
                Film f = new Film();
                Film f2 = new Film();
                
                f.setTytul("Szybcy");
                f2.setTytul("Szybsi");

                Kraj x = new Kraj();
                x.setNazwa("Polska");
                
                Kraj y = new Kraj();
                y.setNazwa("NiePolska");
                
                f.addKraj(x); //dodanie krajow do filmow
                f2.addKraj(x);
                
                
                
                em.persist(f);
                em.persist(f2);
                
               

                f2.getKraje().remove(x); //potrzebne przy usuwaniu kraju z , usuwanie tylko relacji a nie usuwa kraju z bazy
                //f2.getKraje().add(x); // przeciwstawne do powyzszego
                em.getTransaction().commit();
                
                x.getFilmy().add(f2);
                em.refresh(f2);
                em.refresh(x);


		em.close();  
    }
    
}
