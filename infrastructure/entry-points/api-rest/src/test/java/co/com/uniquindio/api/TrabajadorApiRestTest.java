package co.com.uniquindio.api;

import static org.junit.jupiter.api.Assertions.*;

import co.com.uniquindio.api.datatest.DataTest;
import co.com.uniquindio.model.trabajador.Trabajador;
import co.com.uniquindio.usecase.trabajador.TrabajadorUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrabajadorApiRest.class)
@ContextConfiguration(classes = {TrabajadorApiRest.class, TrabajadorUseCase.class})
class TrabajadorApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrabajadorUseCase useCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void listTrabajadoresTest() throws Exception {
        List<Trabajador> Trabajadores = Arrays.asList(DataTest.buildTrabajador());
        when(useCase.listarTrabajadores()).thenReturn(Trabajadores);
        mockMvc.perform(get("/api/v1/agroeasy/trabajador/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).listarTrabajadores();

    }
    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void listVeterinarioTest() throws Exception {
        List<Trabajador> Trabajadores = Arrays.asList(DataTest.buildTrabajador());
        when(useCase.listarTrabajadores()).thenReturn(Trabajadores);
        mockMvc.perform(get("/api/v1/agroeasy/veterinario/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).listarVeterinarios();

    }
    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void listTEmpleadosTest() throws Exception {
        List<Trabajador> Trabajadores = Arrays.asList(DataTest.buildTrabajador());
        when(useCase.listarTrabajadores()).thenReturn(Trabajadores);
        mockMvc.perform(get("/api/v1/agroeasy/empleados/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).listarEmpleados();

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildTrabajador());
        mockMvc.perform(get("/api/v1/agroeasy/trabajador/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdWhenNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/agroeasy/trabajador/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void createTest() throws Exception {
        when(useCase.guardarTrabajador(DataTest.buildTrabajador())).thenReturn(DataTest.buildTrabajador());
        mockMvc.perform(post("/api/v1/agroeasy/trabajador/agregar").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildTrabajador())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }


    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTest() throws Exception {

        when(useCase.findById(1L)).thenReturn(DataTest.buildTrabajador());
        when(useCase.guardarTrabajador(DataTest.buildTrabajador())).thenReturn(DataTest.buildTrabajador());
        mockMvc.perform(put("/api/v1/agroeasy/trabajador/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildTrabajador())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTestWhenNotFoud() throws Exception {
        when(useCase.guardarTrabajador(DataTest.buildTrabajador())).thenReturn(DataTest.buildTrabajador());
        mockMvc.perform(put("/api/v1/agroeasy/trabajador/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildTrabajador())))
                .andExpect(status().isNotFound());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/agroeasy/trabajador/eliminar/{1}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).eliminarTrabajador(1L);

    }
}