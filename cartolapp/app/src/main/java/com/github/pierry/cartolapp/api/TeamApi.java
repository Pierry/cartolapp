package com.github.pierry.cartolapp.api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.github.pierry.cartolapp.api.contracts.IApi;
import com.github.pierry.cartolapp.api.contracts.IPlayerApi;
import com.github.pierry.cartolapp.api.contracts.ITeamApi;
import com.github.pierry.cartolapp.domain.Team;
import com.github.pierry.cartolapp.domain.contracts.ITeamRepository;
import com.github.pierry.cartolapp.repositories.TeamRepository;
import com.github.pierry.cartolapp.ui.adapters.SearchTeamAdapter;
import com.github.pierry.cartolapp.ui.adapters.TeamAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Response;
import java.lang.reflect.Modifier;
import java.util.List;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean public class TeamApi implements ITeamApi {

  @Bean(Api.class) IApi api;
  @Bean(PlayerApi.class) IPlayerApi playerApi;
  @Bean(TeamRepository.class) ITeamRepository teamRepository;

  @Override public void get(final Context context, String team, final RecyclerView recyclerView) {
    String urlFull = ApiConstraints.TEAM.concat(team);
    api.getArray(urlFull).setCallback(new FutureCallback<Response<JsonArray>>() {
      @Override public void onCompleted(Exception e, Response<JsonArray> result) {
        if (e != null) {
          return;
        }
        int code = result.getHeaders().code();
        switch (code) {
          case 200:
            Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
            TypeToken listType = new TypeToken<List<Team>>() {
            };
            List<Team> teams = (List<Team>) gson.fromJson(result.getResult(), listType.getType());
            SearchTeamAdapter teamAdapter = new SearchTeamAdapter(context, teams, teamRepository);
            recyclerView.setAdapter(teamAdapter);
            break;
          case 404:
            break;
        }
      }
    });
  }
}
