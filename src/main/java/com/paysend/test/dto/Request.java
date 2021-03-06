package com.paysend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement(name = "request")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    @XmlElement(name="request-type")
    private String requestType;
    @XmlElement(name="extra")
    private Extra login;
   /* @JacksonXmlProperty(localName="extra")
    private Extra password;*/
}
