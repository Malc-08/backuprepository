package com.olgafranco.app.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

	@Id // Indica que el atributo será la clave primaria
	// Indica como se generará automáticamente las claves primarias
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long users_id;
	
	@Column(name="user_name", length=50, nullable=false)
	private String user_name;
	@Column(name="user_lastname", length=50, nullable=true)
	private String user_lastname; 
	@Column(name="email", length=50, nullable=false, unique=true)
	private String email;
	@Column(name="password", length=100, nullable=false)
	private String password;
	@Column(name="phone", length=15, nullable=false)
	private String phone;
	@Column(name="address", length=150, nullable=true)
	private String address;
	@Column(name="register_date_time", nullable=false)
	private LocalDate register_date_time;
	@Column(name="active", nullable=false)
	private boolean active;

	
	@ManyToMany
	@JoinTable(
			  name = "users_has_privileges",        // nombre de la tabla puente
			  joinColumns = @JoinColumn(name = "user_id"), // nombre del atributo
			  inverseJoinColumns = @JoinColumn(name = "privilege_id")) // nombre del atributo
	private List<Privilege> privileges;	
	
	public User() {
		
	}
	
	public User(String user_name, String user_lastname, String email, String password, String phone, String address,
			LocalDate register_date_time, boolean active, List<Privilege> privileges) {
		super();
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.register_date_time = register_date_time;
		this.privileges = privileges;
		this.active = active;
	}
	
	
	public Long getUsers_id() {
		return users_id;
	}

	public void setUsers_id(Long users_id) {
		this.users_id = users_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getRegister_date_time() {
		return register_date_time;
	}

	public void setRegister_date_time(LocalDate register_date_time) {
		this.register_date_time = register_date_time;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(users_id);
		builder.append(", firstName=");
		builder.append(user_name);
		builder.append(", lastName=");
		builder.append(user_lastname);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", address=");
		builder.append(address);
		builder.append(", register_date_time=");
		builder.append(register_date_time);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}
	
}
