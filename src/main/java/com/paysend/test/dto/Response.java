package com.paysend.test.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "response")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {
    @JacksonXmlProperty(localName="request-type")
    private String requestType;
    @JacksonXmlProperty(localName="name")
    private String name;
}
