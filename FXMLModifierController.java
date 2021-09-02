/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgsescuela.Formations;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dgsescuela.DBConnection;
import static dgsescuela.Formations.FXMLAjouterController.EnseignantStage;
import static dgsescuela.Formations.FXMLFormationsController.StageFor;
import static dgsescuela.LoginPackage.loginController.adminStage;
import static dgsescuela.LoginPackage.loginController.rootAccueil;
import static dgsescuela.LoginPackage.loginController.sceneAccueil;
import dgsescuela.Modele.ModeleEnseignantsStatic;
import dgsescuela.Modele.ModeleFormationsStatic;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
import static sun.util.calendar.CalendarUtils.mod;

/**
 * FXML Controller class
 *
 * @author hdegd
 */
public class FXMLModifierController implements Initializable {

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
/*--------------------Check Box-----------------------*/
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
 @FXML
    private Label isEmpty;
/*------------------------------------------------------*/
@FXML
    private JFXTextField jour1;
  @FXML
    private JFXTextField jour2;
int nbrS=0;
String DD=null; String DF=null;
String S =null; String S444=null;
        String v=null;
         String S222 =null;
        String v2=null;
        String S333=null;
        String S4444=null;
        String S5555=null;
        String S666=null;
          String S777 =null;
        String v7=null;
        String S8=null;
        String S9=null;
        String S10=null;
        String S11=null; 
        String S12=null;
        String S13=null;
        String S14=null;
        String S15=null;
        String S16=null;
        String S17=null;
        String S18=null; String S55=null;
        String S19=null;
        String S20=null;
        String S21=null; 
         String S22=null;   String S24=null;    String S211=null;
        String S212=null;
        String S213=null;
        String S214=null;   String S66=null;String S6666=null;
        String S215=null; 
         String S216=null;   String S217=null;  String S218=null;   String S219=null;  String S220=null;   String S221=null;
        
         String S223=null;  String S224=null;   String S226=null;  String S227=null;   String S228=null; String S225=null;
         String S256=null;   String S257=null;  String S258=null;   String S259=null;  String S260=null;   String S261=null; String S262=null; String S263=null;
         String v216=null;   String v217=null;  String v218=null;   String v219=null;  String v220=null;   String v221=null;
         String v222=null;   String v223=null;  String v224=null;   String v226=null;  String v227=null;   String v228=null; String v225=null;
         String v256=null;   String v257=null;  String v258=null;   String v259=null;  String v260=null;   String v261=null; String v262=null; String v263=null;
         String v66=null;
         String S25=null;   String S26=null;
        String S27=null;
        String S23=null;
       
       
        String v5=null;
        String v6=null; String S36=null; String v46=null;
        String v8=null;
        String v9=null;
        String v10=null;
        String v11=null;
         String v12=null;
         String v13=null;
         String v14=null;
         String v15=null;
         String v16=null; String S77=null;
         String v17=null;
         String v18=null;
         String v19=null;String v2190=null;
         String v20=null;  String v21=null;  String v22=null;  String v23=null; String v24=null; String v25=null; String v26=null;
           String v211=null;    String v212=null;  String v213=null;  String v214=null;  String v215=null; String v255=null; String v4=null; String v36=null;
      
ModeleEnseignantsStatic CurrentObjetStatic;
    ModeleFormationsStatic mForm = new ModeleFormationsStatic();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             Session.getItems().addAll("1","2","3");
        Niveau.getItems().addAll("1","2","3"); 
        /*D1.setEditable(false);
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
        F7.setEditable(false);*/
       CurrentObjetStatic = new ModeleEnseignantsStatic();
        // TODO
        try {
            // TODO
            conn= DBConnection.EtablirConnection();
             String sql= "SELECT DateDebut FROM formation where IDFormation ='"+mForm.getIdFormation()+"'";
                     pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    DD=rs.getString(1);
                     }
                     System.out.println("DateDebut    "+DD.toString());
                     rs.close();
                     String sql2= "SELECT DateFin FROM formation where IDFormation ='"+mForm.getIdFormation()+"'";
                     pst = conn.prepareStatement(sql2);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    DF=rs.getString(1);
                     }
                     System.out.println("DateFin    "+DF.toString());
                     rs.close();
            Init();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dgsescuela.Etudiants.FXMLModifierController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
         initialisationData();

    }    
    private void Init(){
        LocalDate d= LocalDate.parse(DD);
        LocalDate f= LocalDate.parse(DF);
        //pour récupérer les informations qui existe déja dans la bdd
        
        if(mForm==null || mForm.getIdFormation().equals("")){
            
               Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur :   ");
                alert.setContentText("Veuillez Selectionner une formation d'abord!!!");
                alert.showAndWait();
                
        }else{ 
       Titre.setText(mForm.getTitreFormation());
       DateD.setValue(d);
       DateF.setValue(f);
       CalculSemaine();
     Description.setText(mForm.getDescription());
        Session.setValue(mForm.getSession());
        Niveau.setValue(mForm.getNiveau());
        idens.setText(mForm.getIdEnseignant());
        Prix.setText(mForm.getPrix());
        
        }
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
            
                CalculSeance(cmpS);
                    
            }
    @FXML
    void Sceance() throws SQLException, ParseException{
        
                    int f= Integer.parseInt(Semaine.getValue().toString());
                    if(f==0) System.out.println("vvvvvvvvviiiiiiiiiiiiiiiiiiidddddddddeeeeeee  ");
                    if(f==1){
                        Initialisation();
                     S444 = "SELECT IDSemaine FROM `semaine` where numero='1' and IDFormation='"+mForm.getIdFormation()+"'" ;
                    pst = conn.prepareStatement(S444);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v4=rs.getString(1);
                     }
                      rs.close(); 
                     
                     System.out.println("IDSemaine1   "+v4);
                   if(v4==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     S55 = "SELECT HeureDebut FROM `sceance` where jour= 'samedi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S55);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v5=rs.getString(1);
                     }
                     System.out.println("HeureDebutSamedi   "+v5);
                    rs.close(); 
                      if(v5==null) {D1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D1.setText(v5);
                    
                     S6666 = "SELECT HeureFin FROM `sceance` where jour= 'samedi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S6666);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v6=rs.getString(1);
                     }
                     System.out.println("vv6vvv   "+v6);
                    rs.close(); 
                      if(v6==null) {F1.setText(""); System.out.println("hEURESamedi Null");}
                    else F1.setText(v6);
                     /* if(v5!=null && v6!= null) 
                       {S1.setSelected(true);
                     }*/
                    /*******************************/
                 
                    S66 = "SELECT HeureDebut FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S66);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v66=rs.getString(1);
                     }
                     System.out.println("HeureDebutDimanche   "+v66);
                    rs.close(); 
                    if(v66==null) {D2.setText(""); System.out.println("hEUREDimanche Null");}
                    else D2.setText(v66);
                    
                     S77 = "SELECT HeureFin FROM `sceance` where jour='dimanche' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S77);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v7=rs.getString(1);
                     }
                     System.out.println("HeureFinDimanche   "+v7);
                    rs.close(); 
                     if(v7==null) {F2.setText(""); System.out.println("hEUREDimanche Null");}
                    else F2.setText(v7);
                   /*if(v66!=null && v7!= null) 
                     {S2.setSelected(true);
                     }
                    /***************************************/
                    
                      S219 = "SELECT HeureDebut FROM `sceance` where jour= 'lundi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S219);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v219=rs.getString(1);
                     }
                     System.out.println("HeureDebutLundi   "+v219);
                    rs.close(); 
                    if(v219==null) {D3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D3.setText(v219);
                   
                     S10 = "SELECT HeureFin FROM `sceance` where jour='lundi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S10);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v9=rs.getString(1);
                     }
                     System.out.println("HeureFinLundi   "+v9);
                    rs.close(); 
                     if(v9==null) {F3.setText(""); System.out.println("hhhLUNDI Null");}
                    else F3.setText(v9);
                  
                 /*if(v8!=null && v9!= null) 
                       {S3.setSelected(true);
                     }
                    /*********************/
                          
                       S11 = "SELECT HeureDebut FROM `sceance` where jour='mardi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S11);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v10=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v10);
                    rs.close(); 
                    if(v10==null) {D4.setText(""); System.out.println("HHHMARDDII Null");}
                    else D4.setText(v10);
                   
                     S12 = "SELECT HeureFin FROM `sceance` where jour= 'mardi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S12);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v11=rs.getString(1);
                     }
                     System.out.println("HeureFinMardi   "+v11);
                    rs.close(); 
                    if(v11==null) {F4.setText(""); System.out.println("HHHMARDDII Null");}
                    else F4.setText(v11);
                    
                    /* if(v10!=null && v11!= null) 
                          {S4.setSelected(true);
                     }
                    /*********************/
                    S13 = "SELECT HeureDebut FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S13);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v12=rs.getString(1);
                     }
                     System.out.println("HeureDebutMercredi  "+v12);
                    rs.close(); 
                    if(v12==null) {D5.setText(""); System.out.println("HHHMERCREDI Null");}
                    else D5.setText(v12);
                    
                     S14 = "SELECT HeureFin FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S14);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v13=rs.getString(1);
                     }
                     System.out.println("HeureFinMercredi   "+v13);
                    rs.close(); 
                    if(v13==null) {F5.setText(""); System.out.println("HHHMERCREDI Null");}
                    else F5.setText(v13);
                   /*if(v12!=null && v13!= null) 
                        {S5.setSelected(true);
                     }
                    /************/
                    S15 = "SELECT HeureDebut FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S15);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v14=rs.getString(1);
                     }
                     System.out.println("HeureDebutJeudi  "+v14);
                    rs.close(); 
                    if(v14==null) {D6.setText(""); System.out.println("HHHHHSJEUDI Null");}
                    else D6.setText(v14);
                    
                     S16 = "SELECT HeureFin FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S16);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v15=rs.getString(1);
                     }
                     System.out.println("HeureFinJeudi   "+v15);
                    rs.close(); 
                      if(v15==null) {F6.setText(""); System.out.println("HHHSJEUDI Null");}
                    else F6.setText(v15);
                    
                 /*if(v14!=null && v15!= null) 
                       {S6.setSelected(true);
                     }
                    /*********/
                    S17 = "SELECT HeureDebut FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S17);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v16=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v16);
                    rs.close(); 
                    if(v16==null) {D7.setText(""); System.out.println("DHHHHHvENDREDI Null");}
                    else D7.setText(v5);
                    
                     S18 = "SELECT HeureFin FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S18);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v17=rs.getString(1);
                     }
                     System.out.println("HeureFinVendredi   "+v17);
                    rs.close(); 
                     if(v17==null) {F7.setText(""); System.out.println("DHHHHHvENDREDI Null");}
                    else  F7.setText(v17);
                   /*if(v16!=null && v17!= null)
                        {S7.setSelected(true);
                     }*/
                    } 
                    /*+++++++++++++++++++++++++++++*/
                     if(f==4){
                         Initialisation();
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='4' and IDFormation='"+mForm.getIdFormation()+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                     }
                     if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine4   "+v211);
                    rs.close(); 
                     S212 = "SELECT HeureDebut FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S212);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v212=rs.getString(1);
                     }
                     System.out.println("HeureDebutSamedi   "+v212);
                    rs.close(); 
                    if(v212==null) {D1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D1.setText(v212);
                   
                     S213 = "SELECT HeureFin FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S213);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v213=rs.getString(1);
                     }
                     System.out.println("vv5vvv   "+v213);
                    rs.close();
                    if(v213==null) {F1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F1.setText(v213);
                     /*  if(v212!=null && v213!= null)
                            {S1.setSelected(true);
                     }
                    /*******************************/
                 
                      S215 = "SELECT HeureDebut FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S215);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v216=rs.getString(1);
                     }
                     System.out.println("HeureDebutDimanche   "+v216);
                    rs.close(); 
                    if(v216==null) {D2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D2.setText(v216);
                    
                     S217 = "SELECT HeureFin FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S217);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v217=rs.getString(1);
                     }
                     System.out.println("HeureFinDimanche   "+v217);
                    rs.close(); 
                    if(v217==null) {F2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F2.setText(v217);
                  /* if(v216!=null && v217!= null)
                   {S2.setSelected(true);
                   }*/
                   
                     
                    
                    //***************************************
                    
                    S219 = "SELECT HeureDebut FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S219);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v219=rs.getString(1);
                     }
                     System.out.println("HeureDebutLundi   "+v219);
                    rs.close(); 
                    if(v219==null) {D3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D3.setText(v219);
                    
                     S220 = "SELECT HeureFin FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S220);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v220=rs.getString(1);
                     }
                     System.out.println("HeureFinLundi   "+v220);
                    rs.close(); 
                    if(v220==null) {F3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F3.setText(v220);
                  
                 /*if(v219!=null && v220!= null) 
                      {S3.setSelected(true);
                     }*/
                 
                    //********************
                          
                       S222 = "SELECT HeureDebut FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S222);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v222=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v222);
                    rs.close(); 
                    if(v222==null) {D4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D4.setText(v222);
                   
                     S223 = "SELECT HeureFin FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S223);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v223=rs.getString(1);
                     }
                     System.out.println("HeureFinMardi   "+v223);
                    rs.close(); 
                    if(v223==null) {F4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F4.setText(v223);
                    /*if(v222!=null && v223!= null) 
                     {S4.setSelected(true);
                     }*/
                    
                    
                    //********************
                    S225 = "SELECT HeureDebut FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S225);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v255=rs.getString(1);
                     }
                     System.out.println("HeureDebutMercredi  "+v255);
                    rs.close(); 
                    if(v255==null) {D5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D5.setText(v255);
                    
                     S256 = "SELECT HeureFin FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S256);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v256=rs.getString(1);
                     }
                     System.out.println("HeureFinMercredi   "+v256);
                    rs.close(); 
                    if(v256==null) {F5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F5.setText(v256);
                  /*if(v255!=null && v256!= null) 
                       {S5.setSelected(true);
                     }*/
                  
                   
                    //***********
                    S258 = "SELECT HeureDebut FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S258);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v258=rs.getString(1);
                     }
                     System.out.println("HeureDebutJeudi  "+v258);
                    rs.close(); 
                    if(v258==null) {D6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D6.setText(v258);
                  
                     S259 = "SELECT HeureFin FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S259);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v259=rs.getString(1);
                     }
                     System.out.println("HeureFinJeudi   "+v259);
                    rs.close(); 
                    if(v259==null) {F6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F6.setText(v259);
                   
                   /* if(v258!=null && v259!= null) 
                         {S6.setSelected(true);
                     }*/
                    //********
                    S261 = "SELECT HeureDebut FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S261);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v261=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v261);
                    rs.close(); 
                    if(v261==null) {D7.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D7.setText(v261);
                   
                     S262 = "SELECT HeureFin FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S262);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v262=rs.getString(1);
                     }
                     System.out.println("HeureFinVendredi   "+v262);
                    rs.close(); 
                    if(v262==null) {F7.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F7.setText(v262);
                   
                     /*if(v261!=null && v262!= null) 
                          {S7.setSelected(true);
                     }*/
                    
                    } 
                    /*+++++++++++++++++++++++++++++*/
                     if(f==3){
                         Initialisation();
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='3' and IDFormation='"+mForm.getIdFormation()+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                     }
                     if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine3   "+v211);
                    rs.close(); 
                     S212 = "SELECT HeureDebut FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S212);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v212=rs.getString(1);
                     }
                     System.out.println("HeureDebutSamedi   "+v212);
                    rs.close(); 
                    if(v212==null) {D1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D1.setText(v212);
                   
                     S213 = "SELECT HeureFin FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S213);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v213=rs.getString(1);
                     }
                     System.out.println("vv5vvv   "+v213);
                    rs.close();
                    if(v213==null) {F1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F1.setText(v213);
                     /* if(v212!=null && v213!= null)
                           {S1.setSelected(true);
                     }*/
                         
                       
                    /*******************************/
                 
                      S215 = "SELECT HeureDebut FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S215);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v216=rs.getString(1);
                     }
                     System.out.println("HeureDebutDimanche   "+v216);
                    rs.close(); 
                    if(v216==null) {D2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D2.setText(v216);
                    
                     S217 = "SELECT HeureFin FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S217);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v217=rs.getString(1);
                     }
                     System.out.println("HeureFinDimanche   "+v217);
                    rs.close(); 
                    if(v217==null) {F2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F2.setText(v217);
                   /*if(v216!=null && v217!= null) 
                    {S2.setSelected(true);
                     }*/
                  
                    
                    
                    //***************************************
                    
                       S219 = "SELECT HeureDebut FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S219);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v219=rs.getString(1);
                     }
                     System.out.println("HeureDebutLundi   "+v219);
                    rs.close(); 
                    if(v219==null) {D3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D3.setText(v219);
                    
                     S220 = "SELECT HeureFin FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S220);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v220=rs.getString(1);
                     }
                     System.out.println("HeureFinLundi   "+v220);
                    rs.close(); 
                    if(v220==null) {F3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F3.setText(v220);
                  
                    /* if(v219!=null && v220!= null) 
                          {S3.setSelected(true);
                     }*/

                 
                    //********************
                          
                       S222 = "SELECT HeureDebut FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S222);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v222=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v222);
                    rs.close(); 
                    if(v222==null) {D4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D4.setText(v222);
                   
                     S223 = "SELECT HeureFin FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S223);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v223=rs.getString(1);
                     }
                     System.out.println("HeureFinMardi   "+v223);
                    rs.close(); 
                    if(v223==null) {F4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F4.setText(v223);
                   /* if(v222!=null && v223!= null) 
                     {S4.setSelected(true);
                     }*/
                    
                    //********************
                    S225 = "SELECT HeureDebut FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S225);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v255=rs.getString(1);
                     }
                     System.out.println("HeureDebutMercredi  "+v255);
                    rs.close(); 
                    if(v255==null) {D5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D5.setText(v255);
                    
                     S256 = "SELECT HeureFin FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S256);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v256=rs.getString(1);
                     }
                     System.out.println("HeureFinMercredi   "+v256);
                    rs.close(); 
                    if(v256==null) {F5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F5.setText(v256);
                  
                    /* if(v255!=null && v256!= null) 
                          {S5.setSelected(true);
                     }*/

                   
                    //***********
                    S258 = "SELECT HeureDebut FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S258);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v258=rs.getString(1);
                     }
                     System.out.println("HeureDebutJeudi  "+v258);
                    rs.close(); 
                    if(v258==null) {D6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D6.setText(v258);
                  
                     S259 = "SELECT HeureFin FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S259);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v259=rs.getString(1);
                     }
                     System.out.println("HeureFinJeudi   "+v259);
                    rs.close(); 
                    if(v259==null) {F6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F6.setText(v259);
                    
                     /*   if(v258!=null && v259!= null) 
                             {S6.setSelected(true);
                     }*/

                    //********
                    S261 = "SELECT HeureDebut FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S261);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v261=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v261);
                    rs.close(); 
                    if(v261==null) {D7.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D7.setText(v261);
                   
                     S262 = "SELECT HeureFin FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S262);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v262=rs.getString(1);
                     }
                     System.out.println("HeureFinVendredi   "+v262);
                    rs.close(); 
                    if(v262==null) {F7.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F7.setText(v262);
                  /* if(v261!=null && v262!= null) 
                        {S7.setSelected(true);
                     }*/
                     
                    } 
                     /*+++++++++++++++++++++++++++++*/
                     if(f==5){
                         Initialisation();
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='5' and IDFormation='"+mForm.getIdFormation()+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                    
                     }
                    if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                   
                     System.out.println("IDSemaine5   "+v211);
                    rs.close(); 
                     S212 = "SELECT HeureDebut FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S212);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v212=rs.getString(1);
                     }
                     System.out.println("HeureDebutSamedi   "+v212);
                    rs.close(); 
                    if(v212==null) {D1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D1.setText(v212);
                   
                     S213 = "SELECT HeureFin FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S213);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v213=rs.getString(1);
                     }
                     System.out.println("vv5vvv   "+v213);
                    rs.close();
                    if(v213==null) {F1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F1.setText(v213);
                      
                     /*  if(v212!=null && v213!= null) 
                       {S1.setSelected(true);
                     }*/
                       
                    /*******************************/
                 
                      S215 = "SELECT HeureDebut FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S215);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v216=rs.getString(1);
                     }
                     System.out.println("HeureDebutDimanche   "+v216);
                    rs.close(); 
                    if(v216==null) {D2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D2.setText(v216);
                    
                     S217 = "SELECT HeureFin FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S217);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v217=rs.getString(1);
                     }
                     System.out.println("HeureFinDimanche   "+v217);
                    rs.close(); 
                    if(v217==null) {F2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F2.setText(v217);
                   
                    /*if(v216!=null && v217!= null) 
                         {S2.setSelected(true);
                     }*/
                    
                    //***************************************
                    
                       S219 = "SELECT HeureDebut FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S219);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v219=rs.getString(1);
                     }
                     System.out.println("HeureDebutLundi   "+v219);
                    rs.close(); 
                    if(v219==null) {D3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D3.setText(v219);
                    
                     S220 = "SELECT HeureFin FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S220);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v220=rs.getString(1);
                     }
                     System.out.println("HeureFinLundi   "+v220);
                    rs.close(); 
                    if(v220==null) {F3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F3.setText(v220);
                   /* if(v219!=null && v220!= null) 
                         {S3.setSelected(true);
                     }*/
                     
                 
                    //********************
                          
                       S222 = "SELECT HeureDebut FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S222);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v222=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v222);
                    rs.close(); 
                    if(v222==null) {D4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D4.setText(v222);
                   
                     S223 = "SELECT HeureFin FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S223);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v223=rs.getString(1);
                     }
                     System.out.println("HeureFinMardi   "+v223);
                    rs.close(); 
                    if(v223==null) {F4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F4.setText(v223);
                    /*if(v222!=null && v223!= null) 
                     {S4.setSelected(true);
                     }*/
                    
                    //********************
                    S225 = "SELECT HeureDebut FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S225);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v255=rs.getString(1);
                     }
                     System.out.println("HeureDebutMercredi  "+v255);
                    rs.close(); 
                    if(v255==null) {D5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D5.setText(v255);
                    
                     S256 = "SELECT HeureFin FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S256);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v256=rs.getString(1);
                     }
                     System.out.println("HeureFinMercredi   "+v256);
                    rs.close(); 
                    if(v256==null) {F5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F5.setText(v256);
                  
                     
                   
                    //***********
                    S258 = "SELECT HeureDebut FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S258);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v258=rs.getString(1);
                     }
                     System.out.println("HeureDebutJeudi  "+v258);
                    rs.close(); 
                    if(v258==null) {D6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D6.setText(v258);
                  
                     S259 = "SELECT HeureFin FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S259);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v259=rs.getString(1);
                     }
                     System.out.println("HeureFinJeudi   "+v259);
                    rs.close(); 
                    if(v259==null) {F6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F6.setText(v259);
                    
                    /*if(v258!=null && v259!= null) 
                         {S6.setSelected(true);
                     }*/
                    
                    //********
                    S261 = "SELECT HeureDebut FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S261);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v261=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v261);
                    rs.close(); 
                    if(v261==null) {D7.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D7.setText(v261);
                   
                     S262 = "SELECT HeureFin FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S262);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v262=rs.getString(1);
                     }
                     System.out.println("HeureFinVendredi   "+v262);
                    rs.close(); 
                    if(v262==null) {F7.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F7.setText(v262);
                   
                    /* if(v261!=null && v262!= null) 
                     {S7.setSelected(true);
                     }*/
                    
                    } 
                       if(f==2){
                         Initialisation();
                        
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='2' and IDFormation='"+mForm.getIdFormation()+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                     }
                     rs.close(); 
                     if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine2   "+v211);
                    
                     S212 = "SELECT HeureDebut FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S212);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v212=rs.getString(1);
                     }
                     System.out.println("HeureDebutSamedi   "+v212);
                    rs.close(); 
                    if(v212==null) {D1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D1.setText(v212);
                   
                     S213 = "SELECT HeureFin FROM `sceance` where jour= 'samedi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S213);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v213=rs.getString(1);
                     }
                     System.out.println("vv5vvv   "+v213);
                    rs.close();
                    if(v213==null) {F1.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F1.setText(v213);
                      
               /* if(v212!=null && v213!= null) {
                    System.out.println("+++++++++"+S1.isSelected());
                    S1.setSelected(true);
                }*/
                      
                       
                    /*******************************/
                 
                      S215 = "SELECT HeureDebut FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S215);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v216=rs.getString(1);
                     }
                     System.out.println("HeureDebutDimanche   "+v216);
                    rs.close(); 
                    if(v216==null) {D2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D2.setText(v216);
                    
                     S217 = "SELECT HeureFin FROM `sceance` where jour= 'dimanche' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S217);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v217=rs.getString(1);
                     }
                     System.out.println("HeureFinDimanche   "+v217);
                    rs.close(); 
                    if(v217==null) {F2.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F2.setText(v217);
                   
                    
                   /* if(v216!=null && v217!= null) 
                         {S2.setSelected(true);
                     }*/
                    
                    //***************************************
                    S219 = "SELECT HeureDebut FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S219);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v2190=rs.getString(1);
                     }
                     rs.close();
                     System.out.println("HeureDebutLundi2   "+v2190);
                     
                    //if(v2190==null) {D3.setText("");}
                    //else 
                    D3.setText("hhhhhhhhhhhhhhhhhhhhhhh");
                    
                     S220 = "SELECT HeureFin FROM `sceance` where jour= 'lundi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S220);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v220=rs.getString(1);
                     }
                     System.out.println("HeureFinLundi   "+v220);
                    rs.close(); 
                    if(v220==null) {F3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F3.setText(v220);
                  
                   
                     System.out.println("DateSDLundi   "+v221);
                    rs.close(); 
                    if(v221==null) {D3.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D3.setText(v221);
                     /*if(v219!=null && v220!= null) 
                          {S3.setSelected(true);
                     }*/

                    //********************
                          
                       S222 = "SELECT HeureDebut FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S222);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v222=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v222);
                    rs.close(); 
                    if(v222==null) {D4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D4.setText(v222);
                   
                     S223 = "SELECT HeureFin FROM `sceance` where jour= 'mardi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S223);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v223=rs.getString(1);
                     }
                     System.out.println("HeureFinMardi   "+v223);
                    rs.close(); 
                    if(v223==null) {F4.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F4.setText(v223);
                    
                    /*if(v222!=null && v223!= null) 
                     {S4.setSelected(true);
                     }*/
                    //********************
                    S225 = "SELECT HeureDebut FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S225);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v255=rs.getString(1);
                     }
                     System.out.println("HeureDebutMercredi  "+v255);
                    rs.close(); 
                    if(v225==null) {D5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D5.setText(v255);
                    
                     S256 = "SELECT HeureFin FROM `sceance` where jour= 'mercredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S256);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v256=rs.getString(1);
                     }
                     System.out.println("HeureFinMercredi   "+v256);
                    rs.close(); 
                    if(v256==null) {F5.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F5.setText(v256);
                  
                   /* if(v255!=null && v256!= null) 
                         {S5.setSelected(true);
                     }*/

                   
                    //***********
                    S258 = "SELECT HeureDebut FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S258);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v258=rs.getString(1);
                     }
                     System.out.println("HeureDebutJeudi  "+v258);
                    rs.close(); 
                    if(v258==null) {D6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D6.setText(v258);
                  
                     S259 = "SELECT HeureFin FROM `sceance` where jour= 'jeudi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S259);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v259=rs.getString(1);
                     }
                     System.out.println("HeureFinJeudi   "+v259);
                    rs.close(); 
                    if(v259==null) {F6.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else F6.setText(v259);
                    
                    /* if(v258!=null && v259!= null) 
                             {S6.setSelected(true);
                     }*/
                    
                    //********
                    S261 = "SELECT HeureDebut FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S261);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v261=rs.getString(1);
                     }
                     System.out.println("HeureDebutMardi  "+v261);
                    rs.close(); 
                    if(v261==null) {D7.setText(""); System.out.println("hEUREsAMEDI Null");}
                    else D7.setText(v261);
                   
                     S262 = "SELECT HeureFin FROM `sceance` where jour= 'vendredi' and IDSemaine='"+v211+"'" ;
                    pst = conn.prepareStatement(S262);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v262=rs.getString(1);
                     }
                     System.out.println("HeureFinVendredi   "+v262);
                    rs.close(); 
                    if(v262==null) {F7.setText(""); System.out.println("hEUREvendredi Null");}
                    else F7.setText(v262);
                  /* if(v261!=null && v262!= null) 
                  {S7.setSelected(true);
                     }*/
                    
                    } 
              
    }


     @FXML
     void CalculSeance(int c){
         
               nbrseance.setText( ""+cmpS);
         
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
        date1.set(ld.getYear(), ld.getMonthValue()-1,ld.getDayOfMonth());
        

        date2.clear();
        date2.set(ld2.getYear(), ld2.getMonthValue()-1,ld2.getDayOfMonth());
        SimpleDateFormat sdf =new SimpleDateFormat("EEEE");
        System.out.println("jjjjouuurrrrr1    "+sdf.format(date1.getTime()));
       jour1.setText(sdf.format(date1.getTimeInMillis()));
        SimpleDateFormat sdf2 =new SimpleDateFormat("EEEE");
        System.out.println("jjjjouuurrrrr2    "+sdf2.format(date2.getTime()));
               jour2.setText(sdf2.format(date2.getTimeInMillis()));
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
      @FXML 
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
    public void Initialisation(){
         S =null; S2 =null;v2=null;
         S3=null;   S7 =null;
         v7=null;
         S8=null;
         S9=null; S36=null; String v36=null;
         S10=null;
         S11=null; 
         S4=null;
         S5=null;
         S6=null;
           S19=null;S22=null;    S24=null;     S211=null;  S20=null;
         S21=null; 
         S12=null;
         S13=null;
         S14=null;
         S15=null;
         S16=null;
         S17=null;
         S18=null;
         S212=null;
         S213=null;
         S214=null;    S66=null;
         S215=null; 
          S216=null;    S217=null;   S218=null;    S219=null;   S220=null;    S221=null;
          S222=null;    S223=null;   S224=null;    S226=null;   S227=null;    S228=null;  S225=null;
          S256=null;    S257=null;   S258=null;    S259=null;   S260=null;    S261=null;  S262=null;  S263=null;
          v216=null;    v217=null;   v218=null;    v219=null;   v220=null;    v221=null;
          v222=null;    v223=null;   v224=null;    v226=null;   v227=null;    v228=null;  v225=null;
          v256=null;    v257=null;   v258=null;    v259=null;   v260=null;    v261=null;  v262=null;  v263=null;
          v66=null;
          S25=null;    S26=null;
         S27=null;
         S23=null;
       
         
         v5=null;
         v6=null;
         v8=null;
         v9=null;
         v10=null;
         v11=null;
          v12=null;
          v13=null;
          v14=null;
          v15=null;
          v16=null;
          v17=null;
          v18=null;
          v19=null;
          v20=null;   v21=null;   v22=null;   v23=null;  v24=null;  v25=null;  v26=null;
            v211=null;     v212=null;   v213=null;   v214=null;   v215=null;  v255=null;
    
    }
    
     @FXML
    void ModifierFormation()  {
        try {
           
            //if (isValidCondition()) {
                String sql = "update formation set Date_Ajout=?, TitreFormation=?, Prix=?, Session =?, DateDebut =?, DateFin=?,IdEnseignant=?, Niveau=?, Description= ? where IDFormation='" +mForm.getIdFormation()+"'";
                      

             pst = conn.prepareStatement(sql);
                    

                  
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
                    alert.setContentText("la formation a été Bien Modifier");
                    alert.showAndWait();
                    
                    StageFor.close();
                    FenetreFormation();
            
            
            
                    
          } catch (SQLException ex) {
            ex.printStackTrace();

        } /*catch (ParseException ex) {
            Logger.getLogger(dgsescuela.Formations.FXMLModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }*/ catch (IOException ex) {
            Logger.getLogger(dgsescuela.Formations.FXMLModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        KeyEvent event = null;
        ModifierSemaine();
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
       // D1.setEditable(false); D2.setEditable(false); D3.setEditable(false); D4.setEditable(false); D5.setEditable(false); D6.setEditable(false); D7.setEditable(false);
        // F1.setEditable(false); F2.setEditable(false); F3.setEditable(false); F4.setEditable(false); F5.setEditable(false); F6.setEditable(false); F7.setEditable(false);

     }
    @FXML
    void ModifierSemaine() {
             if(t1)
            ModiferSeance(tabI);
             if(t2)
            ModiferSeance(tabI2);
             if(t3)
            ModiferSeance(tabI3);
             if(t4)
            ModiferSeance(tabI4);
              if(t5)
            ModiferSeance(tabI5);
 }
    @FXML
    void ModiferSeance (String[] t) {
         LocalDate ldF = DateD.getValue();
            Calendar dateF = Calendar.getInstance();  
             SimpleDateFormat sdf3 =new SimpleDateFormat("yyyy/MM/dd ");
             dateF.clear();
        dateF.set(ldF.getYear(), ldF.getMonthValue()-1,ldF.getDayOfMonth());
        try {
            String v=null;
            String sqlS= null;
            
            sqlS = "SELECT IDSemaine FROM semaine where IDFormation ='"+mForm.getIdFormation()+"' and numero ='"+t[0]+"'" ;
            pst = conn.prepareStatement(sqlS);
            rs = pst.executeQuery();
            if(rs.next()){
                v=rs.getString(1);
            }
            System.out.println("vvvvvvvvvvvvvv"+v);
            rs.close();
            
            String sql= "Update sceance set DateSceance=?,HeureDebut=?,HeureFin=?,IDSemaine=?,jour=? where IDSemaine='"+v+"'";;
            pst = conn.prepareStatement(sql);
            /*******/
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
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    private boolean isValidCondition() throws SQLException {
        isEmpty.setText("");
        boolean registration = false;
        if (isEmpty()) {
            System.out.println("Condition valid");
            registration = true;
            isEmpty.setText("done !!!");
            isEmpty.setStyle("-fx-text-fill:green;");

        } else {
            isEmpty.setText("SVP entrer tous les champs !!!");
            isEmpty.setStyle("-fx-text-fill:red;");

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

  public void initialisationData(){
    
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
   
     
      
    

 
   
      
    private void actualiser() throws IOException{
        
         
       
 
    }
   
    
     private void selectCondidat(){
    }
    
     
    @FXML
    void FenetreFormation() throws IOException{
         rootAccueil = FXMLLoader.load(getClass().getResource("/dgsescuela/Formations/FXMLFormations.fxml"));
            sceneAccueil = new Scene(rootAccueil);
         adminStage.setScene(sceneAccueil);
            adminStage.show();
            adminStage.setMaximized(false);
            adminStage.setMaximized(true);
        
    }
   

}
