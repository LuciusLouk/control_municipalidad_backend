package com.deluxe.municipalidad.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity @Component
@Table(name="CONDUCTORES")
public class Conductor {	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="cond_id")
	private Long id;
	
	private String apellido;
	private String nombre;
	private Long dni;
	

	@ManyToOne
	@JoinColumn(name="lic_id")
	private Licencia licencia;
}
