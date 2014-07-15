package br.com.linepack.classes;

import br.inf.portalfiscal.nfe.consultaservico.TConsStatServ;
import br.inf.portalfiscal.nfe.consultaservico.TRetConsStatServ;
import br.inf.portalfiscal.wsdl.consultaservico.NfeCabecMsg;
import br.inf.portalfiscal.wsdl.consultaservico.NfeDadosMsg;
import br.inf.portalfiscal.wsdl.consultaservico.NfeStatusServico2;
import br.inf.portalfiscal.wsdl.consultaservico.NfeStatusServico2Soap12;
import br.inf.portalfiscal.wsdl.consultaservico.NfeStatusServicoNF2Result;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.Holder;



public class ConsultaServico {

    public static void processa() throws JAXBException, IOException {

        //System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");        

        // Solicitação
        NfeDadosMsg nfeDadosMsg = createNfeDadosMsg();
        Holder<NfeCabecMsg> nfeCabecMsg = new Holder<>(createNfeCabecMsg());
        NfeStatusServico2Soap12 consulta = new NfeStatusServico2().getNfeStatusServicoServicePort();
        NfeStatusServicoNF2Result nfeStatusServicoNF2Result = consulta.nfeStatusServicoNF2(nfeDadosMsg, nfeCabecMsg);

        for (Object ob : nfeStatusServicoNF2Result.getContent()) {
            TRetConsStatServ retConsStatServ;
            retConsStatServ = (TRetConsStatServ) ob;           

            JAXBContext contexto = JAXBContext.newInstance(br.inf.portalfiscal.nfe.consultaservico.ObjectFactory.class);
            Marshaller m = contexto.createMarshaller();
            m.marshal(retConsStatServ, System.out);
        }

    }

    /* */
    private static NfeDadosMsg createNfeDadosMsg() {
        NfeDadosMsg dadosMsg = new NfeDadosMsg();
        TConsStatServ consStatServ = new TConsStatServ();
        consStatServ.setCUF("41");
        consStatServ.setTpAmb("2");
        consStatServ.setVersao("2.00");
        consStatServ.setXServ("STATUS");
        dadosMsg.getContent().add(consStatServ);
        return dadosMsg;
    }

    private static NfeCabecMsg createNfeCabecMsg() {
        NfeCabecMsg cabecMsg = new NfeCabecMsg();
        cabecMsg.setCUF("41");
        cabecMsg.setVersaoDados("2.00");
        return cabecMsg;
    }  

}
