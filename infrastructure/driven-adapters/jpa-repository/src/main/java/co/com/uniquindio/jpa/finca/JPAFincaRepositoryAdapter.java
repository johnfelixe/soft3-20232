package co.com.uniquindio.jpa.finca;


import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.finca.gateways.FincaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPAFincaRepositoryAdapter extends AdapterOperations<Finca, FincaDTO, Long, JPAFincaRepository>
        implements FincaRepository {

    public JPAFincaRepositoryAdapter(JPAFincaRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Finca.class));
    }

    @Override
    public Finca guardarFinca(Finca var) {
        return super.save(var);
    }


    @Override
    public Finca obtenerFincaPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Finca> listarFinca() {
        return super.findAll();
    }

    @Override
    public void eliminarFinca(Long id) {
        super.delete(id);

    }
}