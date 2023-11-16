package co.com.uniquindio.jpa.trabajador;

import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.model.trabajador.gateways.TrabajadorRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPATrabajadorRepositoryAdapter extends AdapterOperations<Trabajador, TrabajadorDTO, Long, JPATrabajadorRepository>
        implements TrabajadorRepository {

    public JPATrabajadorRepositoryAdapter(JPATrabajadorRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Trabajador.class));
    }

    @Override
    public Trabajador guardarTrabajador(Trabajador trabajador) {
        return super.save(trabajador);
    }


    @Override
    public Trabajador obtenerTrabajadorPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Trabajador> listarTrabajador() {
        return super.findAll();
    }

    @Override
    public void eliminarTrabajador(Long id) {
        super.delete(id);

    }
}
