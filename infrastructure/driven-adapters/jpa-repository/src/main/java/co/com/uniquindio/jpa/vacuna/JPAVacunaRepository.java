package co.com.uniquindio.jpa.vacuna;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAVacunaRepository extends CrudRepository<VacunaDTO, Long>, QueryByExampleExecutor<VacunaDTO> {
}
