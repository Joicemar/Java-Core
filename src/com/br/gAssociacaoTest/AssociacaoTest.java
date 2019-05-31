package com.br.gAssociacaoTest;

import com.br.associacaoClasses.Aluno;
import com.br.associacaoClasses.Local;
import com.br.associacaoClasses.Professor;
import com.br.associacaoClasses.Seminario;

public class AssociacaoTest {
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno("Willian Suane", 27);
		Aluno aluno2 = new Aluno("Joana D'Arc", 20);
		
		Seminario sem = new Seminario("Como ser um baita programador e ficar rico");
		Professor prof = new Professor("Yoda","Usar a força para programar");
		Local local = new Local("Rua das Araras","mato");
		
		aluno.setSeminario(sem);
		aluno2.setSeminario(sem);;
		
		sem.setProfessor(prof);
		sem.setLocal(local);
		sem.setAlunos(new Aluno[]{aluno, aluno2});
		
		Seminario[] semArray = new Seminario[1];
		semArray[0] = sem;
		prof.setSeminario(semArray);
		
		sem.print();
		local.print();
		aluno.print();
		
	}

}
