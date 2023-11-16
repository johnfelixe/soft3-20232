package co.com.uniquindio.jpa.venta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAVentaRepository extends CrudRepository<VentaDTO, Long>, QueryByExampleExecutor<VentaDTO> {
}