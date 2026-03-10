package interfaces;

import java.util.List;

import com.tt1.test.ToDo;

public interface IRepositorio {
	void guardarNuevoToDo(ToDo todo);
    ToDo buscarPorNombre(String nombre);
    void marcarComoCompletada(String nombre);
    List<ToDo> obtenerPendientes();
    boolean contieneEmail(String email);
    void guardarEmail(String email);
    List<String> obtenerTodosLosEmails();
}
