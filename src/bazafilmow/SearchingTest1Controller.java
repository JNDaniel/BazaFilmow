/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Aktor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Mateusz
 */
public class SearchingTest1Controller implements Initializable {

    
    @FXML
    private TextArea TextA1;
    @FXML
    private ListView<String> ListView1;

     List<Aktor> DoEdycji ;//lista przekazywana do edycji
     ObservableList<String> items;
    @FXML
    private Button cofnij1;
    @FXML
    private Button Edytuj1;
    @FXML
    private Button UsunButton;
    @FXML
    private Button NowyAktor;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ObservableList<String> items =FXCollections.observableArrayList();
        ListView1.setItems(items);
        Wyszukaj();
        
        
        
        
        
        // TODO
    }    

    @FXML
    private void WyszukajSzybko(KeyEvent event) {
        Wyszukaj();
   
        
    }
    
    
     void Wyszukaj(){
         
        String s=TextA1.getText();
         List<Aktor> Wynik ;
         
         
     
         
         items =FXCollections.observableArrayList();
         Wynik=Utilities.WyszukajAktoraPoStringuBezPowtorzenAlpha(s);
        
        String g;
         
      
          //System.out.println(Wynik.size());
         for(int i=0;i<Wynik.size();i++){
             
         
             
         g=Wynik.get(i).getNazwisko()+" "+Wynik.get(i).getImie();
         items.add(g);
         
         }
        ListView1.setItems(items);
        DoEdycji=Wynik;
    
    }

    @FXML
    private void CofnijMnie(ActionEvent event) throws IOException {
            Parent movie_parent = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
    }

    @FXML
    private void GoEdytuj(ActionEvent event) throws IOException {
        
        int i= ListView1.getSelectionModel().getSelectedIndex();
        if(i!=-1){
        
            
        Aktor a = DoEdycji.get(i);
        EditAktorController.DewajAktora(a);
        
        
        
                    Parent movie_parent = FXMLLoader.load(getClass().getResource("EditAktor.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
        
        
        
        }
    }

    @FXML
    private void UsunTO(ActionEvent event) {
        int i= ListView1.getSelectionModel().getSelectedIndex();
        if(i!=-1){
          Aktor a = DoEdycji.get(i);
          
           EntityManager em = Utils.getEntityManager();
           
           
           
           em.getTransaction().begin();
           
           if (!em.contains(a)) {
            a = em.merge(a);
                }
           
           
           em.remove(a);
          
               em.getTransaction().commit();

                em.close();  
        
        }
        Wyszukaj();
        
    }

    @FXML
    private void GoNowyAktor(ActionEvent event) throws IOException {
                        
                       Parent movie_parent = FXMLLoader.load(getClass().getResource("TworzenieAktora.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
    }
    
    
    
}
