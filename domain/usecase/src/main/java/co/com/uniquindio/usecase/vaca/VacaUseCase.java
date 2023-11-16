package co.com.uniquindio.usecase.vaca;


import co.com.uniquindio.model.vaca.Vaca;
import co.com.uniquindio.model.vaca.gateways.VacaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VacaUseCase {

    private final VacaRepository vacaRepository;

    public Vaca guardarVaca(Vaca vaca) {
        return vacaRepository.guardarVaca(vaca);
    }

    public List<Vaca> listarVacas() {
        return vacaRepository.listarVaca();
    }

    public Vaca findById(Long id) {
        return vacaRepository.obtenerVacaPorId(id);
    }

    public void eliminarVaca(Long id) {
        vacaRepository.eliminarVaca(id);
    }
}
