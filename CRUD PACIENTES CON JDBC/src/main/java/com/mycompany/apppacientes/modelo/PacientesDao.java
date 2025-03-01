
package com.mycompany.apppacientes.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PacientesDao {

    Conexion conexion = new Conexion();
    Connection con = conexion.getConnection();
    
public boolean guardarPaciente(Pacientes paciente) {
    boolean resultado = false;    
        try{
            
            if(con!=null) {
                PreparedStatement ps = con.prepareStatement("insert into paciente(nombre, direccion, telefono) values(?,?,?)");
                ps.setString(1, paciente.getNombre());
                ps.setString(2, paciente.getDireccion());
                ps.setString(3, paciente.getTelefono());
                ps.execute();
                System.out.println("Paciente guardado");
              
                resultado=true;
            } else {
                System.out.println("Error al guardar paciente");
                resultado=false;
            }
            
        } catch(Exception e) {
            System.out.println("Error al guardar paciente"+e.getMessage());
        }
        return resultado;
 }
 
 public boolean EliminarPaciente(int id_paciente){
        boolean resultado = false; 
        try{
            if(con!=null) {
                PreparedStatement ps = con.prepareStatement("delete from paciente where id="+id_paciente);
                ps.execute();
                ps.close();
                resultado = true;
            } else {
                System.out.println("Error al eliminar paciente");
                resultado = false;
            }
            
        } catch(SQLException e) {
            System.out.println("Error al eliminar paciente"+e.getMessage());
            resultado = false;
        }
        return resultado;
 }
 
 public boolean ActualizarPaciente(Pacientes paciente, int id_paciente) {
     boolean resultado = false;
     try{
         if(con!=null) {
            PreparedStatement ps = con.prepareStatement("UPDATE paciente SET nombre=?, direccion=?, telefono=? WHERE id=" + id_paciente);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getDireccion());
            ps.setString(3, paciente.getTelefono());
         
            ps.executeUpdate();
            resultado = true;
             System.out.println("Paciente actualizado");
         }   else{
         resultado = false;
                System.out.println("No fue posible realizar actualizacion"); 
         }
     } catch(Exception e) {
         JOptionPane.showMessageDialog(null, "Error al actualizar paciente" + e.getMessage());
     }
     return resultado;
 }
 
  public Pacientes BuscarPaciente(int id_paciente) {
     Pacientes paciente = null;
     ResultSet rs = null;
     PreparedStatement ps = null;
     
     try{
         if(con!=null) {
            ps = con.prepareStatement("SELECT * FROM paciente WHERE id=?");
            ps.setInt(1, id_paciente);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                paciente = new Pacientes();
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setTelefono(rs.getString("telefono"));
                System.out.println("paciente encontrado");
            } else{
                System.out.println("paciente no fue encontrado");
                
            }   
         } 
     } catch(Exception e) {
         JOptionPane.showMessageDialog(null, "Error al buscar paciente" + e.getMessage());
     }
     return paciente;
 }
  
 public void MostrarPaciente(DefaultTableModel modelo) throws SQLException {
     int numColumn = 0;
     modelo.setColumnCount(0);
     modelo.setRowCount(0);
     ResultSet rs = null;
     
     PreparedStatement ps = con.prepareStatement("SELECT * FROM paciente");
     
     try { 
         rs = ps.executeQuery();
         numColumn = rs.getMetaData().getColumnCount();
         
         for(int j=1; j<=numColumn; j++){
         modelo.addColumn(rs.getMetaData().getColumnName(j));
         }
         
         while(rs.next()) {
             String [] datos = new String[numColumn];
             for(int i=1; i<=numColumn; i++){
                 datos [i-1] = (String)rs.getString(i);
             }
             
             modelo.addRow(datos);
         
         }
         
         rs.close();
         ps.close();
     } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR PACIENTES" + e.getMessage()); 
     }
     
     
 
 }

    
}
