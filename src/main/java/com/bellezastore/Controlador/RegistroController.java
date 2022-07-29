package com.bellezastore.Controlador;


import com.bellezastore.Modelo.Registro;
import com.bellezastore.Servicio.RegistroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    RegistroServicio registroservicio;
    @GetMapping
    public ResponseEntity<Object> listarUsuario(){
        return registroservicio.listarUsuario();
    }
    @PostMapping
    public ResponseEntity<Registro> agregarUsuario(@RequestBody Registro r){
        return registroservicio.agregarUsuario(r);
    }



}
