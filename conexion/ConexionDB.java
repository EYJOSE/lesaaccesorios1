
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexionDB {
    private String url="jdbc:mysql://localhost:3306/";
    private String bd="lesaaccesorios";
    private String user="root";
    private String password="1234";
    private String driver ="com.mysql.cj.jdbc.Driver";
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
   
     public ConexionDB(){
         
        try {
            // Llamada para  cargar el driver para poder conectarse a una base de datos
            Class.forName(driver);
            // Este método crea un objeto Connection, que se utiliza para crear sentencias SQL
            con = DriverManager.getConnection(url+bd,user,password);
             // Crea un objeto Statement, que representa una sentencia SQL y estos 
            // los objetos Statement generan objrtos ResultSet, que son una tabla de datos 
            // que representan un conjunto de resultados de una base de datos           
               st=con.createStatement();   
        } catch(Exception ex){
            ex.printStackTrace();
        }
        }  
    public void insertar(){
    try{
        String query = "INSERT INTO cliente (id_cliente, Nom_cliente, Apellido_cliente, Telefono) VALUES (9, 'ANDRES', 'FERNANDEZ', '3158548745')";
        st.executeUpdate(query);
        System.out.println("El cliente se ingresó satisfactoriamente\n");
    } catch(Exception ex){
        ex.printStackTrace();
    }
     }
     

    public void consultar(){
        try{
            String query="SELECT * FROM cliente";
            // el método Statement.executeQuery, recuperar datos de una tabla utilizando una sentencia SELECT
            rs = st.executeQuery(query);
            while(rs.next()){
                int id_cliente = rs.getInt("id_cliente");
                String Nom_cliente  = rs.getString("Nom_cliente");
                String Apellido_cliente  = rs.getString("Apellido_cliente");
                  String Telefono  = rs.getString("Telefono");
                System.out.println("cliente: "+ id_cliente + "\nNom_cliente:" + Nom_cliente + "\nApellido_cliente:"+ Apellido_cliente+  "\nTelefono:" + Telefono +"\n");
            }rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }public void actualizar(){
    try{String query = "UPDATE cliente SET Nom_cliente = ' laura ', Apellido_cliente = ' hernandez ', Telefono = '3115245487' WHERE id_cliente = 5";
        st.executeUpdate(query);
        System.out.println("El cliente se actualizó satisfactoriamente\n");
    } catch(Exception ex){
        ex.printStackTrace();
    }
    }
    public void eliminar(){
    try{
        String query = "DELETE FROM cliente WHERE id_cliente = 5";
        st.executeUpdate(query);
        System.out.println("El cliente se eliminó satisfactoriamente\n");
    } catch(Exception ex){
        ex.printStackTrace();
    }
}

}
