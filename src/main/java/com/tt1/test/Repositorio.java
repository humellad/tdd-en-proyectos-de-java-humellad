package com.tt1.test;

import java.util.List;

public class Repositorio implements interfaces.IRepositorio{
	private DBStub db;
	public Repositorio(DBStub db) {
		this.db=db;
	}
    public ToDo buscarPorNombre(String nombre) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void marcarComoCompletada(String nombre) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void guardarNuevoToDo(ToDo todo) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public void guardarEmail(String email) { throw new UnsupportedOperationException("Clase aún no implementada."); }
    public List<ToDo> obtenerPendientes() { throw new UnsupportedOperationException("Clase aún no implementada."); }
	public List<String> obtenerTodosLosEmails() { throw new UnsupportedOperationException("Clase aún no implementada."); }
	public boolean contieneEmail(String email) { throw new UnsupportedOperationException("Clase aún no implementada."); }
}
