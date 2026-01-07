package com.adrar.evalspring.repository;

import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.model.Produit;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer>{

    public boolean findByLibele(String libele);
}
