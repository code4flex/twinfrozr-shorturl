package com.twinfrozr.shorturl.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * IpInfo
 *
 * @author mavin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpInfo implements Serializable {
    private static final long serialVersionUID = 7949269311264822292L;

    private String ip;
    private String pro;
    private String proCode;
    private String city;
    private String cityCode;
    private String addr;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
