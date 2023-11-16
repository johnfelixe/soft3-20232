package co.com.uniquindio.model.produccion;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.model.vaca.Vaca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Produccion {
    private Long id;
    private Date fecha;
    private float cantidad;
    private Finca finca;
    private Vaca vaca;
    private Trabajador trabajador;
}
