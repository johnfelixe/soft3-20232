package co.com.uniquindio.model.vacuna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Vacuna {
    private Long id;
    private String nombre;
    private String tipo;

}
