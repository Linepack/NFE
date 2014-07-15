package br.com.linepack.classes;

import br.inf.portalfiscal.nfe.nfeinutilizacao.TInutNFe;
import br.inf.portalfiscal.nfe.nfeinutilizacao.TRetInutNFe;
import br.inf.portalfiscal.wsdl.nfeinutilizacao2.NfeCabecMsg;
import br.inf.portalfiscal.wsdl.nfeinutilizacao2.NfeDadosMsg;
import br.inf.portalfiscal.wsdl.nfeinutilizacao2.NfeInutilizacao2;
import br.inf.portalfiscal.wsdl.nfeinutilizacao2.NfeInutilizacao2Soap12;
import br.inf.portalfiscal.wsdl.nfeinutilizacao2.NfeInutilizacaoNF2Result;
import javax.xml.ws.Holder;

public class InutilizaNfe {

    public static void processa() {
        
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");        

        NfeDadosMsg nfeDadosMsg = createNfeDadosMsg();
        Holder<NfeCabecMsg> holder = new Holder<>(createNfeCabecMsg());

        NfeInutilizacao2 nfeInutilizacao2 = new NfeInutilizacao2();
        NfeInutilizacao2Soap12 soap12 = nfeInutilizacao2.getNfeInutilizacaoServicePort();        
        NfeInutilizacaoNF2Result result = soap12.nfeInutilizacaoNF2(nfeDadosMsg, holder);
        
        for (Object ob : result.getContent()){
            TRetInutNFe retInutNFe = (TRetInutNFe) ob;
            System.out.println(retInutNFe.getInfInut().getXMotivo());
        }
        
    }

    private static NfeDadosMsg createNfeDadosMsg() {

        TInutNFe inutNFe = new TInutNFe();
        inutNFe.setVersao("2.00");

        TInutNFe.InfInut infInut = new TInutNFe.InfInut();
        infInut.setAno("14");
        infInut.setCNPJ("13021715000172");
        infInut.setCUF("41");
        infInut.setMod("55");
        infInut.setNNFIni("1");
        infInut.setNNFFin("1");
        infInut.setSerie("1");
        infInut.setTpAmb("2");
        infInut.setXServ("INUTILIZAR");
        infInut.setXJust("Teste de inutilização");
        infInut.setId("ID");

        inutNFe.setInfInut(infInut);
        NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.getContent().add(inutNFe);

        return nfeDadosMsg;
    }
    
    private static NfeCabecMsg createNfeCabecMsg(){
        NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();        
        nfeCabecMsg.setCUF("41");
        nfeCabecMsg.setVersaoDados("2.00");
        
        return nfeCabecMsg;
    }

}
