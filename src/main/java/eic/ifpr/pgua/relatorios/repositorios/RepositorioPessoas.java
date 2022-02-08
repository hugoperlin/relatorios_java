package eic.ifpr.pgua.relatorios.repositorios;

import java.util.ArrayList;

import eic.ifpr.pgua.relatorios.daos.interfaces.PessoaDao;
import eic.ifpr.pgua.relatorios.models.Pessoa;

public class RepositorioPessoas {
    
    private PessoaDao pessoaDao;

    public RepositorioPessoas(PessoaDao pessoaDao){
        this.pessoaDao = pessoaDao;
    }

    public ArrayList<Pessoa> listarPessoas() throws Exception{
        return pessoaDao.listar();
    }



}
