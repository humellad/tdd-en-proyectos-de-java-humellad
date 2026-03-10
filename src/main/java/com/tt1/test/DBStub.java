package com.tt1.test;

import java.util.*;

public class DBStub{
	private List<ToDo> tareas = new ArrayList<>();
    private List<String> agendaEmails = new ArrayList<>();

    public void guardarTarea(ToDo tarea) { 
    	tareas.add(tarea); 
    }
    
    public List<ToDo> obtenerTodas() { 
    	return new ArrayList<>(tareas); 
    }
    
    public void añadirEmail(String email) { 
    	agendaEmails.add(email); 
    }
    
    public List<String> obtenerEmails() { 
    	return new ArrayList<>(agendaEmails); 
    }
}
