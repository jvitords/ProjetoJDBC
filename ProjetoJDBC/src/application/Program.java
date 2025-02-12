package application;

import java.util.Date;

import db.DB;
import model.dao.DaoFabrica;
import model.dao.FuncionarioDao;
import model.entities.Departamento;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		Departamento dpt1 = new Departamento("TI", 1);
		Funcionario funcionario = new Funcionario(21, "João", "joao@gmail.com", new Date(), 3500.0, dpt1);
		//System.out.println(funcionario);
		
		DaoFabrica.createFuncionarioDao().insert(funcionario);
	}
}
