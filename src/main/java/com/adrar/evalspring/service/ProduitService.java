package com.adrar.evalspring.service;
import com.adrar.evalspring.exception.produit.ProduitAlreadyExistsException;
import com.adrar.evalspring.exception.produit.ProduitIsNotExistingException;
import com.adrar.evalspring.exception.produit.ProduitsEmptyException;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProduitService {

    private ProduitRepository produitRepository;


    public Produit addProduit(Produit produit){

        if (produitRepository.findByNom(produit.getNom())) {
            throw new ProduitAlreadyExistsException("Le produit avec le nom " + produit.getNom() + " existe déjà.");
        }
        return produitRepository.save(produit);
    }

    public List<Produit> getAllProduits()
    {
        if (produitRepository.count() == 0) {
            throw new ProduitsEmptyException("La liste des produits est vide.");
        }
        return (List<Produit>) produitRepository.findAll();
    }

    public Optional<Produit> getProduitById(Integer id)
    {
        return Optional
                .of(produitRepository
                        .findById(id)
                        .orElseThrow(
                                ()-> new ProduitIsNotExistingException("Le produit avec id :" + id +  " n'existe pas")
                        )
                );
    }
}