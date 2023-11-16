package co.com.uniquindio.jpa.trabajador;


import co.com.uniquindio.jpa.finca.FincaDTO;
import co.com.uniquindio.jpa.produccion.ProduccionDTO;
import co.com.uniquindio.jpa.usuario.UsuarioDTO;
import co.com.uniquindio.jpa.vacunacion.VacunacionDTO;
import co.com.uniquindio.jpa.venta.VentaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "trabajador")
public class TrabajadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    private String correo;

    private String cargo;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "finca_id")
    private FincaDTO finca;

    @JsonIgnoreProperties(value = {"trabajador", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<ProduccionDTO> producciones;

    @JsonIgnoreProperties(value = {"trabajador", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<VentaDTO> venta;

    @JsonIgnoreProperties(value = {"trabajador", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<VacunacionDTO> vacunaciones;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "usuario_id")
    private UsuarioDTO usuario;


}
