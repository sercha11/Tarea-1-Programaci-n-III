package com.mycompany.apppacientes;

import com.mycompany.apppacientes.vista.RegistroPacientes;
import java.sql.SQLException;

public class AppPacientes {

    public static void main(String[] args) throws SQLException {
        RegistroPacientes nueva = new RegistroPacientes();
        nueva.setVisible(true);
    }
}
