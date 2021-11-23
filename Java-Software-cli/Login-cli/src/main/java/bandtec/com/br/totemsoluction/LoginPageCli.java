/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.entity.Usuario;
import bandtec.com.br.totemsoluction.persistence.MaquinaDao;
import bandtec.com.br.totemsoluction.persistence.ProcessosMaquinaDao;
import bandtec.com.br.totemsoluction.persistence.UsuarioDao;
import com.github.britooo.looca.api.core.Looca;
import java.util.Scanner;

public class LoginPageCli {

    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        String login = "";
        String senha = "";
        UsuarioDao usuarioDao = new UsuarioDao();
        MaquinaDao maquinaCl = new MaquinaDao();
        ProcessosMaquinaDao processos01 = new ProcessosMaquinaDao();
        Looca looca = new Looca();
        Boolean repeat = true;

        System.out.println("Bem vindo ao TotemSolutions!");
        System.out.println("\nDigite seu login: ");
        login = leitor.next();
        System.out.println("Digite sua senha: ");
        senha = leitor.next();
        Usuario usuario = new Usuario(login, senha);
        ProcessosTelaInicialCli tela = new ProcessosTelaInicialCli();

        Usuario autentificacao = usuarioDao.autentificacaoDeUsuario(usuario);

        System.out.println("Bem vindo! " + usuario.getLogin());
        do {
            if (autentificacao != null) {
                System.out.println("\n"
                        + "1 - Detalhes do hardware\n"
                        + "2 - Detalhes de processos");

                Integer escolha = leitor.nextInt();

                switch (escolha) {
                    case 1:
                        tela.DetalhesDosHardwares();
                        maquinaCl.insertInfoMaquina(looca, 500);
                        break;

                    case 2:
                        tela.DetalhesDosProcessos();
                        processos01.insertProcessosMaquina(looca, 500);
                        break;

                    default:
                        System.out.println("Digite uma opção válida!");
                        repeat = false;
                        break;
                }
            } else {
                System.out.println("Login e/ou senha inválidos");
            }
        } while (repeat);
    }

}
