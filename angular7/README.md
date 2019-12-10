# angular7 nouveau projet
lancement et creation
<pre><code>
ng new angular7
</code></pre>
angular est basé sur 3 pièces 
* template
* styling
* logique du code (dynamique)


on a un style.scss general et un scss par composant.
le fichier spec est pour les tests
genration d'un composant de navigation
ajoute un nouveau dossier nav les fichiers de ce composant et l'ajoute a app.module.ts
bien penser quand on fait un composant soit meme de rajouter a app.module notre cnouveau composant
<pre><code>
ng generate component nav
</code></pre>
<pre><code>
ng g c about
</code></pre>
<pre><code>
ng g c contact
</code></pre>
<pre><code>
ng g c home
</code></pre>
ajout du component nav dans html du app.component
