package co.com.uniquindio.jpa.venta;

import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.venta.Venta;
import co.com.uniquindio.model.venta.gateways.VentaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPAVentaRepositoryAdapter extends AdapterOperations<Venta, VentaDTO, Long, JPAVentaRepository>
        implements VentaRepository {

    public JPAVentaRepositoryAdapter(JPAVentaRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Venta.class));
    }

    @Override
    public Venta guardarVenta(Venta var) {
        return super.save(var);
    }


    @Override
    public Venta obtenerVentaPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Venta> listarVenta() {
        return super.findAll();
    }

    @Override
    public void eliminarVenta(Long id) {
        super.delete(id);

    }
}