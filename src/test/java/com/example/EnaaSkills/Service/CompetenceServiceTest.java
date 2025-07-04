package com.example.EnaaSkills.Service;

import com.example.EnaaSkills.Dto.CompetenceDto;
import com.example.EnaaSkills.Mapper.CompetenceMapper;
import com.example.EnaaSkills.Model.Competence;
import com.example.EnaaSkills.Repository.CompetenceRepo;
import com.example.EnaaSkills.Repository.SousCompetenceRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetenceServiceTest {
    private CompetenceRepo competenceRepo ;
    private SousCompetenceRepo sousCompetenceRepo;
    private CompetenceMapper competenceMapper;
    private CompetenceService competenceService;

    @BeforeEach
    void setUp(){
        competenceRepo = mock(CompetenceRepo.class);
        sousCompetenceRepo = mock(SousCompetenceRepo.class);
        competenceMapper = Mappers.getMapper(CompetenceMapper.class);
        competenceService = new CompetenceService(competenceMapper , competenceRepo , sousCompetenceRepo);

    }


    @Test
    void addCompetence() {
        CompetenceDto dto = new CompetenceDto();
        dto.setNom("Presentation");

        Competence competence = competenceMapper.ToCompetenceEntity(dto);
        competence.setId(1L);

        when(competenceRepo.save(competence)).thenReturn(competence);

        CompetenceDto savedDto = competenceService.AddCompetence(dto);

        assertNotNull(savedDto);
        assertEquals("Presentation", savedDto.getNom());

    }

    @Test
    void getCompetenceById() {
    }

    @Test
    void updateCompetence() {
        Competence excom = new Competence();
        excom.setId(1L);
        excom.setNom("Git");

        when(competenceRepo.findById(1L)).thenReturn(Optional.of(excom));
        when(competenceRepo.save(excom)).thenAnswer(i->i.getArgument(0));

        CompetenceDto updateDto = new CompetenceDto();
        updateDto.setNom("Nouvelle");

        CompetenceDto update = competenceService.UpdateCompetence(updateDto , 1L);

        assertEquals("Nouvelle",update.getNom());
        verify(competenceRepo).save(excom);

    }
}