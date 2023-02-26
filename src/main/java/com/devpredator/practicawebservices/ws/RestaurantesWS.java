/**
 * 
 */
package com.devpredator.practicawebservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.devpredator.practicawebservices.entity.Restaurante;
import com.devpredator.practicawebservices.service.RestauranteService;

/**
 * @author 4PF28LA_2004
 *
 */
@Path("restaurantesWS")
public class RestaurantesWS {

	private RestauranteService rs = new RestauranteService();
	
	@GET
	@Path("consultarRestaurantes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Restaurante> consultarRestaurantes() {
		return this.rs.consultarRestaurantes();
				
	}
	
	@GET
	@Path("consultarRestaurante/{numEmp}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorId(@PathParam("numEmp") Long numero) {
		Restaurante em =  this.rs.consultarRestaurante(numero);
		
		if(em == null) {
			return Response.noContent().build();
		}
		
		GenericEntity<Restaurante> empleadoGenerico = new GenericEntity<Restaurante>(em, Restaurante.class);
		
		return Response.ok(empleadoGenerico.getEntity()).build();
	}
	
	@POST
	@Path("guardarRestaurante")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarRestaurante(Restaurante restaurante) {
		
		if(restaurante == null) {
			return Response.status(400).entity("No se ha ingresado dato alguno del Restaurante. Favor de ingresar datos").build();
		}
		
		if(restaurante.getIdRestaurante() == null ) {
			return Response.status(400).entity("El ID del Restaurante es obligatorio, favor de ingresarlo.").build();
		}
		
		
		if(restaurante.getNombre() == null || restaurante.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre del Restaurante es obligatorio, favor de ingresar uno.").build();
		}
		
		GenericEntity<Restaurante> restauranteGenerico = new GenericEntity<Restaurante>(restaurante, Restaurante.class);
		return Response.ok(restauranteGenerico).build();
	}
}
