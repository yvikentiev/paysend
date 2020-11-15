package com.paysend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {
    @XmlElement(name="request-type")
    private String requestType;
    @XmlElement(name="name")
    private String name;
}
