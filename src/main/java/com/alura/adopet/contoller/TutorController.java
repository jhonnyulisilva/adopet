package com.alura.adopet.contoller;

import com.alura.adopet.domain.Tutor;
import com.alura.adopet.exception.DadosInvalidoException;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> buscarTutor(@PathVariable long id) {
        Tutor tutor = tutorUseCase.buscarTutor(id);

        if(tutor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tutor);
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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws DadosInvalidoException {
        try {
            tutorUseCase.deletarTutor(id);
            return ResponseEntity.ok().build();
        } catch (DadosInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
