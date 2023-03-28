package com.alura.adopet.useCase;

import com.alura.adopet.domain.Tutor;
import com.alura.adopet.entity.TutorEntity;
import com.alura.adopet.exception.DadosInvalidoException;
import com.alura.adopet.repository.TutorRepository;
import com.alura.adopet.useCase.mapper.TutorMapper;
import com.alura.adopet.utils.ValidaDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorUseCase {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private TutorMapper mapper;

    @Autowired
    private ValidaDados validaDados;

    public Tutor salvar(Tutor tutor) throws DadosInvalidoException {

        try {
            validaDados.validaEmail(tutor.getEmail());
        } catch (DadosInvalidoException e) {
            throw new DadosInvalidoException(e.getMessage());
        }

        tutorRepository.save(mapper.toEntity(tutor));
        return tutor;
    }

    public List<Tutor> buscarTutores() {
        List<TutorEntity> listaTutores = tutorRepository.findAll();
        return mapper.toListDomain(listaTutores);
    }

    public Tutor buscarTutor(long id) {
        Optional<TutorEntity> tutor = tutorRepository.findById(id);
        return mapper.toDomain(tutor.orElse(null));
    }
}
