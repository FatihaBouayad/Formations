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
import dgsescuela.Modele.ModeleEnseignantsStatic;
import dgsescuela.Modele.ModeleFormationsStatic;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import static sun.util.calendar.CalendarUtils.mod;

/**
 * FXML Controller class
 *
 * @author Fatiha Bouayed
 */
public class FXMLAffichageController implements Initializable {
Connection conn;
    PreparedStatement pst = null;
    Statement st;
    PreparedStatement pst2=null;
    ResultSet rs = null;
    int cmp=0;
    int cmp2=0;
    int cmp3=0;
    int cmp4=0;
    int cmp5=0;
    int cmp6=0;
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
int nbrS=0;
String DD=null; String DF=null;

String S =null;
        String v=null;
         String S2 =null;
        String v2=null;
        String S3=null;
        String S4=null;
        String S5=null;
        String S6=null;
          String S7 =null;
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
        String S18=null;
        String S19=null;
        String S20=null;
        String S21=null; 
         String S22=null;   String S24=null;    String S211=null;
        String S212=null;
        String S213=null;
        String S214=null;   String S66=null;
        String S215=null; 
         String S216=null;   String S217=null;  String S218=null;   String S219=null;  String S220=null;   String S221=null;
         String S222=null;   String S223=null;  String S224=null;   String S226=null;  String S227=null;   String S228=null; String S225=null;
         String S256=null;   String S257=null;  String S258=null;   String S259=null;  String S260=null;   String S261=null; String S262=null; String S263=null;
         String v216=null;   String v217=null;  String v218=null;   String v219=null;  String v220=null;   String v221=null;
         String v222=null;   String v223=null;  String v224=null;   String v226=null;  String v227=null;   String v228=null; String v225=null;
         String v256=null;   String v257=null;  String v258=null;   String v259=null;  String v260=null;   String v261=null; String v262=null; String v263=null;
         String v66=null;
         String S25=null;   String S26=null;
        String S27=null;
        String S23=null;
       String v4=null;
        String v3=null;
        String v5=null;
        String v6=null; String S36=null; String v36=null;
        String v8=null;
        String v9=null; int week=0;
        String v10=null;
        String v11=null;
         String v12=null;
         String v13=null;
         String v14=null;
         String v15=null;
         String v16=null;
         String v17=null;
         String v18=null;
         String v19=null;
         String v20=null;  String v21=null;  String v22=null;  String v23=null; String v24=null; String v25=null; String v26=null;
           String v211=null;    String v212=null;  String v213=null;  String v214=null;  String v215=null; String v255=null;
      String X11=null;       String X22=null; 
      String X33=null; 
      String X44=null;        String X55=null; 
int M=0; int M2=0;int M3=0; int M4=0; int M5=0;

    
   ModeleEnseignantsStatic CurrentObjetStatic;
    ModeleFormationsStatic mForm = new ModeleFormationsStatic();
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
             Session.getItems().addAll("1","2","3");
        Niveau.getItems().addAll("1","2","3"); 
      
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
 
    public void initialisationData(){
    
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
      void InitCombo(){
         System.out.println("hi   ");
         int i=1;
         
         for(i=1;i<=week;i++)
                 {
                 String j=String.valueOf(i);
                  Semaine.getItems().add(j);
                 }
     }
    public void Initialisation(){
         S =null; S2 =null;v2=null;
         S3=null;   S7 =null;
         v7=null;v260=null;
         
         S8=null;
         S9=null; S36=null;  v36=null;
         S10=null;
         S11=null; 
         S4=null;v263=null;
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
          v256=null;      v258=null;    v259=null;      v261=null;  v262=null;  v263=null;
          v66=null; v257=null;
          S25=null;    S26=null;
         S27=null;
         S23=null;
        v4=null;
         
         v5=null;
         v6=null;
         v8=null;v260=null;
         v9=null;
         v10=null;
         v11=null;
          v12=null;v36=null;
          v13=null;
          v14=null;v255=null;
          v15=null; v224=null;
          v16=null;
          v17=null;
          v18=null;
          v19=null;
          v20=null;   v21=null;   v22=null;   v23=null;  v24=null;  v25=null;  v26=null;
            v211=null;     v212=null;   v213=null;   v214=null;   v215=null;  v255=null;
            D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

    }
       @FXML
    void Sceance() throws SQLException, ParseException{
         S3 = "SELECT IDFormation FROM `formation` where TitreFormation='"+mForm.getTitreFormation()+"'" ;
                    pst = conn.prepareStatement(S3);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v3=rs.getString(1);
                     }
                     System.out.println("vv3vvv   "+v3);
                    rs.close(); 
                    int f= Integer.parseInt(Semaine.getValue().toString());
                    if(f==0) System.out.println("vvvvvvvvviiiiiiiiiiiiiiiiiiidddddddddeeeeeee  ");
                    if(f==1){
                        Initialisation();
                     S4 = "SELECT IDSemaine FROM `semaine` where numero='1' and IDFormation='"+v3+"'" ;
                    pst = conn.prepareStatement(S4);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v4=rs.getString(1);
                     }
                      rs.close(); 
                     if(v4==null){
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         //D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine1   "+v4);
                   
                     S5 = "SELECT HeureDebut FROM `sceance` where jour= 'samedi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S5);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v5=rs.getString(1);
                     }
                     System.out.println("HeureDebutSamedi   "+v5);
                    rs.close(); 
                      if(v5==null) {D1.setText(""); System.out.println("hEUREsAMEDI Null");}
                      else{ D1.setText(v5);
                      
                      
                      }
                      
                    
                     S6 = "SELECT HeureFin FROM `sceance` where jour= 'samedi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S6);
                    rs = pst.executeQuery();
                     if(rs.next()){
                         v6=rs.getString(1);
                     }
                     System.out.println("vv6vvv   "+v6);
                    rs.close(); 
                      if(v6==null) {F1.setText(""); System.out.println("hEURESamedi Null");}
                    else 
                          F1.setText(v6);
                    
                      
                       
                
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
                    else { 
                        D2.setText(v66);
                        
                    }
                    
                     S7 = "SELECT HeureFin FROM `sceance` where jour='dimanche' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S7);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v7=rs.getString(1);
                     }
                     System.out.println("HeureFinDimanche   "+v7);
                    rs.close(); 
                     if(v7==null) {F2.setText(""); System.out.println("hEUREDimanche Null");}
                    else F2.setText(v7);
                    
                   
                    
                    
                    /***************************************/
                    
                    S9 = "SELECT HeureDebut FROM `sceance` where jour='lundi' and IDSemaine='"+v4+"'" ;
                    pst = conn.prepareStatement(S9);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v8=rs.getString(1);
                     }
                     System.out.println("HeureDebutLundi   "+v8);
                    rs.close(); 
                     if(v8==null) {D3.setText(""); System.out.println("HHHHLundi Null");}
                     else{
                         D3.setText(v8);
                         
                     }
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
                    else {
                        D4.setText(v10);
                        
                    }
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
                    else {
                        D5.setText(v12);
                        
                    }
                    
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
                    else {
                        D6.setText(v14);
                        
                    }
                    
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
                    else {
                        D7.setText(v16);
                        
                    }
                    
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
                     String X1= "Select Count(IDSemaine) from sceance where IDSemaine ='"+v4+"'";
                     pst =conn.prepareStatement(X1);
                     rs = pst.executeQuery();
                     if(rs.next()){
                    X11=rs.getString(1);
                     }
                     rs.close();
                     System.out.println("Count1     "+X11);
                     M= Integer.parseInt(X11);
                        
                    }
                     System.out.println("commmppp1        "+M);
                   /***************************************/
                   if(f==2){
                          Initialisation();
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='2' and IDFormation='"+v3+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                     }
                     if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                       //  D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine2   "+v211);
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
                    else{
                        D1.setText(v212);
                       
                   System.out.println("commmppp21   "+cmp);  

                    }
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
                    else {
                        D2.setText(v216);
                       
                     System.out.println("commmppp22   "+cmp);  

                    }
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
                    else {
                        D3.setText(v219);
                       
                         System.out.println("commmppp23"+cmp);  

                    }
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
                        else {
                        D4.setText(v222);
                       
                 System.out.println("commmppp24   "+cmp);  

                    }
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
                    else {
                        D5.setText(v255);
                       
                     System.out.println("commmppp25 "+cmp);  

                    }
                    
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
                      else {
                        D6.setText(v258);
                       
                     System.out.println("commmppp26"+cmp);  

                    }   
                  
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
                    else {
                        D7.setText(v261);
                        
                       System.out.println("commmppp27"+cmp);  
                    }
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
                   
                    String X2= "Select Count(IDSemaine) from sceance where IDSemaine ='"+v211+"'";
                     pst =conn.prepareStatement(X2);
                     rs = pst.executeQuery();
                     if(rs.next()){
                    X22=rs.getString(1);
                     }
                     rs.close();
                     System.out.println("Count1     "+X22);
                     M2= Integer.parseInt(X22);
                        
                    }
                    
                  
                    /**************************/
                    if(f==3){
                              Initialisation();
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='3' and IDFormation='"+v3+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                     }
                     if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                        // D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine2   "+v211);
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
                    else {
                        D1.setText(v212);
                      
                    }
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
                    else {
                        D2.setText(v216);
                      
                    }
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
                    else {
                        D3.setText(v219);
                      
                    }
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
                    else {
                        D4.setText(v222);
                      
                    }
                   
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
                   else {
                        D5.setText(v255);
                      
                    }
                    
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
                    else {
                        D6.setText(v258);
                      
                    }                  
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
                   else {
                        D7.setText(v261);
                      
                    }
                   
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
                     String X3= "Select Count(IDSemaine) from sceance where IDSemaine ='"+v211+"'";
                     pst =conn.prepareStatement(X3);
                     rs = pst.executeQuery();
                     if(rs.next()){
                    X33=rs.getString(1);
                     }
                     rs.close();
                     System.out.println("Count1     "+X33);
                     M3= Integer.parseInt(X33);
                        
                    
                    
                    
                    
                    }
                    System.out.println("commmppp5        "+cmp);
                    /*+++++++++++++++++++++++++++++*/
                     if(f==4){
                         Initialisation();
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='4' and IDFormation='"+v3+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                     }
                     if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                        // D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine2   "+v211);
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
                    else {
                        D1.setText(v212);
                        
                    }
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
                    else{
                        D2.setText(v216);
                        
                    }
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
                    else{
                        D3.setText(v219);
                        
                    }
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
                   else {
                        D4.setText(v222);
                        
                    }
                   
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
                    else {
                        D5.setText(v255);
                        
                    }
                    
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
                    else {
                        D6.setText(v258);
                        
                    }
                  
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
                     else {
                        D7.setText(v261);
                        
                    }   
                   
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
                    String X4= "Select Count(IDSemaine) from sceance where IDSemaine ='"+v211+"'";
                     pst =conn.prepareStatement(X4);
                     rs = pst.executeQuery();
                     if(rs.next()){
                    X44=rs.getString(1);
                     }
                     rs.close();
                     System.out.println("Count4     "+X44);
                     M4= Integer.parseInt(X44);
                    
                    
                    } 
                 
                    /*+++++++++++++++++++++++++++++*/
                     if(f==5){
                            Initialisation();
                     S211 = "SELECT IDSemaine FROM `semaine` where numero='5' and IDFormation='"+v3+"'" ;
                    pst = conn.prepareStatement(S211);
                    rs = pst.executeQuery();
                     if(rs.next()){
                    v211=rs.getString(1);
                     }
                     if(v211==null)
                        {
                         D1.setText(""); D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                        // D1.setText("");D2.setText(""); D3.setText(""); D4.setText(""); D5.setText(""); D6.setText(""); D7.setText("");
                         F1.setText("");F2.setText(""); F3.setText(""); F4.setText(""); F5.setText(""); F6.setText(""); F7.setText("");

                     }
                     System.out.println("IDSemaine2   "+v211);
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
                    else {
                        D1.setText(v212);
                        
                    }
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
                    else {
                        D2.setText(v216);
                        
                    }
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
                    else {
                        D3.setText(v219);
                        
                    }
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
                    else {
                        D4.setText(v222);
                        
                    }
                   
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
                   else {
                        D5.setText(v255);
                        
                    }
                    
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
                      else {
                        D6.setText(v258);
                        
                    }   
                  
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
                    else {
                        D7.setText(v261);
                        
                    }
                   
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
                    String X5= "Select Count(IDSemaine) from sceance where IDSemaine ='"+v211+"'";
                     pst =conn.prepareStatement(X5);
                     rs = pst.executeQuery();
                     if(rs.next()){
                    X55=rs.getString(1);
                     }
                     rs.close();
                     System.out.println("Count5     "+X55);
                     M5= Integer.parseInt(X55);
               
                    
                 
                    
                    } 
                      // System.out.println("commmppp5       "+cmp);
                       cmp6=M+M2+M3+M4+M5;
                 nbrseance.setText(""+cmp6);
    }
    

    @FXML
    private void Clavier(KeyEvent event) {
    }

    @FXML
    private void Recuperation(MouseEvent event) {
    }
  
    
}
