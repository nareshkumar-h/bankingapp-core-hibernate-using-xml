## Hibernate ( ORM )

* Object Relational Mapping

#### Prerequisite:
* Create Maven Project
* Add jdbc driver and hibernate dependency
```
<dependency>
 <groupId>org.hibernate</groupId>
 <artifactId>hibernate-core</artifactId>
 <version>5.4.3.Final</version>
</dependency>
```

#### Step 1: Create Hibernate Configuration ( resources/hibernate.cfg.xml )
```
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
    "-//Hibernate/Hibernate Configuration DTD//EN"
    "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>

		<property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
		<property name="hibernate.connection.url">jdbc:oracle:thin:@primaveradb.cyysbedq8cqc.us-east-1.rds.amazonaws.com:1521:ORCL</property>
		<property name="hibernate.connection.username">username</property>
		<property name="hibernate.connection.password">password</property>
		<property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>
		<!--<property name="hibernate.hbm2ddl.auto">create</property> -->
		<property name="hibernate.show_sql">true</property>
		
		<mapping resource ="user.hbm.xml"/>
		
	</session-factory>
</hibernate-configuration>
```

#### Create Utility - to get connection ( HibernateUtil.java )
```
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
