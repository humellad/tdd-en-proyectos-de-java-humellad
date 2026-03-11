package com.tt1.test;

import java.util.*;

/**
 * Capa de acceso a datos que implementa {@link Interfaces.IRepositorio}
 * Traduce las necesidades de negocio en operaciones sobre el {@link DBStub}
 */
public class Repositorio implements Interfaces.IRepositorio{
	private DBStub db;

	/**
     * Crea un repositorio vinculado a una simulacion de base de datos.
     * @param db La base de datos simulada a utilizar.
     */
    public Repositorio(DBStub db) { 
    	this.db = db; 
    }

    /**
     * Almacena un objeto ToDo en el sistema.
     * @param todo La tarea que se desea persistir.
     */
    @Override
    public void guardarNuevoToDo(ToDo todo) { 
    	db.guardarTarea(todo); 
    }

    /**
     * Devuelve solo las tareas que no han sido finalizadas
     * @return Lista de tareas con estado completado en false
     */
    @Override
    public List<ToDo> obtenerPendientes() {
    	List<ToDo> total = db.obtenerTodas();
    	List<ToDo> res = new ArrayList<ToDo>();
    	for(ToDo aux : total) {
    		if(!aux.completado()) {
    			res.add(aux);
    		}
    	}
        return res;
    }

    /**
     * Registra un nuevo correo electrónico en la agenda
     * @param email Direccion de correo electrónico (debe ser valida)
     */
    @Override
    public void guardarEmail(String email) { 
    	db.annadirEmail(email); 
    }

    /**
     * Obtiene todos los correos electronicos almacenados en la agenda
     * @return Lista de cadenas con los emails de contacto
     */
    @Override
    public List<String> obtenerTodosLosEmails() { 
    	return db.obtenerEmails(); 
    }

    /**
     * Recupera una tarea especifica buscando por su nombre
     * @param n El nombre de la tarea a buscar
     * @return El objeto {@link ToDo} encontrado o null si no existe
     */
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
    
    /**
     * Cambia el estado de una tarea a completado
     * @param n El nombre de la tarea que se desea finalizar
     */
    @Override 
    public void marcarComoCompletada(String n) {
    	List<ToDo> total = db.obtenerTodas();
    	for(ToDo sol : total) {
    		if(sol.getNombre().equals(n)) {
    			sol.setCompletado(true);
    		}
    	}
    }

    /**
     * Indica si un correo pertenece a la agenda o no
     * @param email Dirección de correo electronico
     * @return true si pertenece a la agenda, false en caso contrario
     */
	@Override
	public boolean contieneEmail(String email) {
		if(db.obtenerEmails().contains(email)) {
			return true;
		}
		return false;
	}
}
