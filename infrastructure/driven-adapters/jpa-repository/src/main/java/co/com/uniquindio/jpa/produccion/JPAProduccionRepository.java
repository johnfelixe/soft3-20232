package co.com.uniquindio.jpa.produccion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAProduccionRepository extends CrudRepository<ProduccionDTO, Long>, QueryByExampleExecutor<ProduccionDTO> {
}
