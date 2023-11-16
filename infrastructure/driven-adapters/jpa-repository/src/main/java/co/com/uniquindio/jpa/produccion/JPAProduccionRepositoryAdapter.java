package co.com.uniquindio.jpa.produccion;

import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.produccion.Produccion;
import co.com.uniquindio.model.produccion.gateways.ProduccionRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPAProduccionRepositoryAdapter extends AdapterOperations<Produccion, ProduccionDTO, Long, JPAProduccionRepository>
        implements ProduccionRepository {

    public JPAProduccionRepositoryAdapter(JPAProduccionRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Produccion.class));
    }

    @Override
    public Produccion guardarProduccion(Produccion var) {
        return super.save(var);
    }


    @Override
    public Produccion obtenerProduccionPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Produccion> listarProduccion() {
        return super.findAll();
    }

    @Override
    public void eliminarProduccion(Long id) {
        super.delete(id);

    }
}