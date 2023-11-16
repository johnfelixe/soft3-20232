package co.com.uniquindio.usecase.venta;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.finca.gateways.FincaRepository;
import co.com.uniquindio.model.venta.Venta;
import co.com.uniquindio.model.venta.gateways.VentaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VentaUseCase {
    private final VentaRepository ventaRepository;
    private final FincaRepository fincaRepository;

    public Venta guardarVenta(Venta var) {

        Finca finca = fincaRepository.obtenerFincaPorId(var.getFinca().getId());

        if (finca.getLeche() - var.getCantidad() >= 0) {
            float total = finca.getLeche() - var.getCantidad();
            finca.setLeche(total);

            if (var.getCantidad() >= 50) {
                var.setPrecio((float) (var.getCantidad() * 1800 - var.getCantidad() * 1800 * 0.20));
            } else if (var.getCantidad() >= 0) {
                var.setPrecio((float) (var.getCantidad() * 1800));
            } else {
                var.setPrecio(0);
            }
            fincaRepository.guardarFinca(finca);
            return ventaRepository.guardarVenta(var);
        }
        return null;
    }

    public Venta actualizarVenta(Venta var) {

        Finca finca = fincaRepository.obtenerFincaPorId(var.getFinca().getId());

        if (finca.getLeche() - var.getCantidad() >= 0) {
            float total = finca.getLeche() - var.getCantidad();
            finca.setLeche(total);

            if (var.getCantidad() >= 50) {
                var.setPrecio((float) (var.getCantidad() * 1800 - var.getCantidad() * 1800 * 0.20));
            } else if (var.getCantidad() >= 0) {
                var.setPrecio((float) (var.getCantidad() * 1800));
            } else {
                var.setPrecio(0);
            }
            fincaRepository.guardarFinca(finca);
            return ventaRepository.guardarVenta(var);
        }
        return null;
    }


    public List<Venta> listarVenta() {
        return ventaRepository.listarVenta();
    }

    public Venta findById(Long id) {
        return ventaRepository.obtenerVentaPorId(id);
    }

    public void eliminarVenta(Long id) {
        Venta venta = ventaRepository.obtenerVentaPorId(id);
        Finca finca = fincaRepository.obtenerFincaPorId(venta.getFinca().getId());
        float total = finca.getLeche() + venta.getCantidad();
        finca.setLeche(total);
        fincaRepository.guardarFinca(finca);
        ventaRepository.eliminarVenta(id);
    }
}
