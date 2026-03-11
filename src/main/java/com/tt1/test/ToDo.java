package com.tt1.test;

import java.util.Date;

/**
 * Representa una tarea pendiente en el sistema.
 */
public class ToDo{
	private String nombre;
    private String descripcion;
    private Date fechaLimite;
    private boolean completado = false;
    
    /**
     * Constructor con parametros de una tarea
     * @param nombre Nombre de la tarea
     * @param descripcion Descripcion de la tarea
     * @param fechaLimite Fecha limite para realizar la tarea
     */
    public ToDo(String nombre, String descripcion, Date fechaLimite) {
    	this.nombre=nombre;
    	this.descripcion=descripcion;
    	this.fechaLimite=fechaLimite;
    }
    
    /**
     * Obtiene el nombre de la tarea
     * @return El nombre de la tarea
     */
    public String getNombre() { 
    	return nombre; 
    }
    
    /**
     * Establece el nombre de la tarea
     * @param nombre El nombre que se asignará a la tarea
     */
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }
    
    /** 
     * Obtiene la descripcion de una tarea
     * @return La descripción de la tarea
     * */
    public String getDescripcion() { 
    	return descripcion; 
    }
    
    /** 
     * Establece la descripcion de la tarea
     * @param descripcion Descripcion de la tarea
     * */
    public void setDescripcion(String descripcion) { 
    	this.descripcion = descripcion; 
    }
    
    /** 
     * Obtiene la fecha limite de una tarea
     * @return La fecha máxima para completar la tarea
     * */
    public Date getFechaLimite() { 
    	return fechaLimite; 
    }
    
    /** 
     * Establece la fecha limite de la tarea
     * @param fechaLimite Fecha en la que la tarea pasará a estar vencida
     * */
    public void setFechaLimite(Date fechaLimite) { 
    	this.fechaLimite = fechaLimite; 
    }
    /**
     * Indica si la tarea ya ha sido finalizada
     * @return true si esta completada, false en caso contrario
     */
    public boolean completado() { 
    	return completado; 
    }
    
    /** 
     * Establece si la tarea se ha completado o no
     * @param completado Estado de finalizacion de la tarea. 
     * */
    public void setCompletado(boolean completado) { 
    	this.completado = completado; 
    }
}
