# Hibernate DB Connection 

#### Task 2: Create Utility - to get connection ( HibernateUtil.java )
```
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	// SessionFactory is an object designed to create sessions that will interact
	// with our database
	private static SessionFactory sf;

	private HibernateUtil() {
	};

	public static SessionFactory getSessionFactory() {

		if (sf == null) {
			// configuration is an "interface" that will instruct how to connect to our
			// database
			// It tells the sessionfactory how to connect to a database
			Configuration cfg = new Configuration();
			sf = cfg.configure().buildSessionFactory();
		}

		return sf;
	}

}
```
Testing:
```
public class TestHibernateUtil {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println(sessionFactory);
	}
}
```

Output:

```
org.hibernate.internal.SessionFactoryImpl@56da52a7
```

## Notes
#### Configuration class :
*  gathers the information from hibernate.cfg.xml and is used to create a session factory
#### SessionFactory interface
* The SessionFactory object configures Hibernate for the application using the supplied configuration object and allows for a Session object to be instantiated. 
* It also stores information on how to make connections to the database. 

