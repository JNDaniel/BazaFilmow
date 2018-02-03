/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazafilmow;

import bazafilmow.model.Kraj;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
            
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> list = FXCollections.observableArrayList();
	String[] locales = Locale.getISOCountries();		
		 
		for (String countryCode : locales) 
                {                   
                    Locale obj = new Locale("", countryCode);
                    list.add(obj.getDisplayCountry());
                }
			
                WyborKraju.setItems(list);
			    
    }    
    
    
    
}
