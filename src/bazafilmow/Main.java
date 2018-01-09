/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.*;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                EntityManager em = Utils.getEntityManager();

		em.getTransaction().begin();
                
                Film f = new Film();
                Film f2 = new Film();
                Film f3 = new Film();
                
                f.setTytul("Szybcy");
                f2.setTytul("Szybsi");
                f3.setTytul("Najszybsi");
                
                Kraj x = new Kraj();
                x.setNazwa("Polska");
                
                Kraj y = new Kraj();
                y.setNazwa("NiePolska");
                
                f.addKraj(x); //dodanie krajow do filmow
                f2.addKraj(x);
                
                Aktor aktor1 = new Aktor();
                aktor1.setImie("AktorImie1");
                aktor1.setNazwisko("AktorNazwisko1");
                
                Aktor aktor2 = new Aktor();
                aktor2.setImie("AktorImie2");
                aktor2.setNazwisko("AktorNazwisko2");
                
                Gatunek gatunek1 = new Gatunek();
                gatunek1.setNazwa("Paranormalny");
                
                Gatunek gatunek2 = new Gatunek();
                gatunek2.setNazwa("Przyrodniczy");
                
                
                
                //f2.deleteKraj(x); //usuwanie tylko relacji a nie usuwa kraju z bazy
                //f.deleteKraj(x);
                //em.remove(x);
                //em.remove(y);
                
                Rezyser rez1 = new Rezyser();
                rez1.setImie("Daniel");
                rez1.setNazwisko("Janowski");
                rez1.setNarodowosc("Polska");
                
                Rezyser rez2 = new Rezyser();
                rez2.setImie("Dan");
                rez2.setNazwisko("Jan");
                rez2.setNarodowosc("Pol");
                
                
                
                em.persist(f);
                em.persist(f2);
                
                f.addRezyser(rez1);
                f.addRezyser(rez2);
                f2.addRezyser(rez2);
                
                
                
 
               //em.persist(aktor2);
               //em.persist(aktor1);
               
               f.addAktor(aktor1);
               //f.addAktor(aktor2);
               //f2.addAktor(aktor2);
               aktor1.addFilm(f2);
               em.getTransaction().commit();
               
               em.getTransaction().begin();
  
               
               
               
               em.persist(gatunek1);
               em.persist(gatunek2);
               f2.addGatunek(gatunek1);
               f.addGatunek(gatunek2);
               f.addGatunek(gatunek1);
               f2.addGatunek(gatunek2);
                
                //Utils.loadKraje();

                //f.deleteAktor(aktor1);
                //f2.deleteAktor(aktor1);



                

                //em.remove(aktor1);
                
                //f2.deleteAktor(aktor1);
                
                
                

                
                
                System.out.println(f.getTytul()+" "+f.getAktorzy());
                System.out.println(f2.getTytul()+" "+f2.getAktorzy());
                

                System.out.println(aktor1.getImie()+" "+aktor1.getFilmy());
                
                
                
                em.getTransaction().commit();
		em.close();
                
            
    }
    
}
