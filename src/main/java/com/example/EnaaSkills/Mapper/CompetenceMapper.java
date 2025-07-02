package com.example.EnaaSkills.Mapper;

import com.example.EnaaSkills.Dto.CompetenceDto;
import com.example.EnaaSkills.Model.Competence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CompetenceMapper {

    CompetenceDto ToCompetenceDto(Competence competence);
    Competence ToCompetenceEntity(CompetenceDto competenceDto);
}
