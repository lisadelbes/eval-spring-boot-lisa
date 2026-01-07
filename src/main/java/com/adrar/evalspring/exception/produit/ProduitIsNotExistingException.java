package com.adrar.evalspring.exception.produit;

public class ProduitIsNotExistingException extends RuntimeException {
    public ProduitIsNotExistingException(String message) {
        super(message);
    }
}
