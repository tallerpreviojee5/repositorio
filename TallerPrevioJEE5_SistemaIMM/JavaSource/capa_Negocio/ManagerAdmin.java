package capa_Negocio;

import capa_Persistencia.ManagerPersistencia;

public class ManagerAdmin {
	public Boolean AutenticarUsuario(modelo.Usuario usuario){
		ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
		managerPersistencia.probarConexion();
		return managerPersistencia.AutenticarUsuario(usuario);
	}
}
