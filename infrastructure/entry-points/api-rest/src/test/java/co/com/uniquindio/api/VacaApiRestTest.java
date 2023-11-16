package co.com.uniquindio.api;


import co.com.uniquindio.api.datatest.DataTest;
import co.com.uniquindio.model.vaca.Vaca;
import co.com.uniquindio.usecase.vaca.VacaUseCase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test ;

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

@WebMvcTest(VacaApiRest.class)
@ContextConfiguration(classes = {VacaApiRest.class, VacaUseCase.class})
class VacaApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacaUseCase useCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void listTest() throws Exception {
        List<Vaca> vacas = Arrays.asList(DataTest.buildVaca());
        when(useCase.listarVacas()).thenReturn(vacas);
        mockMvc.perform(get("/api/v1/agroeasy/vaca/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Lola"))
                .andExpect(status().isOk());
        verify(useCase).listarVacas();

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildVaca());
        mockMvc.perform(get("/api/v1/agroeasy/vaca/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdWhenNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/agroeasy/vaca/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void createTest() throws Exception {
        when(useCase.guardarVaca(DataTest.buildVaca())).thenReturn(DataTest.buildVaca());
        mockMvc.perform(post("/api/v1/agroeasy/vaca/agregar").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildVaca())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).guardarVaca(DataTest.buildVaca());

    }


    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildVaca());
        when(useCase.guardarVaca(DataTest.buildVaca())).thenReturn(DataTest.buildVaca());
        mockMvc.perform(put("/api/v1/agroeasy/vaca/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildVaca())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.vaca.nombre").value("Lola"));
        verify(useCase).guardarVaca(DataTest.buildVaca());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTestWhenNotFoud() throws Exception {
        when(useCase.guardarVaca(DataTest.buildVaca())).thenReturn(DataTest.buildVaca());
        mockMvc.perform(put("/api/v1/agroeasy/vaca/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildVaca())))
                .andExpect(status().isNotFound());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/agroeasy/vaca/eliminar/{1}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).eliminarVaca(1L);

    }
}