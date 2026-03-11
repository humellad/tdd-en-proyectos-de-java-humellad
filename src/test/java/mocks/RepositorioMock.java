package mocks;

import java.util.*;
import com.tt1.test.*;
import Interfaces.IRepositorio;

public class RepositorioMock implements IRepositorio {
	 public boolean guardarLlamado = false;
	    private List<ToDo> tareas = new ArrayList<>();
	    private List<String> emailsSimulados = new ArrayList<>();

	    @Override
	    public void guardarNuevoToDo(ToDo todo) {
	        this.guardarLlamado = true;
	        tareas.add(todo);
	    }

	    
	    public boolean contieneEmail(String email) {
	        return emailsSimulados.contains(email);
	    }

		@Override
		public ToDo buscarPorNombre(String nombre) {
	    	for(ToDo sol : this.tareas) {
	    		if(sol.getNombre().equals(nombre)) {
	    			return sol;
	    		}
	    	}
	    	return null;
		}


		@Override
		public void marcarComoCompletada(String nombre) {
			for(ToDo sol : this.tareas) {
	    		if(sol.getNombre().equals(nombre)) {
	    			sol.setCompletado(true);
	    		}
	    	}
		}


		@Override
		public List<ToDo> obtenerPendientes() {
	    	List<ToDo> res = new ArrayList<ToDo>();
	    	for(ToDo aux : this.tareas) {
	    		if(!aux.completado()) {
	    			res.add(aux);
	    		}
	    	}
	        return res;
		}


		@Override
		public void guardarEmail(String email) {
			emailsSimulados.add(email);
		}


		@Override
		public List<String> obtenerTodosLosEmails() {
			List<String> sol = new ArrayList<String>(this.emailsSimulados);
			return sol;
		}
}