package model.dao;

import model.dao.impl.FuncionarioDaoJDBC;

public class DaoFabrica {
	
	public static FuncionarioDao createFuncionarioDao() {
		return new FuncionarioDaoJDBC();
	}
}
