package br.github.gmess.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClothingModelTest {

    @Test
    public void testNewClothingModel() {
        Assertions.assertNotNull(new ClothingModel());
    }
}