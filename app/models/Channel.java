package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Channel extends Model {
    
	@Required
	@Column(nullable=false, unique=true)
	String name;
	
	@Required
	@Column(nullable=false)
	public Date createdAt;
	
	@Required
	@Column(nullable=false)
	public Date updatedAt;
	
	public Channel(String name) {
		this.name = name;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
		this.updatedAt = new Date();
	}
}
