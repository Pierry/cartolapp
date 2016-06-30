package com.github.pierry.cartolapp.api.contracts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Response;

public interface ITeamApi {

  void get(Context context, String team, RecyclerView recyclerView);
}
