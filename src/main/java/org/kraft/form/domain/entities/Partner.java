package org.kraft.form.domain.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Partner(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Partner() {
		super();
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", name=" + name + "]";
	}

}
