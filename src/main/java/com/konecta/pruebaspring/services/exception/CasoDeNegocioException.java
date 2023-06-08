package com.konecta.pruebaspring.services.exception;

public class CasoDeNegocioException extends RuntimeException {
    public CasoDeNegocioException(String mensaje, Throwable error) {
        super(mensaje, error);
    }
}
