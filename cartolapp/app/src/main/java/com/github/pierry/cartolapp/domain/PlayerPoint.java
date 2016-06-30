package com.github.pierry.cartolapp.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

public class PlayerPoint {

  @SerializedName(value = "apelido") String nickName;
  @SerializedName(value = "pontuacao") String points;
}
