package br.github.gmess.domain.entity.collection;

import br.github.gmess.domain.AggregateRoot;
import br.github.gmess.domain.enums.CollectionTypeEnum;
import br.github.gmess.domain.enums.SeasonEnum;
import br.github.gmess.domain.validation.ValidationHandler;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Collection extends AggregateRoot<CollectionID> {
    private String collectionName;
    private String responsible;
    private CollectionTypeEnum collectionType;
    private SeasonEnum season;
    private List<String> themes = new ArrayList<>();
    private String brand;
    private Integer releaseYear;
    private BigDecimal budget;
    private final Instant createdAt;
    private Instant updatedAt;
    private final Integer createdUser;
    private Integer updatedUser;
    private boolean deleted;

    public Collection(
            final CollectionID anId,
            final String aCollectionName,
            final String aResponsible,
            final CollectionTypeEnum aCollectionType,
            final SeasonEnum aSeason,
            final List<String> aThemes,
            final String aBrand,
            final Integer aReleaseYear,
            final BigDecimal aBudget,
            final Instant aCreatedAt,
            final Instant aUpdatedAt,
            final Integer aCreatedUser,
            final Integer aUpdatedUser,
            final boolean isDeleted) {
        super(anId);
        this.collectionName = aCollectionName;
        this.responsible = aResponsible;
        this.collectionType = aCollectionType;
        this.season = aSeason;
        this.themes = aThemes;
        this.brand = aBrand;
        this.releaseYear = aReleaseYear;
        this.budget = aBudget;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;
        this.createdUser = aCreatedUser;
        this.updatedUser = aUpdatedUser;
        this.deleted = isDeleted;
    }

    public static Collection newCollection(
            final String collectionName,
            final String responsible,
            final CollectionTypeEnum collectionType,
            final SeasonEnum season,
            final List<String> themes,
            final String brand,
            final Integer year,
            final BigDecimal budget,
            final Integer user) {
        final var id = CollectionID.unique();
        final var now = Instant.now();
        return new Collection(
                id,
                collectionName,
                responsible,
                collectionType,
                season,
                themes,
                brand,
                year,
                budget,
                now,
                now,
                user,
                user,
                false);
    }

    public CollectionID getId() {
        return id;
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CollectionValidator(this, handler).validate();
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getResponsible() {
        return responsible;
    }

    public CollectionTypeEnum getCollectionType() {
        return collectionType;
    }

    public SeasonEnum getSeason() {
        return season;
    }

    public List<String> getThemes() {
        return themes;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public Integer getUpdatedUser() {
        return updatedUser;
    }

    public boolean isDeleted() {
        return deleted;
    }


}
