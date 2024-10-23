package com.deluxe.municipalidad.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deluxe.municipalidad.Entity.Usuario;
import com.deluxe.municipalidad.Service.IUsuarioService;
import com.deluxe.municipalidad.model.LoginRequest;


@CrossOrigin(origins = {"http://localhost:4200/"})
@Controller
public class LoginController {

	@Autowired
	IUsuarioService usuarioServiceImp;
	
	@PostMapping(value="login")
	public ResponseEntity<Usuario> login(@RequestBody LoginRequest loginRequest){
		Usuario usuario = usuarioServiceImp.obtenerUsuarioLogin(loginRequest.getUsername(), loginRequest.getPassword());
		return ResponseEntity.ok(usuario);
	}
}
