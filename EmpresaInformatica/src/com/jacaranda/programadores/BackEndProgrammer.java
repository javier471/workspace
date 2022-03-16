package com.jacaranda.programadores;

import java.time.LocalDate;

public class BackEndProgrammer extends Candidate{

	public BackEndProgrammer(LocalDate dateOfBirth, LocalDate startDate, String dni, String name, String surname,
			String ct, boolean inProject) {
		super(dateOfBirth, startDate, dni, name, surname, ct, inProject);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double computeGrossSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

}
