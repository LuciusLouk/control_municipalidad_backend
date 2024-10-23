package com.deluxe.municipalidad.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deluxe.municipalidad.Entity.Control;

public interface ControlRepository extends JpaRepository<Control, Long>{

	public List<Control> findByLicenciaId(Long id);
}
