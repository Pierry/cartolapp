package com.github.pierry.cartolapp.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.astuetz.PagerSlidingTabStrip;
import com.github.pierry.cartolapp.R;
import com.github.pierry.cartolapp.ui.ToolbarBase;
import com.github.pierry.cartolapp.ui.adapters.HomeAdapter;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_home) public class HomeFragment extends Fragment implements OnPageChangeListener {

  @ViewById PagerSlidingTabStrip tabs;
  @ViewById ViewPager pager;

  @Bean(ToolbarBase.class) ToolbarBase toolbarBase;

  @AfterViews void init() {
    SystemBarTintManager tintManager = new SystemBarTintManager(getActivity());
    tintManager.setStatusBarTintEnabled(true);
    pager.setAdapter(new HomeAdapter(getActivity().getSupportFragmentManager()));
    tabs.setViewPager(pager);
    tabs.setTextColorResource(R.color.silver);
    tabs.setDividerColor(android.R.color.transparent);
    final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4,
        getResources().getDisplayMetrics());
    pager.setPageMargin(pageMargin);
    pager.setCurrentItem(0);
    toolbarBase.changeColor(tabs, tintManager, getResources().getColor(R.color.colorPrimary));
    tabs.setOnPageChangeListener(this);
  }

  @Override
  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    LinearLayout layout = (LinearLayout) tabs.getChildAt(0);
    for (int i = 0; i < layout.getChildCount(); i++) {
      TextView tv = (TextView) layout.getChildAt(i);
      if (i == position) {
        tv.setTextColor(getResources().getColor(R.color.icons));
      } else {
        tv.setTextColor(getResources().getColor(R.color.silver));
      }
    }
  }

  @Override public void onPageSelected(int position) {

  }

  @Override public void onPageScrollStateChanged(int state) {

  }
}
