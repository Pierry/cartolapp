package com.github.pierry.cartolapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.github.pierry.cartolapp.ui.ToolbarBase;
import com.github.pierry.cartolapp.ui.fragments.HomeFragment_;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main) public class MainActivity extends AppCompatActivity {

  @ViewById Toolbar toolbar;

  @Bean(ToolbarBase.class) ToolbarBase toolbarBase;

  @AfterViews void init() {
    toolbar.setTitle(R.string.app_name);
    setSupportActionBar(toolbar);
    toolbarBase.injectToolbar(toolbar, this);
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    HomeFragment_ fragment = new HomeFragment_();
    transaction.replace(R.id.content_fragment, fragment);
    transaction.commit();
  }
}

