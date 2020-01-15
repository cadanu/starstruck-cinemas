package com.prog32578;

import java.io.Serializable;

public class Theatre implements Serializable {

	private static final long serialVersionUID = -4414180438014481793L;
	
	private User[] users = new User[100];

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}
	
	public void autoSet(User user) {
		for(int i=0; i<this.users.length; i++) {
			
			if(this.users[i] == null) {
				this.users[i] = user;
				break;
			}
		}
	}
	
	public int getSeatsLeft() {
		int subtrahend = 0;
		for(int i=0; i<this.users.length; i++) {
			if(this.users[i] != null) {
				subtrahend++;
			}
		}
		return this.users.length - subtrahend;
	}
}
