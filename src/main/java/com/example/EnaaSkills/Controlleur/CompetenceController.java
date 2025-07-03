package com.example.EnaaSkills.Controlleur;

import com.example.EnaaSkills.Dto.CompetenceDto;
import com.example.EnaaSkills.Service.CompetenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompetenceController {

    public CompetenceService competenceService;

    @GetMapping("/AllCompetences")
    public List<CompetenceDto> getAllCompetences(){
        return competenceService.getAllCompetences();
    }

    @PostMapping("/AddCompetence")
    public CompetenceDto AddCompetence(@RequestBody  CompetenceDto competenceDto){
        return competenceService.AddCompetence(competenceDto);
    }

    @GetMapping("/Competence/{id}")
    public CompetenceDto getCompetenceById (@PathVariable  Long id ){
        return competenceService.getCompetenceById(id);
    }

    @PutMapping("/competence/{id}")
    public CompetenceDto UpdateCompetence ( @RequestBody CompetenceDto competenceDto , @PathVariable Long id){
        return competenceService.UpdateCompetence(competenceDto , id);
    }
    @DeleteMapping("/delCompetence/{id}")
    public void DeleteCompetence(@PathVariable Long id){
        competenceService.DeleteCompetence(id);

    }

}
