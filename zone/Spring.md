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