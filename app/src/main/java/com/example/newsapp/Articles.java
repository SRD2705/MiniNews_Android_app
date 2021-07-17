package com.example.newsapp;

public class Articles {
    private String head;
    private String short_body;
    private String img_link;
    private String link;
    private String body;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getShort_body() {
        return short_body;
    }

    public void setShort_body(String short_body) {
        this.short_body = short_body;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Articles(String head, String short_body, String img_link, String link, String body) {
        this.head = head;
        this.short_body = short_body;
        this.img_link = img_link;
        this.link = link;
        this.body = body;
    }
}
