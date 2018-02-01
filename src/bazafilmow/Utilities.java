/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Aktor;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 *
 * @author Mateusz
 */




public class Utilities {
    
    
 public static List<Aktor> WyszukajPoNazwisku(String Nazwisko){
 
     List<Aktor> Aktorzy;
     
     

     EntityManager em = Utils.getEntityManager();

     Aktorzy=em.createNamedQuery("Aktor.findByNazwisko") .setParameter("nazwisko", Nazwisko).getResultList();
     
     
     //System.out.println(Aktorzy.size()); liczba aktorow o takim Nazwisku
    return Aktorzy;
 }  
 
 
 public static List<Aktor> WyszukajPoNazwiskuPartialy(String Nazwisko){
 
     List<Aktor> Aktorzy;
      List<Aktor> Wynik = new ArrayList<Aktor>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Aktorzy=em.createNamedQuery("Aktor.findAll").getResultList();
    
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Aktorzy.size();i++){
      
      Nazwisko=Nazwisko.toLowerCase();
          
      if(Aktorzy.get(i).getNazwisko().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i); 
        
       Wynik.add(Aktorzy.get(i));  
     //  System.out.println(Aktorzy.get(i).getNazwisko());
       
         }
 
      }   
      
     
    
     return Wynik;
 }
     
 
 //sprawdza czy pasuje jako imie lub nazwisko
 public static List<Aktor> WyszukajAktoraPoStringu(String Nazwisko){
 
     List<Aktor> Aktorzy;
      List<Aktor> Wynik = new ArrayList<Aktor>() ;
     
      EntityManager em = Utils.getEntityManager();
     
      Aktorzy=em.createNamedQuery("Aktor.findAll").getResultList();
    
       Nazwisko=Nazwisko.toLowerCase();
      
      
      //System.out.println(Aktorzy.size());
      for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getNazwisko().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik.add(Aktorzy.get(i));  
     //  System.out.println(Aktorzy.get(i).getNazwisko());  
                }
        }   
      
      
       for(int i=0;i<Aktorzy.size();i++){
         
      if(Aktorzy.get(i).getImie().toLowerCase().contains(Nazwisko)==true){
     
       // System.out.println(i);   
       Wynik.add(Aktorzy.get(i));  
       System.out.println(Aktorzy.get(i).getImie());  
                }
        }  
      
     
    
     return Wynik;
 }
 
 
 
 
 
}
