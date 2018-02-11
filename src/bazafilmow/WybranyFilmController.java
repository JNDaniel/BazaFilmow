/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Aktor;
import bazafilmow.model.Gatunek;
import bazafilmow.model.Rezyser;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Michał
 */
public class WybranyFilmController implements Initializable {

    @FXML
    private Label Tytul;
    
    @FXML
    private Label Rok;
    
    @FXML
    private Label Box;
    
    @FXML
    private Label Kraj;
    
    @FXML
    private ListView Akt;
    
    @FXML
    private ListView Rez;
    
    @FXML
    private Label Gatunki;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      //Tytul.setText(a.getTytul());
        // TODO
    }  
    
    public void setText(String Tytul,String RokProd,String Money,String Krajj,String Gatunkii,Set<Aktor> Aktorzy, Set<Rezyser> Rezyserzy){
        this.Tytul.setText(Tytul);
        this.Rok.setText(RokProd);
        this.Box.setText(Money);
        this.Kraj.setText(Krajj);
        this.Gatunki.setText(Gatunkii);
        Akt.getItems().addAll(Aktorzy);
        Rez.getItems().addAll(Rezyserzy);
        
         if(Money == null){
            this.Box.setText("NULL");
        }   
        if(RokProd == null){
            this.Rok.setText("NULL");
        }    
        if(Krajj == null){
            this.Kraj.setText("NULL");
        }
              
        if(Gatunki == null){
            this.Gatunki.setText("NULL");
        }
      // this.Gatunki.setText();
        
        
    }
    
}
