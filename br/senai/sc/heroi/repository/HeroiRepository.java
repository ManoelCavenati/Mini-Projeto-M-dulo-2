package br.senai.sc.heroi.repository;

import java.util.ArrayList;
import java.util.List;

import br.senai.sc.heroi.model.Heroi;

public class HeroiRepository {

    public List<Heroi> herois = new ArrayList<>();

    public List<Heroi> consultar() {
        return herois;
    }

    public boolean existePorNome(String nome) {

        for (var heroi : herois) {
            if (heroi.getNome().equalsIgnoreCase(nome))
                return true;
        }
        return false;
    }

    public void adicionar(Heroi heroi) {
        herois.add(heroi);
    }
}
