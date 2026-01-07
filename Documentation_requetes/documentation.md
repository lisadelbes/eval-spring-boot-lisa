# Documentation Aevalspring

## Ajouter un produit

* **Méthode HTTP** : `POST`
* **URL** : `/produit`

### Body 
# valide

```json
{
  "nom": "Chaise",
  "prix": 44.90,
  "categoryId": 1
}
```
### non valide

```json
{
  "name": "",
  "price": -10
}
```

## Afficher tous les produits

* **Méthode HTTP** : `GET`
* **URL** : `/produits`


## Afficher une catégorie par son ID

* **Méthode HTTP** : `GET`
* **URL** : `/categories/{id}`
