# angular7 nouveau projet
lancement et creation
<pre><code>
ng new angular7
</code></pre>
angular est basé sur 3 principes 
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
creation d'un peu de dynamique dans le component nav.component.html
    creation d'une barre de menu  nouveau depuis angular7  <a routerLink="/" class="logo">apptitle</a>
    puis pour que notre variable apptitle soir dynamique {{apptitle}} utilisation de {{}}
    une variable de la logique de code du module va etre wrapper (injectee) dans le code html
ajout du scss global et celui de nav
dans le fichier app-routing on peut definir nos chemins creation d'une variable path 
<pre><code>
const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'about', component: AboutComponent},
];
</code></pre>
début de dynamisme avec utilisateur et un bouton et un listener
<pre><code><button (click)="firstClick()">Click me</button></code></pre>
creation d'un attribut de classe en mode binding d'ou [] on appliquerai le style rouge si le booleen vaut true
<pre><code><h1 [class.gray]="h1StyleBool">Home</h1></code></pre>
deuxieme test avec ngClass qui lui permet de passer plusieurs css par ligne 
troisieme et quatrieme code dans home.component 
creation d'un premier service 
<pre><code>ng g s dataService</code></pre>
ensuite on le met dans le constructeur du composant qui veur souscrire au service
<pre><code> constructor(private data: DataService) { }</code></pre>
Debut des requete http 
