package com.banregio.next.actividadback.app.domain.repository;

import org.springframework.stereotype.Repository;

import com.banregio.next.actividadback.app.domain.entity.Ejemplo;
import com.banregio.next.postgre.domain.repository.PostgreRepository;

/**
 * Ejemplo de repository para un CRUD, de ser necesario aquí se pueden agregar mas metodos.
 * @author ${user}
 * @since ${date}
 */
@Repository
public interface EjemplosRepository extends PostgreRepository<Ejemplo> {
	
}
