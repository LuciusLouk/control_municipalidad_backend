package com.deluxe.municipalidad.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity @Component
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="veh_id")
	private Long id;
	
	private String agencia;
	private String modelo;
	private String marca;
	private String patente;
}
