package controle;

import modelo.Usuario;
import util.ListaUsuario;

public class Validar {

	public boolean nomeCadastrado(Usuario usuario){
		return ListaUsuario.listaUsuario.stream().anyMatch(user ->
		user.getNome().equals(usuario.getNome()));
	}
	
	public boolean cpfCadastrado(Usuario usuario){
		return ListaUsuario.listaUsuario.stream().anyMatch(user -> 
		user.getCpf().equals(usuario.getCpf()));
	}
	
	public boolean DataNascimentoCadastrado(Usuario usuario){
		return ListaUsuario.listaUsuario.stream().anyMatch(user ->
		user.getDataDeNascimento().equals(usuario.getDataDeNascimento()));
	}
	
	public boolean emailCadastrado(Usuario usuario){
		return ListaUsuario.listaUsuario.stream().anyMatch(user -> 
		user.getEmail().equals(usuario.getEmail()));
	}
	
	public boolean senhaCadastrado(Usuario usuario){
		return ListaUsuario.listaUsuario.stream().anyMatch(user -> 
		user.getSenha().equals(usuario.getSenha()));
	}
	
	public boolean login(Usuario usuario){
		if(ListaUsuario.listaUsuario.stream().anyMatch(user -> 
		user.getEmail().equals(usuario.getEmail()))&& ListaUsuario.listaUsuario.stream().anyMatch(user -> 
		user.getSenha().equals(usuario.getSenha())))
			return true;
		return false;
	}
}
