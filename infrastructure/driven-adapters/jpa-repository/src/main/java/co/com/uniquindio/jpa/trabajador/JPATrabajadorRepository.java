package co.com.uniquindio.jpa.trabajador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPATrabajadorRepository extends CrudRepository<TrabajadorDTO, Long>, QueryByExampleExecutor<TrabajadorDTO> {
}
