package com.a1techandroid.test_preperation_app.Custom;

public class HistoryModel {
    String name, date, result, leve;

    public HistoryModel() {
    }

    public HistoryModel(String name, String date, String result, String leve) {
        this.name = name;
        this.date = date;
        this.result = result;
        this.leve = leve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLeve() {
        return leve;
    }

    public void setLeve(String leve) {
        this.leve = leve;
    }
}
