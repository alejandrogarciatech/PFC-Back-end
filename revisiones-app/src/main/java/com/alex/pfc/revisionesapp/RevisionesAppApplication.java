package com.alex.pfc.revisionesapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alex.pfc.revisionesapp.repositorio.UsuarioRepositorio;
import com.alex.pfc.revisionesapp.entidades.Usuario;


@SpringBootApplication
public class RevisionesAppApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(RevisionesAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Usuario> usuario = (List<Usuario>) repositorio.findAll();

		usuario.stream().forEach(usuarios -> {
			System.out.println(usuario);
		});
		/* 
		Usuario usuario1 = new Usuario(null, "Alex", "García García", "Técnico mantenimiento", "alejandrogarcia.tech@gmail.com", "673391682", null);
        Usuario usuario2 = new Usuario(null, "Iván", "Marcos", "Técnico mantenimiento", "ivanmarcos.tech@gmail.com", "673391683", null);
        repositorio.save(usuario1);
        repositorio.save(usuario2);
		*/
	}
}
