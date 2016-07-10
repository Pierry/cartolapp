package com.github.pierry.cartolapp.ui.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import at.markushi.ui.CircleButton;
import com.github.pierry.cartolapp.R;
import com.github.pierry.cartolapp.api.TeamApi;
import com.github.pierry.cartolapp.api.contracts.ITeamApi;
import com.github.pierry.cartolapp.domain.Team;
import com.github.pierry.cartolapp.domain.contracts.ITeamRepository;
import com.github.pierry.cartolapp.repositories.TeamRepository;
import com.github.pierry.cartolapp.ui.SearchTeamActivity_;
import com.github.pierry.cartolapp.ui.adapters.TeamAdapter;
import com.github.pierry.fitloader.RotateLoading;
import java.util.List;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@OptionsMenu(R.menu.home_menu) @EFragment(R.layout.fragment_team) public class TeamFragment
    extends Fragment {

  @ViewById RecyclerView recyclerView;
  @ViewById RelativeLayout body;
  @ViewById RotateLoading rotateLoading;
  @ViewById CircleButton action;

  @Bean(TeamApi.class) ITeamApi teamApi;
  @Bean(TeamRepository.class) ITeamRepository teamRepository;

  @AfterViews void init() {
    loadRecyclerViewConfig();
  }

  @Click void action() {
    startActivity(new Intent(getActivity(), SearchTeamActivity_.class));
  }

  @UiThread void loadRecyclerViewConfig() {
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    loadItems();
  }

  @Background void loadItems() {
    try {
      List<Team> teams = teamRepository.get();
      loadAdapter(teams);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @UiThread void loadAdapter(List<Team> teams) {
    TeamAdapter teamAdapter = new TeamAdapter(getActivity(), teams);
    recyclerView.setAdapter(teamAdapter);
  }

  @OptionsItem(R.id.actionRefresh) void refresh() {
    loadItems();
  }
}