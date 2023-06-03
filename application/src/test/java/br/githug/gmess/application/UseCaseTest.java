package br.githug.gmess.application;

import br.github.gmess.application.UseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {
    @Test
    public void testUseCase() {
        Assertions.assertNotNull(new UseCase());
        Assertions.assertNotNull(new UseCase().execute());
    }
}
