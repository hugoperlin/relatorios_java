package eic.ifpr.pgua.relatorios.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;

import eic.ifpr.pgua.relatorios.daos.interfaces.PessoaDao;
import eic.ifpr.pgua.relatorios.models.Pessoa;

public class FakePessoaDao implements PessoaDao{

    @Override
    public ArrayList<Pessoa> listar() throws Exception {
        
        ArrayList<Pessoa> lista = new ArrayList<>(); 
        
        lista.add(new Pessoa(1, "Zé", LocalDateTime.now().minusYears(10), 1.75));
        lista.add(new Pessoa(2, "Chico", LocalDateTime.now().minusYears(15), 1.65));
        lista.add(new Pessoa(3, "Maria", LocalDateTime.now().minusYears(20), 1.85));
        lista.add(new Pessoa(4, "Jão", LocalDateTime.now().minusYears(25), 1.55));
        
        return lista;
    }
    


}
