package com.example.EnaaSkills.Mapper;

import com.example.EnaaSkills.Dto.SousCompetenceDto;
import com.example.EnaaSkills.Model.SousCompetence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SousCompetenceMapper {

    SousCompetenceDto ToDto (SousCompetence sousCompetence);
    SousCompetence ToEntity (SousCompetenceDto sousCompetenceDto);

}
