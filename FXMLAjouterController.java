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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    Statement st;
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
    private JFXComboBox<String> Semaine;

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
@FXML
    private JFXTextField jour1;
@FXML
    private JFXTextField jour2;

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
     String v=null;
     @FXML
    void AjoutSeance(String[] t) throws ParseException, SQLException, IOException {
            LocalDate ldF = DateD.getValue();
            Calendar dateF = Calendar.getInstance();  
             SimpleDateFormat sdf3 =new SimpleDateFormat("yyyy/MM/dd ");
        //System.out.println("dddaatteee11   "+sdf3.format(dateF.getTime()));
             dateF.clear();
        dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth());
        String sqlS= null;
      
         sqlS = "SELECT max(IDSemaine) FROM `semaine`" ;
                    pst = conn.prepareStatement(sqlS);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v=rs.getString(1);
                     }
                     
                    rs.close();
            
        String sql= "Insert into sceance(DateSceance,HeureDebut,HeureFin,IDSemaine,jour) values(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
       
      if(jour1.getText().equalsIgnoreCase("samedi")){
          System.out.println("Samedi+++++++++++++++++");
                            if((t[15]== "1")) {  
                                 if(t[0]=="1"){
                                 pst.setString(1,  DateD.getValue().toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***Samedi11***"+t[2]);
                                       }
                            if(t[0]=="2"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+7);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***Samedi12***"+t[2]);
                            }
                            if(t[0]=="3"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+14);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***Samedi13***"+t[2]);
                            }
                              if(t[0]=="4"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+21);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***Samedi14***"+t[2]);
                            }
                              if(t[0]=="5"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+28);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***Samedi15***"+t[2]);
                            }
       
       
                                } 
                     
                          if((t[16]== "1")) {  
                                if(t[0]=="1"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+1);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***Dimanche11***"+t[4]);
                                            }
                                 if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+8);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***Dimanche21***"+t[4]);
                                            }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+15);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***Dimanche23***"+t[4]);
                                            }
                                   if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+22);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***Dimanche24***"+t[4]);
                                            }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+29);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***Dimanche25***"+t[4]);
                                            }
                          }
                              if((t[17]== "1")) {  
                                  if(t[0]=="1"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+2);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****Lundi31**"+t[6]);
                                                 }
                                  if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+9);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****Lundi32**"+t[6]);
                                                 }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+16);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****Lundi33**"+t[6]);
                                                 }
                                  if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+23);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****Lundi31**"+t[6]);
                                                 }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+30);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****Lundi35**"+t[6]);
                                                 }
                              }
                         if((t[18]== "1")) {  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+3);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****Mardi41**"+t[8]);
                                }
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+10);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****Mardi42**"+t[8]);
                                }
                                 if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+17);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****Mardi43**"+t[8]);
                                }
                                 if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+24);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****Mardi44**"+t[8]);
                                } 
                                 if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+31);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****Mardi45**"+t[8]);
                                }
                                
                                 }
                                if((t[19]== "1")) {  
                                    if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+4);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***Mercredi51***"+t[10]);
                                    }
                                
                                   if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+11);
                                pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***Mercredi52***"+t[10]);
                                    }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+18);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***Mercredi53***"+t[10]);
                                    }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+25);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***Mercredi54***"+t[10]);
                                    }
                                 if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+32);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***Mercredi55***"+t[10]);
                                    }
                                 }
                        if((t[20]== "1")) {  
                                if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+5);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***Jeudi61***"+t[12]);
                                }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+12);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***Jeudi62***"+t[12]);
                                }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+19);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***Jeudi63***"+t[12]);
                                }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+26);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***Jeudi64***"+t[12]);
                                }
                                if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+33);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***Jeudi65***"+t[12]);
                                }
                                 }
                            if((t[21]== "1")){  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+6);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***Vendredi71***"+t[14]);
                                } 
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+13);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***Vendredi72***"+t[14]);
                                }
                                if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+20);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***Vendredi73***"+t[14]);
                                }
                                if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+27);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***Vendredi74***"+t[14]);
                                }
                                if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+34);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***Vendredi75***"+t[14]);
                                }
                                 }
      }
        if(jour1.getText().equalsIgnoreCase("dimanche")){
             System.out.println("Dimanche+++++++++++++++++");
                        if((t[15]== "1")) {  
                            if(t[0]=="1"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+6);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***DSamedi11***"+t[2]);
                                       }
                            if(t[0]=="2"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+13);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***DSamedi12***"+t[2]);
                            }
                            if(t[0]=="3"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+20);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***DSamedi13***"+t[2]);
                            }
                              if(t[0]=="4"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+27);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***DSamedi14***"+t[2]);
                            }
                              if(t[0]=="5"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+34);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***DSamedi15***"+t[2]);
                            }
       
       
                                } 
                     
                          if((t[16]== "1")) {  
                                if(t[0]=="1"){
                                   
                                 pst.setString(1,  DateD.getValue().toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***DDimanche11***"+t[4]);
                                            }
                                 if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+7);   
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***DDimanche21***"+t[4]);
                                            }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+14);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***DDimanche23***"+t[4]);
                                            }
                                   if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+21);   
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***DDimanche24***"+t[4]);
                                            }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+28);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***DDimanche25***"+t[4]);
                                            }
                          }
                              if((t[17]== "1")) {  
                                  if(t[0]=="1"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+1);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****DLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+8);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****DLundi32**"+t[6]);
                                                 }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+15);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****DLundi33**"+t[6]);
                                                 }
                                  if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+22);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****DLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+29);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****DLundi35**"+t[6]);
                                                 }
                              }
                         if((t[18]== "1")) {  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+2);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****DMardi41**"+t[8]);
                                }
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+9);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****DMardi42**"+t[8]);
                                }
                                 if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+16);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****DMardi43**"+t[8]);
                                }
                                 if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+23);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****DMardi44**"+t[8]);
                                } 
                                 if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+30);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****DMardi45**"+t[8]);
                                }
                                
                                 }
                                if((t[19]== "1")) {  
                                    if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+3);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***DMercredi51***"+t[10]);
                                    }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+10);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***DMercredi52***"+t[10]);
                                    }
                                   
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+17);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***DMercredi53***"+t[10]);
                                    }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+24);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***DMercredi54***"+t[10]);
                                    }
                                 if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+31);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***DMercredi55***"+t[10]);
                                    }
                                 }
                        if((t[20]== "1")) {  
                                if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+4);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***DJeudi61***"+t[12]);
                                }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+11);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***DJeudi62***"+t[12]);
                                }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+18);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***DJeudi63***"+t[12]);
                                }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+25);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***DJeudi64***"+t[12]);
                                }
                                if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+32);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***DJeudi65***"+t[12]);
                                }
                                 }
                            if((t[21]== "1")){  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+5);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***DVendredi71***"+t[14]);
                                } 
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+12);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***DVendredi72***"+t[14]);
                                }
                                if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+19);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***DVendredi73***"+t[14]);
                                }
                                if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+26);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***DVendredi74***"+t[14]);
                                }
                                if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+33);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***DVendredi75***"+t[14]);
                                }
                                 }
        }
        if(jour1.getText().toString()=="lundi"){
             System.out.println("Lundi+++++++++++++++++");
              if((t[15]== "1")) {  
                            if(t[0]=="1"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+5);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***LSamedi11***"+t[2]);
                                       }
                            if(t[0]=="2"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+12);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***LSamedi12***"+t[2]);
                            }
                            if(t[0]=="3"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+19);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***LSamedi13***"+t[2]);
                            }
                              if(t[0]=="4"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+26);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***LSamedi14***"+t[2]);
                            }
                              if(t[0]=="5"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+33);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***LSamedi15***"+t[2]);
                            }
       
       
                                } 
                     
                          if((t[16]== "1")) {  
                                if(t[0]=="1"){
                                   dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+6);
                                 pst.setString(1,   sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***LDimanche11***"+t[4]);
                                            }
                                 if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+13);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***LDimanche21***"+t[4]);
                                            }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+20);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***LDimanche23***"+t[4]);
                                            }
                                   if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+27);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***LDimanche24***"+t[4]);
                                            }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+34);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***LDimanche25***"+t[4]);
                                            }
                          }
                              if((t[17]== "1")) {  
                                  if(t[0]=="1"){
                                   
                                 pst.setString(1, DateD.getValue().toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****lLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+7);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****lLundi32**"+t[6]);
                                                 }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+14);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****lLundi33**"+t[6]);
                                                 }
                                  if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+21);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****lLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+28);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****lLundi35**"+t[6]);
                                                 }
                              }
                         if((t[18]== "1")) {  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+1);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****lMardi41**"+t[8]);
                                }
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+8);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****lMardi42**"+t[8]);
                                }
                                 if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+15);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****LMardi43**"+t[8]);
                                }
                                 if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+22);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****LMardi44**"+t[8]);
                                } 
                                 if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+29);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****LMardi45**"+t[8]);
                                }
                                
                                 }
                                if((t[19]== "1")) {  
                                    if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+2);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***LMercredi51***"+t[10]);
                                    }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+9);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***LMercredi52***"+t[10]);
                                    }
                                   
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+16);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***LMercredi53***"+t[10]);
                                    }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+23);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***LMercredi54***"+t[10]);
                                    }
                                 if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+30);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***LMercredi55***"+t[10]);
                                    }
                                 }
                        if((t[20]== "1")) {  
                                if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+3);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***LJeudi61***"+t[12]);
                                }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+10);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***LJeudi62***"+t[12]);
                                }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+17);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***LJeudi63***"+t[12]);
                                }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+24);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***LJeudi64***"+t[12]);
                                }
                                if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+31);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***LJeudi65***"+t[12]);
                                }
                                 }
                            if((t[21]== "1")){  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+4);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***LVendredi71***"+t[14]);
                                } 
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+11);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***LVendredi72***"+t[14]);
                                }
                                if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+18);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***LVendredi73***"+t[14]);
                                }
                                if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+25);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***LVendredi74***"+t[14]);
                                }
                                if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+32);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***LVendredi75***"+t[14]);
                                }
                                 }
        }
        if(jour1.getText().toString()=="Mardi"){
             System.out.println("Mardi+++++++++++++++++");
              if((t[15]== "1")) {  
                            if(t[0]=="1"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+4);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MSamedi11***"+t[2]);
                                       }
                            if(t[0]=="2"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+11);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MSamedi12***"+t[2]);
                            }
                            if(t[0]=="3"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+18);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MSamedi13***"+t[2]);
                            }
                              if(t[0]=="4"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+25);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MSamedi14***"+t[2]);
                            }
                              if(t[0]=="5"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+32);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MSamedi15***"+t[2]);
                            }
                                } 
                     
                          if((t[16]== "1")) {  
                                if(t[0]=="1"){
                                   dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+5);
                                 pst.setString(1,   sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MDimanche11***"+t[4]);
                                            }
                                 if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+12);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MDimanche21***"+t[4]);
                                            }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+19);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MDimanche23***"+t[4]);
                                            }
                                   if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+26);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MDimanche24***"+t[4]);
                                            }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+33);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MDimanche25***"+t[4]);
                                            }
                          }
                              if((t[17]== "1")) {  
                                  if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+6);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+13);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MLundi32**"+t[6]);
                                                 }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+20);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MLundi33**"+t[6]);
                                                 }
                                  if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+27);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+34);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MLundi35**"+t[6]);
                                                 }
                              }
                         if((t[18]== "1")) {  
                                if(t[0]=="1"){
                                   
                                 pst.setString(1, DateD.getValue().toString());
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MMardi41**"+t[8]);
                                }
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+7);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MMardi42**"+t[8]);
                                }
                                 if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+14);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MMardi43**"+t[8]);
                                }
                                 if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+21);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MMardi44**"+t[8]);
                                } 
                                 if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+28);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MMardi45**"+t[8]);
                                }
                                
                                 }
                                if((t[19]== "1")) {  
                                    if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+1);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MMercredi51***"+t[10]);
                                    }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+8);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MMercredi52***"+t[10]);
                                    }
                                   
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+15);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MMercredi53***"+t[10]);
                                    }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+22);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MMercredi54***"+t[10]);
                                    }
                                 if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+29);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MMercredi55***"+t[10]);
                                    }
                                 }
                        if((t[20]== "1")) {  
                                if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+2);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MJeudi61***"+t[12]);
                                }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+9);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MJeudi62***"+t[12]);
                                }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+16);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MJeudi63***"+t[12]);
                                }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+23);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MJeudi64***"+t[12]);
                                }
                                if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+30);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MJeudi65***"+t[12]);
                                }
                                 }
                            if((t[21]== "1")){  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+3);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MVendredi71***"+t[14]);
                                } 
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+10);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MVendredi72***"+t[14]);
                                }
                                if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+17);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MVendredi73***"+t[14]);
                                }
                                if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+24);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MVendredi74***"+t[14]);
                                }
                                if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+31);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MVendredi75***"+t[14]);
                                }
                                 }
        }
        if(jour1.getText()=="mercredi"){
            System.out.println("Mercredi+++++++++++++++++");
              if((t[15]== "1")) {  
                            if(t[0]=="1"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+3);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MeSamedi11***"+t[2]);
                                       }
                            if(t[0]=="2"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+10);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MeSamedi12***"+t[2]);
                            }
                            if(t[0]=="3"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+17);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MeSamedi13***"+t[2]);
                            }
                              if(t[0]=="4"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+24);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MSamedi14***"+t[2]);
                            }
                              if(t[0]=="5"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+31);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***MeSamedi15***"+t[2]);
                            }
                                } 
                     
                          if((t[16]== "1")) {  
                                if(t[0]=="1"){
                                   dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+4);
                                 pst.setString(1,   sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MeDimanche11***"+t[4]);
                                            }
                                 if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+11);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MeDimanche21***"+t[4]);
                                            }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+18);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MeDimanche23***"+t[4]);
                                            }
                                   if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+25);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MDimanche24***"+t[4]);
                                            }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+32);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***MeDimanche25***"+t[4]);
                                            }
                          }
                              if((t[17]== "1")) {  
                                  if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+5);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MeLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+12);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MeLundi32**"+t[6]);
                                                 }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+19);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MeLundi33**"+t[6]);
                                                 }
                                  if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+26);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MeLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+33);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****MeLundi35**"+t[6]);
                                                 }
                              }
                         if((t[18]== "1")) {  
                                if(t[0]=="1"){
                                 dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+6);  

                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MeMardi41**"+t[8]);
                                }
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+13);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MeMardi42**"+t[8]);
                                }
                                 if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+20);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MeMardi43**"+t[8]);
                                }
                                 if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+27);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MeMardi44**"+t[8]);
                                } 
                                 if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+34);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****MeMardi45**"+t[8]);
                                }
                                
                                 }
                                if((t[19]== "1")) {  
                                    if(t[0]=="1"){
                                   
                                pst.setString(1, DateD.getValue().toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MeMercredi51***"+t[10]);
                                    }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+7);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MeMercredi52***"+t[10]);
                                    }
                                   
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+14);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MeMercredi53***"+t[10]);
                                    }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+21);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MeMercredi54***"+t[10]);
                                    }
                                 if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+28);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MeMercredi55***"+t[10]);
                                    }
                                 }
                        if((t[20]== "1")) {  
                                if(t[0]=="1"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+1);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MeJeudi61***"+t[12]);
                                }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+8);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MeJeudi62***"+t[12]);
                                }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+15);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MeJeudi63***"+t[12]);
                                }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+22);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MeJeudi64***"+t[12]);
                                }
                                if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+29);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***MeJeudi65***"+t[12]);
                                }
                                 }
                            if((t[21]== "1")){  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+2);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MeVendredi71***"+t[14]);
                                } 
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+9);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MeVendredi72***"+t[14]);
                                }
                                if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+16);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MeVendredi73***"+t[14]);
                                }
                                if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+23);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MeVendredi74***"+t[14]);
                                }
                                if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+30);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MeVendredi75***"+t[14]);
                                }
                                 }
        }
        if(jour1.getText().equalsIgnoreCase("jeudi")){
            System.out.println("jeudi+++++++++++++++++");
                            if((t[15]== "1")) {  
                            if(t[0]=="1"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+2);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***JSamedi11***"+t[2]);
                                       }
                            if(t[0]=="2"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+9);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***JSamedi12***"+t[2]);
                            }
                            if(t[0]=="3"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+16);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***JSamedi13***"+t[2]);
                            }
                              if(t[0]=="4"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+23);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***JSamedi14***"+t[2]);
                            }
                              if(t[0]=="5"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+30);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***JSamedi15***"+t[2]);
                            }
                                } 
                     
                          if((t[16]== "1")) {  
                                if(t[0]=="1"){
                                   dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+3);
                                 pst.setString(1,   sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***JDimanche11***"+t[4]);
                                            }
                                 if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+10);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***JDimanche21***"+t[4]);
                                            }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+17);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***JDimanche23***"+t[4]);
                                            }
                                   if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+24);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***JDimanche24***"+t[4]);
                                            }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+31);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***JDimanche25***"+t[4]);
                                            }
                          }
                              if((t[17]== "1")) {  
                                  if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+4);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****JLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+11);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****JLundi32**"+t[6]);
                                                 }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+18);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****JLundi33**"+t[6]);
                                                 }
                                  if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+25);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****JLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+32);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****JLundi35**"+t[6]);
                                                 }
                              }
                         if((t[18]== "1")) {  
                                if(t[0]=="1"){
                                 dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+5);  

                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****JMardi41**"+t[8]);
                                }
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+12);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****JMardi42**"+t[8]);
                                }
                                 if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+19);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****JMardi43**"+t[8]);
                                }
                                 if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+26);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****JMardi44**"+t[8]);
                                } 
                                 if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+33);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****JMardi45**"+t[8]);
                                }
                                
                                 }
                                if((t[19]== "1")) {  
                                    if(t[0]=="1"){
                                      dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+6);

                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***JMercredi51***"+t[10]);
                                    }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+13);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***JMercredi52***"+t[10]);
                                    }
                                   
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+20);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***JMercredi53***"+t[10]);
                                    }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+27);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***MeMercredi54***"+t[10]);
                                    }
                                 if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+34);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***JMercredi55***"+t[10]);
                                    }
                                 }
                        if((t[20]== "1")) {  
                                if(t[0]=="1"){
                                    
                                pst.setString(1,DateD.getValue().toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***JJeudi61***"+t[12]);
                                }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+7);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***JJeudi62***"+t[12]);
                                }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+14);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***JJeudi63***"+t[12]);
                                }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+21);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***JJeudi64***"+t[12]);
                                }
                                if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+28);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***JJeudi65***"+t[12]);
                                }
                                 }
                            if((t[21]== "1")){  
                                if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+1);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"**JVendredi71***"+t[14]);
                                } 
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+8);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***MeVendredi72***"+t[14]);
                                }
                                if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+15);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***JVendredi73***"+t[14]);
                                }
                                if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+22);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***JVendredi74***"+t[14]);
                                }
                                if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+29);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***JVendredi75***"+t[14]);
                                }
                                 }   
        }
        if(jour1.getText().equalsIgnoreCase("vendredi")){
              System.out.println("vendredi+++++++++++++++++");
                            if((t[15]== "1")) {  
                            if(t[0]=="1"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+1);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***VSamedi11***"+t[2]);
                                       }
                            if(t[0]=="2"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+8);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***VSamedi12***"+t[2]);
                            }
                            if(t[0]=="3"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+15);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***VSamedi13***"+t[2]);
                            }
                              if(t[0]=="4"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+22);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***VSamedi14***"+t[2]);
                            }
                              if(t[0]=="5"){
                                dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+29);
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[1]);
                                 pst.setString(3, t[2]);
                                 pst.setString(4, v.toString());
                                 pst.setString(5, "samedi");
                                 pst.executeUpdate();
                                System.out.println(t[1]+"***VSamedi15***"+t[2]);
                            }
                                } 
                     
                          if((t[16]== "1")) {  
                                if(t[0]=="1"){
                                   dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+2);
                                 pst.setString(1,   sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***VDimanche11***"+t[4]);
                                            }
                                 if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+9);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***VDimanche21***"+t[4]);
                                            }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+16);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***VDimanche23***"+t[4]);
                                            }
                                   if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+23);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***VDimanche24***"+t[4]);
                                            }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+30);   
                                 pst.setString(1,  sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[3]);
                                 pst.setString(3, t[4]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "dimanche");
                                 pst.executeUpdate();
                                 System.out.println(t[3]+"***VDimanche25***"+t[4]);
                                            }
                          }
                              if((t[17]== "1")) {  
                                  if(t[0]=="1"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+3);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****JLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="2"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+10);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****VLundi32**"+t[6]);
                                                 }
                                  if(t[0]=="3"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+17);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****VLundi33**"+t[6]);
                                                 }
                                  if(t[0]=="4"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+24);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****VLundi31**"+t[6]);
                                                 }
                                  if(t[0]=="5"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+31);  
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[5]);
                                 pst.setString(3, t[6]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "lundi");
                                 pst.executeUpdate();
                                 System.out.println(t[5]+"****VLundi35**"+t[6]);
                                                 }
                              }
                         if((t[18]== "1")) {  
                                if(t[0]=="1"){
                                 dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+4);  

                                 pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****VMardi41**"+t[8]);
                                }
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+11);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****VMardi42**"+t[8]);
                                }
                                 if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+18);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****VMardi43**"+t[8]);
                                }
                                 if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+25);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****VMardi44**"+t[8]);
                                } 
                                 if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+32);
                                 pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                 pst.setString(2, t[7]);
                                 pst.setString(3, t[8]);
                                 pst.setString(4,v.toString());
                                 pst.setString(5, "mardi");
                                 pst.executeUpdate();
                                 System.out.println(t[7]+"****VMardi45**"+t[8]);
                                }
                                
                                 }
                                if((t[19]== "1")) {  
                                    if(t[0]=="1"){
                                      dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+5);

                                pst.setString(1, sdf3.format(dateF.getTime()).toString());
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***VMercredi51***"+t[10]);
                                    }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+12);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***VMercredi52***"+t[10]);
                                    }
                                   
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+19);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***VMercredi53***"+t[10]);
                                    }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+26);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***VMercredi54***"+t[10]);
                                    }
                                 if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+33);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[9]);
                                pst.setString(3, t[10]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "mercredi");
                                pst.executeUpdate();
                                System.out.println(t[9]+"***VMercredi55***"+t[10]);
                                    }
                                 }
                        if((t[20]== "1")) {  
                                if(t[0]=="1"){
                                  dateF.set(ldF.getYear(), ldF.getMonthValue(),ldF.getDayOfMonth()+6);

                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***VJeudi61***"+t[12]);
                                }
                                if(t[0]=="2"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+13);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***VJeudi62***"+t[12]);
                                }
                                if(t[0]=="3"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+20);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***VJeudi63***"+t[12]);
                                }
                                if(t[0]=="4"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+27);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***VJeudi64***"+t[12]);
                                }
                                if(t[0]=="5"){
                                     dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+34);
                                pst.setString(1,sdf3.format(dateF.getTime()).toString()  );
                                pst.setString(2, t[11]);
                                pst.setString(3, t[12]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "jeudi");
                                pst.executeUpdate();
                                System.out.println(t[11]+"***VJeudi65***"+t[12]);
                                }
                                 }
                            if((t[21]== "1")){  
                                if(t[0]=="1"){
                                  
                                pst.setString(1, DateD.getValue().toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"**VVendredi71***"+t[14]);
                                } 
                                if(t[0]=="2"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+7);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***VVendredi72***"+t[14]);
                                }
                                if(t[0]=="3"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+14);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***VVendredi73***"+t[14]);
                                }
                                if(t[0]=="4"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+21);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***VVendredi74***"+t[14]);
                                }
                                if(t[0]=="5"){
                                    dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth()+28);
                                pst.setString(1, sdf3.format(dateF.getTime()).toString() );
                                pst.setString(2, t[13]);
                                pst.setString(3, t[14]);
                                pst.setString(4,v.toString());
                                pst.setString(5, "vendredi");
                                pst.executeUpdate();
                                System.out.println(t[13]+"***VVendredi75***"+t[14]);
                                }
                                 }   
        }
        for(int k=0;k<21;k++)  {
               t[k]=null;
           }  
            /* for(int k=0;k<21;k++)  {
                 System.out.println("tableau Fin d'excussion ------------------->"+t[k]);
           }*/ 
    }
    
     void CalculSeance(int c) throws ParseException{
         
               nbrseance.setText( ""+cmpS);
         
         
     }
    int week;
  
    
    @FXML
     int CalculSemaine() throws ParseException{
   
    LocalDate ld = DateD.getValue();
    LocalDate ld2 = DateF.getValue();
   LocalDate ld3 = DateD.getValue();

   Calendar date1 = Calendar.getInstance();
   Calendar date2 = Calendar.getInstance();
   Calendar date3 = Calendar.getInstance();
   
    if(DateD.getValue()!=null && DateF.getValue()!= null){
        date1.clear();
        date1.set(ld.getYear(), ld.getMonthValue()-1,ld.getDayOfMonth());
    
        date2.clear();
        date2.set(ld2.getYear(), ld2.getMonthValue()-1,ld2.getDayOfMonth());
        date3.clear();
        date3.set(ld3.getYear(), ld3.getMonthValue()-1,ld3.getDayOfMonth()+32);
        SimpleDateFormat sdf3 =new SimpleDateFormat("dd/MM/yyyy ");
        System.out.println("dddaatteee33   "+sdf3.format(date3.getTime()));
                System.out.println("dddaatteee22  "+date2.getTime());

        SimpleDateFormat sdf =new SimpleDateFormat("EEEE");
        System.out.println("jjjjouuurrrrr1    "+sdf.format(date1.getTime()));
       jour1.setText(sdf.format(date1.getTimeInMillis()));
        SimpleDateFormat sdf2 =new SimpleDateFormat("EEEE");
        System.out.println("jjjjouuurrrrr2    "+sdf2.format(date2.getTime()));

       jour2.setText(sdf2.format(date2.getTime()));
        date3.set(ld.getDayOfMonth()+1, ld.getMonthValue(),ld.getYear());
        System.out.println("---------------<<<<<<<<<<<<"+date3.getTime());
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
    InitCombo();
    return week;
    }
     void InitCombo(){
         System.out.println("hi   ");
         int i=1;
         
         for(i=1;i<=week;i++)
                 {
                 String j=String.valueOf(i);
                  Semaine.getItems().add(j);
                 }
     }
     @FXML
     void InitTable(){
        // S1.isSelected();
       
         S1.setSelected(false);
        S2.setSelected(false);
         S3.setSelected(false);
         S4.setSelected(false);
         S5.setSelected(false);
         S6.setSelected(false);
         S7.setSelected(false);
        
         D1.clear(); D2.clear(); D3.clear(); D4.clear(); D5.clear(); D6.clear();D7.clear(); 
         F1.clear(); F2.clear(); F3.clear(); F4.clear(); F5.clear(); F6.clear();F7.clear(); 
        D1.setEditable(false); D2.setEditable(false); D3.setEditable(false); D4.setEditable(false); D5.setEditable(false); D6.setEditable(false); D7.setEditable(false);
         F1.setEditable(false); F2.setEditable(false); F3.setEditable(false); F4.setEditable(false); F5.setEditable(false); F6.setEditable(false); F7.setEditable(false);

     }
     boolean t1 =false;
     boolean t2 =false;
     boolean t3 =false;
     boolean t4=false;
     boolean t5=false;
 public String[] tabI=new String[22];
 public String[] tabI2=new String[22];
 public String[] tabI3=new String[22];
  public String[] tabI4=new String[22];
 public String[] tabI5=new String[22];
 
     @FXML
      void Recuperation(){
         System.out.println("oooooooooooooooooooooo"+Semaine.getValue());
         int f= Integer.parseInt(Semaine.getValue());
         if(f== 1){
             t1=true;
       String[]  tab1={"1",D1.getText(),F1.getText(),D2.getText(),F2.getText(),D3.getText(),F3.getText(),D4.getText(),F4.getText(),
             D5.getText(),F5.getText(),D6.getText(),F6.getText(),D7.getText(),F7.getText(),"0","0","0","0","0","0","0"};
       if(D1.isEditable() && F1.isEditable()) tab1[15]="1";
       if(D2.isEditable() && F2.isEditable()) tab1[16]="1";
       if(D3.isEditable() && F3.isEditable()) tab1[17]="1";
       if(D4.isEditable() && F4.isEditable()) tab1[18]="1";
       if(D5.isEditable() && F5.isEditable()) tab1[19]="1";
       if(D6.isEditable() && F6.isEditable()) tab1[20]="1";
       if(D7.isEditable() && F7.isEditable()) tab1[21]="1";
             System.out.println("ookkk1");
            
             for(int y=0;y<21;y++)
                 System.out.println("premier Tableau    "+tab1[y]);
             tabI=tab1;
         }
         
          if(f==2){
              t2=true;
             String[] tab2 ={"2",D1.getText(),F1.getText(),D2.getText(),F2.getText(),D3.getText(),F3.getText(),D4.getText(),F4.getText(),
             D5.getText(),F5.getText(),D6.getText(),F6.getText(),D7.getText(),F7.getText(),"0","0","0","0","0","0","0"};
              if(D1.isEditable() && F1.isEditable()) tab2[15]="1";
       if(D2.isEditable() && F2.isEditable()) tab2[16]="1";
       if(D3.isEditable() && F3.isEditable()) tab2[17]="1";
       if(D4.isEditable() && F4.isEditable()) tab2[18]="1";
       if(D5.isEditable() && F5.isEditable()) tab2[19]="1";
       if(D6.isEditable() && F6.isEditable()) tab2[20]="1";
       if(D7.isEditable() && F7.isEditable()) tab2[21]="1";
             System.out.println("ookkk2");
             tabI2=tab2;
              for(int y=0;y<20;y++)
                 System.out.println("deuxième Tableau    "+tabI2[y]);
             
         }
           if(f==3){
               t3=true;
             String[] tab3 ={"3",D1.getText(),F1.getText(),D2.getText(),F2.getText(),D3.getText(),F3.getText(),D4.getText(),F4.getText(),
             D5.getText(),F5.getText(),D6.getText(),F6.getText(),D7.getText(),F7.getText(),"0","0","0","0","0","0","0"};
                   if(D1.isEditable() && F1.isEditable()) tab3[15]="1";
                 if(D2.isEditable() && F2.isEditable()) tab3[16]="1";
                 if(D3.isEditable() && F3.isEditable()) tab3[17]="1";
                if(D4.isEditable() && F4.isEditable()) tab3[18]="1";
                 if(D5.isEditable() && F5.isEditable()) tab3[19]="1";
                  if(D6.isEditable() && F6.isEditable()) tab3[20]="1";
                  if(D7.isEditable() && F7.isEditable()) tab3[21]="1";
             System.out.println("ookkk3");
            tabI3=tab3;
             for(int y=0;y<20;y++)
                 System.out.println("troisième Tableau    "+tabI3[y]);
             
         }
           if(f== 4){
             t4=true;
       String[]  tab4={"4",D1.getText(),F1.getText(),D2.getText(),F2.getText(),D3.getText(),F3.getText(),D4.getText(),F4.getText(),
             D5.getText(),F5.getText(),D6.getText(),F6.getText(),D7.getText(),F7.getText(),"0","0","0","0","0","0","0"};
       if(D1.isEditable() && F1.isEditable()) tab4[15]="1";
       if(D2.isEditable() && F2.isEditable()) tab4[16]="1";
       if(D3.isEditable() && F3.isEditable()) tab4[17]="1";
       if(D4.isEditable() && F4.isEditable()) tab4[18]="1";
       if(D5.isEditable() && F5.isEditable()) tab4[19]="1";
       if(D6.isEditable() && F6.isEditable()) tab4[20]="1";
       if(D7.isEditable() && F7.isEditable()) tab4[21]="1";
             System.out.println("ookkk4");
            
             for(int y=0;y<21;y++)
                 System.out.println("quatrieme Tableau    "+tab4[y]);
             tabI4=tab4;
         }
           if(f== 5){
             t5=true;
       String[]  tab5={"5",D1.getText(),F1.getText(),D2.getText(),F2.getText(),D3.getText(),F3.getText(),D4.getText(),F4.getText(),
             D5.getText(),F5.getText(),D6.getText(),F6.getText(),D7.getText(),F7.getText(),"0","0","0","0","0","0","0"};
       if(D1.isEditable() && F1.isEditable()) tab5[15]="1";
       if(D2.isEditable() && F2.isEditable()) tab5[16]="1";
       if(D3.isEditable() && F3.isEditable()) tab5[17]="1";
       if(D4.isEditable() && F4.isEditable()) tab5[18]="1";
       if(D5.isEditable() && F5.isEditable()) tab5[19]="1";
       if(D6.isEditable() && F6.isEditable()) tab5[20]="1";
       if(D7.isEditable() && F7.isEditable()) tab5[21]="1";
             System.out.println("ookkk5");
            
             for(int y=0;y<21;y++)
                 System.out.println("cinquiéme Tableau    "+tab5[y]);
             tabI5=tab5;
         }
  InitTable();
  
     }
      @FXML
      void Infos(){
         // boolean t1= false;boolean t2= false; boolean t3= false; boolean t4= false; boolean t5= false; boolean t6= false; boolean t7= false;
    int f= Integer.parseInt(Semaine.getValue());
    // int S= Integer.parseInt(Semaine.getValue());
               S1.setSelected(false);S2.setSelected(false); S3.setSelected(false); S4.setSelected(false); S5.setSelected(false); S6.setSelected(false); S7.setSelected(false);
            if(f== 1){
             System.out.println("11111");
             D1.setText(tabI[1]);  F1.setText(tabI[2]); 
             if(tabI[15]=="1") { 
             System.out.println("Actif"+S1.isSelected()); 
             S1.setSelected(true);
                 System.out.println("riiieennn");
             }
             D2.setText(tabI[3]);  F2.setText(tabI[4]); 
             if(tabI[16]=="1")  {
                 System.out.println("Actif2"+S2.isSelected());
                 S2.setSelected(true); }
             D3.setText(tabI[5]);  F3.setText(tabI[6]); 
             if(tabI[17]=="1")  {
                 S3.setSelected(true);
             } 
             
             D4.setText(tabI[7]);  F4.setText(tabI[8]); 
             if(tabI[18]=="1")  {
                 S4.setSelected(true);
             }
             D5.setText(tabI[9]);   F5.setText(tabI[10]); 
             if(tabI[19]=="1")  {
                 S5.setSelected(true);
             }
             D6.setText(tabI[11]);  F6.setText(tabI[12]);
             if(tabI[20]=="1")  {
                 S6.setSelected(true);
             }
             D7.setText(tabI[13]);  F7.setText(tabI[14]);
             if(tabI[21]=="1")  {
                 S7.setSelected(true);
             }
                       }
            for(int i=0;i<22;i++)
                    System.out.println("Tableau 1"+tabI[i]);

     
      S1.setSelected(false);S2.setSelected(false); S3.setSelected(false); S4.setSelected(false); S5.setSelected(false); S6.setSelected(false); S7.setSelected(false);

         if(f== 2){
             System.out.println("22222");
             D1.setText(tabI2[1]);  F1.setText(tabI2[2]); 
             if(tabI2[15]=="1") { 
           
             S1.setSelected(true);
        
             }
             D2.setText(tabI2[3]);  F2.setText(tabI2[4]); 
             if(tabI2[16]=="1") { 
              
             S2.setSelected(true);
                 
             }
             D3.setText(tabI2[5]);  F3.setText(tabI2[6]); 
             if(tabI2[17]=="1") { 
              
             S3.setSelected(true);
                 
             }
             D4.setText(tabI2[7]);  F4.setText(tabI2[8]); 
             if(tabI2[18]=="1") { 
              
             S4.setSelected(true);
                 
             }
             D5.setText(tabI2[9]);   F5.setText(tabI2[10]); 
             if(tabI2[19]=="1") { 
              
             S5.setSelected(true);
                 
             }
             D6.setText(tabI2[11]);  F6.setText(tabI2[12]);
             if(tabI2[20]=="1") { 
              
             S6.setSelected(true);
                 
             }
             D7.setText(tabI2[13]);  F7.setText(tabI2[14]);
             if(tabI2[21]=="1") { 
              
             S7.setSelected(true);
                 
             }
             
        
              }
      for(int i=0;i<22;i++)
                    System.out.println("Tableau 2"+tabI2[i]);

         S1.setSelected(false);S2.setSelected(false); S3.setSelected(false); S4.setSelected(false); S5.setSelected(false); S6.setSelected(false); S7.setSelected(false);
         if(f== 3){
             System.out.println("333333");
             D1.setText(tabI3[1]);  F1.setText(tabI3[2]); 
             D2.setText(tabI3[3]);  F2.setText(tabI3[4]); 
             D3.setText(tabI3[5]);  F3.setText(tabI3[6]); 
             D4.setText(tabI3[7]);  F4.setText(tabI3[8]); 
             D5.setText(tabI3[9]);   F5.setText(tabI3[10]);
             D6.setText(tabI3[11]);  F6.setText(tabI3[12]);
             D7.setText(tabI3[13]);  F7.setText(tabI3[14]);
              if(tabI3[15]=="1") { 
           
             S1.setSelected(true);
        
             }
                if(tabI3[16]=="1") { 
              
             S2.setSelected(true);
                 
             }
              if(tabI3[17]=="1") { 
              
             S3.setSelected(true);
                 
             }
                if(tabI3[18]=="1") { 
              
             S4.setSelected(true);
                 
             }
                if(tabI3[19]=="1") { 
              
             S5.setSelected(true);
                 
             }
                if(tabI3[20]=="1") { 
              
             S6.setSelected(true);
                 
             }
                if(tabI3[21]=="1") { 
              
             S7.setSelected(true);
                 
             }
         }
              S1.setSelected(false);S2.setSelected(false); S3.setSelected(false); S4.setSelected(false); S5.setSelected(false); S6.setSelected(false); S7.setSelected(false);
               if(f== 4){
             System.out.println("44444444");
             D1.setText(tabI4[1]);  F1.setText(tabI4[2]); 
             D2.setText(tabI4[3]);  F2.setText(tabI4[4]); 
             D3.setText(tabI4[5]);  F3.setText(tabI4[6]); 
             D4.setText(tabI4[7]);  F4.setText(tabI4[8]); 
             D5.setText(tabI4[9]);   F5.setText(tabI4[10]);
             D6.setText(tabI4[11]);  F6.setText(tabI4[12]);
             D7.setText(tabI4[13]);  F7.setText(tabI4[14]);
                   if(tabI4[15]=="1") { 
           
             S1.setSelected(true);
        
             }
                if(tabI4[16]=="1") { 
              
             S2.setSelected(true);
                 
             }
              if(tabI4[17]=="1") { 
              
             S3.setSelected(true);
                 
             }
                if(tabI4[18]=="1") { 
              
             S4.setSelected(true);
                 
             }
                if(tabI4[19]=="1") { 
              
             S5.setSelected(true);
                 
             }
                if(tabI4[20]=="1") { 
              
             S6.setSelected(true);
                 
             }
                if(tabI4[21]=="1") { 
              
             S7.setSelected(true);
                 
             }
              } 
        S1.setSelected(false);S2.setSelected(false); S3.setSelected(false); S4.setSelected(false); S5.setSelected(false); S6.setSelected(false); S7.setSelected(false);
         if(f== 5){
             System.out.println("555555");
             D1.setText(tabI5[1]);  F1.setText(tabI5[2]); 
             D2.setText(tabI5[3]);  F2.setText(tabI5[4]); 
             D3.setText(tabI5[5]);  F3.setText(tabI5[6]); 
             D4.setText(tabI5[7]);  F4.setText(tabI5[8]); 
             D5.setText(tabI5[9]);   F5.setText(tabI5[10]); 
             D6.setText(tabI5[11]);  F6.setText(tabI5[12]);
             D7.setText(tabI5[13]);  F7.setText(tabI5[14]);
                   if(tabI5[15]=="1") { 
           
             S1.setSelected(true);
        
             }
                if(tabI5[16]=="1") { 
              
             S2.setSelected(true);
                 
             }
              if(tabI5[17]=="1") { 
              
             S3.setSelected(true);
                 
             }
                if(tabI5[18]=="1") { 
              
             S4.setSelected(true);
                 
             }
                if(tabI5[19]=="1") { 
              
             S5.setSelected(true);
                 
             }
                if(tabI5[20]=="1") { 
              
             S6.setSelected(true);
                 
             }
                if(tabI5[21]=="1") { 
              
             S7.setSelected(true);
                 
             }
        
              }
      }
 String MaxF=null;
 @FXML
void AjoutSemaine(KeyEvent event) throws ParseException, SQLException, IOException {
 //String val= Semaine.getValue();
 //int b= Integer.parseInt(val);
 
 
    try{
     
      if (isValidCondition()) {
        
         // String SS="SELECT Max(IDFormation) FROM `formation`";
 
 String sql= "SELECT MAX(IDFormation) FROM formation";
                     pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    MaxF=rs.getString(1);
                     }
                     System.out.println("IDFormation    "+MaxF.toString());
                     
                     rs.close();
                    
                     if(t1){
                        for(int u=0;u<21;u++)
                         System.out.println("Seamineeeeeee 1    "+tabI[u]);
                   
     String req="INSERT INTO semaine(IDFormation,numero) values(?,?) ";
      pst = conn.prepareStatement(req);
                    pst.setString(1, MaxF.toString());
                    pst.setString(2,"1");
     
    
                    pst.executeUpdate();
                    pst.close();
                    
                System.out.println("la semaine"+tabI[0]+"  est ajoutée");
                AjoutSeance(tabI);
                     }
                //     System.out.println("apreeeetttt"+t2+"tttaabb2   "+tabI2[0]);
                     if(t2){
                     for(int u=0;u<21;u++)
                         System.out.println("Seamineeeeeee 1    "+tabI2[u]);
     String req="INSERT INTO semaine(IDFormation,numero) values(?,?) ";
     pst = conn.prepareStatement(req);             
     pst.setString(1, MaxF.toString());
                    pst.setString(2, "2");
                  
                    pst.executeUpdate();
                    pst.close();
                    
                System.out.println("la semaine"+tabI2[0]+"  est ajoutée");
               AjoutSeance(tabI2);
                     }
                   //  System.out.println("apreeeetttt"+t3+"tttaabb1   "+tabI3[0]);
                     if(t3){
                   // for(int u=0;u<21;u++)
                     //    System.out.println("Seamineeeeeee 3    "+tabI3[u]);
     String req="INSERT INTO semaine(IDFormation,numero) values(?,?) ";
     pst = conn.prepareStatement(req);
                    pst.setString(1, MaxF.toString());
                    pst.setString(2, "3");
      
      pst.executeUpdate();
                    pst.close();
                    
                System.out.println("la semaine"+tabI3[0]+" est ajoutée");
               AjoutSeance(tabI3);
                     }    
                      if(t4){
                  //  for(int u=0;u<21;u++)
                    //     System.out.println("Seamineeeeeee 1    "+tabI4[u]);
     String req="INSERT INTO semaine(IDFormation,numero) values(?,?) ";
     pst = conn.prepareStatement(req);
                    pst.setString(1, MaxF.toString());
                    pst.setString(2, "4");
      
      pst.executeUpdate();
                    pst.close();
                    
                System.out.println("la semaine"+tabI4[0]+" est ajoutée");
               AjoutSeance(tabI4);
                     }
                       if(t5){
                  //  for(int u=0;u<21;u++)
                    //     System.out.println("Seamineeeeeee 5    "+tabI5[u]);
     String req="INSERT INTO semaine(IDFormation,numero) values(?,?) ";
     pst = conn.prepareStatement(req);
                    pst.setString(1, MaxF.toString());
                    pst.setString(2, "5");
      
      pst.executeUpdate();
                    pst.close();
                    
                System.out.println("la semaine"+tabI5[0]+" est ajoutée");
               AjoutSeance(tabI5);
                     }
      } else {
          System.out.println("erreur d'ajout de semaine");
      }
      
      
 }catch (SQLException ex) {
            ex.printStackTrace();
    }
//    AjoutSeance(event);
}
@FXML
    void AjoutFormation() throws ParseException, SQLException, IOException {
                   
         try {
             
            if (isValidCondition()) {
                
          
                    String sql2 = "insert into formation (Date_Ajout,TitreFormation,Prix,Session,DateDebut,DateFin,idEnseignant,Niveau,Description) values(?,?,?,?,?,?,?,?,?)";
                    
                    
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
@FXML
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
   @FXML
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
    @FXML
   public void FenetreFormation() throws ParseException, IOException {

            rootAccueil = FXMLLoader.load(getClass().getResource("/dgsescuela/Formations/FXMLFormations.fxml"));
            sceneAccueil = new Scene(rootAccueil);
         


    }

}
