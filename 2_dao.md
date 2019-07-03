
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
