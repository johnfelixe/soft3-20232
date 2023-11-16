package co.com.uniquindio.api;


import co.com.uniquindio.model.vaca.Vaca;
import co.com.uniquindio.usecase.vaca.VacaUseCase;
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
public class VacaApiRest {
    @Autowired
    private final VacaUseCase vacaUseCase;

    @GetMapping(path = "/vaca/listar")
    public List<Vaca> listarVacas() {
        return vacaUseCase.listarVacas();
    }

    @GetMapping("/vaca/{id}")
    public ResponseEntity<?> buscarVacaPorId(@PathVariable Long id) {

        Vaca vaca = null;
        Map<String, Object> response = new HashMap<>();
            vaca = vacaUseCase.findById(id);

        if (vaca == null) {
            response.put("mensaje", "La vaca ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Vaca>(vaca, HttpStatus.OK);
    }

    @PostMapping("/vaca/agregar")
    public ResponseEntity<?> crearVaca(@RequestBody Vaca vaca) {

        Vaca vacaNueva = null;
        Map<String, Object> response = new HashMap<>();

      vacaNueva = vacaUseCase.guardarVaca(vaca);

        response.put("mensaje", "la Vaca ha sido creado con exito!");
        response.put("Vaca", vacaNueva);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/vaca/actualizar/{id}")
    public ResponseEntity<?> actualizarVaca(@RequestBody Vaca vaca, @PathVariable Long id) {

        Vaca vacaActual = vacaUseCase.findById(id);

        Vaca vacaActualizada = null;

        Map<String, Object> response = new HashMap<>();

        if (vacaActual == null) {
            response.put("mensaje", "Error: no se pudo editar, la vaca ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

            vacaActual.setNombre(vaca.getNombre());
            vacaActual.setRaza(vaca.getRaza());


            vacaActualizada = vacaUseCase.guardarVaca(vacaActual);


        response.put("mensaje", "La vaca ha sido actualizado con exito!");
        response.put("vaca", vacaActualizada);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/vaca/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
            vacaUseCase.eliminarVaca(id);
        response.put("mensaje", "La Vaca eliminado con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
