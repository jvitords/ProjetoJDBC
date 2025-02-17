package model.dao;

import java.sql.Connection;

import db.DB;
import model.dao.impl.DepartamentoDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;

public class DaoFabrica {
	
	public static FuncionarioDao createFuncionarioDao() {
		return new FuncionarioDaoJDBC(DB.getConnection());
	}
	
	public static DepartamentoDaoJDBC createDepartamentoDao() {
		return new DepartamentoDaoJDBC(DB.getConnection());
	}
}