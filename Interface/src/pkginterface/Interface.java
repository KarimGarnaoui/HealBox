/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author MArgaux
 */
public class Interface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
		
		
		Connection connexion = connecterDB();
                MenuPrincipal menu = new MenuPrincipal(connexion);
                	
	}

       public static Connection connecterDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver : OK");
			String url = "jdbc:mysql://localhost:3306/medicament?useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String password = "pass";
			Connection cnx = DriverManager.getConnection(url,user,password);
			System.out.println("Connexion à la BDD : Succes");
			return cnx; 
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
        
        
    }
    
}
