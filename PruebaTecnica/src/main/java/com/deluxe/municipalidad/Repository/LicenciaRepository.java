package com.deluxe.municipalidad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deluxe.municipalidad.Entity.Licencia;

public interface LicenciaRepository extends JpaRepository<Licencia, Long>{


	public Licencia findByNumero(Long numero);
}
