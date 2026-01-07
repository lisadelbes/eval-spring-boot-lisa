package com.adrar.evalspring.service;


import com.adrar.evalspring.exception.categorie.CategorieAlreadyExistsException;
import com.adrar.evalspring.exception.categorie.CategorieIsNotExistingException;
import com.adrar.evalspring.exception.categorie.CategoriesEmptyException;
import com.adrar.evalspring.exception.produit.ProduitAlreadyExistsException;
import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieService {

    private CategorieRepository categorieRepository;

    public Categorie addCategorie(Categorie categorie){

        if (categorieRepository.findByLibele(categorie.getLibele())) {
            throw new CategorieAlreadyExistsException("La catégorie est le libélé " + categorie.getLibele() + " existe déjà.");
        }
        return categorieRepository.save(categorie);
    }

    public Optional<Categorie> getCategorieById(Integer id) {
        return Optional
                .of(categorieRepository
                        .findById(id)
                        .orElseThrow(
                                ()-> new CategorieIsNotExistingException("La catégorie avec l'id :" + id +  " n'existe pas")
                        )
                );
    }

    public List<Categorie> getAllCategories()
    {
        if (categorieRepository.count() == 0) {
            throw new CategoriesEmptyException("La liste des catégorie est vide.");
        }
        return (List<Categorie>) categorieRepository.findAll();
    }
}
