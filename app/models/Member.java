package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

import models.User;
import models.Channel;

@Entity
public class Member extends Model {
    
	@Required
	public User user;
	
	@Required
	public Channel channel;
	
	@Required
	public boolean isOwner;
	
	@Required
	public Date joinedOn;
	
	public Member(User user, Channel channel, boolean isOwner) {
		this.user = user;
		this.channel = channel;
		this.isOwner = isOwner;
		this.joinedOn = new Date();
	}
	
}
