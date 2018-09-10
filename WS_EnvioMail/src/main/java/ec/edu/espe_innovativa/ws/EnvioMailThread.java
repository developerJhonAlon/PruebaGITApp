/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_innovativa.ws;

import static java.io.File.separatorChar;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;

/**
 *
 * @author PC1
 */
public class EnvioMailThread extends Thread {

    public EnvioMailThread(String remitente, String destinatarios, String asunto, String mensaje, Boolean esHtml, byte[] archivoAdjunto, String nombreArchivoAdjunto, byte[] archivoAdjunto2, String nombreArchivoAdjunto2, String pathTemp) {
        this.remitente = remitente;
        this.destinatarios = destinatarios;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.esHtml = esHtml;
        this.archivoAdjunto = archivoAdjunto;
        this.nombreArchivoAdjunto = nombreArchivoAdjunto;
        this.archivoAdjunto2 = archivoAdjunto2;
        this.nombreArchivoAdjunto2 = nombreArchivoAdjunto2;
        this.pathTemp=pathTemp;
    }

    @Override
    public void run() {
        /*
        
        //CON SERVIDOR MAIL DE ESPE
        try {
         BodyPart messageBodyPart = new MimeBodyPart();
         if (esHtml) {
         messageBodyPart.setContent(mensaje, "text/html; charset=UTF-8");
         } else {
         messageBodyPart.setText(mensaje);
         }

         MimeMultipart multiParte = new MimeMultipart();
         multiParte.addBodyPart(messageBodyPart);

         InitialContext ic = new InitialContext();
         Session session = (Session) ic.lookup("mail/MySession");
         Message msg = new MimeMessage(session);
         msg.setSubject(asunto);
         msg.setSentDate(new Date());
         msg.setFrom(new InternetAddress(remitente));
         msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatarios));
         msg.setContent(multiParte);
         Transport.send(msg);

         } catch (Exception e) {
         e.printStackTrace();
         }
         */
        //CON SERVIDOR GMAIL
        try {
            BodyPart messageBodyPart = new MimeBodyPart();
            if (esHtml) {
                messageBodyPart.setContent(mensaje, "text/html; charset=UTF-8");
            } else {
                messageBodyPart.setText(mensaje);
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(messageBodyPart);
            if (archivoAdjunto != null && nombreArchivoAdjunto != null && !nombreArchivoAdjunto.trim().isEmpty()) {
                BodyPart adjunto = new MimeBodyPart();
                if (!Files.isDirectory(Paths.get(pathTemp))) {
                    Files.createDirectories(Paths.get(pathTemp));
                }
                pathTemp = pathTemp + separatorChar + new Date().getTime();
                Files.write(Paths.get(pathTemp), archivoAdjunto, StandardOpenOption.CREATE);
                adjunto.setDataHandler(new DataHandler(new FileDataSource(pathTemp)));
                adjunto.setFileName(nombreArchivoAdjunto);
                multiParte.addBodyPart(adjunto);
            }
            if (archivoAdjunto2 != null && nombreArchivoAdjunto2 != null && !nombreArchivoAdjunto2.trim().isEmpty()) {
                BodyPart adjunto = new MimeBodyPart();
                if (!Files.isDirectory(Paths.get(pathTemp))) {
                    Files.createDirectories(Paths.get(pathTemp));
                }
                pathTemp = pathTemp + separatorChar + new Date().getTime();
                Files.write(Paths.get(pathTemp), archivoAdjunto2, StandardOpenOption.CREATE);
                adjunto.setDataHandler(new DataHandler(new FileDataSource(pathTemp)));
                adjunto.setFileName(nombreArchivoAdjunto2);
                multiParte.addBodyPart(adjunto);
            }
            InitialContext ic = new InitialContext();
            Session session = (Session) ic.lookup("mail/MySession2");
            Properties props = session.getProperties();
            //props.put("mail.from", remitente);
            /*props.put("mail.smtp.user", "espevinculacion01@gmail.com");
            props.put("mail.smtp.password", "espevinculacion2016");*/
            
            Message msg = new MimeMessage(session);
            msg.setSubject(asunto);
            msg.setSentDate(new Date());
            //msg.setFrom(new InternetAddress(remitente));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatarios));
            msg.setContent(multiParte);
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String destinatarios;
    private String remitente;
    private String asunto;
    private String mensaje;
    private Boolean esHtml;
    private byte[] archivoAdjunto;
    private String nombreArchivoAdjunto;
    private byte[] archivoAdjunto2;
    private String nombreArchivoAdjunto2;
    private String pathTemp;

    public String getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean isEsHtml() {
        return esHtml;
    }

    public void setEsHtml(Boolean esHtml) {
        this.esHtml = esHtml;
    }

    public byte[] getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(byte[] archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public String getNombreArchivoAdjunto() {
        return nombreArchivoAdjunto;
    }

    public void setNombreArchivoAdjunto(String nombreArchivoAdjunto) {
        this.nombreArchivoAdjunto = nombreArchivoAdjunto;
    }

    public byte[] getArchivoAdjunto2() {
        return archivoAdjunto2;
    }

    public void setArchivoAdjunto2(byte[] archivoAdjunto2) {
        this.archivoAdjunto2 = archivoAdjunto2;
    }

    public String getNombreArchivoAdjunto2() {
        return nombreArchivoAdjunto2;
    }

    public void setNombreArchivoAdjunto2(String nombreArchivoAdjunto2) {
        this.nombreArchivoAdjunto2 = nombreArchivoAdjunto2;
    }

}
