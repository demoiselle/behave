//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.13 at 12:00:05 PM BRT 
//


package com.ibm.rqm.xml.bind;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://jazz.net/xmlns/alm/qm/v0.1/}reportableArtifact">
 *       &lt;sequence>
 *         &lt;element name="webId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}title"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://jazz.net/xmlns/alm/v0.1/}updated"/>
 *         &lt;element name="creationtime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="resolvedtime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}description"/>
 *         &lt;element name="summary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://purl.org/dc/elements/1.1/}creator"/>
 *         &lt;element name="authorid">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute ref="{http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://jazz.net/xmlns/alm/v0.1/}owner"/>
 *         &lt;element name="ownerid">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute ref="{http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resolverid">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute ref="{http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="stateid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://jazz.net/xmlns/alm/v0.1/}state"/>
 *         &lt;element name="severity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filedagainst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plannedfor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="duedate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="tags" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oldstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statechangedate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="changestates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="changestate" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="stateid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="oldstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="newstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="statechangedate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://jazz.net/xmlns/alm/qm/v0.1/}customAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "webId",
    "title",
    "type",
    "updated",
    "creationtime",
    "resolvedtime",
    "description",
    "summary",
    "creator",
    "authorid",
    "owner",
    "ownerid",
    "resolution",
    "resolverid",
    "stateid",
    "state",
    "severity",
    "priority",
    "filedagainst",
    "plannedfor",
    "duedate",
    "tags",
    "oldstate",
    "statechangedate",
    "changestates",
    "customAttributes"
})
@XmlRootElement(name = "workitem")
public class Workitem
    extends ReportableArtifact
{

    protected Integer webId;
    @XmlElement(namespace = "http://purl.org/dc/elements/1.1/", required = true)
    protected String title;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(namespace = "http://jazz.net/xmlns/alm/v0.1/", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updated;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationtime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar resolvedtime;
    @XmlElement(namespace = "http://purl.org/dc/elements/1.1/", required = true)
    protected String description;
    @XmlElement(required = true)
    protected String summary;
    @XmlElement(namespace = "http://purl.org/dc/elements/1.1/", required = true)
    protected Creator creator;
    @XmlElement(required = true)
    protected Workitem.Authorid authorid;
    @XmlElement(namespace = "http://jazz.net/xmlns/alm/v0.1/", required = true)
    protected Owner owner;
    @XmlElement(required = true)
    protected Workitem.Ownerid ownerid;
    @XmlElement(required = true)
    protected String resolution;
    @XmlElement(required = true)
    protected Workitem.Resolverid resolverid;
    @XmlElement(required = true)
    protected String stateid;
    @XmlElement(namespace = "http://jazz.net/xmlns/alm/v0.1/", required = true)
    protected State state;
    @XmlElement(required = true)
    protected String severity;
    @XmlElement(required = true)
    protected String priority;
    @XmlElement(required = true)
    protected String filedagainst;
    @XmlElement(required = true)
    protected String plannedfor;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar duedate;
    @XmlElement(required = true)
    protected String tags;
    @XmlElement(required = true)
    protected String oldstate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar statechangedate;
    @XmlElement(required = true)
    protected Workitem.Changestates changestates;
    protected CustomAttributes customAttributes;

    /**
     * Gets the value of the webId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWebId() {
        return webId;
    }

    /**
     * Sets the value of the webId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWebId(Integer value) {
        this.webId = value;
    }

    /**
     * [READ-ONLY] A name given to the workitem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * [READ-ONLY] XML dateTime of the last update of the workitem.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdated() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdated(XMLGregorianCalendar value) {
        this.updated = value;
    }

    /**
     * Gets the value of the creationtime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationtime() {
        return creationtime;
    }

    /**
     * Sets the value of the creationtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationtime(XMLGregorianCalendar value) {
        this.creationtime = value;
    }

    /**
     * Gets the value of the resolvedtime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getResolvedtime() {
        return resolvedtime;
    }

    /**
     * Sets the value of the resolvedtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResolvedtime(XMLGregorianCalendar value) {
        this.resolvedtime = value;
    }

    /**
     * [READ-ONLY] An account of the workitem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * [READ-ONLY] [IMMUTABLE] The contributor that created the work item.
     * 
     * @return
     *     possible object is
     *     {@link Creator }
     *     
     */
    public Creator getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Creator }
     *     
     */
    public void setCreator(Creator value) {
        this.creator = value;
    }

    /**
     * Gets the value of the authorid property.
     * 
     * @return
     *     possible object is
     *     {@link Workitem.Authorid }
     *     
     */
    public Workitem.Authorid getAuthorid() {
        return authorid;
    }

    /**
     * Sets the value of the authorid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Workitem.Authorid }
     *     
     */
    public void setAuthorid(Workitem.Authorid value) {
        this.authorid = value;
    }

    /**
     * [READ-ONLY] The contributor that owns the work item.
     * 
     * @return
     *     possible object is
     *     {@link Owner }
     *     
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link Owner }
     *     
     */
    public void setOwner(Owner value) {
        this.owner = value;
    }

    /**
     * Gets the value of the ownerid property.
     * 
     * @return
     *     possible object is
     *     {@link Workitem.Ownerid }
     *     
     */
    public Workitem.Ownerid getOwnerid() {
        return ownerid;
    }

    /**
     * Sets the value of the ownerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Workitem.Ownerid }
     *     
     */
    public void setOwnerid(Workitem.Ownerid value) {
        this.ownerid = value;
    }

    /**
     * Gets the value of the resolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolution(String value) {
        this.resolution = value;
    }

    /**
     * Gets the value of the resolverid property.
     * 
     * @return
     *     possible object is
     *     {@link Workitem.Resolverid }
     *     
     */
    public Workitem.Resolverid getResolverid() {
        return resolverid;
    }

    /**
     * Sets the value of the resolverid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Workitem.Resolverid }
     *     
     */
    public void setResolverid(Workitem.Resolverid value) {
        this.resolverid = value;
    }

    /**
     * Gets the value of the stateid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateid() {
        return stateid;
    }

    /**
     * Sets the value of the stateid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateid(String value) {
        this.stateid = value;
    }

    /**
     * [READ-ONLY] The name of the current state of the workitem.
     * 
     * @return
     *     possible object is
     *     {@link State }
     *     
     */
    public State getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link State }
     *     
     */
    public void setState(State value) {
        this.state = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Gets the value of the filedagainst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiledagainst() {
        return filedagainst;
    }

    /**
     * Sets the value of the filedagainst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiledagainst(String value) {
        this.filedagainst = value;
    }

    /**
     * Gets the value of the plannedfor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlannedfor() {
        return plannedfor;
    }

    /**
     * Sets the value of the plannedfor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlannedfor(String value) {
        this.plannedfor = value;
    }

    /**
     * Gets the value of the duedate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDuedate() {
        return duedate;
    }

    /**
     * Sets the value of the duedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDuedate(XMLGregorianCalendar value) {
        this.duedate = value;
    }

    /**
     * Gets the value of the tags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTags() {
        return tags;
    }

    /**
     * Sets the value of the tags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTags(String value) {
        this.tags = value;
    }

    /**
     * Gets the value of the oldstate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldstate() {
        return oldstate;
    }

    /**
     * Sets the value of the oldstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldstate(String value) {
        this.oldstate = value;
    }

    /**
     * Gets the value of the statechangedate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatechangedate() {
        return statechangedate;
    }

    /**
     * Sets the value of the statechangedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatechangedate(XMLGregorianCalendar value) {
        this.statechangedate = value;
    }

    /**
     * Gets the value of the changestates property.
     * 
     * @return
     *     possible object is
     *     {@link Workitem.Changestates }
     *     
     */
    public Workitem.Changestates getChangestates() {
        return changestates;
    }

    /**
     * Sets the value of the changestates property.
     * 
     * @param value
     *     allowed object is
     *     {@link Workitem.Changestates }
     *     
     */
    public void setChangestates(Workitem.Changestates value) {
        this.changestates = value;
    }

    /**
     * [READ-ONLY] A user defined name/value pair associated with the workitem.
     * 
     * @return
     *     possible object is
     *     {@link CustomAttributes }
     *     
     */
    public CustomAttributes getCustomAttributes() {
        return customAttributes;
    }

    /**
     * Sets the value of the customAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomAttributes }
     *     
     */
    public void setCustomAttributes(CustomAttributes value) {
        this.customAttributes = value;
    }


    /**
     * [DEPRECATED] [READ-ONLY] [IMMUTABLE] The Jazz Team Server (JTS) user ID of the contributor that authored the work item.  Note, this property was deprecated in RQM 2.0.  Use dc:creator.
     * 
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute ref="{http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Authorid {

        @XmlValue
        protected String content;
        @XmlAttribute(namespace = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
        @XmlSchemaType(name = "anyURI")
        protected String resource;

        /**
         * [DEPRECATED] [READ-ONLY] [IMMUTABLE] The Jazz Team Server (JTS) user ID of the contributor that authored the work item.  Note, this property was deprecated in RQM 2.0.  Use dc:creator.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        /**
         * [DEPRECATED] [READ-ONLY] [IMMUTABLE] The Jazz Team Server (JTS) URL of the contributor that authored the work item.  Note, this property was deprecated in RQM 2.0.  Use dc:creator.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResource() {
            return resource;
        }

        /**
         * Sets the value of the resource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResource(String value) {
            this.resource = value;
        }

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
     *         &lt;element name="changestate" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="stateid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="oldstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="newstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="statechangedate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "changestate"
    })
    public static class Changestates {

        @XmlElement(required = true)
        protected List<Workitem.Changestates.Changestate> changestate;

        /**
         * Gets the value of the changestate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the changestate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChangestate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Workitem.Changestates.Changestate }
         * 
         * 
         */
        public List<Workitem.Changestates.Changestate> getChangestate() {
            if (changestate == null) {
                changestate = new ArrayList<Workitem.Changestates.Changestate>();
            }
            return this.changestate;
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
         *         &lt;element name="stateid" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="oldstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="newstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="statechangedate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
            "stateid",
            "oldstate",
            "newstate",
            "statechangedate"
        })
        public static class Changestate {

            @XmlElement(required = true)
            protected String stateid;
            @XmlElement(required = true)
            protected String oldstate;
            @XmlElement(required = true)
            protected String newstate;
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar statechangedate;

            /**
             * Gets the value of the stateid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStateid() {
                return stateid;
            }

            /**
             * Sets the value of the stateid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStateid(String value) {
                this.stateid = value;
            }

            /**
             * Gets the value of the oldstate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOldstate() {
                return oldstate;
            }

            /**
             * Sets the value of the oldstate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOldstate(String value) {
                this.oldstate = value;
            }

            /**
             * Gets the value of the newstate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNewstate() {
                return newstate;
            }

            /**
             * Sets the value of the newstate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNewstate(String value) {
                this.newstate = value;
            }

            /**
             * Gets the value of the statechangedate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getStatechangedate() {
                return statechangedate;
            }

            /**
             * Sets the value of the statechangedate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStatechangedate(XMLGregorianCalendar value) {
                this.statechangedate = value;
            }

        }

    }


    /**
     * [DEPRECATED] [READ-ONLY] The Jazz Team Server (JTS) user ID of the contributor that owns the work item.  Note, this property was deprecated in RQM 2.0.  Use alm:owner.
     * 
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute ref="{http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Ownerid {

        @XmlValue
        protected String content;
        @XmlAttribute(namespace = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
        @XmlSchemaType(name = "anyURI")
        protected String resource;

        /**
         * [DEPRECATED] [READ-ONLY] The Jazz Team Server (JTS) user ID of the contributor that owns the work item.  Note, this property was deprecated in RQM 2.0.  Use alm:owner.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        /**
         * [DEPRECATED] [READ-ONLY] The Jazz Team Server (JTS) URL of the contributor that owns the work item.  Note, this property was deprecated in RQM 2.0.  Use alm:owner.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResource() {
            return resource;
        }

        /**
         * Sets the value of the resource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResource(String value) {
            this.resource = value;
        }

    }


    /**
     * [READ-ONLY] The Jazz Team Server (JTS) user ID of the contributor that resolved the work item.
     * 
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute ref="{http://www.w3.org/1999/02/22-rdf-syntax-ns#}resource"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Resolverid {

        @XmlValue
        protected String content;
        @XmlAttribute(namespace = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
        @XmlSchemaType(name = "anyURI")
        protected String resource;

        /**
         * [READ-ONLY] The Jazz Team Server (JTS) user ID of the contributor that resolved the work item.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        /**
         * [READ-ONLY] The Jazz Team Server (JTS) URL of the contributor that resolved the work item.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResource() {
            return resource;
        }

        /**
         * Sets the value of the resource property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResource(String value) {
            this.resource = value;
        }

    }

}
