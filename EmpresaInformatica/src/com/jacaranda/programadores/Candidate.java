package com.jacaranda.programadores;

import java.time.LocalDate;

public abstract class Candidate {
	private LocalDate dateOfBirth;
	private LocalDate startDate;
	private String dni;
	private String name;
	private String surname;
	private ContractType ct;
	private boolean inProject;

	public Candidate(LocalDate dateOfBirth, LocalDate startDate, String dni, String name, String surname, String ct,
			boolean inProject) {
		super();
		this.dateOfBirth = dateOfBirth;
		this.startDate = startDate;
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.ct = ContractType.valueOf(ct.toUpperCase());
		this.inProject = inProject;
	}

	abstract public double computeGrossSalary();

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ContractType getCt() {
		return ct;
	}

	public void setCt(ContractType ct) {
		this.ct = ct;
	}

	public boolean isInProject() {
		return inProject;
	}

	public void setInProject(boolean inProject) {
		this.inProject = inProject;
	}

	public int CompareTo(Candidate c1) {
		int resul;
		if (this.startDate.isBefore(c1.startDate)) {
			resul = -1;
		} else if (this.startDate.isAfter(c1.startDate)) {
			resul = 1;
		} else {
			resul = 0;
		}
		return resul;
	}

}
