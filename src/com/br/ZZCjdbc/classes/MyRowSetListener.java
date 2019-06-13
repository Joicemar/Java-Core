package com.br.ZZCjdbc.classes;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyRowSetListener implements RowSetListener {

	@Override
	public void rowSetChanged(RowSetEvent event) {
		/* Executado quando a linha inteira foi modificada */
		System.out.println("comando execute executado");

	}

	@Override
	public void rowChanged(RowSetEvent event) {
		System.out.println("linha foi atualizada, inserida ou deletada");
		if(event.getSource() instanceof RowSet) {
			try {
				((RowSet) event.getSource()).execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		/* Toda vez que o cursos mover */
		System.out.println("Cursor moveu");

	}

}
