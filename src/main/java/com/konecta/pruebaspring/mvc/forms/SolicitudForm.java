package com.konecta.pruebaspring.mvc.forms;

import com.konecta.pruebaspring.dto.SolicitudDTO;

public class SolicitudForm {
    private SolicitudDTO solicitud;

    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
    }

}
