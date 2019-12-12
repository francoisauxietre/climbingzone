 Le patron de conception prototype est utilisé lorsque la création d'une instance est complexe ou consommatrice en temps.
 Plutôt que créer plusieurs instances de la classe, on copie la première instance et on modifie la copie de façon
 appropriée.
 Pour implanter ce patron il faut déclarer une classe abstraite spécifiant une méthode abstraite (virtuelle pure en C++)
 appelée clone(). Toute classe nécessitant un constructeur polymorphique dérivera de cette classe abstraite et
 implantera la méthode clone().
 Le client de cette classe, au lieu d'écrire du code invoquant directement l'opérateur "new" sur une classe
 explicitement connue, appellera la méthode clone() sur le prototype ou passera par un mécanisme fourni par un
 autre patron de conception (par exemple une méthode de fabrique avec un paramètre désignant la classe concrète
 à instancier).
//La classe Prototype sert de modèle principal pour la création de nouvelles copies. Les classes PrototypeA et
 PrototypeB viennent spécialiser la classe Prototype en venant par exemple modifier certains attributs.
 La méthode clone() doit retourner une copie de l'objet concerné. Les sous-classes peuvent hériter ou surcharger
 la méthode clone(). La classe utilisatrice va se charger d'appeler les méthodes de clonage de la classe Prototype.

