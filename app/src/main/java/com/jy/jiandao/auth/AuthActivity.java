package com.jy.jiandao.auth;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.jy.jiandao.auth.login.VerificationLoginFragment;
import com.mr.k.mvp.base.BaseActivity;
import com.mr.k.mvp.manager.MvpFragmentManager;

/*
 * created by Cherry on 2019-12-27
 **/
public class AuthActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_auth);

        MvpFragmentManager.addOrShowFragment(getSupportFragmentManager(), VerificationLoginFragment.class,null, android.R.id.content );
    }
}
