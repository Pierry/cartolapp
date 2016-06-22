package com.github.pierry.cartolapp.domain;

public class Player {

  private String name;
  private String photo;
  private double price;
  private double var;
  private double average;
  private double matches;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getVar() {
    return var;
  }

  public void setVar(double var) {
    this.var = var;
  }

  public double getAverage() {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
  }

  public double getMatches() {
    return matches;
  }

  public void setMatches(double matches) {
    this.matches = matches;
  }
}
