package com.www.tabbartry;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        position=position+1;
        if(position==1){
            home_fragment home=new home_fragment();
            return home;

        }
       else if(position==2){
            login_fragment login=new login_fragment();
            return login;

        }
       else{
           signup_fragment sign= new signup_fragment();
           return sign;
        }
//        Bundle bundle=new Bundle();
//        bundle.putString("message","Fragment:"+position);
//        home.setArguments(bundle);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position=position+1;
        if(position==1){
            return "home";
        }
      else  if(position==2){
            return "Login";
        }
      else{
            return "Sign Up";

        }
    }
}
