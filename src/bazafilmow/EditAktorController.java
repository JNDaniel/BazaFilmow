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
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Mateusz
 */
public class EditAktorController implements Initializable {
     static Aktor b;
    @FXML
    private TextArea SIemaaTest;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SIemaaTest.setText(b.getNazwisko());
        // TODO
    }    
    
    public static void DewajAktora(Aktor a){
        b=a;
        System.out.println(b.getNazwisko());
    }
    
}
