package com.tt1.test;

import java.util.*;

import interfaces.*;

public class Servicio{
	private IRepositorio repo;
    private IMailerStub mailer;

    public Servicio(IRepositorio repo, IMailerStub mailer) {
    	this.repo=repo;
    	this.mailer=mailer;
    }
    public void crearTarea(String nombre, Date fecha) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void agregarEmailAgenda(String email) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void completarTarea(String nombre) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public List<ToDo> consultarPendientes() { throw new UnsupportedOperationException("Clase aún no implementada."); }
    private void verificarAlertasYEnviarCorreos() { throw new UnsupportedOperationException("Clase aún no implementada."); }
}
