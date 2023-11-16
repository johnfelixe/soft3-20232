package co.com.uniquindio.usecase.vaca;


import co.com.uniquindio.model.vaca.Vaca;
import co.com.uniquindio.model.vaca.gateways.VacaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


class VacaUseCaseTest {

    @InjectMocks
    private VacaUseCase useCase;

    @Mock
    private VacaRepository repository;

    Vaca entity = mock(Vaca.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void guardarVaca() {
        when(repository.guardarVaca(entity)).thenReturn(entity);
        assertNotNull(useCase.guardarVaca(entity));
    }

    @Test
    void listarVacas() {
        when(repository.listarVaca()).thenReturn(List.of(entity));
        assertNotNull(useCase.listarVacas());
    }

    @Test
    void findById() {
        when(repository.obtenerVacaPorId(1L)).thenReturn(entity);
        assertNotNull(useCase.findById(1L));
    }

    @Test
    void eliminarVaca() {
        useCase.eliminarVaca(1L);
        verify(repository, times(1)).eliminarVaca(1L);
    }

}