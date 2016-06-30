package com.github.pierry.cartolapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RelativeLayout;
import com.github.pierry.cartolapp.MainActivity_;
import com.github.pierry.cartolapp.R;
import com.github.pierry.cartolapp.api.TeamApi;
import com.github.pierry.cartolapp.api.contracts.ITeamApi;
import com.github.pierry.cartolapp.domain.contracts.ITeamRepository;
import com.github.pierry.cartolapp.repositories.TeamRepository;
import com.github.pierry.fitloader.RotateLoading;
import com.rengwuxian.materialedittext.MaterialEditText;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_team_search) public class SearchTeamActivity
    extends AppCompatActivity {

  @ViewById RecyclerView recyclerView;
  @ViewById RelativeLayout body;
  @ViewById RotateLoading rotateLoading;
  @ViewById MaterialEditText teamRequest;
  @ViewById Toolbar toolbar;

  @Bean(TeamApi.class) ITeamApi teamApi;
  @Bean(TeamRepository.class) ITeamRepository teamRepository;

  @AfterViews void initAfterText() {
    toolbar.setTitle(R.string.add_team);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    final Context context = this;
    loadRecyclerViewConfig();
    teamRequest.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override public void afterTextChanged(Editable editable) {
        if (editable.toString().length() > 3) {
          String text = editable.toString();
          teamApi.get(context, text, recyclerView);
        }
      }
    });
  }

  @UiThread void loadRecyclerViewConfig() {
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
  }

  @OptionsItem(android.R.id.home) void home() {
    startActivity(new Intent(this, MainActivity_.class));
  }

  @Override public void onBackPressed() {
    startActivity(new Intent(this, MainActivity_.class));
  }
}