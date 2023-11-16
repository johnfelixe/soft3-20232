package co.com.uniquindio.jpa.vaca;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAVacaRepository extends CrudRepository<VacaDTO, Long>, QueryByExampleExecutor<VacaDTO> {
}
