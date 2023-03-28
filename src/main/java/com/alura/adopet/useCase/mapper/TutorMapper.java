package com.alura.adopet.useCase.mapper;

import com.alura.adopet.domain.Tutor;
import com.alura.adopet.entity.TutorEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutorMapper {

    TutorEntity toEntity(Tutor user);

    Tutor toDomain(TutorEntity userEntity);

    List<TutorEntity> toListEntity(List<Tutor> user);

    List<Tutor> toListDomain(List<TutorEntity> userEntities);
}
