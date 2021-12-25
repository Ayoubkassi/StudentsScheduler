/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ryota
 */
public class Admins {
     private int id;
    private String username;
    private String password;
    
    public Admins(){
        super();
    }

    public Admins(int id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admins{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
     public static ArrayList<Admins> getAdmins(){
        
        Connection connect = null;
        Statement statement = null;
       // PreparedStatement preparedstatement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://localhost:3306/TD3";
        String user = "root";
        String password = "guillaume";
        
        ArrayList<Admins> admins = new ArrayList<Admins>();
        
        try{
            //Define Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Initialize connection
            connect = DriverManager.getConnection(url,user,password);
            //statements
            
            statement = connect.createStatement();
            
            //read from db
            
            resultSet = statement.executeQuery("select * from admins");
            
            //to print content
             System.out.println("");
             System.out.println("");
             System.out.println("");
            while(resultSet.next()){
                
                String username = resultSet.getString("username");
                String pass = resultSet.getString("password");
                int id = resultSet.getInt("id");
                
                //save here
                Admins adm = new Admins(id,username,pass);
                admins.add(adm);
               

            }
            
            
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
          return admins;

        
    }
}
