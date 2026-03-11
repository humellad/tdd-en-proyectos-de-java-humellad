package com.tt1.test;

/**
 * Simulador de envio de correos electronicos por consola
 */
public class MailerStub implements Interfaces.IMailerStub{
	/**
     * Muestra por la salida estándar el destino y el mensaje del correo
     * @param destino Email del destinatario
     * @param mensaje Contenido del mensaje
     * @return Siempre devuelve true al ser una simulacion
     */
	@Override
    public boolean enviarCorreo(String destino, String mensaje) {
        System.out.println("ENVIANDO CORREO A: " + destino);
        System.out.println("MENSAJE: " + mensaje);
        return true;
    }
}
