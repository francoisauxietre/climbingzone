Spring Data is an umbrella project to simplify persisting POJOs to various forms of storage
Rendre persistant un objet c’est sauvegarder ses
données sur un support non volatile de telle sorte
qu’un objet identique à cet objet pourra être recréé
lors d’une session ultérieure
 L’objet et le relationnel sont 2 paradigmes bien
différents
– Faire la correspondance entre les données modélisées
par un modèle objet et par un modèle relationnel n’est
pas simple
– Le modèle relationnel est moins riche que le modèle
objet
– pas d’héritage, ni de références, ni de collections dans
le modèle relationnel

* Focus is on retrieving POJOs from the backend, and saving POJOs to
the backend
POJO plain old java object
* Repository – Convert retrieved data into POJOs – Convert POJOs into saved data 
* Mapping – Inferred from conventions – Annotations to help automate field mapping 
* Template – Provide simplified direct-access to database 
* Automatically managing internal resources 
* Query – Apply provided native queries directly – Convert QueryDSL into native queries
Annotations dans les classessont la pour definir un  mappings un liens
@Entity @Table(...)
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; private Date firstOrderDate; private String email;
// Other data-members
}
@Document
public class Customer {
... @Region
public class Customer {

exemple de query 
// native query
@Query("select u from User u where u.emailAddress = ?1")
User findByEmail(String email);
// queryDSL
List<User> findAllByZIP(String zip)
{ return findAll(person.address.zipcode.eq(zip)); }

  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

  // Enables the distinct flag for the query
  List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
  List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

  // Enabling ignoring case for an individual property
  List<Person> findByLastnameIgnoreCase(String lastname);
  // Enabling ignoring case for all suitable properties
  List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

  // Enabling static ORDER BY for a query
  List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
  List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
}

Keyword	Sample	JPQL snippet
And	findByLastnameAndFirstname	… where x.lastname = ?1 and x.firstname = ?2
Or	findByLastnameOrFirstname	… where x.lastname = ?1 or x.firstname = ?2
Is,Equals	findByFirstname,findByFirstnameIs,findByFirstnameEquals	… where x.firstname = 1?
Between	findByStartDateBetween	… where x.startDate between 1? and ?2
LessThan	findByAgeLessThan	… where x.age < ?1
LessThanEqual	findByAgeLessThanEqual	… where x.age <= ?1
GreaterThan	findByAgeGreaterThan	… where x.age > ?1
GreaterThanEqual	findByAgeGreaterThanEqual	… where x.age >= ?1
After	findByStartDateAfter	… where x.startDate > ?1
Before	findByStartDateBefore	… where x.startDate < ?1
IsNull	findByAgeIsNull	… where x.age is null
IsNotNull,NotNull	findByAge(Is)NotNull	… where x.age not null
Like	findByFirstnameLike	… where x.firstname like ?1
NotLike	findByFirstnameNotLike	… where x.firstname not like ?1
StartingWith	findByFirstnameStartingWith	… where x.firstname like ?1 (parameter bound with appended %)
EndingWith	findByFirstnameEndingWith	… where x.firstname like ?1 (parameter bound with prepended %)
Containing	findByFirstnameContaining	… where x.firstname like ?1 (parameter bound wrapped in %)
OrderBy	findByAgeOrderByLastnameDesc	… where x.age = ?1 order by x.lastname desc
Not	findByLastnameNot	… where x.lastname <> ?1
In	findByAgeIn(Collection<Age> ages)	… where x.age in ?1
NotIn	findByAgeNotIn(Collection<Age> age)	… where x.age not in ?1
True	findByActiveTrue()	… where x.active = true
False	findByActiveFalse()	… where x.active = false
IgnoreCase	findByFirstnameIgnoreCase	… where UPPER(x.firstame) = UPPER(?1)

exemple de repository
public interface UserRepository extends Repository<User, Long> { <S extends User> save(S entity); // Definition as per CRUDRepository
User findById(long i); // Query determined from method name
User findByNameIgnoreCase(String name); // Case insensitive search @Query("select u from User u where u.emailAddress = ?1")
User findByEmail(String email); // ?1 replaced by method param
}
public interface CrudRepository<T, ID> extends Repository<T, ID> {
public <S extends T> T save(S entity);
public <S extends T> Iterable<S> save(Iterable<S> entities);
public T findOne(ID id);
public Iterable<T> findAll();
public void delete(ID id);
public void delete(T entity);
public void delete(Iterable<? extends T> entities);
public void deleteAll();
public long count();

et on peut aussi etendre crudrepository
public interface UserRepository extends CRUDRepository<User, Long> {
@Query("select u from User u where u.emailAddress = ?1")

public interface CRUDRepository<T, I> {
T findOne(I id);
Iterable<T> findAll();
T save(T entity);
Iterable<T> save(Iterable(? extends T> entiries);
void delete(T entity);
void delete(I id);
void delete(T entity);
void delete(Iterable<> extends T> entities);
void deleteAll();
long count();
boolean exists(I id);

public interface – <Op>CustomerRepository can be Gt, Lt, Ne, Between, Like … etc extends CrudRepository<Customer, Long> {
public Customer findByEmail(String someEmail); // No <Op> for Equals
public Customer findByFirstOrderDateGt(Date someDate);
public Customer findByFirstOrderDateBetween(Date d1, Date d2);
@Query(“SELECT c FROM Customer c WHERE c.email NOT LIKE '%@%'”)
public List<Customer> findInvalidEmails();

SERVEUR
Plus de 80% des applications et des sites Web sont hébergés par des serveurs web open source. En voici 5 qui pourraient vous intéresser si vous voulez vous lancer sur ce secteur. Si les piles LAMP (Linux, Apache, MySQL, PHP) ou LEMP (Linux, Nginx, MySQL, PHP) sont certainement les plus faciles à utiliser au départ, d'autres solutions sont envisageables.

 

 publicité 
Apache HTTP Server, le leader
Le logiciel HTTP Apache Server, nommé souvent httpd ou plus simplement Apache, à plus de 20 ans d'âge. Une pérennité qui s'explique par une popularité impressionnante : 52% des sites web dans le monde sont hébergés sur un serveur qui utilise Apache. Surtout, si l'on croise souvent Apache sur des distributions Linux, le produit est ,disponible sur OS X et Windows.

Apache est disponible sous licence... Apache v2. Ce serveur Web utilise une architecture modulaire et évolutive, de manière à étendre les fonctionnalités en cas de besoin, comme l'équilibrage de charge par exemple. A noter que depuis la version 2.4, Apache prend en charge le protocole HTTP/2 grâce au module mod_http2. Enfin, il convient de dire que la longévité de ce logiciel lui confère une documentation importante tout comme l'intégration d'autres logiciels.

Plus d'information sur Apache HTTP Server
Nginx, le spécialiste des connexions simultanées
Le développement de Nginx a débuté en 2002 sous les bons auspices d'Igor Sysoev, et la première version publique date de 2004. Nginx répond à la question de la prise en charge de multiples connexions simultanées sur un serveur web, dit problème C10K.

Avec 30% des sites web qui tournent sur Nginx, nulle doute que cette mission est remplie. Dans ce but, Nginx repose sur une architecture événementielle asynchrone, ce qui permet de gérer des sessions simultanées massives. A noter que les administrateurs apprécient aussi Nginx en raison de son usage modéré des ressources tout comme sa capacité à monter facilement en charge. Nginx est publié sous une licence BSD, et peut être déployé en tant que serveur Web mais aussi comme serveur proxy ou comme équilibreur de charge.

Plus d'information sur Nginx
Apache Tomcat, origine Java
Apache Tomcat est un conteneur servlet Java open source qui fonctionne comme serveur Web en étendant les capacités d'un serveur. Ce sont les alternatives Java aux technologies telles que PHP et ASP.NET. La base du code de Tomcat a été donnée par Sun Microsystems à l'Apache Software Foundation en 1999. Un peu moins de 1% de tous les sites web utilisent Apache Tomcat.

Apache Tomcat est publié sous licence Apache v2, et est généralement utilisé pour exécuter des applications Java. Il peut cependant être étendu au rôle de serveur web normal en utilisant Coyote. Apache Tomcat est souvent classé parmi d'autres serveurs d'applications Java open source comme JBoss, Wildfly et Glassfish.

Plus d'information sur Apache Tomcat
Node.js, le rejeton de JavaScript
Node.js est un environnement JavaScript côté serveur pour les applications réseau, et donc les serveurs web. Node.js est utilisé par 0,2% des sites web. Créé en 2009 par Ryan Dahl, le projet Node.js est administré par la Fondation Node.js, et supporté par la Fondation Linux.

La différence entre Node.js et autres serveurs web est qu'il est avant tout un environnement d'exécution multi-plateforme pour créer des applications réseau. Node.js propose une architecture événementielle capable de gérer des entrées et des sorties asynchrones. Cela permet d'optimiser le débit et l'évolutivité des applications Web, des qualités idéales pour des applications de communication temps réel et des jeux vidéos en ligne.

Node.js se distingue également des autres serveurs web par le fait que cet outil fait partie intégrante de la pile web, comme l'HTML, le CSS ou encore le JavaScript. Par opposition, Apache ou Nginx font partie de piles logicielles très différentes. Node.js est publié sous différentes licences.

Plus d'information sur Node.js
Lighttpd, le poids léger
Lighttpd existe depuis 2003. Il est utilisé par environ 0,1% des sites Web et est distribué sous licence BSD.

Lighttpd se distingue des autres serveurs web par sa faible empreinte mémoire, sa faible charge CPU, et ses optimisations de vitesse. Il utilise une architecture événementielle, est optimisé pour un grand nombre de connexions parallèles, et prend en charge FastCGI, SCGI, Auth, Output-compression, la réécriture d'URL entre autres. Lighttpd est un serveur web populaire pour Catalyst ou le framework Ruby on Rails.