package com.paysend.test.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "extra")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Extra {
    @JacksonXmlProperty(localName="name",isAttribute = true)
    private String name;
    @JacksonXmlText
    private String text;
}
