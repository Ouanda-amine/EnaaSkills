package com.example.EnaaSkills.Service;

import com.example.EnaaSkills.Dto.SousCompetenceDto;
import com.example.EnaaSkills.Mapper.SousCompetenceMapper;
import com.example.EnaaSkills.Model.SousCompetence;
import com.example.EnaaSkills.Repository.CompetenceRepo;
import com.example.EnaaSkills.Repository.SousCompetenceRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SousCompetenceService {

    private  final SousCompetenceMapper sousCompetenceMapper;
    private final SousCompetenceRepo sousCompetenceRepo;
    private final CompetenceRepo competenceRepo ;

    public SousCompetenceDto AddSubCompetence(SousCompetenceDto sousCompetenceDto){
        var competence = competenceRepo.findById(sousCompetenceDto.getIdCompetence()).orElse(null);

        var res = sousCompetenceRepo.save(new SousCompetence(null , sousCompetenceDto.getName() , sousCompetenceDto.getDescription(), competence , sousCompetenceDto.isValide()));

        return sousCompetenceMapper.ToDto(res);


    }

    public List<SousCompetenceDto> getAllSousCompetences(){
        return sousCompetenceRepo.findAll().stream()
                .map(sousCompetenceMapper::ToDto)
                .toList();
    }

    public  SousCompetenceDto getSubComById(Long id){
        return sousCompetenceRepo.findById(id)
                .map(sousCompetenceMapper::ToDto)
                .orElseThrow(()->new RuntimeException("subcom not found"));
    }

    public SousCompetenceDto UpdateSubCom(SousCompetenceDto sousCompetenceDto , Long id){
        SousCompetence sousCompetence = sousCompetenceRepo.findById(id).get();
        sousCompetence.setName(sousCompetenceDto.getName());
        sousCompetence.setDescription(sousCompetenceDto.getDescription());
        sousCompetence.setValide(sousCompetenceDto.isValide());

        return sousCompetenceMapper.ToDto(sousCompetenceRepo.save(sousCompetence));


    }

    public void DeleteSubCom (Long id){
        sousCompetenceRepo.deleteById(id);
    }

}
