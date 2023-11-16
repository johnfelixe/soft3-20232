package co.com.uniquindio.model.vacunacion;

import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.model.vaca.Vaca;
import co.com.uniquindio.model.vacuna.Vacuna;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Vacunacion {
    private Long id;
    private Date fecha;
    private Vacuna Vacuna;
    private Vaca Vaca;
    private Trabajador trabajador;

}
