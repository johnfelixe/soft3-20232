package co.com.uniquindio.jpa.vaca;

import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.vaca.Vaca;
import co.com.uniquindio.model.vaca.gateways.VacaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPAVacaRepositoryAdapter extends AdapterOperations<Vaca, VacaDTO, Long, JPAVacaRepository>
        implements VacaRepository {

    public JPAVacaRepositoryAdapter(JPAVacaRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Vaca.class));
    }

    @Override
    public Vaca guardarVaca(Vaca var) {
        return super.save(var);
    }


    @Override
    public Vaca obtenerVacaPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Vaca> listarVaca() {
        return super.findAll();
    }

    @Override
    public void eliminarVaca(Long id) {
        super.delete(id);

    }
}
