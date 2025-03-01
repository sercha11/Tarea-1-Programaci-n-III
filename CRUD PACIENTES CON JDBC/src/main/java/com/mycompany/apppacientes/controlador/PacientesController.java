package com.mycompany.apppacientes.controlador;

import com.mycompany.apppacientes.modelo.Pacientes;
import com.mycompany.apppacientes.modelo.PacientesDao;
import javax.swing.table.DefaultTableModel;

public class PacientesController implements Ipacientes {
    
    PacientesDao dao = new PacientesDao();   
    
    @Override
    public boolean guardar(Pacientes paciente) {
        try{
            dao.guardarPaciente(paciente);
            return true;
        } catch(Exception e){
            System.out.println("ERROR AL GUARDAR PACIENTE");
            return false;
        }
        
    }

    @Override
    public boolean actualizar(Pacientes paciente, int id_paciente) {
      try{
          dao.ActualizarPaciente(paciente, id_paciente);
          return true;
      }
      catch(Exception e) {
          System.out.println("ERROR AL ACTUALIZAR PACIENTE");
          return false;
      }
    }

    @Override
    public boolean eliminar(int id_paciente) {
        try{        
            dao.EliminarPaciente(id_paciente);
            return true;
        } catch(Exception e){
            System.out.println("ERROR AL ELIMINAR PACIENTE");
            return false;
        }
    }

    @Override
    public void consultar(DefaultTableModel modelo) {
       try{
           dao.MostrarPaciente(modelo);
           
       } catch(Exception e){
           System.out.println("ERROR AL MOSTRAR PACIENTES");
       }
    }

    @Override
    public Pacientes BuscarPaciente(int id_paciente) {
        Pacientes paciente = null; 
        try{        
            paciente = dao.BuscarPaciente(id_paciente);
            if(paciente != null) {
                System.out.println("paciente encontrado");
            } else{
                System.out.println("paciente no encontrado");
            }
            
        } catch(Exception e){
            System.out.println("ERROR AL BUSCAR PACIENTE");
            
        }
        return paciente;
    }
    
}
