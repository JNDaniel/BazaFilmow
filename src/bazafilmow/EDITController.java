/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Film;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Michał
 */

public class EDITController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button Cofnij;
    
    @FXML
    public ListView lista; 
    
    @FXML
    private Button Edytuj;
    
    @FXML 
    private Button Usun;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ObservableList<String> list = FXCollections.observableArrayList();
        EntityManager em = Utils.getEntityManager();
                    
        Query queryFilmy = em.createNamedQuery("Film.findAll");
        Collection filmy = queryFilmy.getResultList();     
        list.addAll(filmy);
        lista.setItems(list);
        
           
    }    
    
    
    
    @FXML 
    public void handleMouseClick(MouseEvent arg0){
        // System.out.println("clicked on " + lista.getSelectionModel().getSelectedItem());
        Film o = new Film();
        o = (Film) lista.getSelectionModel().getSelectedItem();        
        System.out.println(o.getTytul());

    
}
    
    @FXML
    private void handleEdytujButton(ActionEvent event) throws IOException{
        
        Film value = (Film) lista.getSelectionModel().getSelectedItem();
        
        if(value != null){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EdycjaFilmu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Edycja");
            stage.setScene(new Scene(root1));  
            stage.show();
        }
        }
    
    @FXML
    private void handleUsunButton(ActionEvent event)throws IOException{
            

        EntityManager em = Utils.getEntityManager();
        
        Film value = (Film) lista.getSelectionModel().getSelectedItem();
        if(value != null){
        em.getTransaction().begin();
        
        if(!em.contains(value)){
            value = em.merge(value);
        }
        
        em.remove(value);

        em.getTransaction().commit();
        }
        em.close();
        
        }
        
        
    @FXML
    private void handleCofnijButton(ActionEvent event) throws IOException{
            
            Parent movie_parent = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
            
        }
    
    
    
}
