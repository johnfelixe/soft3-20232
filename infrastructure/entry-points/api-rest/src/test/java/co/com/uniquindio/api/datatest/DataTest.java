package co.com.uniquindio.api.datatest;

import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.model.produccion.Produccion;
import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.model.vaca.Vaca;
import co.com.uniquindio.model.vacuna.Vacuna;
import co.com.uniquindio.model.vacunacion.Vacunacion;
import co.com.uniquindio.model.venta.Venta;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataTest {
    public static Vaca buildVaca() {
        return Vaca.builder()
                .id(1L)
                .nombre("Lola")
                .raza("negra")
                .finca(buildFinca())
                .build();
    }

    public static Finca buildFinca() {
        return Finca.builder()
                .id(1L)
                .leche(100)
                .nombre("Lolita")
                .hectareas(100)
                .direccion("Avenida 1")
                .build();
    }
    public static Produccion buildProduccion() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return Produccion.builder()
                .id(1L)
                .vaca(buildVaca())
                .trabajador(buildTrabajador())
                .finca(buildFinca())
                .cantidad(100)
                .fecha(date)
                .build();
    }
    public static Trabajador buildTrabajador() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return Trabajador.builder()
                .apellido("Oscar")
                .cargo("Administrador")
                .fecha(date)
                .correo("prueba@gmail.com")
                .id(1L)
                .cedula("1234")
                .build();
    }
    public static Vacuna buildVacuna() {
        return Vacuna.builder()
                .id(1L)
                .nombre("Covid")
                .tipo("C")
                .build();
    }

    public static Vacunacion buildVacunacion() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return Vacunacion.builder()
                .fecha(date)
                .id(1L)
                .Vacuna(buildVacuna())
                .trabajador(buildTrabajador())
                .Vaca(buildVaca())
                .build();
    }

    public static Venta buildVenta() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return Venta.builder()
                .cantidad(0)
                .comprador("Oscar")
                .fecha(date)
                .id(1L)
                .finca(buildFinca())
                .trabajador(buildTrabajador())
                .precio(0)
                .build();
    }

}
