package co.com.uniquindio.api;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.usecase.finca.FincaUseCase;
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
public class FincaApiRest {

    @Autowired
    private final FincaUseCase fincaUseCase;

    @GetMapping(path = "/finca/listar")
    public List<Finca> listarFincaes() {
        return fincaUseCase.listarFincas();
    }

    @GetMapping("/finca/{id}")
    public ResponseEntity<?> buscarFincaPorId(@PathVariable Long id) {

        Finca entidad = null;
        Map<String, Object> response = new HashMap<>();

        entidad = fincaUseCase.findById(id);

        if (entidad == null) {
            response.put("mensaje", "Finca ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Finca>(entidad, HttpStatus.OK);
    }

    @PostMapping("/finca/agregar")
    public ResponseEntity<?> crearFinca(@RequestBody Finca finca) {

        Finca nuevo = null;
        Map<String, Object> response = new HashMap<>();


        nuevo = fincaUseCase.guardarFinca(finca);


        response.put("mensaje", "Finca ha sido creada con exito!");
        response.put("finca", nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/finca/actualizar/{id}")
    public ResponseEntity<?> actualizarFinca(@RequestBody Finca finca, @PathVariable Long id) {

        Finca actual = fincaUseCase.findById(id);
        Finca actualizado = null;
        Map<String, Object> response = new HashMap<>();

        if (actual == null) {
            response.put("mensaje", "Error: no se pudo editar, Finca ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        actual.setNombre(finca.getNombre());
        actual.setDireccion(finca.getDireccion());
        actual.setHectareas(finca.getHectareas());
        actual.setLeche(finca.getLeche());
        actualizado = fincaUseCase.guardarFinca(actual);


        response.put("mensaje", "Finca ha sido actualizado con exito!");
        response.put("finca", actualizado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/finca/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        fincaUseCase.eliminarFinca(id);


        response.put("mensaje", "Finca eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}

