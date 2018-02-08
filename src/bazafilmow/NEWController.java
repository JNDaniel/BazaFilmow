/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.Utils;
import bazafilmow.model.Film;
import bazafilmow.model.Gatunek;
import bazafilmow.model.Kraj;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Michał
 */
public class NEWController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField Tytul;
    
    @FXML
    private TextField Rok;
    
    @FXML
    private TextField Money;
    
    @FXML
    private ComboBox WyborKraju;
    
    @FXML
    private ComboBox WyborAktora;
    
    @FXML
    private ComboBox WyborRe;
    
    @FXML
    private RadioButton Komedia;
    
    @FXML
    private RadioButton Obyczajowy;
    
    @FXML
    private RadioButton Akcji;
    
    @FXML
    private RadioButton Sensacyjny;
    
    @FXML
    private RadioButton Horror;
    
    @FXML
    private RadioButton Animowany;
    
    @FXML
    private RadioButton Dramat;
    
    @FXML
    private RadioButton Thriller;
    
    @FXML
    private RadioButton Fantasy;
     
    @FXML
    private TextField RezField;
    
    @FXML
    private TextField AktField;
    
    //static int count =1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Utilities3.dodajGatunki();
        
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        ObservableList<String> list3 = FXCollections.observableArrayList();
        
        
        
	String[] locales = Locale.getISOCountries();		
		 
		for (String countryCode : locales) 
                {                   
                    Locale obj = new Locale("", countryCode);
                    list.add(obj.getDisplayCountry());
                }
			
                WyborKraju.setItems(list);
			    
                EntityManager em = Utils.getEntityManager();
                //em.getTransaction().begin();

                Query queryAktorzy = em.createNamedQuery("Aktor.findAll");
                Collection aktorzy = queryAktorzy.getResultList();     
                list2.addAll(aktorzy);
                WyborAktora.setItems(list2);

                Query queryRezyserzy = em.createNamedQuery("Rezyser.findAll");
                Collection rezyserzy = queryRezyserzy.getResultList();
                list3.addAll(rezyserzy);
                WyborRe.setItems(list3);
    }    
    
            @FXML
            private void comboActionAktor() {
                //WyborAktora.valueProperty().addListener(new ChangeListener<String>() {
                  //  @Override
                   // public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        
                 ObservableList<String> list = FXCollections.observableArrayList();
                 EntityManager em = Utils.getEntityManager();
                    
                Query queryAktorzy = em.createNamedQuery("Aktor.findAll");
                Collection aktorzy = queryAktorzy.getResultList();     
                list.addAll(aktorzy);
                WyborAktora.setItems(list);
                   
                String output = WyborAktora.getSelectionModel().getSelectedItem().toString();
                //System.out.println(output);
                AktField.setText(output);
                        
                   // }
               // });
            }

            
             @FXML
            private void comboActionRezyser() {
                //WyborAktora.valueProperty().addListener(new ChangeListener<String>() {
                  //  @Override
                   // public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        
                 ObservableList<String> list = FXCollections.observableArrayList();
                 EntityManager em = Utils.getEntityManager();
                    
                Query queryRez = em.createNamedQuery("Rezyser.findAll");
                Collection rezyserzy = queryRez.getResultList();     
                list.addAll(rezyserzy);
                WyborRe.setItems(list);
                
                String output = WyborRe.getSelectionModel().getSelectedItem().toString();
                //System.out.println(output);
                RezField.setText(output);
                        
                   // }
               // });
            }
            
    
            @FXML
	    private void handleOKButton(ActionEvent event) throws IOException{
	        System.out.println("OK Clicked");
                
                EntityManager em = Utils.getEntityManager();
                em.getTransaction().begin();
                
                Film f = new Film();
                f.setTytul(Tytul.getText());
                
                short RokValue = Short.parseShort(Rok.getText());
                f.setRokProd(RokValue);
                 
                float BoxOffice = Float.parseFloat(Money.getText());
                f.setBoxOffice(BoxOffice);
                
                 Set<Gatunek> gg=dodanieGatunkowDoFilmu();
                 if(gg.isEmpty()==false){
                 f.setGatunki(gg);
                 
                 }
                
	        
                em.persist(f);             
                
                em.getTransaction().commit();

		em.close();  
                
                
               
                
                Parent movie_parent = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
                
	    }
    
            @FXML
	    private void handleNewAktorButton(ActionEvent event) throws IOException{
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewAktor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Nowy Aktor");
                stage.setScene(new Scene(root1));  
                stage.show();
            }
            
            @FXML
	    private void handleNewRezButton(ActionEvent event) throws IOException{
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewRez.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Nowy Reżyser");
                stage.setScene(new Scene(root1));  
                stage.show();
          
            }
            
            @FXML
	    private void handleCancelButton(ActionEvent event) throws IOException{
                Parent movie_parent = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
	        Scene movie_scene = new Scene(movie_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	          
	                app_stage.hide(); //optional
	                app_stage.setScene(movie_scene);
	                app_stage.show();
            }
            
            
            //zakładam że sam film został juz utworzony i jest w bazie
            
            private Set<Gatunek> dodanieGatunkowDoFilmu(){
                
                Gatunek g = new Gatunek();
                
                 Set<Gatunek> SetG = new HashSet<Gatunek>();
            
            
                if(Obyczajowy.isSelected()==true){
                g=Utilities3.dajGatunek("Obyczajowy");
                SetG.add(g);
                
                }
                 if(Komedia.isSelected()==true){
                Gatunek g1=Utilities3.dajGatunek("Komedia");
                System.out.println(g1.getNazwa());
                  SetG.add(g1);
                }
                 
                  if(Akcji.isSelected()==true){
                g=Utilities3.dajGatunek("Akcji");
                  SetG.add(g);
                }
                  
                if(Sensacyjny.isSelected()==true){
                g=Utilities3.dajGatunek("Sensacyjny");
                  SetG.add(g);
                }
                
                if(Horror.isSelected()==true){
                g=Utilities3.dajGatunek("Horror");
                  SetG.add(g);
                }
                
                if(Animowany.isSelected()==true){
                g=Utilities3.dajGatunek("Animowany");
                  SetG.add(g);
                }
                
                if(Dramat.isSelected()==true){
                g=Utilities3.dajGatunek("Dramat");
                  SetG.add(g);
                }
                
                if(Thriller.isSelected()==true){
                g=Utilities3.dajGatunek("Thriller");
                  SetG.add(g);
                }
                
                if(Fantasy.isSelected()==true){
                g=Utilities3.dajGatunek("Fantasy");
                  SetG.add(g);
                }
            
            
            return SetG;
            
            }
            
}
