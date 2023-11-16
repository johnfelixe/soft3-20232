package co.com.uniquindio.usecase.vacunacion;

import co.com.uniquindio.model.vacunacion.Vacunacion;
import co.com.uniquindio.model.vacunacion.gateways.VacunacionRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class VacunacionUseCase {
    private final VacunacionRepository vacunacionRepository;

    public Vacunacion guardarVacunacion(Vacunacion vacunacion) {
        return vacunacionRepository.guardarVacunacion(vacunacion);
    }

    public List<Vacunacion> listarVacunacion() {
        return vacunacionRepository.listarVacunacion();
    }

    public List<Vacunacion> listarVacunacionPorVaca(Long idVaca) {

        List<Vacunacion> allVacunaciones = vacunacionRepository.listarVacunacion();

        List<Vacunacion> vacunaciones = new ArrayList<>();

        for (Vacunacion vacuna : allVacunaciones) {
            if (vacuna.getVaca().getId()== idVaca) {
                vacunaciones.add(vacuna);
            }
        }


        return vacunaciones;
    }

    public Vacunacion findById(Long id) {
        return vacunacionRepository.obtenerVacunacionPorId(id);
    }

    public void eliminarVacunacion(Long id) {
        vacunacionRepository.eliminarVacunacion(id);
    }
}
