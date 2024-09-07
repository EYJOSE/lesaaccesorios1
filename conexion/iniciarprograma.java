
package conexion;


public class iniciarprograma {

  
    public static void main (String[] args) {
        
            ConexionDB objclie = new  ConexionDB();
          
            objclie.insertar();
            objclie.consultar();
            objclie.actualizar();
            objclie.eliminar();            
    }
    
}
