/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Aktor;
import bazafilmow.model.Rezyser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Michał
 */
public class TworzenieRezyseraController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField imie;

    @FXML
    private TextField nazwisko;
    
    @FXML
    private TextField narod;
    
    @FXML
    private TextField urodz;
    
    @FXML
    private Button OKButton;
    
    @FXML
    private Button CloseButton;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
	private void handleOKButton(ActionEvent event) throws IOException{
	    System.out.println("OK Clicked");
            
            EntityManager em = Utils.getEntityManager();

            em.getTransaction().begin();
            
            Rezyser aktor = new Rezyser();
            
            aktor.setImie(imie.getText());
            aktor.setNazwisko(nazwisko.getText());
            aktor.setNarodowosc(narod.getText());
            aktor.setDataUrodzenia(urodz.getText());
                 
                em.persist(aktor);
                  
            em.getTransaction().commit();

            em.close(); 
            
                
                    Parent movie_parent = FXMLLoader.load(getClass().getResource("SzukajRezysera.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();       
                
        }
    
        @FXML
	private void handleCloseButton(ActionEvent event) throws IOException{
            
                  Parent movie_parent = FXMLLoader.load(getClass().getResource("SzukajRezysera.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
            
        }
    
}
