package com.tt1.test;

import java.util.*;

import Interfaces.*;

/**
 * Servicio de logica de negocio para la gestión de tareas
 * Se encarga de validar entradas, gestionar tareas y disparar alertas automáticas
 */
public class Servicio{
	private IRepositorio repo;
    private IMailerStub mailer;

    /**
     * Inicializa el servicio con sus dependencias
     * @param repo Repositorio de datos
     * @param mailer Motor de envío de correos
     */
    public Servicio(IRepositorio repo, IMailerStub mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }

    /**
     * Crea una tarea y ejecuta una verificación de alertas
     * @param nombre Nombre de la tarea
     * @param descripcion Descripcion de la tarea
     * @param fecha Fecha limite de la tarea
     */
    public void crearTarea(String nombre, String descripcion, Date fecha) {
        if (nombre == null || nombre.isEmpty()) {
        	throw new IllegalArgumentException();
        }
        ToDo nuevo = new ToDo(nombre, descripcion, fecha);
        repo.guardarNuevoToDo(nuevo);
        verificarAlertasYEnviarCorreos();
    }

    /**
     * Devuelve las tareas sin completar tras verificar alertas
     * @return Lista de {@link ToDo} pendientes
     */
    public List<ToDo> consultarPendientes() {
        verificarAlertasYEnviarCorreos();
        return repo.obtenerPendientes();
    }

    /**
     * Agrega un email a la agenda
     * @param email Direccion de correo a registrar
     */
    public void agregarEmailAgenda(String email) {
        if (!email.contains("@")) {
        	throw new IllegalArgumentException("Email inválido");
        }
        repo.guardarEmail(email);
    }

    /**
     * Método que escanea tareas vencidas y envía correos a toda la agenda
     */
    private void verificarAlertasYEnviarCorreos() {
        List<ToDo> pendientes = repo.obtenerPendientes();
        List<String> contactos = repo.obtenerTodosLosEmails();
        for (ToDo tarea : pendientes) {
            if (tarea.getFechaLimite().before(Calendar.getInstance().getTime())) {
                for (String email : contactos) {
                    mailer.enviarCorreo(email, "ALERTA: Tarea vencida: " + tarea.getNombre());
                }
            }
        }
    }
}
