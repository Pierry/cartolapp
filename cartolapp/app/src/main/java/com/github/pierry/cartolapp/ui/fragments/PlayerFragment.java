package com.github.pierry.cartolapp.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.pierry.cartolapp.R;
import com.github.pierry.cartolapp.api.PlayerApi;
import com.github.pierry.cartolapp.api.contracts.IPlayerApi;
import com.github.pierry.cartolapp.domain.Player;
import com.github.pierry.cartolapp.domain.contracts.IClubRepository;
import com.github.pierry.cartolapp.domain.contracts.IPlayerRepository;
import com.github.pierry.cartolapp.repositories.ClubRepository;
import com.github.pierry.cartolapp.repositories.PlayerRepository;
import com.github.pierry.cartolapp.ui.adapters.PlayerAdapter;
import com.github.pierry.fitloader.RotateLoading;
import java.util.List;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@OptionsMenu(R.menu.home_menu) @EFragment(R.layout.fragment_players) public class PlayerFragment
    extends Fragment {

  @ViewById RecyclerView recyclerView;
  @ViewById RelativeLayout body;
  @ViewById RotateLoading rotateLoading;
  @ViewById TextView empty;

  @Bean(PlayerApi.class) IPlayerApi playerApi;
  @Bean(PlayerRepository.class) IPlayerRepository playerRepository;
  @Bean(ClubRepository.class) IClubRepository clubRepository;

  @AfterViews void init() {
    loadRecyclerViewConfig();
  }

  @UiThread void loadRecyclerViewConfig() {
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    loadItems();
  }

  @Background void loadItems() {
    try {
      List<Player> players = playerRepository.get();
      if (players == null || players.size() == 0) {
        empty.setVisibility(View.VISIBLE);
      } else {
        empty.setVisibility(View.INVISIBLE);
      }
      loadAdapter(players);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @UiThread void loadAdapter(List<Player> players) {
    PlayerAdapter playerAdapter = new PlayerAdapter(getActivity(), players, clubRepository);
    recyclerView.setAdapter(playerAdapter);
  }

  @OptionsItem(R.id.actionRefresh) void refresh() {
    loadItems();
  }
}
