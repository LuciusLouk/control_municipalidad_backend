package com.deluxe.municipalidad.Service.Imp;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deluxe.municipalidad.FileUpload;
import com.deluxe.municipalidad.Entity.Conductor;
import com.deluxe.municipalidad.Entity.Control;
import com.deluxe.municipalidad.Entity.Licencia;
import com.deluxe.municipalidad.Repository.ControlRepository;
import com.deluxe.municipalidad.Service.IControlService;
import com.deluxe.municipalidad.Service.ILicenciaService;

@Service
public class ControlServiceImp implements IControlService {

	private final Path rootLocation = Paths.get("src", "main", "resources", "static", "images");
	@Autowired
	ControlRepository controlRepository;
	@Autowired
	ILicenciaService licenciaRepository;
	
	@Override
	public void registrarControl(Control c) {
		//Antes de guardar debo cambiar el base64 por la ruta donde se guardará la imagen
				String base64=c.getDniFrente();
				//decodifico el texto en base64 a bytes (procuro quitarle el encabezado)
				byte[] bytesDecodificados = Base64.decodeBase64(FileUpload.obtenerBase64SinEncabezado(base64));
				
		        /******* Crear la imagen en proyecto *********/
		        Path rutaCompleta = FileUpload.obtenerRutaDeGuardado();
		        try (OutputStream stream = Files.newOutputStream(rutaCompleta)) {
		            stream.write(bytesDecodificados);
		        } catch (IOException e) {
		            System.err.println("Error al guardar la imagen: " + e.getMessage());
		        }
		
        Licencia l = new Licencia();
        l.setId(licenciaRepository.obtenerLicenciaPorNumero(c.getLicencia().getNumero()).getId());
        //c.setLicencia(l);
        //licenciaRepository.save(l);
        		
        //c.setDniFrente(rutaCompleta.toString());
        //licenciaRepository.save(c.getLicencia());
        Control control = new Control();
        control.setFecha(c.getFecha());
        control.setNotaAdicional(c.getNotaAdicional());
        control.setDniFrente(rutaCompleta.toString());
        control.setUsuario(c.getUsuario());
        control.setLicencia(l);
        

        controlRepository.save(control);

	}

	@Override
	public void modificarControl(Control c) {
		Control control = controlRepository.findById(c.getId()).orElse(c);
		if(control !=null) {
			control = c;
			controlRepository.save(control);
		}

	}

	@Override
	public List<Control> obtenerTodosControles() {
		List<Control> controles = controlRepository.findAll();
		for (Control control : controles) {
			List<Conductor> conductores = control.getLicencia().getConductores();
			for (Conductor conductor : conductores) {
				conductor.setLicencia(null);			}
		}
		return controles;
	}

	@Override
	public List<Control> obtenerControlesLicencia(Licencia l) {
		return controlRepository.findByLicenciaId(l.getId());
	}

	@Override
	public List<Control> obtenerControlesFecha(LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
