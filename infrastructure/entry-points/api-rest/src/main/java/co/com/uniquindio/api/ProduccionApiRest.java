package co.com.uniquindio.api;

import co.com.uniquindio.model.produccion.Produccion;
import co.com.uniquindio.usecase.produccion.ProduccionUseCase;
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
public class ProduccionApiRest {

    @Autowired
    private final ProduccionUseCase useCase;


    @GetMapping(path = "/produccion/listar")
    public List<Produccion> listarProducciones() {
        return useCase.listarProducciones();
    }

    @GetMapping("/produccion/{id}")
    public ResponseEntity<?> buscarProduccionPorId(@PathVariable Long id) {

        Produccion produccion = null;
        Map<String, Object> response = new HashMap<>();

        produccion = useCase.findById(id);


        if (produccion == null) {
            response.put("mensaje", "Produccion ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Produccion>(produccion, HttpStatus.OK);
    }

    @PostMapping("/produccion/agregar")
    public ResponseEntity<?> crearProduccion(@RequestBody Produccion produccion) {

        Produccion nuevo = null;
        Map<String, Object> response = new HashMap<>();

        nuevo = useCase.guardarProduccion(produccion);
/*
        if (nuevo == null) {
            response.put("mensaje", "Error: no se pudo agregar la produccion de una vaca que ha sido vacunada en menos de 15 dias");

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

 */


        response.put("mensaje", "Produccion ha sido creada con exito!");
        response.put("Produccion", nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/produccion/actualizar/{id}")
    public ResponseEntity<?> actualizarProduccion(@RequestBody Produccion produccion, @PathVariable Long id) {

        Produccion actual = useCase.findById(id);
        System.out.println("1------------" + actual);
        Produccion actualizado = null;

        Map<String, Object> response = new HashMap<>();


        if (actual == null) {
            response.put("mensaje", "Error: no se pudo editar, Produccion ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        actual.setFecha(produccion.getFecha());
        actual.setCantidad(produccion.getCantidad());
        actual.setVaca(produccion.getVaca());
        actual.setTrabajador(produccion.getTrabajador());
        actual.setFinca(produccion.getFinca());

        actualizado = useCase.actualizarProduccion(actual);
        /*
        if (actualizado == null) {
            response.put("mensaje", "No se pudo editar, La Produccion ID: "
                    .concat(id.toString().concat(" por que no se puede registrar la leche de una vaca que ha sido vacunada en menos de 15 dias!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

         */


        response.put("mensaje", "Produccion ha sido actualizado con exito!");
        response.put("Produccion", actualizado);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/produccion/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        useCase.eliminarProduccion(id);

        response.put("mensaje", "Produccion eliminada con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}

