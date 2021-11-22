/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class ProcessosCli {
    Looca looca = new Looca();
    MensagensSlack slack = new MensagensSlack();
    
    public void teste() {
        ProcessosGroup processosGroup = looca.getGrupoDeProcessos();
        List<Processo> processos = processosGroup.getProcessos();

        String txtFinal = "";

        for (Processo processo : processos) {

            txtFinal += "Nome: " + processo.getNome() + "\nPID: " + processo.getPid() + "\n\n";
        }
        System.out.println(txtFinal);
        //txConteudo.setText("<html><body>processosGroup.<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br>noite<br></body></html>");
    }
}
