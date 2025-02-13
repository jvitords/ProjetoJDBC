package application;

import java.util.Date;

import db.DB;
import model.dao.DaoFabrica;
import model.dao.FuncionarioDao;
import model.dao.impl.FuncionarioDaoJDBC;
import model.entities.Departamento;
import model.entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		FuncionarioDao funcionarioDao = DaoFabrica.createFuncionarioDao();
		System.out.println(funcionarioDao.encontrarFuncionarioAtravesDoId(7));
	}
}
