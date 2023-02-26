/**
 * 
 */
package com.devpredator.practicawebservices.service;

import java.util.ArrayList;
import java.util.List;

import com.devpredator.practicawebservices.entity.Restaurante;

/**
 * @author 4PF28LA_2004
 *
 */
public class RestauranteService {

	public List<Restaurante> consultarRestaurantes() {
		// Restaurante 1:
		Restaurante r1 = new Restaurante();
		r1.setIdRestaurante(1L);
		r1.setNombre("La Perla 1.");
		r1.setDireccion("Las serranas 400.");
		r1.setSlogan("Slogan 1.");

		// Restaurante 2:
		Restaurante r2 = new Restaurante();
		r2.setIdRestaurante(2L);
		r2.setNombre("La Perla 2.");
		r2.setDireccion("Las serranas 402.");
		r2.setSlogan("Slogan 2.");

		// Restaurante 3:
		Restaurante r3 = new Restaurante();
		r3.setIdRestaurante(3L);
		r3.setNombre("La Perla 3.");
		r3.setDireccion("Las serranas 403.");
		r3.setSlogan("Slogan 3.");

		// Restaurante 4:
		Restaurante r4 = new Restaurante();
		r4.setIdRestaurante(4L);
		r4.setNombre("La Perla 4.");
		r4.setDireccion("Las serranas 404.");
		r4.setSlogan("Slogan 4.");

		// Restaurante 5:
		Restaurante r5 = new Restaurante();
		r5.setIdRestaurante(5L);
		r5.setNombre("La Perla 5.");
		r5.setDireccion("Las serranas 405.");
		r5.setSlogan("Slogan 5.");
		
		//Listado de restaurante:
		List<Restaurante> restaurantes = new ArrayList<>();
		
		restaurantes.add(r1);
		restaurantes.add(r2);
		restaurantes.add(r3);
		restaurantes.add(r4);
		restaurantes.add(r5);

		return restaurantes;
	}
	
	public Restaurante consultarRestaurante(Long id) {
		List<Restaurante> restaurantes = this.consultarRestaurantes();
		
		Restaurante rs = null;
		
		for (Restaurante restaurante : restaurantes) {
			if(id == restaurante.getIdRestaurante()) {
				rs = restaurante;
			}
		}
		return rs;
	}
}
