package br.github.gmess.domain.validation.handler;

import br.github.gmess.domain.exception.DomainException;
import br.github.gmess.domain.validation.Error;
import br.github.gmess.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler  implements ValidationHandler {

    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception exception) {
            throw DomainException.with(new Error(exception.getMessage()));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return null;
    }
}
