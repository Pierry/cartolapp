package com.github.pierry.cartolapp.api;

import com.github.pierry.cartolapp.api.contracts.IApi;
import com.github.pierry.cartolapp.api.contracts.IPlayerApi;
import com.github.pierry.cartolapp.domain.contracts.IPlayerRepository;
import com.github.pierry.cartolapp.repositories.PlayerRepository;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Response;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean public class PlayerApi implements IPlayerApi {

  @Bean(Api.class) IApi api;
  @Bean(PlayerRepository.class) IPlayerRepository playerRepository;

  @Override public void get(String team) {
    String urlFull = ApiConstraints.TEAM_PLAYERS.concat(team);
    api.getObject(urlFull).setCallback(new FutureCallback<Response<JsonObject>>() {
      @Override public void onCompleted(Exception e, Response<JsonObject> result) {
        if (e == null) {
          return;
        }
        int code = result.getHeaders().code();
        switch (code) {
          case 200:
            // deserialize
            // save
            break;
          case 404:
            break;
        }
      }
    });
  }
}
