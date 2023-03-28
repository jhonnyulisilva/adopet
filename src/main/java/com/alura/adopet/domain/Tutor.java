package com.alura.adopet.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String nome;
    private String email;
    private String senha;

}
