package sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {

    public static void main(String[] args) {
	//Paso 1: Conectar con la base de datos
	Connection conexion = null;
	conexion = Conexion.sqlite("C:\\Users\\samu\\Documents\\NetBeansProjects\\db_agenda.sqlite");
	if (conexion != null) {
		System.out.println("Conexion realizada con éxito");
		//Paso 2: Ejecutar una consulta
		try {
			ResultSet rs = null;
			Statement sentencia = conexion.createStatement(); 
			String sql = "SELECT * FROM agenda;";
			rs = sentencia.executeQuery(sql);
			//Paso 3: Extrayendo los datos del resultset
			while (rs.next()) {
                            //Recuperar datos por el nombre de la columna 
                            String nombre = rs.getString("nombre"); 
                            String telefonocasa = rs.getString("telefono"); 
                            //Ver valores
                            System.out.println(nombre + ", " + telefonocasa );
			}  
		} catch (SQLException ex) {
			System.out.println("Error");
		}
	}
    }
}
    
