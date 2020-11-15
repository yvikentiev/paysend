package com.paysend.test.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement(localName = "request")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    @JacksonXmlProperty(localName="request-type")
    private String requestType;
    @JacksonXmlProperty(localName="extra")
    private Extra login;
   /* @JacksonXmlProperty(localName="extra")
    private Extra password;*/
}
