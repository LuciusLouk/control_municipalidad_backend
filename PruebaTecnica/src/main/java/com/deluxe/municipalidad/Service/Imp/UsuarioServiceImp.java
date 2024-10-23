package com.deluxe.municipalidad.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deluxe.municipalidad.Entity.Usuario;
import com.deluxe.municipalidad.Repository.UsuarioRepository;
import com.deluxe.municipalidad.Service.IUsuarioService;
@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario obtenerUsuarioLogin(String nombre, String password) {
		return usuarioRepository.findByUsernameAndPassword(nombre, password);
	}

}
