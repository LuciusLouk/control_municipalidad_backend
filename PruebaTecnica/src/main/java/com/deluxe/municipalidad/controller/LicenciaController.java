package com.deluxe.municipalidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deluxe.municipalidad.Entity.Licencia;
import com.deluxe.municipalidad.Service.ILicenciaService;

@Controller
@RequestMapping(value="licencia")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class LicenciaController {
	
	@Autowired
	ILicenciaService licenciaServiceImp;
	
	@GetMapping(value="numero/{num}")
	public ResponseEntity<Licencia> obtenerLicenciaPorNumero(@PathVariable(value="num")Long numero){
		Licencia licencia = licenciaServiceImp.obtenerLicenciaPorNumero(numero);
		
		return ResponseEntity.ok(licencia);
	}
}
