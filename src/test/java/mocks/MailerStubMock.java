package mocks;

import Interfaces.IMailerStub;

public class MailerStubMock implements IMailerStub {
	public boolean llamado = false;
    public String ultimoMensaje;

    @Override
    public boolean enviarCorreo(String destino, String mensaje) {
        this.llamado = true;
        this.ultimoMensaje = mensaje;
        return true;
    }
}
