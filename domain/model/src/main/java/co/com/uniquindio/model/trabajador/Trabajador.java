package co.com.uniquindio.model.trabajador;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Trabajador {
    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String cargo;
    private Date fecha;
    private Finca finca;
    private Usuario usuario;
}
