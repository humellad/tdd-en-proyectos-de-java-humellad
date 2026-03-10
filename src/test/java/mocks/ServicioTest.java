package mocks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import com.tt1.test.*;

import interfaces.*;

public class ServicioTest {
	private Servicio servicio;
    private MailerStubMock mailerMock;
    private IRepositorio repoMock;

    @BeforeEach
    void setUp() {
        // ARRANGE Global
        mailerMock = new MailerStubMock();
        repoMock = new RepositorioMock(); 
        servicio = new Servicio(repoMock, mailerMock);
    }

    @Test
    void testAgregarEmailValido() {
        String email = "test@unirioja.es";
        servicio.agregarEmailAgenda(email);
        assertTrue(repoMock.contieneEmail(email));
    }
}
