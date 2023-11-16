package co.com.uniquindio.api;

import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.usecase.trabajador.TrabajadorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/api/v1/agroeasy", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrabajadorApiRest {

    @Autowired
    private final TrabajadorUseCase trabajadorUseCase;



    @GetMapping(path = "/trabajador/listar")
    public List<Trabajador> listarTrabajadores() {
        return trabajadorUseCase.listarTrabajadores();
    }

    @GetMapping(path = "/empleados/listar")
    public List<Trabajador> listarEmpleados() {
        return trabajadorUseCase.listarEmpleados();
    }

    @GetMapping(path = "/veterinario/listar")
    public List<Trabajador> listarVeterinarios() {
        return trabajadorUseCase.listarVeterinarios();
    }

    @GetMapping("/trabajador/{id}")
    public ResponseEntity<?> buscarTrabajadorPorId(@PathVariable Long id) {

        Trabajador trabajador = null;
        Map<String, Object> response = new HashMap<>();

        trabajador = trabajadorUseCase.findById(id);

        if (trabajador == null) {
            response.put("mensaje", "El trabajador ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<Trabajador>(trabajador, HttpStatus.OK);
    }

    @PostMapping("/trabajador/agregar")
    public ResponseEntity<?> crearTrabajador(@RequestBody Trabajador trabajador) {

        Trabajador trabajadorNuevo = null;
        Map<String, Object> response = new HashMap<>();

        List<Trabajador> trabajadores = trabajadorUseCase.listarTrabajadores();


            trabajadorNuevo = trabajadorUseCase.guardarTrabajador(trabajador);


        response.put("mensaje", "El trabajador ha sido creado con exito!");
        response.put("trabajador", trabajadorNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/trabajador/actualizar/{id}")
    public ResponseEntity<?> actualizarTrabajador(@RequestBody Trabajador trabajador, @PathVariable Long id) {

        Trabajador trabajadorActual = trabajadorUseCase.findById(id);

        Trabajador trabajadorActualizado = null;

        Map<String, Object> response = new HashMap<>();


        if (trabajadorActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el trabajador ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }



            trabajadorActual.setNombre(trabajador.getNombre());
            trabajadorActual.setApellido(trabajador.getApellido());
            trabajadorActual.setCargo(trabajador.getCargo());
            trabajadorActual.setCorreo(trabajador.getCorreo());
            trabajadorActual.setCedula(trabajador.getCedula());
            trabajadorActual.setFecha(trabajador.getFecha());
            trabajadorActual.setFinca(trabajador.getFinca());

            trabajadorActualizado = trabajadorUseCase.guardarTrabajador(trabajadorActual);



        response.put("mensaje", "El trabajador ha sido actualizado con exito!");
        response.put("trabajador", trabajadorActualizado);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/trabajador/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();


            trabajadorUseCase.eliminarTrabajador(id);


        response.put("mensaje", "El trabajador eliminado con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
