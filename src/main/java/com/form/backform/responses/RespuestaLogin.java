package com.form.backform.responses;

public class RespuestaLogin {
    public boolean isSuccessful;
    public String message;

    public RespuestaLogin(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
        this.message = this.isSuccessful
            ? "Usuario Logeado exitosamente"
            : "Error al iniciar sesión";
    }

    public boolean getMensaje() {
        return isSuccessful;
    }

    public void setMensaje(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }
}
