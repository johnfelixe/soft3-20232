package co.com.uniquindio.api;

import static org.junit.jupiter.api.Assertions.*;

import co.com.uniquindio.api.datatest.DataTest;
import co.com.uniquindio.model.vacuna.Vacuna;
import co.com.uniquindio.usecase.vacuna.VacunaUseCase;
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

@WebMvcTest(VacunaApiRest.class)
@ContextConfiguration(classes = {VacunaApiRest.class, VacunaUseCase.class})
class VacunaApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacunaUseCase useCase;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void listTest() throws Exception {
        List<Vacuna> Vacunas = Arrays.asList(DataTest.buildVacuna());
        when(useCase.listarVacunas()).thenReturn(Vacunas);
        mockMvc.perform(get("/api/v1/agroeasy/vacuna/listar").contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).listarVacunas();

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildVacuna());
        mockMvc.perform(get("/api/v1/agroeasy/vacuna/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void getByIdWhenNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/agroeasy/vacuna/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).findById(1L);
    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void createTest() throws Exception {
        when(useCase.guardarVacuna(DataTest.buildVacuna())).thenReturn(DataTest.buildVacuna());
        mockMvc.perform(post("/api/v1/agroeasy/vacuna/agregar").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildVacuna())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).guardarVacuna(DataTest.buildVacuna());

    }


    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTest() throws Exception {
        when(useCase.findById(1L)).thenReturn(DataTest.buildVacuna());
        when(useCase.guardarVacuna(DataTest.buildVacuna())).thenReturn(DataTest.buildVacuna());
        mockMvc.perform(put("/api/v1/agroeasy/vacuna/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildVacuna())))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(useCase).guardarVacuna(DataTest.buildVacuna());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void updateTestWhenNotFoud() throws Exception {
        when(useCase.guardarVacuna(DataTest.buildVacuna())).thenReturn(DataTest.buildVacuna());
        mockMvc.perform(put("/api/v1/agroeasy/vacuna/actualizar/1").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(DataTest.buildVacuna())))
                .andExpect(status().isNotFound());

    }

    @Test
    @WithMockUser(username = "admin", password = "12345", roles = "ADMIN")
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/v1/agroeasy/vacuna/eliminar/{1}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(useCase).eliminarVacuna(1L);

    }
}