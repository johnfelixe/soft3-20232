package co.com.uniquindio.api;

import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.model.vacuna.Vacuna;
import co.com.uniquindio.usecase.vacuna.VacunaUseCase;
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
public class VacunaApiRest {

    @Autowired
    private final VacunaUseCase useCase;


    @GetMapping(path = "/vacuna/listar")
    public List<Vacuna> listarVacunaes() {
        return useCase.listarVacunas();
    }

    @GetMapping("/vacuna/{id}")
    public ResponseEntity<?> buscarVacunaPorId(@PathVariable Long id) {

        Vacuna entidad = null;
        Map<String, Object> response = new HashMap<>();

            entidad = useCase.findById(id);


        if (entidad == null) {
            response.put("mensaje", "Vacuna ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Vacuna>(entidad, HttpStatus.OK);
    }

    @PostMapping("/vacuna/agregar")
    public ResponseEntity<?> crearVacuna(@RequestBody Vacuna vacuna) {

        Vacuna nuevo = null;
        Map<String, Object> response = new HashMap<>();

            nuevo = useCase.guardarVacuna(vacuna);


        response.put("mensaje", "Vacuna ha sido creada con exito!");
        response.put("Vacuna", nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/vacuna/actualizar/{id}")
    public ResponseEntity<?> actualizarVacuna(@RequestBody Vacuna vacuna, @PathVariable Long id) {

        Vacuna actual = useCase.findById(id);

        Vacuna actualizado = null;

        Map<String, Object> response = new HashMap<>();


        if (actual == null) {
            response.put("mensaje", "Error: no se pudo editar, Vacuna ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }



            actual.setNombre(vacuna.getNombre());
            actual.setTipo(vacuna.getTipo());

            actualizado = useCase.guardarVacuna(actual);



        response.put("mensaje", "Vacuna ha sido actualizado con exito!");
        response.put("Vacuna", actualizado);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/vacuna/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();


            useCase.eliminarVacuna(id);

        response.put("mensaje", "Vacuna eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}