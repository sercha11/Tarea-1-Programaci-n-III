create DATABASE pacienteumg;

create TABLE paciente(
id integer AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100) not null,
direccion varchar(100) not null,
telefono varchar(30)
);
