/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Rezyser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Michał
 */


public class NewRezController implements Initializable {

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
    }

        @FXML
	private void handleOKButton(ActionEvent event) throws IOException{
	    System.out.println("OK Clicked");
            
            EntityManager em = Utils.getEntityManager();

            em.getTransaction().begin();
            
            Rezyser rez = new Rezyser();
            
            rez.setImie(imie.getText());
            rez.setNazwisko(nazwisko.getText());
            rez.setNarodowosc(narod.getText());
            rez.setDataUrodzenia(urodz.getText());
            
            em.persist(rez);
            
            em.getTransaction().commit();

            em.close(); 
                
            Stage stage = (Stage) OKButton.getScene().getWindow();
            
            stage.close();           
                
        }
    
        @FXML
	private void handleCloseButton(ActionEvent event) throws IOException{
            
            Stage stage = (Stage) CloseButton.getScene().getWindow();
            stage.close();
            
        }
        
}
