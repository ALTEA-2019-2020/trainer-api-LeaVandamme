package com.miage.altea.trainer_api.bo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import javax.persistence.Embeddable;

public class PokemonTest {
    @Test
    void pokemon_shouldBeAnEmbeddable(){
        assertNotNull(Pokemon.class.getAnnotation(Embeddable.class));
    }
}
