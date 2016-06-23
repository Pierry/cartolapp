package com.github.pierry.cartolapp.api.contracts;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Response;

public interface ITeamApi {

  void get(String team);
}
