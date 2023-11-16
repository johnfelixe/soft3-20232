package co.com.uniquindio.model.venta.gateways;

import co.com.uniquindio.model.venta.Venta;

import java.util.List;

public interface VentaRepository {
    Venta guardarVenta(Venta venta);

    Venta obtenerVentaPorId(Long id);

    List<Venta> listarVenta();

    void eliminarVenta(Long id);
}
