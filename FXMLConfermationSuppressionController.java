/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgsescuela.Formations;


import dgsescuela.Etudiants.*;
import com.jfoenix.controls.JFXButton;
import static dgsescuela.LoginPackage.loginController.rootAccueil;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dgsescuela.AccueilPackage.FXMLAccueilController;
import dgsescuela.DBConnection;
import static dgsescuela.LoginPackage.loginController.adminStage;
import static dgsescuela.LoginPackage.loginController.rootAccueil;
import static dgsescuela.LoginPackage.loginController.sceneAccueil;
import dgsescuela.Modele.ModeleEtudiantsStatic;
import dgsescuela.Modele.ModeleFormationsStatic;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author unknown
 */
public class FXMLConfermationSuppressionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private JFXTextField Nom_utilisateur;

    @FXML
    private JFXPasswordField mot_passe;

    @FXML
    private Button btnClose;

    ModeleFormationsStatic CurrentFournisseurStatic = new ModeleFormationsStatic();
 String sqlS=null; String sqlS2=null; String sqlS3=null; String sqlS4=null; String sqlS5=null; String sqlSS=null;
    String v=null; String v2=null; String v3=null; String v4=null; String v5=null;String v10=null;
    @FXML
    private void SupprimerCondidat() {
        try {
            String sql = "DELETE  FROM `formation`  WHERE IDFormation ='" + CurrentFournisseurStatic.getIdFormation()+ "'";
            
           pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        //SupprimerSemaine();
    }
@FXML 
void Init(){
     String sqlS=null; String sqlS2=null; String sqlS3=null; String sqlS4=null; String sqlS5=null;
    String v=null; String v2=null; String v3=null; String v4=null; String v5=null;
}
    @FXML
void SupprimerSemaine(){
    Init();
            try {
          sqlSS = "DELETE FROM `semaine` WHERE IDFormation ='"+CurrentFournisseurStatic.getIdFormation()+"'" ;
           pst = conn.prepareStatement(sqlSS);
            pst.executeUpdate();
            pst.close();
            rs.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
          SupprimerCondidat();
            // SupprimerSeance();
}
@FXML
void SupprimerInscription (){
    String sqlS=null;
    String v=null;
    try {
       
            String s="Delete from inscription where IDformation ='"+CurrentFournisseurStatic.getIdFormation()+"'";
             pst = conn.prepareStatement(s);
            pst.executeUpdate();
            pst.close();
            rs.close();
             } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
@FXML
void SupprimerSeance(){
   
     try {
         sqlS = "SELECT IDSemaine FROM semaine where numero = '1' and IDFormation ='"+CurrentFournisseurStatic.getIdFormation()+"'" ;
            pst = conn.prepareStatement(sqlS);
            rs = pst.executeQuery();
            if(rs.next()){
                v=rs.getString(1);
            }
            rs.close();
            sqlS2 = "SELECT IDSemaine FROM semaine where numero = '2' and IDFormation ='"+CurrentFournisseurStatic.getIdFormation()+"'" ;
            pst = conn.prepareStatement(sqlS2);
            rs = pst.executeQuery();
            if(rs.next()){
                v2=rs.getString(1);
            }
             rs.close();
            sqlS3 = "SELECT IDSemaine FROM semaine where numero = '3' and IDFormation ='"+CurrentFournisseurStatic.getIdFormation()+"'" ;
            pst = conn.prepareStatement(sqlS3);
            rs = pst.executeQuery();
            if(rs.next()){
                v3=rs.getString(1);
            }
             rs.close();
            sqlS4 = "SELECT IDSemaine FROM semaine where numero = '4' and IDFormation ='"+CurrentFournisseurStatic.getIdFormation()+"'" ;
            pst = conn.prepareStatement(sqlS4);
            rs = pst.executeQuery();
            if(rs.next()){
                v4=rs.getString(1);
            }
             rs.close();
          sqlS5 = "SELECT IDSemaine FROM semaine where numero = '5' and IDFormation ='"+CurrentFournisseurStatic.getIdFormation()+"'" ;
            pst = conn.prepareStatement(sqlS5);
            rs = pst.executeQuery();
            if(rs.next()){
                v5=rs.getString(1);
            }
             rs.close();
         if(v !=null){
            String sql = "DELETE  FROM `sceance` WHERE IDSemaine ='" + v.toString()+"'";
            
           pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
            rs.close();
         }
         if(v2 !=null){
            String sql2 = "DELETE  FROM `sceance`  WHERE IDSemaine ='" + v2.toString()+"'";
            
           pst = conn.prepareStatement(sql2);
            pst.executeUpdate();
            pst.close();
            rs.close();
         }
         if(v3 !=null){
            String sql3 = "DELETE  FROM `sceance`  WHERE IDSemaine ='" + v3.toString()+"'";
            
           pst = conn.prepareStatement(sql3);
            pst.executeUpdate();
            pst.close();
            rs.close();
         }
         if(v4 !=null){
            String sql4 = "DELETE  FROM `sceance`  WHERE IDSemaine ='" + v4.toString()+"'";
            
           pst = conn.prepareStatement(sql4);
            pst.executeUpdate();
            pst.close();
            rs.close();
         }
         if(v5 !=null){
            String sql5 = "DELETE  FROM `sceance`  WHERE IDSemaine ='" + v5.toString()+"'";
            
           pst = conn.prepareStatement(sql5);
            pst.executeUpdate();
            pst.close();
            rs.close();
         }
        if((v==null) || (v2==null)) {
             System.out.println("vide1");
         }
         if((v3==null) || (v4==null)) {
             System.out.println("vide2");
         }
          if((v5==null) ) {
             System.out.println("vide3");
         }
             
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
     
     SupprimerSemaine();
     SupprimerInscription();
}
    
    @FXML
    void Valider() {
        //on peut eviter cette methode pour eviter la duplication
        SupprimerSeance();
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            conn = DBConnection.EtablirConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLConfermationSuppressionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void quit() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }

   private void actualiser() throws IOException{
       
       quit();
         
            rootAccueil = FXMLLoader.load(getClass().getResource("/dgsescuela/Formations/FXMLFormations.fxml"));
            sceneAccueil = new Scene(rootAccueil);

            adminStage.setScene(sceneAccueil);
            adminStage.show();
            adminStage.setMaximized(false);
            adminStage.setMaximized(true);


    }
   
   
    private void ConfermationSuppression() throws SQLException, IOException{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Risque de Suppression des Données  !!!");
            alert.setContentText("Cette action va supprimer le Condidat N°{{ " + CurrentFournisseurStatic+ "}}");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() != ButtonType.OK) {} 
            else {
                Valider();
                actualiser();

                pst.close();
                rs.close();
            }
    }
    
    @FXML
    void Confermer(MouseEvent event) throws SQLException, IOException {

        
          try {
          String sql = "SELECT * FROM `Users` WHERE (Nom='"+Nom_utilisateur.getText()+"' or Email='"+Nom_utilisateur.getText()+"') and password='"+mot_passe.getText()+"'";
            pst = conn.prepareStatement(sql);
          rs = pst.executeQuery();
      // if email et psw juste appeler confirmationSupprission
          if(rs.next()){
            ConfermationSuppression();
          }
          else{

               Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Erreur :   ");
                alert.setContentText("Le mot de passe ou l'utilisateur sont incorrect!!!");
                alert.showAndWait();

          }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
          

        pst.close();
        rs.close();

    }

}
