package com.deluxe.municipalidad.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deluxe.municipalidad.Entity.Control;
import com.deluxe.municipalidad.Service.IControlService;

@Controller
@RequestMapping(value="control")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ControlController {

	
	@Autowired
	IControlService controlServiceImp;
	
	@GetMapping(value="todos")
	public ResponseEntity<List<Control>> obtenerControles(){
		
		List<Control> controles = controlServiceImp.obtenerTodosControles();
		System.out.println(controles);
		return ResponseEntity.ok(controles);
	}
	
	@PostMapping(value="alta")
	public ResponseEntity<Map<String, String>> altaControl(@RequestBody Control c){
		Map<String, String> response = new HashMap<>();
		
		controlServiceImp.registrarControl(c);
		response.put("message", "Se registro el control");
		return ResponseEntity.ok(response);
	}
	
	
	
}
