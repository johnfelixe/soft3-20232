package co.com.uniquindio.jpa.vacuna;

import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.vacuna.Vacuna;
import co.com.uniquindio.model.vacuna.gateways.VacunaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPAVacunaRepositoryAdapter extends AdapterOperations<Vacuna, VacunaDTO, Long, JPAVacunaRepository>
        implements VacunaRepository {

    public JPAVacunaRepositoryAdapter(JPAVacunaRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Vacuna.class));
    }

    @Override
    public Vacuna guardarVacuna(Vacuna var) {
        return super.save(var);
    }


    @Override
    public Vacuna obtenerVacunaPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Vacuna> listarVacuna() {
        return super.findAll();
    }

    @Override
    public void eliminarVacuna(Long id) {
        super.delete(id);

    }
}