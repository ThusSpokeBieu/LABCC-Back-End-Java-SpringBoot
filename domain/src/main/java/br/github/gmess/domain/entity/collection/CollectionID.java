package br.github.gmess.domain.entity.collection;

import br.github.gmess.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CollectionID extends Identifier {
    private final String value;

    private CollectionID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CollectionID unique() {
        return CollectionID.from(UUID.randomUUID());
    }

    public static CollectionID from(final String anId) {
        return new CollectionID(anId);
    }

    public static CollectionID from(final UUID anId) {
        return new CollectionID(anId.toString().toLowerCase());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CollectionID that = (CollectionID) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
