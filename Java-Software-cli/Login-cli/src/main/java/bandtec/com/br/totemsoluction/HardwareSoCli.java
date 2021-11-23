/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import com.github.britooo.looca.api.core.Looca;

/**
 *
 * @author Wesley
 */
public class HardwareSoCli {
    Looca looca = new Looca();
    MensagensSlack slack = new MensagensSlack();
    
    public void ExibirSo() {
        System.out.println("\n");
        System.out.println(String.format("----- INFORMACOES DO SISTEMA OPERACIONAL -----"
                + "\nSistema operacional: %s"
                + "\nFabricante: %s"
                + "\nArquitetura: %d bits"
                + "\nInicializado: %s"
                + "\nTempo de atividade: %s", looca.getSistema().getSistemaOperacional(),
                looca.getSistema().getFabricante(), looca.getSistema().getArquitetura(),
                looca.getSistema().getInicializado(), looca.getSistema().getTempoDeAtividade()));
        System.out.println(("Executando como " + (looca.getSistema().getPermissao() ? "root" : "usuário padrão")));
        
        
    }
}
