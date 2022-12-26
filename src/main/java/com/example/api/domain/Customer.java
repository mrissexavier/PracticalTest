package com.example.api.domain;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long id;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String name;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	@Email
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cust_id", referencedColumnName = "customer_id")
	private List<Address> address;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
