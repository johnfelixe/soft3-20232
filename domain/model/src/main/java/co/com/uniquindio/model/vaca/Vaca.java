package co.com.uniquindio.model.vaca;

import co.com.uniquindio.model.finca.Finca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Vaca {
    private Long id;
    private String nombre;
    private String raza;
    private Finca finca;
}
