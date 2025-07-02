package com.example.EnaaSkills.Service;

import com.example.EnaaSkills.Dto.CompetenceDto;
import com.example.EnaaSkills.Mapper.CompetenceMapper;
import com.example.EnaaSkills.Repository.CompetenceRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CompetenceService {

    private  final CompetenceMapper competenceMapper;
    private  final CompetenceRepo competenceRepo;


    public CompetenceDto AddCompetence(CompetenceDto competenceDto){
        return  competenceMapper.ToCompetenceDto(competenceRepo.save(competenceMapper.ToCompetenceEntity(competenceDto)));
    }

    public List<CompetenceDto> getAllCompetences(){
        return competenceRepo.findAll().stream()
                .map(competence -> competenceMapper.ToCompetenceDto(competence))
                .toList();
    }



}
