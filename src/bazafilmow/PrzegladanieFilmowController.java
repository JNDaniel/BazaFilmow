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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Michał
 */
public class PrzegladanieFilmowController implements Initializable {

    @FXML
    private TextField Szukaj;
    
    @FXML
    private Button Cofnij;
    
    @FXML
    private ListView lista;
    
    List<Film> DoEdycji;
    
    static Film f;
    ObservableList<String> list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        
        ObservableList<String> list = FXCollections.observableArrayList();
        lista.setItems(list); //dodane
         Wyszukaj();//ddodane
        
         /*
        EntityManager em = Utils.getEntityManager();
                    
        Query queryFilmy = em.createNamedQuery("Film.findAllAlpha");
        List<Film> filmy = queryFilmy.getResultList();     

        
        String g;
        
        for(int i=0;i<filmy.size();i++){
                 
        g = filmy.get(i).getTytul();
        list.add(g);
         
         }
        lista.setItems(list);
        DoEdycji=filmy;
     */   
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

    @FXML 
    public void handleMouseClick(MouseEvent arg0) throws IOException{
        

        int i= lista.getSelectionModel().getSelectedIndex();
        
        if(i !=-1){
            
        f = DoEdycji.get(i);
        
        String tytul = f.getTytul();

        String rok = null;
        String money = null;
        String kraj = null;
        String elo = null;
        
        if(f.getRokProd() != null){
            
        short RokProd = f.getRokProd();
        rok = String.valueOf(RokProd);
        }
            
        if(f.getBoxOffice() != null){
            
        float BoxOffice = f.getBoxOffice();
        money = String.valueOf(BoxOffice);
        }
               
        if(f.getJezyk() != null){            
        kraj = f.getJezyk();
        }
        
        Set<Gatunek> SetGatunki;
        SetGatunki = f.getGatunki();
        
        if(!SetGatunki.isEmpty()){    
        elo = SetGatunki.toString();
        
        }  
        
        
         Set<Aktor> SetAktorzy;
         SetAktorzy = f.getAktorzy();
         
         Set<Rezyser> SetRezyserzy;
         SetRezyserzy = f.getRezyserzy();

        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WybranyFilm.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        
        WybranyFilmController display = fxmlLoader.getController();
        display.setText(tytul,rok,money,kraj,elo,SetAktorzy,SetRezyserzy);
        
        Stage stage = new Stage();
        stage.setTitle("Przeglądaj");
        stage.setScene(new Scene(root1));  
        stage.show();
        
        }
        
    }
    
    
    void Wyszukaj(){
         
        String s=Szukaj.getText();
         List<Film> Wynik ;
         
         
     
         
         list =FXCollections.observableArrayList();
         Wynik=Utilities.WyszukajFilmPoStringuBezPowtorzen(s);
        
        String g;
         
      
          //System.out.println(Wynik.size());
         for(int i=0;i<Wynik.size();i++){
             
         
             
         g=Wynik.get(i).getTytul();
         list.add(g);
         
         }
        lista.setItems(list);
        DoEdycji=Wynik;
    
    }
    
    

    @FXML
    private void PrzeglondajFilmy(KeyEvent event) {
        Wyszukaj();
    }

}