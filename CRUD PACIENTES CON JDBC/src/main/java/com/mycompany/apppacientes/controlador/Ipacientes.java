package com.mycompany.apppacientes.controlador;

import com.mycompany.apppacientes.modelo.Pacientes;
import javax.swing.table.DefaultTableModel;

public interface Ipacientes {
    public boolean guardar(Pacientes paciente);
    public boolean actualizar(Pacientes paciente, int id_paciente);
    public boolean eliminar(int id_paciente);
    public void consultar(DefaultTableModel modelo);
    public Pacientes BuscarPaciente(int id_paciente);
}
