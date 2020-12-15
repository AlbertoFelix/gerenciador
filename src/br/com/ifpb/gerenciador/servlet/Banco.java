package br.com.ifpb.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer id = 2;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("IFPB CG");
		empresa.setId(0);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("IFPB JP");
		empresa2.setId(1);
		lista.add(empresa);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(id);
		id++;
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id ) {
				it.remove();
			}
		}
	}
}
