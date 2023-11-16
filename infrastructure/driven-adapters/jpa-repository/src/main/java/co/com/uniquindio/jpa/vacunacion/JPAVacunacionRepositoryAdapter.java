package co.com.uniquindio.jpa.vacunacion;

import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.vacunacion.Vacunacion;
import co.com.uniquindio.model.vacunacion.gateways.VacunacionRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPAVacunacionRepositoryAdapter extends AdapterOperations<Vacunacion, VacunacionDTO, Long, JPAVacunacionRepository>
        implements VacunacionRepository {

    public JPAVacunacionRepositoryAdapter(JPAVacunacionRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Vacunacion.class));
    }

    @Override
    public Vacunacion guardarVacunacion(Vacunacion var) {
        return super.save(var);
    }


    @Override
    public Vacunacion obtenerVacunacionPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Vacunacion> listarVacunacion() {
        return super.findAll();
    }

    @Override
    public void eliminarVacunacion(Long id) {
        super.delete(id);

    }
}