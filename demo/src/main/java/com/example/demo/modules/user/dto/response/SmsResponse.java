package com.example.demo.modules.user.dto.response;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@XmlRootElement(name = "REPLY")
@XmlAccessorType(XmlAccessType.FIELD)
public class SmsResponse {
    @XmlElement(name = "PARAMETER")
    private String parameter;

    @XmlElement(name = "LOGIN")
    private String login;

    @XmlElement(name = "PUSHAPI")
    private String pushApi;

    @XmlElement(name = "STAKEHOLDERID")
    private String stakeHolderId;

    @XmlElement(name = "PERMITTED")
    private String permitted;

    @XmlElement(name = "SMSINFO")
    private SmsInfo smsInfo;
}
