package com.twinfrozr.shorturl.restful.controller.command;

import java.io.Serializable;

/**
 * urlCommand
 *
 * @author marvin
 */
public class UrlCommand implements Serializable {

    private String url;
    private GenType type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GenType getType() {
        return type;
    }

    public void setType(GenType type) {
        this.type = type;
    }
}
