package mocks;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.*;
import com.tt1.test.*;

public class ServicioTestIntegracion {
	private Servicio servicio;
    private DBStub db;
    private Repositorio repo;
    private MailerStub mailer;

    @BeforeEach
    void setUp() {
        db = new DBStub();
        repo = new Repositorio(db);
        mailer = new MailerStub();
        servicio = new Servicio(repo, mailer);
    }

    @Test
    void testIntegracionTareaVencidaEnviaCorreo() {
        String email = "alumno@unirioja.es";
        String nombreTarea = "Entregar Práctica TDD";
        Calendar cal = Calendar.getInstance();
        Date fechaPasada = cal.getTime();

        servicio.agregarEmailAgenda(email);
        servicio.crearTarea(nombreTarea, fechaPasada);
        List<ToDo> pendientes = servicio.consultarPendientes();
        assertNotNull(pendientes);
    }
}
