![Adapter](UML_DP_Adaptateur.png)

Adaptateur 
est un patron de conception qui permet de convertir l'interface d'une classe en une autre 
interface que le client attend. Adaptateur fait fonctionner un ensemble de classes qui n'auraient pas pu 
fonctionner sans lui, à cause d'une incompatibilité d'interfaces.


Exemple
Vous voulez intégrer une classe que vous ne voulez/pouvez pas modifier.

Applicabilité
Une API tiers convient à votre besoin fonctionnel, mais la signature de ses méthodes ne vous convient pas.
Vous voulez normaliser l'utilisation d'anciennes classes sans pour autant en reprendre tout le code.
