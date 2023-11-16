package co.com.uniquindio.usecase.produccion;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.finca.gateways.FincaRepository;
import co.com.uniquindio.model.produccion.Produccion;
import co.com.uniquindio.model.produccion.gateways.ProduccionRepository;
import co.com.uniquindio.model.vacunacion.Vacunacion;
import co.com.uniquindio.usecase.vacunacion.VacunacionUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProduccionUseCase {

    private final ProduccionRepository produccionRepository;
    private final FincaRepository fincaRepository;
    private final VacunacionUseCase vacunacionUseCase;


    public Produccion guardarProduccion(Produccion produccion) {

        List<Vacunacion> vacunaciones = vacunacionUseCase.listarVacunacionPorVaca(produccion.getVaca().getId());
        if (!vacunaciones.isEmpty()) {
            for (int i = 0; i < vacunaciones.size(); i++) {
                long fechaInicialMs = vacunaciones.get(i).getFecha().getTime();
                long fechaFinalMs = produccion.getFecha().getTime();
                long diferencia = fechaFinalMs - fechaInicialMs;
                long dias = diferencia / (1000 * 60 * 60 * 24);
                if (dias < 15) {
                    return null;
                }
            }
        }

        Finca finca = fincaRepository.obtenerFincaPorId(produccion.getFinca().getId());
        float total = produccion.getCantidad() + finca.getLeche();
        finca.setLeche(total);
        fincaRepository.guardarFinca(finca);
        return produccionRepository.guardarProduccion(produccion);
    }

    public Produccion actualizarProduccion(Produccion produccion) {

        List<Vacunacion> vacunaciones = vacunacionUseCase.listarVacunacionPorVaca(produccion.getVaca().getId());
        if (!vacunaciones.isEmpty()) {
            for (int i = 0; i < vacunaciones.size(); i++) {
                long fechaInicialMs = vacunaciones.get(i).getFecha().getTime();
                long fechaFinalMs = produccion.getFecha().getTime();
                long diferencia = fechaFinalMs - fechaInicialMs;
                long dias = diferencia / (1000 * 60 * 60 * 24);
                if (dias < 15) {
                    return null;
                }
            }
        }
        float eliminarLeche = produccionRepository.obtenerProduccionPorId(produccion.getId()).getCantidad();
        Finca finca = fincaRepository.obtenerFincaPorId(produccion.getFinca().getId());
        float total = produccion.getCantidad() + finca.getLeche() - eliminarLeche;


            finca.setLeche(total);
            fincaRepository.guardarFinca(finca);
            return produccionRepository.guardarProduccion(produccion);

    }

    public List<Produccion> listarProducciones() {
        return produccionRepository.listarProduccion();
    }

    public Produccion findById(Long id) {
        return produccionRepository.obtenerProduccionPorId(id);
    }

    public boolean eliminarProduccion(Long id) {

        Produccion produccion = produccionRepository.obtenerProduccionPorId(id);
        Finca finca = fincaRepository.obtenerFincaPorId(produccion.getFinca().getId());
        float total = finca.getLeche() - produccion.getCantidad();
        if (total >= 0) {
            finca.setLeche(total);
            fincaRepository.guardarFinca(finca);
            produccionRepository.eliminarProduccion(id);
            return true;
        }
        return false;

    }
}