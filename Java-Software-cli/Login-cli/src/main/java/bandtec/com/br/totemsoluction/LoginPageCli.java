/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.entity.Usuario;
import bandtec.com.br.totemsoluction.persistence.UsuarioDao;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LoginPageCli {

    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        String login = "";
        String senha = "";
        UsuarioDao usuarioDao = new UsuarioDao();

        System.out.println("Bem vindo ao TotemSolutions!");
        System.out.println("\nDigite seu login: ");
        login = leitor.next();
        System.out.println("Digite sua senha: ");
        senha = leitor.next();
        Usuario usuario = new Usuario(login, senha);
        ProcessosTelaInicialCli tela = new ProcessosTelaInicialCli();
        Integer escolha = 0;

        Usuario autentificacao = usuarioDao.autentificacaoDeUsuario(usuario);

        if (autentificacao != null) {
            System.out.println("Bem vindo! " + usuario);
            System.out.println("1 - Detalhes do hardware\n"
                    + "2 - Detalhes de processos");
            escolha = leitor.nextInt();
            if (escolha == 1) {
                tela.DetalhesDosHardwares();
            } else if (escolha == 2) {
                tela.DetalhesDosProcessos();
            } else {
                System.out.println("Digite uma opção válida!");
            }
        } else {
            System.out.println("Login e/ou senha inválidos");
        }
    }

}
