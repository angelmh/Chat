package com.jrzdeveloper.guesschat;

/**
 * Created by Angel on 30/10/2017.
 */

public class Chat {
    private String pregunta;
    private String respuesta;


    public Chat(String pregunta, String res) {
        this.pregunta = pregunta;
        this.respuesta = res;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
