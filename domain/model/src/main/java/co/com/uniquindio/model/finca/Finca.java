package co.com.uniquindio.model.finca;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Finca {
    private Long id;
    private String nombre;
    private String direccion;
    private float hectareas;
    private float leche;

}
