package com.github.pierry.cartolapp.api.contracts;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Response;

public interface IApi {

  Future<Response<JsonObject>> getObject(String url);

  Future<Response<JsonArray>> getArray(String url);
}
