package com.alex.pfc.revisionesapp;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.alex.pfc.revisionesapp.repositorio.EquipoRepositorio;
import com.alex.pfc.revisionesapp.repositorio.UsuarioRepositorio;
import com.alex.pfc.revisionesapp.entidades.Equipo;
import com.alex.pfc.revisionesapp.entidades.Usuario;


@SpringBootApplication
public class RevisionesAppApplication implements CommandLineRunner{
/*
	@Autowired
	private UsuarioRepositorio repositorio;

	@Autowired
	private EquipoRepositorio repositorio2;
*/
	public static void main(String[] args) {
		SpringApplication.run(RevisionesAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//list();
		//findOne();
		//queriesPersonalizadas();
		//createUsuario();
		//createEquipo();
		//update();
		//delete();
		//delete2();
	}
/*
	@Transactional(readOnly = true)
	public void list(){
		//List<Usuario> usuario = (List<Usuario>) repositorio.findAll();
		//List<Usuario> usuario = (List<Usuario>) repositorio.buscarByPuesto("Director técnico", "Juan");

		List<Usuario> usuarios = (List<Usuario>) repositorio.findByPuestoAndNombre("DirectorTecnico", "Peter");

		usuarios.stream().forEach(usuario -> {
			System.out.println(usuario);
		});
	}

	@Transactional(readOnly = true)
	public void findOne(){
		Usuario usuario = null;
		Optional<Usuario> optionalUsuario = repositorio.findById(1L);
		if(optionalUsuario.isPresent()){
			usuario = optionalUsuario.get();
		}
		System.out.println(usuario);
		
		repositorio.findByNombreContaining("no").ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void queriesPersonalizadas(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("============ CONSULTA DE  NOMBRE POR ID ============");
		System.out.println("Ingrese el id para buscar el nombre: ");
		Long id = teclado.nextLong();
		teclado.close();

		String nombre = repositorio.getNombreById(id);
		System.out.println(nombre);

		String nombreCompleto = repositorio.getNombreCompletoById(id);
		System.out.println(nombreCompleto);
	}

	@Transactional
	public void createUsuario(){

		Scanner scanner = new Scanner (System.in);
		System.out.println("Ingrese el nombre: ");
		String nombre = scanner.next();
		System.out.println("Ingrese el apellido: ");
		String apellido = scanner.next();
		System.out.println("Ingrese el puesto: ");
		String puesto = scanner.next();
		System.out.println("Ingrese el correo: ");
		String correo = scanner.next();
		System.out.println("Ingrese el teléfono: ");
		String telefono = scanner.next();
		scanner.close();

		Usuario usuario = new Usuario(null, nombre, apellido, puesto, correo, telefono, null);
		
		Usuario usuarioNew = repositorio.save(usuario);
		System.out.println(usuarioNew);

		repositorio.findById(usuarioNew.getId()).ifPresent(System.out::println);
	}
/* 
	@Transactional
	public void createEquipo(){

		Scanner scanner = new Scanner (System.in);
		System.out.println("Ingrese la matrícula: ");
		String id = scanner.next();
		System.out.println("Ingrese el nombre: ");
		String nombre = scanner.next();
		System.out.println("Ingrese el tipo de producto: ");
		Long tipoProducto = scanner.nextLong();
		System.out.println("Ingrese la marca: ");
		String marca = scanner.next();
		System.out.println("Ingrese el modelo: ");
		String modelo = scanner.next();
		System.out.println("Ingrese el número de serie: ");
		Long nSerie = scanner.nextLong();
		System.out.println("Ingrese el peso: ");
		double peso = scanner.nextDouble();
		System.out.println("Ingrese las dimensiones: ");
		double dimensiones = scanner.nextDouble();
		System.out.println("Ingrese la ubicación: ");
		String ubicacion = scanner.next();
		scanner.close();

		Equipo equipo = new Equipo(id, nombre, tipoProducto, marca, modelo, nSerie, peso, dimensiones, ubicacion);

		Equipo equipoNew = repositorio2.save(equipo);
		System.out.println(equipoNew);

		repositorio2.findById(equipoNew.getId()).ifPresent(System.out::println);
	}

	@Transactional
	public void update(){

		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el ID del usuario a editar: ");
		Long id = teclado.nextLong();

		Optional<Usuario> optionalUsuario = repositorio.findById(id);

		if (optionalUsuario.isPresent()){

			Usuario usuario = optionalUsuario.orElseThrow();

			System.out.println(usuario);
			System.out.println("Ingrese el puesto: ");
			String puesto = teclado.next();
			usuario.setPuesto(puesto);
			Usuario usuarioActualizado = repositorio.save(usuario);
			System.out.println(usuarioActualizado);
		} else {
			System.out.println("El usuario no existe");
		}
		teclado.close();
	}

	@Transactional
	public void delete(){
		repositorio.findAll().forEach(System.out::println);

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el ID del usuario a eliminar: ");
		Long id = teclado.nextLong();
		repositorio.deleteById(id);

		repositorio.findAll().forEach(System.out::println);

		teclado.close();
	}

	@Transactional
	public void delete2(){
		repositorio.findAll().forEach(System.out::println);

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el ID del usuario a eliminar: ");
		Long id = teclado.nextLong();

		Optional<Usuario> optionalUsuario = repositorio.findById(id);

		optionalUsuario.ifPresentOrElse(usuario -> repositorio.delete(usuario), 
		() -> System.out.println("El id introducido no existe"));

		repositorio.findAll().forEach(System.out::println);

		teclado.close();
	}
	*/
}
