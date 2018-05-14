
package mediamark;
import java.sql.*;

public class Mediamark {

  
    public static void main(String[] args) {
        cargarDatos();
    }

    private static void cargarDatos() {
        try{
            //1.Cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. Creo la conexion contra la BD 
            Connection c=
                    DriverManager.getConnection("jdbc:mysql://localhost/mediamark","alumno","alumno");
            // 3. Creo el Statement
            Statement s=c.createStatement();
            //4.Trabajo con las consultas
            ResultSet rs=s.executeQuery("Select Id,Nombre,Precio From Productos"); //La unica diferencia es que en este punto puse un asterisco (*) en vez de atributos 
            while(rs.next()==true){
                System.out.println(rs.getInt("Id")+" "+rs.getString("Nombre")+" "+rs.getDouble("Precio"));
            }
            rs.close();
            s.close();
            c.close();
        } catch(Exception e){
            System.out.println("Error en la base de datos"); 
            e.printStackTrace();
            //Muestra informacion del error
        }
  
    }
    
}
