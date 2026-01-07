package com.adrar.evalspring.repository;

import com.adrar.evalspring.model.Produit;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer>
{
    public boolean findByNom(String nom);
}


