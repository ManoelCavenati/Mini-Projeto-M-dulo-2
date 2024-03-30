package br.senai.sc.heroi;

import java.util.List;

import br.senai.sc.heroi.exception.OperacaoInvalidaException;
import br.senai.sc.heroi.model.Heroi;
import br.senai.sc.heroi.model.Operacao;
import br.senai.sc.heroi.repository.HeroiRepository;
import br.senai.sc.heroi.view.HeroiCLI;

public class DevHeroiAplicacao {

    private HeroiCLI view = new HeroiCLI();
    private HeroiRepository repository = new HeroiRepository();

    public void executar() {

        Operacao operacao = null;

        while (operacao != Operacao.SAIR) {
            view.exibirMenu();
            operacao = obterOperacao();
            processar(operacao);
        }

        view.exibirMensagemInfo("\033[0;31mSistema encerrado!\033[0m");
    }

    private Operacao obterOperacao() {
        String opcao = view.obterCodigoOperacao();
        try {
            Operacao operacao = Operacao.converter(opcao);
            return operacao;
        } catch (OperacaoInvalidaException e) {
            return null;
        }

    }

    private void processar(Operacao operacao) {
        if (operacao == null) {
            view.exibirMensagemErro("\033[0;31mCódigo de Operação Inválido!!! \033[0m");
            view.aguardar();
        } else if (operacao == Operacao.ADICIONAR) {
            adicionar();
        } else if (operacao == Operacao.LISTAR) {
            listar();
        }

    }

    private void adicionar() {
        Heroi heroi = view.obterDados();
        boolean isExistente = repository.existePorNome(heroi.getNome());
        if (isExistente) {
            view.exibirMensagemErro("\033[0;31mHerói já cadastrado \033[0m");
            return;
        }
        repository.adicionar(heroi);
        view.exibirMensagemSucesso("\033[0;32mHerói adicionado com sucesso! \033[0m");
        view.aguardar();
    }

    private void listar() {
        List<Heroi> lista = repository.consultar();
        if (lista.isEmpty()) {
            view.exibirMensagemErro("\033[0;33mSem heróis cadastrados para exibição! \033[0m");
            return;
        }
        for (Heroi heroi : lista) {
            view.exibirDados(heroi);
        }
    }
}
