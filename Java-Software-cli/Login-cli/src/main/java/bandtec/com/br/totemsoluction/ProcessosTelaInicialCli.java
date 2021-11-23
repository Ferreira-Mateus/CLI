/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandtec.com.br.totemsoluction;

import bandtec.com.br.totemsoluction.slack.MensagensSlack;
import com.github.britooo.looca.api.core.Looca;

public class ProcessosTelaInicialCli {

    Looca looca = new Looca();
    MensagensSlack slack = new MensagensSlack();
    Integer fkMaquina = null;
    Integer fkDisco = null;
    HardwareMemoriaCli infoMemoria = new HardwareMemoriaCli();
    HardwareSoCli infoSo = new HardwareSoCli();
    HardwareProcessadorCli infoProc = new HardwareProcessadorCli();
    HardwareHdCli infoHD = new HardwareHdCli();
    ProcessosCli infoProcessos = new ProcessosCli();
    Memoria memoriaCli = new Memoria();
    MaquinaDao maquinaCli = new MaquinaDao();
    
    public void DetalhesDosHardwares() {
        infoMemoria.ExibeMemoria();
        infoSo.ExibirSo();
        infoProc.ExibeProcesso();
        infoHD.ExibeHD();
        maquinaCli.insertInfoMaquina();
    }
    
    public void DetalhesDosProcessos() {
        infoProcessos.teste();
    }
}
