/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Aktor;
import bazafilmow.model.Film;
import bazafilmow.model.Gatunek;
import bazafilmow.model.Rezyser;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
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

    static Film a;
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button Cofnij;
    
    @FXML
    public ListView lista; 
    
    List<Film> DoEdycji;
    
    @FXML
    private Button Edytuj;
    
    @FXML 
    private Button Usun;
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ObservableList<String> list = FXCollections.observableArrayList();
        EntityManager em = Utils.getEntityManager();
                    
        Query queryFilmy = em.createNamedQuery("Film.findAllAlpha");
        List<Film> filmy = queryFilmy.getResultList();     
       // list.addAll(filmy);
        //lista.setItems(list);

        
        String g;
        
        for(int i=0;i<filmy.size();i++){
                 
        g = filmy.get(i).getTytul();
        list.add(g);
         
         }
        lista.setItems(list);
        DoEdycji=filmy;
        
           
    }    
    
    
    
    @FXML 
    public void handleMouseClick(MouseEvent arg0){
        
    }
    
    @FXML
    private void handleEdytujButton(ActionEvent event) throws IOException{
        
       // Film value = (Film) lista.getSelectionModel().getSelectedItem();
        
       int i= lista.getSelectionModel().getSelectedIndex();
       if(i!=-1){
               
        a = DoEdycji.get(i);
       // EdycjaFilmController.DajFilm(a);
        
       
       
        String tytul = a.getTytul();
        String rok = null;
        String money = null;
        String kraj = null;
        
        if(a.getRokProd() != null){
            
        short RokProd = a.getRokProd();
        rok = String.valueOf(RokProd);
        }
            
        if(a.getBoxOffice() != null){
            
        float BoxOffice = a.getBoxOffice();
        money = String.valueOf(BoxOffice);
        }
        
        
        if(a.getJezyk() != null){            
        kraj = a.getJezyk();
        }
       
         Set<Gatunek> SetGatunki;
         SetGatunki = a.getGatunki();
         
         Set<Aktor> SetAktorzy;
         SetAktorzy = a.getAktorzy();
         
         Set<Rezyser> SetRezyserzy;
         SetRezyserzy = a.getRezyserzy();
        
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EdycjaFilm.fxml"));
            Parent movie_parent = (Parent) fxmlLoader.load();
            Scene movie_scene = new Scene(movie_parent); 
            
            EdycjaFilmController display = fxmlLoader.getController();
            display.setText(tytul, rok, money, kraj, SetGatunki, SetAktorzy, SetRezyserzy);
            
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show(); 
                            
        
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
    /*
    public static void funkcja(Film b){
        a=b;
        System.out.println(a.getBoxOffice());
    }
    */
}
