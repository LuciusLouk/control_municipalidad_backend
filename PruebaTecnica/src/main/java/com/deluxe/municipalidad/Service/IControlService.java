package com.deluxe.municipalidad.Service;

import java.time.LocalDate;
import java.util.List;

import com.deluxe.municipalidad.Entity.Control;
import com.deluxe.municipalidad.Entity.Licencia;

public interface IControlService {

	public void registrarControl(Control c);
	public void modificarControl(Control c);
	public List<Control> obtenerTodosControles();
	public List<Control> obtenerControlesLicencia(Licencia l);
	public List<Control> obtenerControlesFecha(LocalDate fecha);
	
}
