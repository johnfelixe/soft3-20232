package co.com.uniquindio.model.vacuna.gateways;

import co.com.uniquindio.model.vacuna.Vacuna;

import java.util.List;

public interface VacunaRepository {
    Vacuna guardarVacuna(Vacuna vacuna);

    Vacuna obtenerVacunaPorId(Long id);

    List<Vacuna> listarVacuna();

    void eliminarVacuna(Long id);
}
