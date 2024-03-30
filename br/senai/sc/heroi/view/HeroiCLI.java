package br.senai.sc.heroi.view;

import java.util.Scanner;
import br.senai.sc.heroi.model.Heroi;

public class HeroiCLI {
    private Scanner leitor;

    public HeroiCLI() {
        this.leitor = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\033[0;104m --------- MENU -------- \033[0m");
        System.out.println("\033[0;35m 1 - Adicionar");
        System.out.println(" 2 - Listar");
        System.out.println(" 3 - Sair ");
    }

    public String obterCodigoOperacao() {
        System.out.print("Escolha a opção: \033[0m");
        String opcao = leitor.nextLine();
        System.out.println();
        return opcao.trim();
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirMensagemSucesso(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirMensagemInfo(String mensagem) {
        System.out.println(mensagem);
    }

    public void aguardar() {
        System.out.println();
        System.out.println("\033[0;33mPressione qualquer tecla para continuar... \033[0m");
        leitor.nextLine();

    }

    public Heroi obterDados() {

        System.out.println("Informe o nome: ");
        System.out.print("\033[0;32m");
        String nome = leitor.nextLine();
        System.out.println("\033[0m");
        System.out.print("Informe o Superpoder: ");
        System.out.println("\033[0;32m");
        String sp = leitor.nextLine();
        System.out.println("\033[0m");
        System.out.println("Informe a Idade: ");
        System.out.print("\033[0;32m");
        int idade = leitor.nextInt();
        leitor.nextLine();
        System.out.println("\033[0m");
        return new Heroi(nome, sp, idade);
    }

    public void exibirDados(Heroi heroi) {
        System.out.println(String.format("\033[0;32mHerói: %s, superpoder: %s, idade: %d \033[0m", heroi.getNome(),
                heroi.getSuperpoder(), heroi.getIdade()));
        System.out.println();
    }

    public void fecharScanner() {
        leitor.close();
    }
}