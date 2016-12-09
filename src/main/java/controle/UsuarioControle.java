package controle;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import modelo.Usuario;
import util.ListaUsuario;
import controle.Validar;

@ApplicationPath("/resource")
@Path("/usuario")
public class UsuarioControle extends Application {
	private Validar validar = new Validar();

	// @POST
	// @Path("/login")
	// @Consumes("application/json")
	// public Response verificarUsuario(Usuario usuario) {
	// if (validar.login(usuario)) {
	// return Response.status(Response.Status.OK).entity("{\"status\":
	// true}").build();
	// }
	// return Response.status(Response.Status.UNAUTHORIZED).entity("{\"status\":
	// false}").build();
	// }

	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	public Response inserir(Usuario usuario) {
		System.out.println("Entrou");
		try {
			if (!validar.cpfCadastrado(usuario)) {
				if (!validar.emailCadastrado(usuario)) {
					if (!validar.cpfCadastrado(usuario)) {
						ListaUsuario.listaUsuario.add(usuario);
						return Response.status(Response.Status.OK).entity(Response.Status.OK.toString()).build();
					} else {
						return Response.status(Response.Status.FOUND).encoding(Response.Status.FOUND.toString())
								.build();
					}
				} else {
					return Response.status(Response.Status.FOUND).encoding(Response.Status.FOUND.toString()).build();
				}
			} else {
				return Response.status(Response.Status.FOUND).encoding(Response.Status.FOUND.toString()).build();
			}

	// @GET
	// @Path("/buscarPorNome/{nome}")
	// @Produces("application/json")
	// public Response buscarPorNome(@PathParam("nome") String nome) {
	// return Response.status(200).entity(new GenericEntity<List<Usuario>>(
	// ListaUsuario.listaUsuario.stream().filter(u ->
	// u.getNome().equals(nome)).collect(Collectors.toList())) {
	// }).build();
	// }
	//
	// @GET
	// @Path("/buscarPorCPF/{cpf}")
	// @Produces("application/json")
	// public Response buscarCPF(@PathParam("cpf") String cpf) {
	//
	// return Response.status(200).entity(new GenericEntity<List<Usuario>>(
	// ListaUsuario.listaUsuario.stream().filter(u ->
	// u.getCpf().equals(cpf)).collect(Collectors.toList())) {
	// }).build();
	// }
	//
	// @GET
	// @Path("/buscarPorEmail/{email}")
	// @Produces("application/json")
	// public Response buscarEmail(@PathParam("email") String email) {
	// return Response.status(200).entity(new GenericEntity<List<Usuario>>(
	// ListaUsuario.listaUsuario.stream().filter(u ->
	// u.getEmail().equals(email)).collect(Collectors.toList())) {
	// }).build();
	// }
	//
	// @GET
	// @Path("/listar")
	// @Produces("application/json")
	// public Response listarTodos() {
	// return Response.status(200).entity(new
	// GenericEntity<List<Usuario>>(ListaUsuario.listaUsuario) {
	// }).build();
	// }

}
