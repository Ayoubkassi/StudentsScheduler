/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import static Controle.Based.ajouterEleve;
import static Controle.Based.fetchEleves;
import static Controle.Based.modifierEleve;
import static Controle.Based.selectEleveById;
import static Controle.Based.selectEleveByNomEtPrenom;
import static Controle.Based.supprimerEleveNomEtPrenom;
import static Controle.Based.supprimerEleveavecId;
import DAO.Eleve;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author ryota
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        System.out.println("Bismi Allah");
        
        Eleve eleve = null;
        String nom , prenom , filiere, annee;
        int id;
        
        //chercher avec Id
        //eleve = selectEleveById(1);
        
        //chercher avec nom et prenom
        //eleve = selectEleveByNomEtPrenom("kassi","ayoub");
        
        //tester ajouter eleve
        //eleve = new Eleve("hanyf","othmane","2017","electrical");
        //ajouterEleve(eleve);
        
        
        //tester le mise a jour d'un eleve
//        eleve = new Eleve("hanyf","othmane","2017","Softwares");
//        modifierEleve(2,eleve);
        
        
        //afficher le resultat
        //eleve.affiche();
        
        
        //ajouter une boucle comme ca le programme va se repeter jusqua chosir finir
        boolean exit = true;
        loop : while(exit){
        System.out.println("*********** Welcome to Eleve Database Management **************");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("1 : selection de tous les etudiants");
        System.out.println("2 : selection d'un etudiant avec son id");
        System.out.println("3 : selection d'un etudiant avec son nom et prenom");
        System.out.println("4 : insertion d'un nouveau etudiant");
        System.out.println("5 : mise a jour d'un etudiant");
        System.out.println("6 : suppression d'un etudiant avec id");
        System.out.println("7 : suppression d'un etudiant avec nom et prenom");
        System.out.println("8 : Si vous voulez quitter le programme");
        System.out.println("");
        System.out.println("Entrez votre choix : ");

        Scanner in = new Scanner(System.in);        
        int choix = in.nextInt();
        
        
        switch(choix){
            case 1 :
                fetchEleves();
                break;
                
            case 2 :
                System.out.println("Entrez id d'un Eleve : ");
                id = in.nextInt();
                eleve = selectEleveById(id);
                eleve.affiche();
                break;
                
            case 3 :
                
                System.out.println("Entrez le nom de l'eleve que vous cherchez : ");
                nom = in.next();
                System.out.println("Entrez le prenom de l'eleve que vous cherchez : ");
                prenom = in.next();
                eleve = selectEleveByNomEtPrenom(nom, prenom);
                eleve.affiche();
                break;
            
            case 4 :
                System.out.println("Entrez son nom : ");
                nom = in.next();
                System.out.println("Entrez son prenom : ");
                prenom = in.next();
                System.out.println("Entrez son filiere : ");
                filiere = in.next();
                System.out.println("Entrez l'annee scolaire : ");
                annee = in.next();
                eleve = new Eleve(nom,prenom,annee,filiere);
                ajouterEleve(eleve);
                eleve.affiche();
                break;
                
            case 5 :
                System.out.println("Entrez id de l'eleve que vous voulez modifier : ");
                id = in.nextInt();
                System.out.println("Entrez son nouveau nom : ");
                nom = in.next();
                System.out.println("Entrez son nouveau prenom : ");
                prenom = in.next();
                System.out.println("Entrez sa nouvelle filiere : ");
                filiere = in.next();
                System.out.println("Entrez une nouvelle annee scolaire : ");
                annee = in.next();
                eleve = new Eleve(nom,prenom,annee,filiere);
                modifierEleve(id,eleve);
                System.out.println("Nouvelle valeur : ");
                eleve = selectEleveById(id);
                eleve.affiche();
                break;
                
            case 6 :
                System.out.println("Entrez id de l'eleve que vous voulez supprimer : ");
                id = in.nextInt();
                supprimerEleveavecId(id);
                break;
                
            case 7 :
                System.out.println("Entrez le nom de l'eleve que vous souhaitez supprimer: ");
                nom = in.next();
                System.out.println("Entrez le prenom de l'eleve que vous souhaitez supprimer : ");
                prenom = in.next();
                supprimerEleveNomEtPrenom(nom,prenom);
                break;
            
            case 8 :
                break loop;
            default:
                System.out.println("Votre choix n'existe pas!!!");
             
                
        }
        
        }
        
        
 
        
        
    }
}



