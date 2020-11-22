
package Vista;

import conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Funciones {

    private static conexion.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    public static boolean isRegister(Sentencias s){
        
        String sql = Sentencias.REGISTRAR;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getCodigo());
            ps.setString(2, s.getNombre());
            ps.setDouble(3, s.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            
              return false;
            //Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static boolean isUpdate(Sentencias s){
        
        String sql = Sentencias.ACTUALIZAR;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getCodigo());
            ps.setString(2, s.getNombre());
            ps.setDouble(3, s.getPrecio());
            ps.setString(4, s.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            
              return false;
            //Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public static boolean isDelete(Sentencias s){
        
        String sql = Sentencias.ELIMINAR;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, s.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            
              return false;
            //Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isTruncate(Sentencias s){
        
        String sql = Sentencias.ELIMINARTODO;
        
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            
              return false;
            //Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setListar(String buscar){
        
        DefaultTableModel modelo = (DefaultTableModel)CRUD.tabla.getModel();
        while(modelo.getRowCount() > 0){
            
            modelo.removeRow(0);
        }
        String sql = " ";
        if (buscar.equals(" ")){
            
            sql = Sentencias.LISTAR;
        }
        else
        {
            sql = "SELECT * FROM productos WHERE("
                    + "codigo LIKE'"+buscar+"%' OR"
                    + "nombre LIKE'"+buscar+"%' OR"
                    + "precio LIKE'"+buscar+"%'  )";
        }
        String datos[] = new String[4];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("codigo");
                datos[2] = rs.getString("nombre");
                datos[3] = rs.getString("precio");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static  String ExtraerIdMax(){
        
        String sql = "SELECT MAX(id) FROM productos";
        int id = 0;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                id = rs.getInt(1);
            }
            if (id == 0){
                id = 1;
            }
            else
            {
                id = id + 1;
            }
            return String.valueOf(id);
        } catch (SQLException ex) {
            return null;
            //Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
