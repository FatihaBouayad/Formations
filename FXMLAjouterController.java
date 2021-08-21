/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgsescuela.Formations;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dgsescuela.DBConnection;
import static dgsescuela.LoginPackage.loginController.adminStage;
import static dgsescuela.LoginPackage.loginController.rootAccueil;
import static dgsescuela.LoginPackage.loginController.sceneAccueil;
import dgsescuela.Modele.ModeleEnseignantsStatic;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.exolab.castor.types.DateTime;
import static sun.util.calendar.CalendarUtils.mod;

/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLAjouterController implements Initializable {

    Connection conn;
    PreparedStatement pst = null;
    PreparedStatement pst2=null;
    ResultSet rs = null;
    
    @FXML
    private JFXTextField Titre;

    @FXML
    private JFXTextArea Description;
    
    @FXML
    private TextField   idens;

    @FXML
    private TextField nbrseance;
     @FXML
    private TextField nbrsemaine;
      @FXML
    private JFXTextField Prix;
    
     @FXML
    private JFXComboBox<String> Session;
    @FXML
    private JFXComboBox<String> Niveau;
    

    @FXML
    private DatePicker DateD;
    @FXML
    private DatePicker DateF;
    
   
/*---------------TXTfield Heure Debut-----------------*/
   @FXML
    private JFXTextField D1;
   @FXML
    private JFXTextField D2;
   @FXML
    private JFXTextField D3;
  @FXML
    private JFXTextField D4;
  @FXML
    private JFXTextField D5;
  @FXML
    private JFXTextField D6;
  @FXML
    private JFXTextField D7;
  /*--------------------------------------------------*/
/*--------------------TXTField Heure Fin------------*/
@FXML
    private JFXTextField F1; 
@FXML
    private JFXTextField F2;
@FXML
    private JFXTextField F3;
@FXML
    private JFXTextField F4;
@FXML
    private JFXTextField F5;
@FXML
    private JFXTextField F6;
@FXML
    private JFXTextField F7;

/*------------------------------------------------------*/
/*--------------------Check Box-----------------------*/
@FXML
    private CheckBox S0;

@FXML
    private CheckBox S1;
@FXML
    private CheckBox S2;
@FXML
    private CheckBox S3;
@FXML
    private CheckBox S4;
@FXML
    private CheckBox S5;
@FXML
    private CheckBox S6;
@FXML
    private CheckBox S7;
/*------------------------------------------------------*/
ModeleEnseignantsStatic CurrentObjetStatic;

public static Stage EnseignantStage = new Stage();

    @FXML
    private Label isEmpty;
    
   
   
    private KeyEvent event;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

   
        Session.getItems().addAll("1","2","3");
        Niveau.getItems().addAll("1","2","3"); 
        D1.setEditable(false);
        D2.setEditable(false);
        D3.setEditable(false);
        D4.setEditable(false);
        D5.setEditable(false);
        D6.setEditable(false);
        D7.setEditable(false);
        F1.setEditable(false);
        F2.setEditable(false);
        F3.setEditable(false);
        F4.setEditable(false);
        F5.setEditable(false);
        F6.setEditable(false);
        F7.setEditable(false);
        CurrentObjetStatic = new ModeleEnseignantsStatic();
         initialisationData();

    }    
    
 @FXML
    void Clavier(KeyEvent event) throws ParseException, SQLException, IOException, JRException {
         if (event.getCode() == KeyCode.ESCAPE.CONTROL)
         {
             
    

         }else if (event.getCode() == KeyCode.ENTER)
         {
             

         }else if (event.getCode() == KeyCode.F7){
    
         }
    }
     int cmpS=0;
    @FXML
            void verification() throws ParseException, SQLException, IOException{
                
                
                
                if(S1.isSelected() && D1.isEditable()==false && F1.isEditable()==false){
                    D1.setEditable(true);
                    F1.setEditable(true);
                  
                   cmpS++;
                    
                }
                else if(S2.isSelected() && D2.isEditable()==false && F2.isEditable()==false){
                    D2.setEditable(true);
                    F2.setEditable(true);
                   
                    cmpS++;
                    
                }
                else if(S3.isSelected()&& D3.isEditable()==false && F3.isEditable()==false){
                    D3.setEditable(true);
                    F3.setEditable(true);
                    
                    cmpS++;
                }
                else if(S4.isSelected()&& D4.isEditable()==false && F4.isEditable()==false){
                    D4.setEditable(true);
                    F4.setEditable(true);
                   
                    cmpS++;
                }
                else if(S5.isSelected()&& D5.isEditable()==false && F5.isEditable()==false){
                    D5.setEditable(true);
                    F5.setEditable(true);
                    
                    cmpS++;
                }
                else if(S6.isSelected()&& D6.isEditable()==false && F6.isEditable()==false){
                    D6.setEditable(true);
                    F6.setEditable(true);
                   
                    cmpS++;
                }
                else if(S7.isSelected()&& D7.isEditable()==false && F7.isEditable()==false){
                    D7.setEditable(true);
                    F7.setEditable(true);
                    
                    cmpS++;
                }
              System.out.println("compteur"+cmpS);
                CalculSeance(cmpS);
                    
            }
    
    int nbrS;
    
    @FXML
    void AjoutSeance( ) throws ParseException, SQLException, IOException {
        
        String v=null;
        String sqlS= null;
        
         sqlS = "SELECT max(IDSemaine) FROM `semaine`" ;
                    pst = conn.prepareStatement(sqlS);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v=rs.getString(1);
                     }
                     
                    rs.close();
                    
       String sql= "Insert into sceance(DateSceance,HeureDebut,HeureFin,IDSemaine) values(?,?,?,?)";
        pst = conn.prepareStatement(sql);
         if(D1.isEditable()&& F1.isEditable()) {  
        
                    pst.setString(1,  LocalDate.now().toString());
                    pst.setString(2, D1.getText().toString());
                    pst.setString(3, F1.getText().toString());
                  pst.setString(4, v.toString());
                     pst.executeUpdate();
                    System.out.println(D1.getText().toString()+"***1***"+F1.getText().toString());
         }
         if(D2.isEditable()&& F2.isEditable()) {  
        
                    pst.setString(1,  LocalDate.now().toString());
                    pst.setString(2, D2.getText().toString());
                    pst.setString(3, F2.getText().toString());
                    pst.setString(4,v.toString());
                    pst.executeUpdate();
                    System.out.println(D2.getText().toString()+"***2***"+F2.getText().toString());
         }
         if(D3.isEditable()&& F3.isEditable()) {  
        
                    pst.setString(1,  LocalDate.now().toString());
                    pst.setString(2, D3.getText().toString());
                    pst.setString(3, F3.getText().toString());
                    pst.setString(4,v.toString());
                    pst.executeUpdate();
                    System.out.println(D3.getText().toString()+"****3**"+F3.getText().toString());
         }
         if(D4.isEditable()&& F4.isEditable()) {  
        
                    pst.setString(1,  LocalDate.now().toString());
                    pst.setString(2, D4.getText().toString());
                    pst.setString(3, F4.getText().toString());
                    pst.setString(4,v.toString());
                    pst.executeUpdate();
                    System.out.println(D4.getText().toString()+"****4**"+F4.getText().toString());
         }
         if(D5.isEditable()&& F5.isEditable()) {  
        
                    pst.setString(1,  LocalDate.now().toString());
                    pst.setString(2, D5.getText().toString());
                    pst.setString(3, F5.getText().toString());
                    pst.setString(4,v.toString());
                    pst.executeUpdate();
                    System.out.println(D5.getText().toString()+"***5***"+F5.getText().toString());
         }
         if(D6.isEditable()&& F6.isEditable()) {  
        
                    pst.setString(1,  LocalDate.now().toString());
                    pst.setString(2, D6.getText().toString());
                    pst.setString(3, F6.getText().toString());
                    pst.setString(4,v.toString());
                    pst.executeUpdate();
                    System.out.println(D6.getText().toString()+"***6***"+F6.getText().toString());
         }
         if(D7.isEditable()&& F7.isEditable()) {  
        
                    pst.setString(1,  LocalDate.now().toString());
                    pst.setString(2, D7.getText().toString());
                    pst.setString(3, F7.getText().toString());
                    pst.setString(4,v.toString());
                    pst.executeUpdate();
                    System.out.println(D7.getText().toString()+"***7***"+F7.getText().toString());
         }
        
               
            }
    
     @FXML
     void CalculSeance(int c){
         System.out.println("Nombre de séances par semaine------------"+cmpS);
        nbrS= CalculSemaine()*cmpS;
        System.out.println("Nombre de séances de la formation****************"+nbrS);
               nbrseance.setText( ""+nbrS);
         
         
     }
    int week;
     
    @FXML
     int CalculSemaine(){
   
    LocalDate ld = DateD.getValue();
    LocalDate ld2 = DateF.getValue();
   Calendar date1 = Calendar.getInstance();
   Calendar date2 = Calendar.getInstance();
    if(DateD.getValue()!=null && DateF.getValue()!= null){
        date1.clear();
        date1.set(ld.getYear(), ld.getMonthValue(),ld.getDayOfMonth());
        
        date2.clear();
        date2.set(ld2.getYear(), ld2.getMonthValue(),ld2.getDayOfMonth());

        long diff = date2.getTimeInMillis() - date1.getTimeInMillis();
      
        float dayCount = (float) diff / (24 * 60 * 60 * 1000);

         week = (int) (dayCount / 7) ;
         if(mod((long) dayCount,7) != 0){
             week =week+1;
             
         }
               System.out.println("Nombre semaine------------"+week);
       nbrsemaine.setText(week+"");
    }
    else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur :   ");
                    alert.setContentText("Veuillez entrer une date valide s'il vous plait !!!!!!");
                    alert.showAndWait();
    }
    return week;
    }
     
     
@FXML
void AjoutSemaine(KeyEvent event) throws ParseException, SQLException, IOException {
 try{
     
      if (isValidCondition()) {
        
         // String SS="SELECT Max(IDFormation) FROM `formation`";
 
     String req="INSERT INTO semaine(IDFormation) SELECT MAX(IDFormation) FROM formation";
     
      pst = conn.prepareStatement(req);
    
    
     

                    pst.executeUpdate();
                    pst.close();
                    
                System.out.println("la semaine est ajoutée");
                  
      } else {
          System.out.println("erreur d'ajout de semaine");
      }
      AjoutSeance();
      
 }catch (SQLException ex) {
            ex.printStackTrace();
    }
//    AjoutSeance(event);
}
    @FXML
    void AjoutFormation() throws ParseException, SQLException, IOException {
            System.out.println("---------------------------------------->1");
        
         try {
             System.out.println("---------------------------------------->1");
            if (isValidCondition()) {
                System.out.println("---------------------------------------->2");
          
                    String sql2 = "insert into formation (Date_Ajout,TitreFormation,Prix,Session,DateDebut,DateFin,idEnseignant,Niveau,Description) values(?,?,?,?,?,?,?,?,?)";
                    
                    System.out.println("---------------------------------------->3");
                    pst = conn.prepareStatement(sql2);
                    

                  
                    pst.setString(1, LocalDate.now().toString());
                    pst.setString(2, Titre.getText());
                    pst.setString(3, Prix.getText());
                    pst.setString(4, Session.getValue());
                    pst.setString(5, DateD.getValue().toString());
                    pst.setString(6, DateF.getValue().toString());
                    pst.setString(7, idens.getText());
                    pst.setString(8, Niveau.getValue());
                    pst.setString(9,Description.getText());
     

                    pst.executeUpdate();
                    pst.close();
                    
                
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sucess");
                    alert.setHeaderText("Sucess :   ");
                    alert.setContentText("lA formation :" + "  '" + Titre.getText() + "' " + "a été ajouté avec succès");
                    alert.showAndWait();
                    
                   // newStage.close();
                    FenetreFormation();
                   
                
          } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur :   ");
                alert.setContentText("Vérifiez les données d'Article!!!");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } catch (ParseException ex) {
            Logger.getLogger(FXMLAjouterController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
         AjoutSemaine(event);
    }

    private void initialisationData() {
          try {
            // TODO
            conn= DBConnection.EtablirConnection();
            //fxDateAjout.setValue(LocalDate.now());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dgsescuela.Enseignants.FXMLAjouterController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
   
      private void ConfirmationImpression() throws SQLException, JRException, IOException {
          
             Alert alert = new Alert(AlertType.CONFIRMATION);
                   alert.setTitle("Confirmatin Impression");
                   alert.setHeaderText("Impression Ticket");
                   alert.setContentText("Vous voulez imprimer un Ticket?");

                   Optional<ButtonType> result = alert.showAndWait();
                   if (result.get() == ButtonType.OK){
                       Imprimer();
                       actualiser();
                   } else {
                        actualiser();
                   }
          
      }
      
    private void actualiser() throws IOException{
        
      
       
 
    }
   
    
    @FXML
   public void FenetreEnseignant() throws IOException {

      // CalculSemaine();
        rootAccueil = FXMLLoader.load(getClass().getResource("/dgsescuela/Formations/FXMLEnseignants.fxml"));
        sceneAccueil = new Scene(rootAccueil);

            EnseignantStage.setScene(sceneAccueil);
            EnseignantStage.showAndWait();
          
            idens.setText(CurrentObjetStatic.getIdEnseignant());

    }
   
    public void Imprimer() throws SQLException, JRException, IOException {
         

      
      
       }
    
    private boolean isValidCondition() throws SQLException {
    
        boolean registration = false;
        if (isEmpty()) {
            System.out.println("Condition valideeeeeeeeeee");
            registration = true;
         

        } else {
          

            System.out.println("Condition Invalid");
            registration = false;
        }

        return registration;

    }
      private boolean isEmpty() {
        boolean isEmpty = false;
        if (Titre.getText().trim().isEmpty()
                || Description.getText().trim().isEmpty()
                || Prix.getText().trim().isEmpty()
                || DateD.getValue()==null
                || DateF.getValue()==null
                ) {

            //System.out.println("il y a un ou plusieur champs vide");
            isEmpty = false;
        } else {
                    
            System.out.println("il y a un ou plusieur champs vide");

            isEmpty = true;
        }
        return isEmpty;
    }
       private boolean isnewData() throws SQLException {

        String sql = "select * from `formation` where Titre='" + Titre.getText() + "'";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            pst.close();
            rs.close();
            System.out.println("isn't new data");
            return false;

        }
        pst.close();
        rs.close();
        System.out.println("is new data");
        return true;
    }
    
   public void FenetreFormation() throws ParseException, IOException {

            rootAccueil = FXMLLoader.load(getClass().getResource("/dgsescuela/Formations/FXMLFormations.fxml"));
            sceneAccueil = new Scene(rootAccueil);
         


    }

}
