package com.deluxe.municipalidad.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deluxe.municipalidad.Entity.Conductor;
import com.deluxe.municipalidad.Entity.Licencia;
import com.deluxe.municipalidad.Repository.LicenciaRepository;
import com.deluxe.municipalidad.Service.ILicenciaService;

@Service
public class LicenciaServiceImp implements ILicenciaService {

	@Autowired
	LicenciaRepository licenciaRepository;
	
	
	@Override
	public Licencia obtenerLicenciaPorNumero(Long numero) {
		Licencia licencia = licenciaRepository.findByNumero(numero);
		
		
		return licencia;
	}

}
