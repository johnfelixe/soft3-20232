package co.com.uniquindio.model.produccion.gateways;

import co.com.uniquindio.model.produccion.Produccion;

import java.util.List;

public interface ProduccionRepository {

    Produccion guardarProduccion(Produccion produccion);

    Produccion obtenerProduccionPorId(Long id);

    List<Produccion> listarProduccion();

    void eliminarProduccion(Long id);
}
