package co.com.uniquindio.model.vacunacion.gateways;

import co.com.uniquindio.model.vacunacion.Vacunacion;

import java.util.List;

public interface VacunacionRepository {
    Vacunacion guardarVacunacion(Vacunacion vacunacion);

    Vacunacion obtenerVacunacionPorId(Long id);

    List<Vacunacion> listarVacunacion();

    void eliminarVacunacion(Long id);
}
