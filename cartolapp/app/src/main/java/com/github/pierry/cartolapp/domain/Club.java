package com.github.pierry.cartolapp.domain;

public class Club {

  private int clubId;
  private String name;
  private String abbr;
  private String image;

  public int getClubId() {
    return clubId;
  }

  public void setClubId(int clubId) {
    this.clubId = clubId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbbr() {
    return abbr;
  }

  public void setAbbr(String abbr) {
    this.abbr = abbr;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
