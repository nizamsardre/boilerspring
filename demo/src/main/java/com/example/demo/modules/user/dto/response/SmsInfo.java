package com.example.demo.modules.user.dto.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class SmsInfo {
    @XmlElement(name = "MSISDN")
    private String msisdn;

    @XmlElement(name = "SMSTEXT")
    private String smsText;

    @XmlElement(name = "CSMSID")
    private String csmsid;

    @XmlElement(name = "REFERENCEID")
    private String referenceId;
}
