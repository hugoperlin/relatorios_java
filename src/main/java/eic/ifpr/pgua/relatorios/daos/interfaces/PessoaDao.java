package eic.ifpr.pgua.relatorios.daos.interfaces;

import java.util.ArrayList;

import eic.ifpr.pgua.relatorios.models.Pessoa;

public interface PessoaDao {
    ArrayList<Pessoa> listar() throws Exception;
}
