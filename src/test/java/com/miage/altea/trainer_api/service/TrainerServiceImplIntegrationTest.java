package com.miage.altea.trainer_api.service;

import com.miage.altea.trainer_api.bo.Trainer;
import com.miage.altea.trainer_api.repository.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TrainerServiceImplIntegrationTest {

    @Autowired
    TrainerRepository trainerRepository;

    @Test
    void getTrainer_withNameAsh_shouldReturnAsh() {

        TrainerService trainerService = Mockito.mock(TrainerService.class);
        Trainer trainer = new Trainer();
        trainer.setName("Ash");
        Mockito.when(trainerService.getTrainer("Ash")).thenReturn(trainer);

        Trainer t = trainerService.getTrainer("Ash");
        assertEquals("Ash", t.getName());
    }

    @Test
    void getAllTrainers_shouldReturnAshAndMisty() {

        TrainerService trainerService = Mockito.mock(TrainerService.class);
        Trainer trainer = new Trainer();
        trainer.setName("Ash");
        Trainer trainer2 = new Trainer();
        trainer2.setName("Misty");
        Trainer[] trainers = {trainer, trainer2};

        Mockito.when(trainerService.getAllTrainers()).thenReturn(Arrays.asList(trainers));

        Iterable<Trainer> res = trainerService.getAllTrainers();
        assertNotNull(trainers);
        assertEquals(2, trainers.length);

        assertEquals("Ash", trainers[0].getName());
        assertEquals("Misty", trainers[1].getName());
    }

    @Test
    void createTrainer_shouldReturnTheTrainer() {

        TrainerService trainerService = Mockito.mock(TrainerService.class);
        Trainer trainer = new Trainer();
        trainer.setName("Ash");
        Mockito.when(trainerService.createTrainer(trainer)).thenReturn(trainer);

        Trainer res = trainerService.createTrainer(trainer);
        assertNotNull(res);

        assertEquals("Ash", res.getName());
    }
}
