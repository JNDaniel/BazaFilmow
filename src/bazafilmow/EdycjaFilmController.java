/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import static bazafilmow.EDITController.a;
import static bazafilmow.Utils.em;
import bazafilmow.model.Aktor;
import bazafilmow.model.Film;
import bazafilmow.model.Gatunek;
import bazafilmow.model.Kraj;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
public class EdycjaFilmController implements Initializable {

    
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
    private RadioButton Sci;
    
    @FXML
    private RadioButton Dokument;
    
    @FXML
    private RadioButton Przygodowy;
             
    @FXML
    private Label NazwaKraju;
    
     
    @FXML
    private ListView ViewAktorzy;
    
    @FXML
    private ListView ViewRezyserzy;
    
    @FXML
    private Button RemoveAktora;
    
    @FXML
    private Button RemoveRe;
    
    @FXML
    private Button NewRezButton;
    
    @FXML
    private Button NewAktorButton;
    
    @FXML
    private Button OKButton;
    
    @FXML
    private Button CancelButton;
    
  
    //static Film b;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        //Tytul.setText(b.getTytul());
        
        Utilities3.dodajGatunki();
        
        ObservableList<String> list = FXCollections.observableArrayList();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        ObservableList<String> list3 = FXCollections.observableArrayList();
        
                
                EntityManager em = Utils.getEntityManager();
                
                
                Query queryKraj = em.createNamedQuery("Kraj.findAll");
                Collection kraje = queryKraj.getResultList();     
                list.addAll(kraje);
                WyborKraju.setItems(list);

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
                       
                ObservableList<String> list = FXCollections.observableArrayList();
                EntityManager em = Utils.getEntityManager();
                    
                Query queryAktorzy = em.createNamedQuery("Aktor.findAll");
                Collection aktorzy = queryAktorzy.getResultList();     
                list.addAll(aktorzy);
                WyborAktora.setItems(list);
                   
                if(!ViewAktorzy.getItems().contains(WyborAktora.getSelectionModel().getSelectedItem())){                                           
                 
                    ViewAktorzy.getItems().add(WyborAktora.getSelectionModel().getSelectedItem());
                    
                }

            }    
        
     
             @FXML
            private void comboActionKraj(){
                
                Kraj lol = new Kraj();
                lol = (Kraj) WyborKraju.getSelectionModel().getSelectedItem();
                String nazwa = lol.getNazwa();
                NazwaKraju.setText(nazwa);
                
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
                
                if(!ViewRezyserzy.getItems().contains(WyborRe.getSelectionModel().getSelectedItem())){                                           
                
                    ViewRezyserzy.getItems().add(WyborRe.getSelectionModel().getSelectedItem());
                    
                }
                   // }
               // });
            }
            
            @FXML
	    private void handleUsunButtonAkt(ActionEvent event){
                ViewAktorzy.getItems().remove(ViewAktorzy.getSelectionModel().getSelectedItem());
            }
    
            
            @FXML
	    private void handleUsunButtonRez(ActionEvent event){
                ViewRezyserzy.getItems().remove(ViewRezyserzy.getSelectionModel().getSelectedItem());
            }
            
            @FXML
	    private void handleOKButton(ActionEvent event) throws IOException{
	        System.out.println("OK Clicked");
                
                EntityManager em = Utils.getEntityManager();
                em.getTransaction().begin();
                
                if (!em.contains(a)) {
                a = em.merge(a);
                }
                
                
                boolean flag =false;
                

                
                 Set<Gatunek> gg=dodanieGatunkowDoFilmu(a);
                 if(gg.isEmpty()==false){
                 a.setGatunki(gg);
                 
                 }
                
	        
                //em.persist(a);             

                
                dodanieGatunkowDoFilmu(a);
                
                System.out.println(a.getGatunki());
                
                
               // f.addKraj((Kraj) WyborKraju.getSelectionModel().getSelectedItem());
               // em.persist(f);
                
                if (Tytul.getText() == null || Tytul.getText().trim().isEmpty()) {
                    
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NULL ERROR");
                    alert.setHeaderText("Tytuł nie może być NULL");
                    alert.setContentText("Zmień tytuł!");

                    alert.showAndWait();
                    flag = false;
                   
                }
                else{
                    
                    a.setTytul(Tytul.getText());
                    //em.persist(a); 
                    flag = true;       
                    
                }
                
                if (Rok.getText() == null || Rok.getText().trim().isEmpty() || "NULL".equals(Rok.getText())){
                    
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NULL ERROR");
                    alert.setHeaderText("Rok nie może być NULL");
                    alert.setContentText("Zmień rok!");

                    alert.showAndWait();
                    flag = false;
                }
                else{
                    
                     short RokValue = Short.parseShort(Rok.getText()); //-short
                    a.setRokProd(RokValue);
                    //em.persist(a); 
                    flag = true;
                    
                }
                
                if (Money.getText() == null || Money.getText().trim().isEmpty() || "NULL".equals(Money.getText())){ 
                    
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NULL ERROR");
                    alert.setHeaderText("BoxOffice nie może być NULL");
                    alert.setContentText("Zmień BoxOffice!");

                    alert.showAndWait();
                    flag = false;
                }
                else{
                    
                    float BoxOffice = Float.parseFloat(Money.getText()); //-float
                    a.setBoxOffice(BoxOffice);
                   // em.persist(a);
                    flag = true;
                                  
                }
                

                //f.addAktor((Aktor) WyborAktora.getSelectionModel().getSelectedItem());

                
                    for(int i=0;i<ViewAktorzy.getItems().size();i++){
                       
                       a.addAktor((Aktor) ViewAktorzy.getItems().get(i));
                    }
               // em.persist(a);                         
                System.out.println(a.getAktorzy());
                
                
                    for(int i=0;i<ViewRezyserzy.getItems().size();i++){
                       
                       a.addRezyser((Rezyser) ViewRezyserzy.getItems().get(i));
                    }
                    
               // em.persist(a);
                System.out.println(a.getRezyserzy());
                
                
                
                if(flag == true){
      
                em.getTransaction().commit();

		em.close();

                
                Stage stage = (Stage) CancelButton.getScene().getWindow();
                stage.close();
                
                }
                
                
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
                Stage stage = (Stage) CancelButton.getScene().getWindow();
                stage.close();
            }
            
            
            //zakładam że sam film został juz utworzony i jest w bazie
            
            private Set<Gatunek> dodanieGatunkowDoFilmu(Film f){
                
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
            
                if(Sci.isSelected()== true){
                g=Utilities3.dajGatunek("Sci-Fi");
                 SetG.add(g);
                }
                     
                if(Dokument.isSelected()){
                g=Utilities3.dajGatunek("Dokumentalny");
                 SetG.add(g);
                }
                
                if(Przygodowy.isSelected()){
                g=Utilities3.dajGatunek("Przygodowy");
                 SetG.add(g);
                }
              return SetG;  
            }
            
    /*
     public static void DajFilm(Film a){
        b=a;
        System.out.println(b.getTytul());
    }
    */
            
    public void setText(String tytul, String RokProd , String Money, String Kraj, Set<Gatunek> SetGatunki, Set<Aktor> SetAktorzy, Set<Rezyser> SetRezyserzy){
        this.Tytul.setText(tytul);
        this.Rok.setText(RokProd);
        this.Money.setText(Money);
        this.NazwaKraju.setText(Kraj);
        
        if(Money == null){
            this.Money.setText("NULL");
        }   
        if(RokProd == null){
            this.Rok.setText("NULL");
        }    
        if(Kraj == null){
            this.NazwaKraju.setText("NULL");
        }
        
        Gatunek G1=null;
        Gatunek G2=null;
        Gatunek G3=null;
        Gatunek G4=null;
        Gatunek G5=null;
        Gatunek G6=null;
        Gatunek G7=null;
        Gatunek G8=null;
        Gatunek G9=null;
        Gatunek G10=null;
        Gatunek G11=null;
        Gatunek G12=null;
        
        List<Gatunek> Gatunki;
        List<Gatunek> Gatunki2;
        List<Gatunek> Gatunki3;
        List<Gatunek> Gatunki4;
        List<Gatunek> Gatunki5;
        List<Gatunek> Gatunki6;
        List<Gatunek> Gatunki7;
        List<Gatunek> Gatunki8;
        List<Gatunek> Gatunki9;
        List<Gatunek> Gatunki10;
        List<Gatunek> Gatunki11;
        List<Gatunek> Gatunki12;
        
        Gatunki=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Komedia").getResultList();
        Gatunki2=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Obyczajowy").getResultList();
        Gatunki3=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Akcji").getResultList();
        Gatunki4=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Sensacyjny").getResultList();
        Gatunki5=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Horror").getResultList();
        Gatunki6=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Animowany").getResultList();
        Gatunki7=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Dramat").getResultList();
        Gatunki8=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Thriller").getResultList();
        Gatunki9=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Fantasy").getResultList();
        Gatunki10=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Sci-Fi").getResultList();
        Gatunki11=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Dokumentalny").getResultList();
        Gatunki12=em.createNamedQuery("Gatunek.findByNazwa").setParameter("nazwa", "Przygodowy").getResultList();
        
        if(Gatunki.isEmpty()==false){
        G1=Gatunki.get(0);
        }       
        if(Gatunki2.isEmpty()==false){
        G2=Gatunki2.get(0);
        }        
        if(Gatunki3.isEmpty()==false){
        G3=Gatunki3.get(0);
        }
        if(Gatunki4.isEmpty()==false){
        G4=Gatunki4.get(0);
        }
        if(Gatunki5.isEmpty()==false){
        G5=Gatunki5.get(0);
        }
        if(Gatunki6.isEmpty()==false){
        G6=Gatunki6.get(0);
        }
        if(Gatunki7.isEmpty()==false){
        G7=Gatunki7.get(0);
        }
        if(Gatunki8.isEmpty()==false){
        G8=Gatunki8.get(0);
        }
        if(Gatunki9.isEmpty()==false){
        G9=Gatunki9.get(0);
        }
        if(Gatunki10.isEmpty()==false){
        G10=Gatunki10.get(0);
        }
        if(Gatunki11.isEmpty()==false){
        G11=Gatunki11.get(0);
        }
        if(Gatunki12.isEmpty()==false){
        G12=Gatunki12.get(0);
        }
        
        
        
        if(SetGatunki.contains(G1)){
            Komedia.setSelected(true);          
            
        }
        
        if(SetGatunki.contains(G2)){
            Obyczajowy.setSelected(true);          
            
        }
        if(SetGatunki.contains(G3)){
            Akcji.setSelected(true);          
            
        }
        if(SetGatunki.contains(G4)){
            Sensacyjny.setSelected(true);          
            
        }
        if(SetGatunki.contains(G5)){
            Horror.setSelected(true);          
            
        }
        if(SetGatunki.contains(G6)){
            Animowany.setSelected(true);          
            
        }
        if(SetGatunki.contains(G7)){
            Dramat.setSelected(true);          
            
        }
        if(SetGatunki.contains(G8)){
            Thriller.setSelected(true);          
            
        }
        if(SetGatunki.contains(G9)){
            Fantasy.setSelected(true);          
            
        }
        if(SetGatunki.contains(G10)){
            Sci.setSelected(true);          
            
        }
        if(SetGatunki.contains(G11)){
            Dokument.setSelected(true);          
            
        }
        if(SetGatunki.contains(G12)){
            Przygodowy.setSelected(true);          
            
        }
        
        ViewAktorzy.getItems().addAll(SetAktorzy);
        ViewRezyserzy.getItems().addAll(SetRezyserzy);
        
    }
    
    
}
