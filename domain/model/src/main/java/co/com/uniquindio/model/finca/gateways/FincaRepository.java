package co.com.uniquindio.model.finca.gateways;

import co.com.uniquindio.model.finca.Finca;

import java.util.List;

public interface FincaRepository {

    Finca guardarFinca(Finca finca);

    Finca obtenerFincaPorId(Long id);

    List<Finca> listarFinca();

    void eliminarFinca(Long id);
}
