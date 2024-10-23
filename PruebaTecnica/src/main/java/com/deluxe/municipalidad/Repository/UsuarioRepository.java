package com.deluxe.municipalidad.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deluxe.municipalidad.Entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.nombre= :nombre AND u.password =:password")
    public Usuario findByUsernameAndPassword(@Param("nombre") String nombre,@Param("password") String password);

}
