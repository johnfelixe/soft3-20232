package co.com.uniquindio.api;

import co.com.uniquindio.model.vacuna.Vacuna;
import co.com.uniquindio.model.venta.Venta;
import co.com.uniquindio.usecase.venta.VentaUseCase;
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
public class VentaApiRest {

    @Autowired
    private final VentaUseCase useCase;


    @GetMapping(path = "/venta/listar")
    public List<Venta> listarVentaes() {
        return useCase.listarVenta();
    }

    @GetMapping("/venta/{id}")
    public ResponseEntity<?> buscarVentaPorId(@PathVariable Long id) {

        Venta entidad = null;
        Map<String, Object> response = new HashMap<>();
        entidad = useCase.findById(id);

        if (entidad == null) {
            response.put("mensaje", "Venta ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Venta>(entidad, HttpStatus.OK);
    }

    @PostMapping("/venta/agregar")
    public ResponseEntity<?> crearVenta(@RequestBody Venta venta) {
        Venta nuevo = null;
        Map<String, Object> response = new HashMap<>();
        nuevo = useCase.guardarVenta(venta);
        /*
        if (nuevo == null) {
            response.put("mensaje", "No se pudo crear la venta por que excede la cantidad de leche");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }\

         */
        response.put("mensaje", "Venta ha sido creada con exito!");
        response.put("Venta", nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/venta/actualizar/{id}")
    public ResponseEntity<?> actualizarVenta(@RequestBody Venta venta, @PathVariable Long id) {
        Venta actual = useCase.findById(id);
        Venta actualizado = null;
        Map<String, Object> response = new HashMap<>();

        if (actual == null) {
            response.put("mensaje", "Error: no se pudo editar, Venta ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        actual.setFecha(venta.getFecha());
        actual.setComprador(venta.getComprador());
        actual.setCantidad(venta.getCantidad());
        actual.setTrabajador(venta.getTrabajador());

        actualizado = useCase.actualizarVenta(actual);
        /*
        if (actualizado == null) {
            response.put("mensaje", "Error: no se pudo editar, La Venta ID: "
                    .concat(id.toString()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

         */
        response.put("mensaje", "Venta ha sido actualizado con exito!");
        response.put("Venta", actualizado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/venta/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        useCase.eliminarVenta(id);
        response.put("mensaje", "Venta eliminada con exito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}

