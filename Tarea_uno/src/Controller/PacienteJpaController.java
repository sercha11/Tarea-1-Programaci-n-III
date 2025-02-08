package Controller;

import Entidad.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PacienteJpaController implements Serializable {

    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tarea_unoPU");
    
    public void RegistrarPacientes (Paciente paciente) {
    
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try{
            et.begin();
            em.persist(paciente);
            et.commit();
            
        } catch (Exception e) { 
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    
    }
    
    public List<Paciente> VisualizarPacientes () {
        EntityManager em = emf.createEntityManager();
        List<Paciente> paciente = new ArrayList<>();
        
        try{
           paciente = em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();  
        } catch (Exception e) { 
            System.err.print("ERROR AL MOSTRAR PACIENTES");
        } finally {
            em.close();
        }
        return paciente;
    }
    
    public Paciente BuscarUnPaciente (int id) {
        EntityManager em = emf.createEntityManager();
        Paciente buscado = null;
        
        try{
           buscado = em.find(Paciente.class, id);
        } catch (Exception e) { 
            System.err.print("ERROR AL BUSCAR PACIENTE");
        } finally {
            em.close();
        }
        return buscado;
    }
     
        public Paciente EliminarUnPaciente (int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Paciente buscado = null;
        
        try{
           et.begin();
           buscado = em.find(Paciente.class, id);
           em.remove(buscado);
           et.commit();
        } catch (Exception e) { 
            if(et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return buscado;
    }
        public void ActualizarPacientes (Paciente paciente) {
    
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try{
            et.begin();
            em.merge(paciente);
            et.commit();
            
        } catch (Exception e) { 
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    
    }
    
    
    
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tarea_unoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
}
