package com.bellezastore.Servicio.Impl;

import com.bellezastore.Modelo.Producto;
import com.bellezastore.Modelo.Registro;
import com.bellezastore.Repositorio.RegistroRepositorio;
import com.bellezastore.Servicio.RegistroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroServiceImpl implements RegistroServicio {
    @Autowired
    private RegistroRepositorio registroRepos;
    @Override
    public ResponseEntity<Object> listarUsuario() {
        try{
            List<Registro> registros = registroRepos.findAll();
            if (registros.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(registros);

        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }
        return null;
    }

    @Override
    public ResponseEntity<Registro> agregarUsuario(Registro registro) {
        try{
            Registro nuevoRegistro = registroRepos.save(registro);
            if (nuevoRegistro == null ){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(registro);

        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }

        return null;
    }



}
