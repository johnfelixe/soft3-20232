package co.com.uniquindio.api;

import co.com.uniquindio.api.datatest.DataTest;
import co.com.uniquindio.model.produccion.Produccion;
import co.com.uniquindio.usecase.produccion.ProduccionUseCase;

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

@WebMvcTest(ProduccionApiRest.class)
@ContextConfiguration(classes = {ProduccionApiRest.class, ProduccionUseCase.class})
class ProduccionApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProduccionUseCase useCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void listTest() throws Exception {
        List<Produccion> Producciones = Arrays.asList(DataTest.buildProduccion());
        when(useCase.listarProducciones()).thenReturn(Producciones);
        mockMvc.perform(get("/api/v1/agroeasy/produccion/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).listarProducciones();

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildProduccion());
        mockMvc.perform(get("/api/v1/agroeasy/produccion/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdWhenNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/agroeasy/produccion/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void createTest() throws Exception {
        when(useCase.guardarProduccion(DataTest.buildProduccion())).thenReturn(DataTest.buildProduccion());

        mockMvc.perform(post("/api/v1/agroeasy/produccion/agregar").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildProduccion())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildProduccion());

        when(useCase.actualizarProduccion(DataTest.buildProduccion())).thenReturn(DataTest.buildProduccion());

        mockMvc.perform(put("/api/v1/agroeasy/produccion/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildProduccion())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTestWhenNotFoud() throws Exception {
        when(useCase.guardarProduccion(DataTest.buildProduccion())).thenReturn(DataTest.buildProduccion());
        mockMvc.perform(put("/api/v1/agroeasy/produccion/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildProduccion())))
                .andExpect(status().isNotFound());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/agroeasy/produccion/eliminar/{1}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).eliminarProduccion(1L);

    }
}