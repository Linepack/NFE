package br.com.linepack.classes;

import br.inf.portalfiscal.nfe.consultacadastro.TConsCad;
import br.inf.portalfiscal.nfe.consultacadastro.TRetConsCad;
import br.inf.portalfiscal.nfe.consultacadastro.TUfCons;
import br.inf.portalfiscal.wsdl.consultacadastro.CadConsultaCadastro2;
import br.inf.portalfiscal.wsdl.consultacadastro.CadConsultaCadastro2Soap12;
import br.inf.portalfiscal.wsdl.consultacadastro.ConsultaCadastro2Result;
import br.inf.portalfiscal.wsdl.consultacadastro.NfeCabecMsg;
import br.inf.portalfiscal.wsdl.consultacadastro.NfeDadosMsg;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.Holder;

public class ConsultaCadastro {

    public static void processa() throws JAXBException {
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");          
        
        NfeDadosMsg nfeDadosMsg = createNfeDadosMsg();
        Holder<NfeCabecMsg> holderNfeCabecMsg = new Holder<>(createNfeCabecMsg());        
        CadConsultaCadastro2 consulta = new CadConsultaCadastro2();
        CadConsultaCadastro2Soap12 soap12 =  consulta.getCadConsultaCadastro2Soap12();
        ConsultaCadastro2Result consultaCadastro2 = soap12.consultaCadastro2(nfeDadosMsg, holderNfeCabecMsg);                        
        
        for (Object ob : consultaCadastro2.getContent()){
            TRetConsCad retConsCad =  (TRetConsCad) ob;
            
            JAXBContext context =  JAXBContext.newInstance(TRetConsCad.class);
            Marshaller m = context.createMarshaller();
            m.marshal(retConsCad, System.out);
            
        }
        
    }

    private static NfeDadosMsg createNfeDadosMsg() {        
        NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        TConsCad consCad = new TConsCad();
        consCad.setVersao("2.00");

        TConsCad.InfCons infCons = new TConsCad.InfCons();        
        infCons.setXServ("CONS-CAD");        
        infCons.setUF(TUfCons.PR);
        infCons.setCNPJ("01733454000134");

        consCad.setInfCons(infCons);
        nfeDadosMsg.getContent().add(consCad);       
        return nfeDadosMsg;
    }
    
    
    private static NfeCabecMsg createNfeCabecMsg(){
        NfeCabecMsg nfeCabecMsg = new NfeCabecMsg();
        nfeCabecMsg.setCUF("41");
        nfeCabecMsg.setVersaoDados("2.00");
        
        return nfeCabecMsg;
        
                
    }

}
