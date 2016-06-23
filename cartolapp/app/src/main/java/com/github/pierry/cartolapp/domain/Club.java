package com.github.pierry.cartolapp.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Club") public class Club extends Model {

  @Column(name = "ClubId") int clubId;
  @Column(name = "Name") String name;
  @Column(name = "Abbr") String abbr;
  @Column(name = "Image") String image;

  public Club() {
    super();
  }

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
