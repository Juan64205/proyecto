
package Vista;


public class Sentencias {
    
    private String codigo, nombre;
    private Double precio;
    private String id;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public static String LISTAR = "SELECT * FROM productos";
    
    public static String REGISTRAR = "INSERT INTO productos("
            + "codigo, "
            + "nombre,"
            + "precio)"
            + "VALUES(?, ?, ?)";
    
    public static String ACTUALIZAR = "UPDATE productos SET"
            + "codigo = ?,"
            + "nombre = ?,"
            + "precio = ?"
            + "WHERE id = ?";
    
    public static String ELIMINAR = "DELETE FROM productos WHERE id = ?";
    
    public static String ELIMINARTODO = "TRUNCATE TABLE productos";
}
