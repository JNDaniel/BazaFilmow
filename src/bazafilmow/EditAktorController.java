/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import bazafilmow.model.Aktor;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Mateusz
 */
public class EditAktorController implements Initializable {
     static Aktor b;
    @FXML
    private TextArea SIemaaTest;
    @FXML
    private Button ZatwierdzButton;
    @FXML
    private Button CancelButton;
    @FXML
    private TextArea Nazwisko1;
    @FXML
    private TextArea Narodowosc1;
    @FXML
    private TextArea DataUrodzenia1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SIemaaTest.setText(b.getImie());
        Nazwisko1.setText(b.getNazwisko());
        Narodowosc1.setText(b.getNarodowosc());
        DataUrodzenia1.setText(b.getDataUrodzenia());
        // TODO
    }    
    
    public static void DewajAktora(Aktor a){
        b=a;
      
    }
    
    
    

    @FXML
    private void ZatwierdzButtonHandler(ActionEvent event) throws IOException {
        
        String Nazwisko=Nazwisko1.getText();
        String Imie= SIemaaTest.getText();
        String Narodowosc = Narodowosc1.getText();
        String DataUrodzenia = DataUrodzenia1.getText();
        
        
        
        
          Aktor doZmiany =b; 
          
           EntityManager em = Utils.getEntityManager();
           
           
           
           em.getTransaction().begin();
           
           if (!em.contains(doZmiany)) {
            doZmiany = em.merge(doZmiany);
                }
           
           
           doZmiany.setNazwisko(Nazwisko);
            doZmiany.setImie(Imie);
             doZmiany.setDataUrodzenia(DataUrodzenia);
              doZmiany.setNarodowosc(Narodowosc);
           
          
               em.getTransaction().commit();

                em.close();  
        
        //powrot do poprzedniego okna
         Parent movie_parent = FXMLLoader.load(getClass().getResource("SearchingTest1.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
                
                
    }

    @FXML
    private void CofajMnie(ActionEvent event) throws IOException {
          Parent movie_parent = FXMLLoader.load(getClass().getResource("SearchingTest1.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
    }
    
}
