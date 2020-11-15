package com.paysend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "extra")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Extra {
    @XmlAttribute(name="name")
    private String name;
    @XmlValue
    private String text;
}
