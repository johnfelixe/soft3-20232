package co.com.uniquindio.usecase.trabajador;

import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.model.trabajador.gateways.TrabajadorRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class TrabajadorUseCase {

    private final TrabajadorRepository trabajadorRepository;

    public Trabajador guardarTrabajador(Trabajador trabajador) {
        return trabajadorRepository.guardarTrabajador(trabajador);
    }
    public List<Trabajador> listarTrabajadores() {
        return trabajadorRepository.listarTrabajador();
    }

    public List<Trabajador> listarEmpleados() {
        List<Trabajador> trabajadores = trabajadorRepository.listarTrabajador();
        List<Trabajador> empleados = new ArrayList();
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getCargo().equals("EMPLEADO")) {
                empleados.add(trabajador);
            }
        }
        return empleados;
    }

    public List<Trabajador> listarVeterinarios() {
        List<Trabajador> trabajadores = trabajadorRepository.listarTrabajador();
        List<Trabajador> veterinario = new ArrayList();
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getCargo().equals("VETERINARIO")) {
                veterinario.add(trabajador);
            }
        }
        return veterinario;
    }

    public Trabajador findById(Long id) {
        return trabajadorRepository.obtenerTrabajadorPorId(id);
    }

    public Trabajador findByUsername(String username) {
        List<Trabajador> trabajadores = trabajadorRepository.listarTrabajador();
        if (!trabajadores.isEmpty()) {
            for (int i = 0; i < trabajadores.size(); i++) {
                if (trabajadores.get(i).getUsuario().getUsername().equals(username)) {
                    return trabajadores.get(i);
                }
            }
        }
        return null;
    }

    public Trabajador findByUsernameId(Long id) {
        List<Trabajador> trabajadores = trabajadorRepository.listarTrabajador();
        if (!trabajadores.isEmpty()) {
            for (int i = 0; i < trabajadores.size(); i++) {
                if (trabajadores.get(i).getUsuario().getId().equals(id)) {
                    return trabajadores.get(i);
                }
            }
        }
        return null;
    }

    public void eliminarTrabajador(Long id) {
        trabajadorRepository.eliminarTrabajador(id);
    }
}
