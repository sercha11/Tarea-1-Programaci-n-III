package com.mycompany.apppacientes.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static final String JDBC_DRIVER = "org.postgresql.jdbc.Driver";
    Connection con;
    String Base = "pacienteumg";
    String DB_URL = "jdbc:postgresql://localhost:5433/" + Base + "?useSSL=false&serverTimeZone =UTC";        
    static final String user = "postgres";
    static final String password = "1234";
    
    public Conexion(){
        try{
            con = DriverManager.getConnection(DB_URL, user, password);
            System.out.println("Conectado en la base de datos");
            
        } catch(Exception e) {
            System.out.println("Error de conexion en la base de datos"+e.getMessage());
        }  
        
    }

    public Connection getConnection(){
 
     return con;
 } 



 
}
