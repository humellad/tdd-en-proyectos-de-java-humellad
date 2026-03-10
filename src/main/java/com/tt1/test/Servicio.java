package com.tt1.test;

import java.util.*;

import Interfaces.*;

public class Servicio{
	private IRepositorio repo;
    private IMailerStub mailer;

    public Servicio(IRepositorio repo, IMailerStub mailer) {
        this.repo = repo;
        this.mailer = mailer;
    }

    public void crearTarea(String nombre, String descripcion, Date fecha) {
        if (nombre == null || nombre.isEmpty()) {
        	throw new IllegalArgumentException();
        }
        ToDo nuevo = new ToDo(nombre, descripcion, fecha);
        repo.guardarNuevoToDo(nuevo);
        verificarAlertasYEnviarCorreos();
    }

    public List<ToDo> consultarPendientes() {
        verificarAlertasYEnviarCorreos();
        return repo.obtenerPendientes();
    }

    public void agregarEmailAgenda(String email) {
        if (!email.contains("@")) {
        	throw new IllegalArgumentException("Email inválido");
        }
        repo.guardarEmail(email);
    }

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
