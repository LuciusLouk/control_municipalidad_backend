package com.deluxe.municipalidad.Entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity @Component
@Table(name="CONTROLES")
public class Control {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="con_id")
	private Long id;
	
	private LocalDate fecha;
	private String notaAdicional;
	private String dniFrente;
	private String dniDorso;
	private String carnet;
	

	@ManyToOne
	@JoinColumn(name="usu_id",nullable=false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name="lic_id")
	private Licencia licencia;
	
}
