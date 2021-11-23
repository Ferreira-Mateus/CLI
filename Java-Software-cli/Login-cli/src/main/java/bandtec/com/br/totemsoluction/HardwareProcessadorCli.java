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
public class HardwareProcessadorCli {
    Looca looca = new Looca();
    MensagensSlack slack = new MensagensSlack();
    
    public void ExibeProcesso() {
        System.out.println("\n");
        System.out.println(String.format("----- INFORMACOES PROCESSADOR -----"
                + "\nFabricante: %s"
                + "\nNome: %s"
                + "\nIdentificador: %s"
                + "\nMicro Arquitetura: %s"
                + "\nFrequência: %s"
                + "\nNº de pacotes físicos: %s"
                + "\nNº de CPU físicos: %s"
                + "\nNº de CPU lógicos: %s",looca.getProcessador().getFabricante(),
        looca.getProcessador().getNome(), looca.getProcessador().getIdentificador(),
        looca.getProcessador().getMicroarquitetura(), looca.getProcessador().getFrequencia(),
        looca.getProcessador().getNumeroPacotesFisicos(), looca.getProcessador().getNumeroCpusFisicas(),
        looca.getProcessador().getNumeroCpusLogicas()));
        
        Double uso = looca.getProcessador().getUso();
        Integer usoProc = uso.intValue();

        System.out.println("Uso: " + usoProc);
    }
}
