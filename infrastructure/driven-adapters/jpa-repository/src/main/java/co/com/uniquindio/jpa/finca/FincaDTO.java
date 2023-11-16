package co.com.uniquindio.jpa.finca;


import co.com.uniquindio.jpa.produccion.ProduccionDTO;
import co.com.uniquindio.jpa.trabajador.TrabajadorDTO;
import co.com.uniquindio.jpa.vaca.VacaDTO;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "finca")
public class FincaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String direccion;

    @Column(nullable = false)
    private float hectareas;

    @Column(nullable = false)
    private float leche;

    @JsonIgnoreProperties(value = {"finca", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finca", cascade = CascadeType.ALL)
    private List<TrabajadorDTO> trabajadores;

    @JsonIgnoreProperties(value = {"finca", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finca", cascade = CascadeType.ALL)
    private List<ProduccionDTO> producciones;

    @JsonIgnoreProperties(value = {"finca", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finca", cascade = CascadeType.ALL)
    private List<VacaDTO> vacas;

    @JsonIgnoreProperties(value = {"finca", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finca", cascade = CascadeType.ALL)
    private List<VentaDTO> ventas;

    @JsonIgnoreProperties(value = {"finca", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finca", cascade = CascadeType.ALL)
    private List<VacunacionDTO> vacunaciones;


}
