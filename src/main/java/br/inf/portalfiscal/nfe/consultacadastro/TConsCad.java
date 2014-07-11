//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.09 at 08:22:07 PM BRT 
//


package br.inf.portalfiscal.nfe.consultacadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Tipo Pedido de Consulta de cadastro de contribuintes
 * 
 * <p>Java class for TConsCad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TConsCad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infCons">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="xServ">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TServ">
 *                         &lt;enumeration value="CONS-CAD"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfCons"/>
 *                   &lt;choice>
 *                     &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIe"/>
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVar"/>
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVar"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerConsCad" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TConsCad", propOrder = {
    "infCons"
})
@XmlRootElement(name = "ConsCad")
public class TConsCad {

    @XmlElement(required = true)
    protected TConsCad.InfCons infCons;
    @XmlAttribute(name = "versao", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String versao;

    /**
     * Gets the value of the infCons property.
     * 
     * @return
     *     possible object is
     *     {@link TConsCad.InfCons }
     *     
     */
    public TConsCad.InfCons getInfCons() {
        return infCons;
    }

    /**
     * Sets the value of the infCons property.
     * 
     * @param value
     *     allowed object is
     *     {@link TConsCad.InfCons }
     *     
     */
    public void setInfCons(TConsCad.InfCons value) {
        this.infCons = value;
    }

    /**
     * Gets the value of the versao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Sets the value of the versao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersao(String value) {
        this.versao = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="xServ">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TServ">
     *               &lt;enumeration value="CONS-CAD"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="UF" type="{http://www.portalfiscal.inf.br/nfe}TUfCons"/>
     *         &lt;choice>
     *           &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIe"/>
     *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjVar"/>
     *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpfVar"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "xServ",
        "uf",
        "ie",
        "cnpj",
        "cpf"
    })
    public static class InfCons {

        @XmlElement(required = true)
        protected String xServ;
        @XmlElement(name = "UF", required = true)
        protected TUfCons uf;
        @XmlElement(name = "IE")
        protected String ie;
        @XmlElement(name = "CNPJ")
        protected String cnpj;
        @XmlElement(name = "CPF")
        protected String cpf;

        /**
         * Gets the value of the xServ property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXServ() {
            return xServ;
        }

        /**
         * Sets the value of the xServ property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXServ(String value) {
            this.xServ = value;
        }

        /**
         * Gets the value of the uf property.
         * 
         * @return
         *     possible object is
         *     {@link TUfCons }
         *     
         */
        public TUfCons getUF() {
            return uf;
        }

        /**
         * Sets the value of the uf property.
         * 
         * @param value
         *     allowed object is
         *     {@link TUfCons }
         *     
         */
        public void setUF(TUfCons value) {
            this.uf = value;
        }

        /**
         * Gets the value of the ie property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIE() {
            return ie;
        }

        /**
         * Sets the value of the ie property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIE(String value) {
            this.ie = value;
        }

        /**
         * Gets the value of the cnpj property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCNPJ() {
            return cnpj;
        }

        /**
         * Sets the value of the cnpj property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCNPJ(String value) {
            this.cnpj = value;
        }

        /**
         * Gets the value of the cpf property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCPF() {
            return cpf;
        }

        /**
         * Sets the value of the cpf property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCPF(String value) {
            this.cpf = value;
        }

    }

}
