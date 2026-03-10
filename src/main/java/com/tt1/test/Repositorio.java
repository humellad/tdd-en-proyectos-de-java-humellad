package com.tt1.test;

import java.util.*;

public class Repositorio implements Interfaces.IRepositorio{
	private DBStub db;

    public Repositorio(DBStub db) { this.db = db; }

    @Override
    public void guardarNuevoToDo(ToDo todo) { db.guardarTarea(todo); }

    @Override
    public List<ToDo> obtenerPendientes() {
    	List<ToDo> total = db.obtenerTodas();
    	List<ToDo> res = new ArrayList<ToDo>();
    	for(ToDo aux : total) {
    		if(aux.completado()) {
    			res.add(aux);
    		}
    	}
        return res;
    }

    @Override
    public void guardarEmail(String email) { 
    	db.añadirEmail(email); 
    }

    @Override
    public List<String> obtenerTodosLosEmails() { 
    	return db.obtenerEmails(); 
    }

    @Override 
    public ToDo buscarPorNombre(String n) {
    	List<ToDo> total = db.obtenerTodas();
    	for(ToDo sol : total) {
    		if(sol.getNombre().equals(n)) {
    			return sol;
    		}
    	}
    	return null; 
    }
    
    @Override 
    public void marcarComoCompletada(String n) {
    	List<ToDo> total = db.obtenerTodas();
    	for(ToDo sol : total) {
    		if(sol.getNombre().equals(n)) {
    			sol.setCompletado(true);
    		}
    	}
    }

	@Override
	public boolean contieneEmail(String email) {
		if(db.obtenerEmails().contains(email)) {
			return true;
		}
		return false;
	}
}
