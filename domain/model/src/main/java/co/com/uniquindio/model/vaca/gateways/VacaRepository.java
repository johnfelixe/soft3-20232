package co.com.uniquindio.model.vaca.gateways;

import co.com.uniquindio.model.vaca.Vaca;

import java.util.List;

public interface VacaRepository {
    Vaca guardarVaca(Vaca vaca);

    Vaca obtenerVacaPorId(Long id);

    List<Vaca> listarVaca();

    void eliminarVaca(Long id);
}
