/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class HardwareHdCli {

    Conversor conv = new Conversor();
    Looca looca = new Looca();
    MensagensSlack slack = new MensagensSlack();

    public void ExibeHD() {

        // Informações sobre o DISCO
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

        List<Disco> discos = grupoDeDiscos.getDiscos();

        System.out.println("\n");
        for (Disco disco : discos) {
            System.out.println(String.format("----- INFORMACOES HD -----"
                    + "\nNome: %s"
                    + "\nModelo: %s"
                    + "\nSerial: %s"
                    + "\nTamanho: %s"
                    + "\nQuantidade de leituras: %s"
                    + "\nBytes total de leituras: %s"
                    + "\nQuantidade de escritas: %s", disco.getNome(),
                    disco.getModelo(), disco.getSerial(), Conversor.formatarBytes(disco.getTamanho()),
                    conv.formatarBytes(disco.getLeituras()), conv.formatarBytes(disco.getBytesDeLeitura()),
                     conv.formatarBytes(disco.getEscritas())));
            System.out.println("\n");
        }

        // Informações sobre o tipo de disco, 
        DiscosGroup grupoDeVolumes = looca.getGrupoDeDiscos();
        List<Volume> volumes = grupoDeVolumes.getVolumes();

        // for avançado para Setar Textos -> JLabel
        for (Volume vol : volumes) {
            System.out.println("\nTipo: " + volumes.get(0).getTipo());
            System.out.println("\nPonto de montagem: " + volumes.get(0).getPontoDeMontagem());

            Long disp = volumes.get(0).getDisponivel();
            Long total = volumes.get(0).getTotal();

            var teste = (disp * 100) / total;
            int valor = (int) teste;

            System.out.println(valor);
        }
    }
}
