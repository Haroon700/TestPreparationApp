package com.a1techandroid.test_preperation_app.Custom;

public class HistoryModel {
    String name, date, result, leve, correct , wrong;

    public HistoryModel() {
    }

    public HistoryModel(String name, String date, String result, String leve, String correct, String wrong) {
        this.name = name;
        this.date = date;
        this.result = result;
        this.leve = leve;
        this.correct = correct;
        this.wrong = wrong;
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

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }
}
