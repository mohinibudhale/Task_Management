package com.projectToDo.springboot.WebAppToDo.todo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class ToDo {

	public ToDo() {
		
	}

	public ToDo(int id, String name, String desc, LocalDate targetDate, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.targetDate = targetDate;
		this.status = status;
	}

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@Size(min = 10, message = "please enter atleast 10 characters.")
	@Column(name = "description")
	private String desc;

	private LocalDate targetDate;
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", name=" + name + ", desc=" + desc + ", targetDate=" + targetDate + ", status="
				+ status + "]";
	}

}
