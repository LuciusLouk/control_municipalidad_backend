package com.deluxe.municipalidad.Entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity @Component
@Table(name="LICENCIAS")
public class Licencia {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="lic_id")
	private Long id;
	
	private Long numero;
	private LocalDate fechaExpiracion;
	
	@OneToOne
	@JoinColumn(name="veh_id")
	private Vehiculo vehiculo;

	@OneToMany(mappedBy = "licencia",fetch = FetchType.EAGER, cascade= CascadeType.REMOVE)
	private List<Conductor> conductores;
	
}
