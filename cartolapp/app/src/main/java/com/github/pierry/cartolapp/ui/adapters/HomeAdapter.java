package com.github.pierry.cartolapp.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.github.pierry.cartolapp.ui.fragments.PlayerFragment_;
import com.github.pierry.cartolapp.ui.fragments.TeamFragment_;

public class HomeAdapter extends FragmentPagerAdapter {
  final int PAGE_COUNT = 3;
  private String tabTitles[] = new String[] { "Equipes", "Jogadores", "Perfil" };

  public HomeAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public int getCount() {
    return PAGE_COUNT;
  }

  @Override public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return new TeamFragment_();
      case 1:
        return new PlayerFragment_();
      case 2:
        return new PlayerFragment_();
    }
    return new TeamFragment_();
  }

  @Override public CharSequence getPageTitle(int position) {
    return tabTitles[position];
  }
}