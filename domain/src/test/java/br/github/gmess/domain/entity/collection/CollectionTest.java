package br.github.gmess.domain.entity.collection;

import br.github.gmess.domain.enums.CollectionTypeEnum;
import br.github.gmess.domain.enums.SeasonEnum;
import br.github.gmess.domain.exception.DomainException;
import br.github.gmess.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CollectionTest {

    @Test
    public void givenValidParams_whenCallCollection_thenInstantiateCollection() {
        final var expectedCollectionName = "LABCoast Collection 2024";
        final var expectedResponsible = "Gabriel Costa";
        final var expectedCollectionType = CollectionTypeEnum.COMMERCIAL;
        final var expectedSeason = SeasonEnum.SUMMER;
        final var expectedThemes = new ArrayList<String>();
        final var expectedBrand = "LABCoast";
        final var expectedReleaseYear = 2024;
        final var expectedBudget = new BigDecimal("100000");

        expectedThemes.add("Coast");
        expectedThemes.add("Summer");
        expectedThemes.add("Hawaii");

        final var actualCollection =
                Collection.newCollection(
                        expectedCollectionName,
                        expectedResponsible,
                        expectedCollectionType,
                        expectedSeason,
                        expectedThemes,
                        expectedBrand,
                        expectedReleaseYear,
                        expectedBudget,
                        1);

        Assertions.assertNotNull(actualCollection);
        Assertions.assertNotNull(actualCollection.getId());
        Assertions.assertEquals(expectedCollectionName, actualCollection.getCollectionName());
        Assertions.assertEquals(expectedResponsible, actualCollection.getResponsible());
        Assertions.assertEquals(expectedCollectionType, actualCollection.getCollectionType());
        Assertions.assertEquals(expectedSeason, actualCollection.getSeason());
        Assertions.assertEquals(expectedThemes, actualCollection.getThemes());
        Assertions.assertEquals(expectedBrand, actualCollection.getBrand());
        Assertions.assertEquals(expectedReleaseYear, actualCollection.getReleaseYear());
        Assertions.assertEquals(expectedBudget, actualCollection.getBudget());
        Assertions.assertNotNull(actualCollection.getCreatedAt());
        Assertions.assertNotNull(actualCollection.getUpdatedAt());
        Assertions.assertEquals(1, actualCollection.getCreatedUser());
        Assertions.assertEquals(1, actualCollection.getUpdatedUser());
        Assertions.assertEquals(false, actualCollection.isDeleted());
    }


    @Test
    public void givenInvalidParams_whenCallNewCollectionAndValidate_thenShouldReturnException() {
        final String expectedCollectionName = null;
        final var expectedException = "'collection name' should not be null";
        final var expectedErrorCount = 1;
        final var expectedResponsible = "Gabriel Costa";
        final var expectedCollectionType = CollectionTypeEnum.COMMERCIAL;
        final var expectedSeason = SeasonEnum.SUMMER;
        final var expectedThemes = new ArrayList<String>();
        final var expectedBrand = "LABCoast";
        final var expectedReleaseYear = 2024;
        final var expectedBudget = new BigDecimal("100000");

        expectedThemes.add("Coast");
        expectedThemes.add("Summer");
        expectedThemes.add("Hawaii");

        final var actualCollection =
                Collection.newCollection(
                        expectedCollectionName,
                        expectedResponsible,
                        expectedCollectionType,
                        expectedSeason,
                        expectedThemes,
                        expectedBrand,
                        expectedReleaseYear,
                        expectedBudget,
                            1);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> {
                    actualCollection.validate(new ThrowsValidationHandler());
                });

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedException, actualException.getErrors().get(0).message());
    }
}
