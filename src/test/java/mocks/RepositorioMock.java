package mocks;

import java.util.*;
import com.tt1.test.*;
import Interfaces.IRepositorio;

public class RepositorioMock implements IRepositorio {
    public boolean guardarLlamado = false;
    private List<String> emailsSimulados = new ArrayList<>();

    @Override
    public void guardarNuevoToDo(ToDo todo) {
        this.guardarLlamado = true;
    }

    
    public boolean contieneEmail(String email) {
        return emailsSimulados.contains(email);
    }
    
    public void annadirEmailManual(String email) {
        emailsSimulados.add(email);
    }


	@Override
	public ToDo buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void marcarComoCompletada(String nombre) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ToDo> obtenerPendientes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void guardarEmail(String email) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<String> obtenerTodosLosEmails() {
		// TODO Auto-generated method stub
		return null;
	}
}