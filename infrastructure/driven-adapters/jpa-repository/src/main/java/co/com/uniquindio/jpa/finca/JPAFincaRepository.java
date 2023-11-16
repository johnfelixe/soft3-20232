package co.com.uniquindio.jpa.finca;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAFincaRepository extends CrudRepository<FincaDTO, Long>, QueryByExampleExecutor<FincaDTO> {
}

