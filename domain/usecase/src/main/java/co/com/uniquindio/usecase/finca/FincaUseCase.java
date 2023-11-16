package co.com.uniquindio.usecase.finca;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.finca.gateways.FincaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FincaUseCase {

    private final FincaRepository fincaRepository;

    public Finca guardarFinca(Finca finca) {
        return fincaRepository.guardarFinca(finca);
    }

    public List<Finca> listarFincas() {
        return fincaRepository.listarFinca();
    }

    public Finca findById(Long id) {
        return fincaRepository.obtenerFincaPorId(id);
    }

    public void eliminarFinca(Long id) {
        fincaRepository.eliminarFinca(id);
    }
}