package co.com.uniquindio.model.trabajador.gateways;

import co.com.uniquindio.model.trabajador.Trabajador;

import java.util.List;

public interface TrabajadorRepository {
    Trabajador guardarTrabajador(Trabajador trabajador);

    Trabajador obtenerTrabajadorPorId(Long id);

    List<Trabajador> listarTrabajador();

    void eliminarTrabajador(Long id);
}
