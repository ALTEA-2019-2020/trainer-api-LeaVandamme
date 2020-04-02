package com.miage.altea.trainer_api.service;

import com.miage.altea.trainer_api.bo.Trainer;
import com.miage.altea.trainer_api.repository.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TrainerServiceImplIntegrationTest {

    @Autowired
    TrainerRepository trainerRepository;

    @Test
    void getTrainer_withNameAsh_shouldReturnAsh() {
        TrainerRepository trainerRepository = Mockito.mock(TrainerRepository.class);
        TrainerService trainerService = new TrainerServiceImpl(trainerRepository);
        Trainer trainer = new Trainer();
        trainer.setName("Ash");
        Mockito.when(trainerRepository.findById("Ash")).thenReturn(Optional.of(trainer));

        Trainer t = trainerService.getTrainer("Ash");
        assertEquals("Ash", t.getName());
    }

    @Test
    void getAllTrainers_shouldReturnAshAndMisty() {
        TrainerRepository trainerRepository = Mockito.mock(TrainerRepository.class);
        TrainerService trainerService = new TrainerServiceImpl(trainerRepository);
        Trainer trainer = new Trainer();
        trainer.setName("Ash");
        Trainer trainer2 = new Trainer();
        trainer2.setName("Misty");
        Trainer[] trainers = {trainer, trainer2};

        Mockito.when(trainerRepository.findAll()).thenReturn(Arrays.asList(trainers));

        Iterable<Trainer> res = trainerService.getAllTrainers();
        assertNotNull(trainers);
        assertEquals(2, trainers.length);

        assertEquals("Ash", trainers[0].getName());
        assertEquals("Misty", trainers[1].getName());
    }

    @Test
    void createTrainer_shouldReturnTheTrainer() {

        TrainerRepository trainerRepository = Mockito.mock(TrainerRepository.class);
        TrainerService trainerService = new TrainerServiceImpl(trainerRepository);
        Trainer trainer = new Trainer();
        trainer.setName("Ash");
        Mockito.when(trainerRepository.save(trainer)).thenReturn(trainer);

        Trainer res = trainerService.createTrainer(trainer);
        assertNotNull(res);

        assertEquals("Ash", res.getName());
    }
}
