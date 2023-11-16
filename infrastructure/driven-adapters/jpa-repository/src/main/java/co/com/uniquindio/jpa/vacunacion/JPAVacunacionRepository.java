package co.com.uniquindio.jpa.vacunacion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAVacunacionRepository extends CrudRepository<VacunacionDTO, Long>, QueryByExampleExecutor<VacunacionDTO> {
}