package co.com.uniquindio.api;

import static org.junit.jupiter.api.Assertions.*;

import co.com.uniquindio.api.datatest.DataTest;
import co.com.uniquindio.model.finca.Finca;
import co.com.uniquindio.usecase.finca.FincaUseCase;

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

@WebMvcTest(FincaApiRest.class)
@ContextConfiguration(classes = {FincaApiRest.class, FincaUseCase.class})
class FincaApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FincaUseCase useCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void listTest() throws Exception {
        List<Finca> Fincas = Arrays.asList(DataTest.buildFinca());
        when(useCase.listarFincas()).thenReturn(Fincas);
        mockMvc.perform(get("/api/v1/agroeasy/finca/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).listarFincas();

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildFinca());
        mockMvc.perform(get("/api/v1/agroeasy/finca/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdWhenNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/agroeasy/finca/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void createTest() throws Exception {
        when(useCase.guardarFinca(DataTest.buildFinca())).thenReturn(DataTest.buildFinca());
        mockMvc.perform(post("/api/v1/agroeasy/finca/agregar").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildFinca())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).guardarFinca(DataTest.buildFinca());

    }


    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildFinca());
        when(useCase.guardarFinca(DataTest.buildFinca())).thenReturn(DataTest.buildFinca());
        mockMvc.perform(put("/api/v1/agroeasy/finca/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildFinca())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).guardarFinca(DataTest.buildFinca());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTestWhenNotFoud() throws Exception {
        when(useCase.guardarFinca(DataTest.buildFinca())).thenReturn(DataTest.buildFinca());
        mockMvc.perform(put("/api/v1/agroeasy/finca/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildFinca())))
                .andExpect(status().isNotFound());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/agroeasy/finca/eliminar/{1}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).eliminarFinca(1L);

    }
}