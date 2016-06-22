package com.github.pierry.cartolapp.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import com.github.pierry.cartolapp.R;
import com.github.pierry.fitloader.RotateLoading;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@OptionsMenu(R.menu.home_menu) @EFragment(R.layout.fragment_home) public class HomeFragment
    extends Fragment {

  @ViewById RecyclerView recyclerView;
  @ViewById RelativeLayout body;
  @ViewById RotateLoading rotateLoading;

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
      // todo
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @OptionsItem(R.id.actionRefresh) void refresh() {
    loadItems();
  }
}
