
#### Task 1 : Create Table ( users )
* Create a Table : users ( id,name,email,password)


#### Task 2 : Create Model class ( User.java )
* Fields : id,name,email,password

#### Task 3: Create Configuration File ( resources/user.cfg.xml )
```
<hibernate-mapping>

	<class name="com.naresh.bankingapp.model.User" table="users">
		<id name="id" type="int" column="id">
			<generator class="native"></generator>
		</id>
		<property name="name" column="name" type="string"></property>
		<property name="email" column="email" type="string"></property>
		<property name="password" column="password" type="string"></property>
	</class>
</hibernate-mapping>
```

#### Task 4: Add entry in hibernate.cfg.xml
```
<mapping resource ="user.hbm.xml"/>
```
