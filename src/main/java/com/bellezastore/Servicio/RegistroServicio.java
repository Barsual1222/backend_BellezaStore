package com.bellezastore.Servicio;

import com.bellezastore.Modelo.Registro;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface RegistroServicio {

    ResponseEntity<Object> listarUsuario();
    ResponseEntity<Registro>agregarUsuario(Registro registro);
}
