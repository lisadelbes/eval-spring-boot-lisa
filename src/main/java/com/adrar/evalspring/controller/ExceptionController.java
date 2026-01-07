package com.adrar.evalspring.controller;

import com.adrar.evalspring.exception.categorie.CategorieIsNotExistingException;
import com.adrar.evalspring.exception.categorie.CategoriesEmptyException;
import com.adrar.evalspring.exception.produit.ProduitIsNotExistingException;
import com.adrar.evalspring.exception.produit.ProduitsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProduitIsNotExistingException.class)
    public ResponseEntity<Map<String, String>> handleProduitIsNotExistingException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(ProduitsEmptyException.class)
    public ResponseEntity<Map<String, String>> handleProduitsEmptyException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(CategorieIsNotExistingException.class)
    public ResponseEntity<Map<String, String>> handleCategorieIsNotExistingException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }



    @ExceptionHandler(CategoriesEmptyException.class)
    public ResponseEntity<Map<String, String>> handleCategoriesEmptyException(RuntimeException ex)
    {
        Map<String,String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
