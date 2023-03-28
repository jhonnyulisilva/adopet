package com.alura.adopet.contoller;

import com.alura.adopet.domain.Tutor;
import com.alura.adopet.useCase.TutorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorUseCase tutorUseCase;

    @GetMapping()
    public ResponseEntity<?> buscarTutores() {
        return ResponseEntity.ok(tutorUseCase.buscarTutores());
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Tutor user) {
        try {
            Tutor tutorCriado = tutorUseCase.salvar(user);
            return ResponseEntity.ok().body(tutorCriado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
