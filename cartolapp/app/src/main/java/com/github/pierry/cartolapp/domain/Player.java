package com.github.pierry.cartolapp.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Player") public class Player extends Model {

  @Column(name = "PlayerId") String playerId;
  @Column(name = "Name") String name;
  @Column(name = "Photo") String photo;
  @Column(name = "Price") double price;
  @Column(name = "Var") double var;
  @Column(name = "Average") double average;
  @Column(name = "Matches") double matches;

  public Player() {
    super();
  }

  public String getPlayerId() {
    return playerId;
  }

  public void setPlayerId(String playerId) {
    this.playerId = playerId;
  }

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
