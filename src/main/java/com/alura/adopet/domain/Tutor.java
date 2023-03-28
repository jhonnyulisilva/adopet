package com.alura.adopet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {

    private Long id;
    private String nome;
    private String email;
    private String senha;

}
