package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Produit;

import com.adrar.evalspring.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProduitController {

    private ProduitService produitService;


    @GetMapping("/produits")
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getProduits()
    {
        return  produitService.getAllProduits();
    }

    @GetMapping("/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produit> afficherProduit(@PathVariable Integer id)
    {
        return produitService.getProduitById(id);
    }

    @PostMapping("/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit ajouterProduit(@RequestBody Produit produit)
    {
        return produitService.addProduit(produit);
    }
}
