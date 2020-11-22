
package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public static Connection conection = null;
   
    
    public Connection getConexion(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost/componentesjd", "root", "root");
            return conection;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
