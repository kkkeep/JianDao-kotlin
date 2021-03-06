package com.jy.jiandao.home;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.jy.jiandao.R;
import com.jy.jiandao.data.repository.NewsPageRepository;
import com.jy.jiandao.home.recommend.RecommendFragment;
import com.mr.k.mvp.base.BaseActivity;
import com.mr.k.mvp.base.BaseFragment;
import com.mr.k.mvp.manager.MvpFragmentManager;
import com.mr.k.mvp.widget.bottomtab.BottomTabLayout;

/*
 * created by Cherry on 2020-01-06
 **/
public class HomeActivity extends BaseActivity {

    private BottomTabLayout bottomTabLayout;


    private BaseFragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        bottomTabLayout = findViewById(R.id.main_bottom_tab_layout);


        bottomTabLayout.setOnTabSelectListener(new BottomTabLayout.OnTabSelectListener() {
            @Override
            public void select(int id) {
                switch (id){
                    case R.id.mvp_tab_layout_tab1:{
                      mCurrentFragment =   MvpFragmentManager.addOrShowFragment(getSupportFragmentManager(), RecommendFragment.class, mCurrentFragment, R.id.home_fragment_container);
                        break;
                    }

                    case R.id.mvp_tab_layout_tab2:{

                        break;
                    }

                    case R.id.mvp_tab_layout_tab3:{
                        break;
                    }
                }

            }
        });


        bottomTabLayout.select(R.id.mvp_tab_layout_tab1);








    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        NewsPageRepository.destroy();
    }
}
