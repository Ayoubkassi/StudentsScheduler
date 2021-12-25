/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import DAO.Eleve;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryota
 */
public class Based {
    
    //connection avec la base de donne
    public static Statement connectToDB() throws ClassNotFoundException, SQLException{
        
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://localhost:3306/TD3";
        String user = "root";
        String password = "guillaume";
        
         try{
            //Definer notre driver
            Class.forName("com.mysql.jdbc.Driver");  
            //Initializer la connection
            connect = DriverManager.getConnection(url,user,password);
            //statements
            statement = connect.createStatement();
         }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            return statement;
    }
    
    
    
    //trouver etudiant avce Id
    public static Eleve selectEleveById(int id) throws ClassNotFoundException, SQLException{
        Eleve eleve = null;
        Statement st = connectToDB();
        String sql = "select * from Eleve where id='" + id + "'";
        ResultSet rs = st.executeQuery(sql);
         if (!rs.first()) {
             System.out.println("Eleve avec id : "+id+" n'existe pas");
         }else{
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String annee = rs.getString("anneeScolaire");
                String filiere = rs.getString("filiere");
                
                 eleve = new Eleve(nom,prenom,annee,filiere);
                                
         }
  
        
        return eleve;
    }
    
    
    //trouver etudiant avec nom complet nom et prenom
    public static Eleve selectEleveByNomEtPrenom(String nom , String prenom) throws ClassNotFoundException, SQLException{
        Eleve eleve = null;
        
        try{
        Statement st = connectToDB();
        String sql = "select * from Eleve where nom='" + nom + "'and prenom ='" +prenom + "'";
        ResultSet rs = st.executeQuery(sql);
         if (!rs.first()) {
             System.out.println("Eleve avec nom et prenom : "+nom+" "+prenom + "n'existe pas");
         }else{
                String pren = rs.getString("prenom");
                String no = rs.getString("nom");
                String annee = rs.getString("anneeScolaire");
                String filiere = rs.getString("filiere");
                
                eleve = new Eleve(no,pren,annee,filiere);
                
                
         }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
        return eleve;
    }
    
    public static void ajouterEleve(Eleve eleve) throws SQLException, ClassNotFoundException{
        
        try{
            Statement st = connectToDB();
            String sql = "select * from Eleve where nom='" + eleve.nom + "'and prenom ='" +eleve.prenom + "'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.first()){
                //verifier si l'eleve existe deja dans la base de donnes;
                System.out.println("Sorry deja un Eleve existe avec le meme nom et prenom");
            }else{

                String requette = "INSERT INTO `Eleve`(`nom`, `prenom`, `anneeScolaire`,`filiere`) "
                        + "VALUES ('" + eleve.nom + "','" + eleve.prenom + "','" + eleve.anneeScolaire+ "','" + eleve.Filiere + "')";
                st.execute(requette);
        }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //modifier par id
    public static void modifierEleve(int id,Eleve newEleve) throws SQLException, ClassNotFoundException{
        Eleve eleve = null;
        try{
        eleve = selectEleveById(id);
        //verifier l'existence d'abord
        if(eleve != null){
              Statement st = connectToDB();
              String sql = "UPDATE `Eleve`SET nom='" + newEleve.nom + "',prenom='" + newEleve.prenom + "',anneeScolaire='" + newEleve.anneeScolaire  + "',filiere='" + newEleve.Filiere + "'WHERE id='" + id + "'";
              st.execute(sql);
              System.out.println("Eleve mis a jour avec succes");
           }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //methode additionel pour afficher toutes les etudiant
    
    public static void fetchEleves(){
        
        ArrayList<Eleve> eleves = new ArrayList<Eleve>();
        
        try{
            Statement st = connectToDB();
            String sql = "select * from Eleve ";
            ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {
                Eleve eleve = new Eleve(rs.getString("nom"), rs.getString("prenom"), rs.getString("anneeScolaire"),rs.getString("filiere"));
                eleves.add(eleve);
                eleve.affiche();
            }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //methode additionel pour afficher toutes les etudiant
    
    public static ArrayList<Eleve> fetchEleve(){
        
        ArrayList<Eleve> eleves = new ArrayList<Eleve>();
        
        try{
            Statement st = connectToDB();
            String sql = "select * from Eleve ";
            ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {
                Eleve eleve = new Eleve(rs.getString("nom"), rs.getString("prenom"), rs.getString("anneeScolaire"),rs.getString("filiere"));
                eleves.add(eleve);
                eleve.affiche();
            }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return eleves;
        
    }
    
    //methode additionel pour supprimer un etudiant avec id
    
    public static void supprimerEleveavecId(int id){
         Eleve eleve = null;
        try{
        eleve = selectEleveById(id);
        //verifier l'existence d'abord
        if(eleve != null){
              Statement st = connectToDB();
              String sql = "DELETE FROM `Eleve` WHERE id='" + id + "'";
              st.execute(sql);
              System.out.println("Eleve supprime de la base de donne");
           }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   //methode additionel pour supprimer un etudiant avec nom et prenom
    
    public static void supprimerEleveNomEtPrenom(String nom , String prenom){
        Eleve eleve = null;
        try{
        eleve = selectEleveByNomEtPrenom(nom,prenom);
        //verifier l'existence d'abord
        if(eleve != null){
              Statement st = connectToDB();
              String sql = "DELETE FROM `Eleve` WHERE nom='" + nom + "' and prenom='"+prenom+"'";
              st.execute(sql);
              System.out.println("Eleve supprime de la base de donne");
           }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Controle.Based.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //selct id by nom et prenom
    
    public static int selectId(String nom , String prenom) throws ClassNotFoundException, SQLException{
        int id = 1;
        Statement st = connectToDB();
        String sql = "select * from Eleve where nom='" + nom + "'and prenom ='" +prenom + "'";
        ResultSet rs = st.executeQuery(sql);
         if (!rs.first()) {
             System.out.println("Eleve avec id : "+id+" n'existe pas");
         }else{
                
                id = rs.getInt("id");
                
                                
         }
        return id;
    }
    
}
