package application;

import db.DB;
import model.entities.Departamento;

public class Program {

	public static void main(String[] args) {

		Departamento dpt = new Departamento("TI", 1);
		System.out.println(dpt);
		
	}
}
