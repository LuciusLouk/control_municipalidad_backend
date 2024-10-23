package com.deluxe.municipalidad;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FileUpload {

	private final Path rootLocation = Paths.get("src", "main", "resources", "static", "images");

	public Path obtenerRutaDeGuardado() {
		/****** Genero un nombre único para el archivo que se guardará en la ruta ********/
        LocalDateTime now = LocalDateTime.now();
        
        // Formatear la fecha y hora actual como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = now.format(formatter);
        
        // Generar un identificador único aleatorio
        String uniqueID = UUID.randomUUID().toString();
        
        String uniqueName = formattedDateTime + "_" + uniqueID + ".png";
   	 	// Crear una ruta para la carpeta donde se almacenarán los archivos
       Path directorioImagenes = Paths.get("src", "main", "resources", "static", "images");
       // Obtener la ruta completa del archivo
       return directorioImagenes.resolve(uniqueName);
        
       
	}
	
	/**
	 * @param base64
	 * @return Devuelve un texto en base 64 sin encabezado
	 */
	public String obtenerBase64SinEncabezado(String base64) {

        String base64SinEncabezado = "";
		int indexComa = base64.indexOf(","); // Encuentra la posición de la coma
        if (indexComa != -1) {
            base64SinEncabezado = base64.substring(indexComa + 1); // Obtiene la subcadena después de la coma

        } else {
            // Manejo de caso donde no se encuentra la coma
            base64SinEncabezado = base64;
        }
		return base64SinEncabezado;
	}
	
	/**
	 * Establece la ruta de la imagen que será enviada al front 
	 * @param imagen
	 * @return
	 */
	public String cargarImagen(String imagen) {
		String ruta = imagen.replace("src\\main\\resources\\static\\images\\", "http://localhost:8080/files/");

	    return ruta;
	}
}
