package com.app.course.online.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User implements Comparable< User >
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "active")
	private long active;

	public User() {
		
	}
	
	public String getEmail()
	{ return email; }
	public void setEmail(String email)
	{ this.email = email; }
	public String getPassword()
	{ return password; }
	public void setPassword(String password)
	{ this.password = password; }
	public Long getId()
	{ return id; }
	public void setId(Long id)
	{ this.id = id; }
	public String getName()
	{ return name; }
	public void setName(String name)
	{ this.name = name; }
	public String getSurname()
	{ return surname; }
	public void setSurname(String surname)
	{ this.surname = surname; }

	public long getActive()
	{
		return active;
	}

	public void setActive(long active)
	{
		this.active = active;
	}
	
	@Override
    public int compareTo(User o) {
        return this.getId().compareTo(o.getId());
    }
}
