package com.example.punto1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/nombre")
public class NombreController {

    private final Map<String, String> miembros;

    public NombreController() {
        miembros = new HashMap<>();
        miembros.put("davidf-perezm", "David Fernando Pérez Medina");
        miembros.put("rodriguezlukas", "Lukas Fernando Rodríguez Pelaez");

    }

    @GetMapping("/{usuario}")
    public ResponseEntity<String> getNombreCompleto(@PathVariable String usuario) {
        String nombreCompleto = miembros.get(usuario);
        if (nombreCompleto != null) {
            return ResponseEntity.ok(nombreCompleto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}
