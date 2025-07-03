package com.example.EnaaSkills.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SousCompetenceDto {
    private Long id ;
    private String name ;
    private String description;
    private Long idCompetence ;
    private boolean isValide ;

}
