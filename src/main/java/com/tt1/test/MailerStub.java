package com.tt1.test;

public class MailerStub implements Interfaces.IMailerStub{
	@Override
    public boolean enviarCorreo(String destino, String mensaje) {
        System.out.println("ENVIANDO CORREO A: " + destino);
        System.out.println("MENSAJE: " + mensaje);
        return true;
    }
}
