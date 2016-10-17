package modelo;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import capa_Persistencia.ManagerPersistencia;
import modelo.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioManagedBean {
	private Usuario usuario = new Usuario();

	public UsuarioManagedBean(){
//		usuario.setNombre("nombreUsuario");
//		usuario.setApellido("apellidoUsuario");
//		usuario.setDireccion("direccionUsuario");
//		
//		usuario.getTelefonos().add("telefono-1");
//		usuario.getTelefonos().add("telefono-2");
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean accion(){
		System.out.println("Usuario: " + usuario.getNombre());
		System.out.println("Secreto: " + usuario.getSecreto());
		ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
		managerPersistencia.probarConexion();
		return managerPersistencia.AutenticarUsuario(usuario);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
