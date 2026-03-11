package com.tt1.test;

import java.util.*;

/**
 * Simulador de base de datos
 * Gestiona el almacenamiento de tareas y correos en memoria
 */
public class DBStub{
	private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    /**
     * Registra una nueva tarea en la coleccion
     * @param tarea Objeto ToDo a persistir
     */
    public void guardarTarea(ToDo tarea) { 
    	tareas.add(tarea); 
    }
    
    /**
     * Recupera el listado completo de tareas almacenadas
     * @return Una copia de la lista de tareas
     */
    public List<ToDo> obtenerTodas() { 
    	return new ArrayList<>(tareas); 
    }
    
    /**
     * Agrega una dirección de correo a la agenda
     * @param email Cadena con la dirección de correo
     */
    public void annadirEmail(String email) { 
    	agendaEmails.add(email); 
    }
    
    /**
     * Obtiene todos los contactos registrados en la agenda
     * @return Lista de correos electronicos
     */
    public List<String> obtenerEmails() { 
    	return new ArrayList<>(agendaEmails); 
    }
}
