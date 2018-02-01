/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.*;
import bazafilmow.Utilities;
import java.util.ArrayList;
import java.util.List;

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
        //test
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
                
                
                //dodatkowi
                
                  Aktor aktor10 = new Aktor();
                aktor10.setImie("Michal");
                aktor10.setNazwisko("Wisniewski");
                  Aktor aktor100 = new Aktor();
                aktor100.setImie("Jacek");
                aktor100.setNazwisko("Stonoga");
                  Aktor aktor1000 = new Aktor();
                aktor1000.setImie("Dominik");
                aktor1000.setNazwisko("Redzynia");
                
                em.persist(aktor10);
                em.persist(aktor100);
                em.persist(aktor1000);
                //
                
                
                
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
                
                f.addAktor(aktor1);
                f.addAktor(aktor2);
                f2.addAktor(aktor2);
                //f.deleteAktor(aktor1);
               
               em.persist(f);
               em.persist(f2);
     
               f2.addGatunek(gatunek1);
               f.addGatunek(gatunek2);
               f.addGatunek(gatunek1);
               f2.addGatunek(gatunek2);
               
               f2.deleteGatunek(gatunek1);
                
                
                //f.deleteRezyser(rez1); //usuniecie po persist niszczy relacje ale zostawia rekord rezyser w bazie
                //Utils.loadKraje();
                em.getTransaction().commit();

		em.close();  
                
                
                
                //test wyszukiwania
               // List<Aktor> hit;
               // hit=Utilities.WyszukajPoNazwisku("Stonoga");
               // System.out.println(hit.get(0).getNazwisko());
                
                
                Utilities.WyszukajPoNazwiskuPartialy("Naz");
    }
    
}
