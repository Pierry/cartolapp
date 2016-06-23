package com.github.pierry.cartolapp.api;

import android.content.Context;
import com.github.pierry.cartolapp.api.contracts.IApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import org.androidannotations.annotations.EBean;

@EBean public class Api implements IApi {

  private Context context;
  private static final String GET = "GET";
  private static final String POST = "POST";
  private static final String PUT = "PUT";

  public Api(Context context) {
    this.context = context;
  }

  @Override public Future<Response<JsonObject>> getObject(String url) {
    Future<Response<JsonObject>> callback =
        Ion.with(context).load(GET, url).asJsonObject().withResponse();
    return callback;
  }

  @Override public Future<Response<JsonArray>> getArray(String url) {
    Future<Response<JsonArray>> callback =
        Ion.with(context).load(GET, url).asJsonArray().withResponse();
    return callback;
  }
}
