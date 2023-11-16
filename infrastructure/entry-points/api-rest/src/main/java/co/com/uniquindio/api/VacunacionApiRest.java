package co.com.uniquindio.api;

import co.com.uniquindio.model.vacunacion.Vacunacion;
import co.com.uniquindio.usecase.vacunacion.VacunacionUseCase;
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
public class VacunacionApiRest {

    @Autowired
    private final VacunacionUseCase useCase;


    @GetMapping(path = "/vacunacion/listar")
    public List<Vacunacion> listarVacunaciones() {
        return useCase.listarVacunacion();
    }

    @GetMapping("/vacunacion/{id}")
    public ResponseEntity<?> buscarVacunacionPorId(@PathVariable Long id) {

        Vacunacion entidad = null;
        Map<String, Object> response = new HashMap<>();


            entidad = useCase.findById(id);


        if (entidad == null) {
            response.put("mensaje", "Vacunacion ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Vacunacion>(entidad, HttpStatus.OK);
    }

    @PostMapping("/vacunacion/agregar")
    public ResponseEntity<?> crearVacunacion(@RequestBody Vacunacion vacunacion) {

        Vacunacion nuevo = null;
        Map<String, Object> response = new HashMap<>();



            nuevo = useCase.guardarVacunacion(vacunacion);


        response.put("mensaje", "Vacunacion ha sido creada con exito!");
        response.put("Vacunacion", nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/vacunacion/actualizar/{id}")
    public ResponseEntity<?> actualizarVacunacion(@RequestBody Vacunacion vacunacion, @PathVariable Long id) {

        Vacunacion actual = useCase.findById(id);

        Vacunacion actualizado = null;

        Map<String, Object> response = new HashMap<>();


        if (actual == null) {
            response.put("mensaje", "Error: no se pudo editar, La Vacunación ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

            actual.setVaca(vacunacion.getVaca());
            actual.setTrabajador(vacunacion.getTrabajador());
            actual.setVacuna(vacunacion.getVacuna());
            actual.setFecha(vacunacion.getFecha());

            actualizado = useCase.guardarVacunacion(actual);



        response.put("mensaje", "La vacunación ha sido actualizado con exito!");
        response.put("vacunacion", actualizado);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/vacunacion/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();


            useCase.eliminarVacunacion(id);

        response.put("mensaje", "Vacunacion eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }



}