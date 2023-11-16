package co.com.uniquindio.usecase.vacuna;

import co.com.uniquindio.model.vacuna.Vacuna;
import co.com.uniquindio.model.vacuna.gateways.VacunaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VacunaUseCase {
    private final VacunaRepository vacunaUseCase;

    public Vacuna guardarVacuna(Vacuna vacuna) {
        return vacunaUseCase.guardarVacuna(vacuna);
    }

    public List<Vacuna> listarVacunas() {
        return vacunaUseCase.listarVacuna();
    }

    public Vacuna findById(Long id) {
        return vacunaUseCase.obtenerVacunaPorId(id);
    }

    public void eliminarVacuna(Long id) {
        vacunaUseCase.eliminarVacuna(id);
    }
}
