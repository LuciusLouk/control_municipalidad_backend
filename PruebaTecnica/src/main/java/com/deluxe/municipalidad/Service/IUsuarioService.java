package com.deluxe.municipalidad.Service;

import com.deluxe.municipalidad.Entity.Usuario;

public interface IUsuarioService {

	public Usuario obtenerUsuarioLogin(String nombre,String password);
}
