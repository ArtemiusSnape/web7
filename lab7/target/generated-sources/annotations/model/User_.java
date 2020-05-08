package model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Integer> user_type;
	public static volatile SingularAttribute<User, Integer> user_id;
	public static volatile SingularAttribute<User, String> user_name;
	public static volatile SingularAttribute<User, String> login;

	public static final String PASSWORD = "password";
	public static final String USER_TYPE = "user_type";
	public static final String USER_ID = "user_id";
	public static final String USER_NAME = "user_name";
	public static final String LOGIN = "login";

}

