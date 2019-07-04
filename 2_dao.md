
#### Task 1: Create UserDAO - Insert
```
public class UserDAOImpl implements UserDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void insert(User user) throws DBException {
		Session sess = sf.openSession();
		try {

			sess.beginTransaction();
			sess.save(user);
			sess.getTransaction().commit();
			System.out.println("UserDAO->insert");
		} catch (HibernateException e) {
			throw new DBException("Unable to insert user", e);
		} finally {
			sess.close();
		}
	}
}
```
#### Task 2: Create UserDAO - Update
```
sess.update(user);
```
#### Task 3: Create UserDAO - findOne
```
int userId = 1;
User user = sess.get(User.class, userId);
```
#### Task 4: Create UserDAO - Delete
```
sess.delete(user);
```
#### Task 5: Create UserDAO - findAll
```
Query<User> createQuery = sess.createQuery("from User u", User.class);
List<User> userList = createQuery.getResultList();
```


#### What is HQL ? 
* HQL - Hibernate Query Language ( e.g from User )
* HQL considers the java objects in a similar way as that of the SQL.

#### What is Transaction ?
* Atomic Unit of work.

#### Why is ORM preferred over JDBC ?
* It allows business code access the objects rather than Database tables.
* It hides the details of SQL queries from OO logic.
* It is based on JDBC “under hood”.
* Dealing with database implementation is not required.
* Entities are based on business concepts rather than database structures.
* It generates the automatic key and Transaction management.
* Application development is faster.
