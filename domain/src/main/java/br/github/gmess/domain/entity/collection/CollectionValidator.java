package br.github.gmess.domain.entity.collection;

import br.github.gmess.domain.validation.Error;
import br.github.gmess.domain.validation.ValidationHandler;
import br.github.gmess.domain.validation.Validator;

public class CollectionValidator extends Validator {

    private final Collection collection;

    public CollectionValidator(final Collection collection, final ValidationHandler handler) {
        super(handler);
        this.collection = collection;
    }

    @Override
    public void validate() {
        if (this.collection.getCollectionName() == null) {
            this.validationHandler().append(new Error("'collection name' should not be null"));
        }
    }
}
