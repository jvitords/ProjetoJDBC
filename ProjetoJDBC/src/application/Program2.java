package application;

import model.dao.DaoFabrica;
import model.dao.DepartamentoDao;

public class Program2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamento = DaoFabrica.createDepartamentoDao();
		
		//departamento.insert("Teee");
		//departamento.update(12, "Tekonologio");
		//departamento.delete(26);
		//System.out.println(departamento.encontrarDepartamentoAtravesDoId(12));
		departamento.encontrarTodosDepartamentos().forEach(d -> System.out.println(d.getIdDoDepartamento() + " - " + d.getNomeDoDepartamento()));
	}
}