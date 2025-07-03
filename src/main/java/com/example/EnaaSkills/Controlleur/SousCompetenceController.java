package com.example.EnaaSkills.Controlleur;

import com.example.EnaaSkills.Dto.SousCompetenceDto;
import com.example.EnaaSkills.Service.SousCompetenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SousCompetenceController {

    public SousCompetenceService sousCompetenceService;

    @PostMapping("/AddSubCom")
    public SousCompetenceDto AddSousCompetence(@RequestBody  SousCompetenceDto sousCompetenceDto){
        return sousCompetenceService.AddSubCompetence(sousCompetenceDto);
    }

    @GetMapping("/AllSubComs")
    public List<SousCompetenceDto> getAllSubComs(){
        return sousCompetenceService.getAllSousCompetences();
    }

    @GetMapping("/subcom/{id}")
    public SousCompetenceDto getSubComById(@PathVariable Long id){
        return sousCompetenceService.getSubComById(id);
    }

    @PutMapping("/Subcom/{id}")
    public SousCompetenceDto UpdateSubCom(@RequestBody SousCompetenceDto sousCompetenceDto ,@PathVariable Long id){
        return sousCompetenceService.UpdateSubCom(sousCompetenceDto , id);

    }

    @DeleteMapping("/supSubCom/{id}")
    public void DeleteSubCom(@PathVariable Long id){
        sousCompetenceService.DeleteSubCom(id);

    }
}
