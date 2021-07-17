package com.example.newsapp;

import java.util.ArrayList;

public class NewsModal {
    private int aa_totalResult;
    private String aa_status;
    private ArrayList<Articles> articles;

    public int getAa_totalResult() {
        return aa_totalResult;
    }

    public void setAa_totalResult(int aa_totalResult) {
        this.aa_totalResult = aa_totalResult;
    }

    public String getAa_status() {
        return aa_status;
    }

    public void setAa_status(String aa_status) {
        this.aa_status = aa_status;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    public NewsModal(int aa_totalResult, String aa_status, ArrayList<Articles> articles) {
        this.aa_totalResult = aa_totalResult;
        this.aa_status = aa_status;
        this.articles = articles;
    }
}
