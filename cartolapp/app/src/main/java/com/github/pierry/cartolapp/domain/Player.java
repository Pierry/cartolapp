package com.github.pierry.cartolapp.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

@Table(name = "Player") public class Player extends Model {

  @SerializedName(value = "atleta_id") @Column(name = "PlayerId") String playerId;
  @SerializedName(value = "nome") @Column(name = "Name") String name;
  @SerializedName(value = "foto") @Column(name = "Photo") String photo;
  @SerializedName(value = "preco_num") @Column(name = "Price") double price;
  @SerializedName(value = "time_id") @Column(name = "Var") double var;
  @SerializedName(value = "time_id") @Column(name = "Average") double average;
  @SerializedName(value = "time_id") @Column(name = "Points") double points;
  @SerializedName(value = "time_id") @Column(name = "Matches") double matches;
  @SerializedName(value = "time_id") @Column(name = "ClubId") long clubId;

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

  public long getClubId() {
    return clubId;
  }

  public void setClubId(long clubId) {
    this.clubId = clubId;
  }

  public double getPoints() {
    return points;
  }

  public void setPoints(double points) {
    this.points = points;
  }
}
