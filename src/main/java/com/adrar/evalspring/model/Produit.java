
package com.adrar.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "Attention, le champ du nom du produit est obligatoire.")
    @Length(min = 3, message = "Le nom du produit doit faire plus de 2 caractères.")
    private String nom;

    @Column(nullable = false)
    @NotEmpty(message = "Attentinon, le champ du prix du produit est obligatoire.")
    @Positive(message = "Le prix du produit doit être supérieur à 0€.")
    private Double prix;
}
