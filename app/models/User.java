package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import models.MD5;

@Entity
@Table(name="users")
public class User extends Model {
    
	@Required
	@Column(nullable=false, unique=true)
	public String name;
	
	@Required
	@Column(nullable=false)
	public String hashedPass;
	
	public String fullname;
	
	public User(String name, String password, String fullname) {
		this.name = name;
		this.hashedPass = MD5.crypt(password);
		this.fullname = fullname;
	}
	
	public static boolean connect(String name, String password) {
		User user = User.find("byNameAndHashedPass", name, MD5.crypt(password)).first();
		return user != null;
	}
}
