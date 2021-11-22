/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;

/**
 *
 * @author Wesley
 */
public class HardwareMemoriaCli {
    Conversor conv = new Conversor();
    Memoria memoria = new Memoria();
    MensagensSlack slack = new MensagensSlack();
    
    public void ExibeMemoria() {       
        String memTot = conv.formatarBytes(memoria.getTotal());
        System.out.println("----- INFORMÇÕES DA MEMÓRIA -----");
        
        System.out.print(String.format("Memória em uso: %d", ((memoria.getEmUso() * 100) / memoria.getTotal()) + 1));
        System.out.println("%");
        //pbEmUso2.setValue((int) ((memoria.getEmUso() * 100) / memoria.getTotal()) + 1);
        System.out.print(String.format("Memória disponível: %d", ((memoria.getDisponivel() * 100) / memoria.getTotal())));
        System.out.println("%");
        //pbDisponivel.setValue((int) ((memoria.getDisponivel() * 100) / memoria.getTotal()));
        System.out.println(String.format("Memória total: %s", memTot));
        //labelTotal.setText(conv.formatarBytes(memoria.getTotal()));
    }
}
