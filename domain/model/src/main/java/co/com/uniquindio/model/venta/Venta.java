package co.com.uniquindio.model.venta;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.trabajador.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Venta {
    private Long id;
    private float cantidad;
    private String comprador;
    private Date fecha;
    private float precio;
    private Finca finca;
    private Trabajador trabajador;

}
