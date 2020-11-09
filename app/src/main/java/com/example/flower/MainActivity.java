package com.example.flower;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout homeLinear;
    LinearLayout textLinear;
    LinearLayout talkLinear;
    LinearLayout myLinear;

    Fragment1 homeFragment;
    Fragment2 textFragment;
    Fragment3 talkFragment;
    Fragment4 myFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeLinear=findViewById(R.id.homeLinear);
        textLinear=findViewById(R.id.textLinear);
        talkLinear=findViewById(R.id.talkLinear);
        myLinear=findViewById(R.id.myLinear);

        homeLinear.setOnClickListener(this);
        textLinear.setOnClickListener(this);
        talkLinear.setOnClickListener(this);
        myLinear.setOnClickListener(this);

        fragmentManager=getSupportFragmentManager();
        homeLinear.performClick();
    }
    public void onClick(View view){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction(); //只能是局部变量,不能为全局变量，否则不能重复commit  FragmentTransaction只能使用一次
        hideAllFragment(fragmentTransaction);
        switch (view.getId()){
            case R.id.homeLinear:
                setAllFalse();
                homeLinear.setSelected(true);
                if (homeFragment==null){
                    homeFragment=new Fragment1("Home");
                    fragmentTransaction.add(R.id.frame,homeFragment);
                }
                else{
                    fragmentTransaction.show(homeFragment);
                }
                break;

            case R.id.textLinear:
                setAllFalse();
                textLinear.setSelected(true);
                if (textFragment==null){
                    textFragment=new Fragment2("Home");
                    fragmentTransaction.add(R.id.frame,textFragment);
                }
                else{
                    fragmentTransaction.show(textFragment);
                }
                break;

            case R.id.talkLinear:
                setAllFalse();
                talkLinear.setSelected(true);
                if (talkFragment==null){
                    talkFragment=new Fragment3("Home");
                    fragmentTransaction.add(R.id.frame,talkFragment);
                }
                else{
                    fragmentTransaction.show(talkFragment);
                }
                break;

            case R.id.myLinear:
                setAllFalse();
                myLinear.setSelected(true);
                if (myFragment==null){
                    myFragment=new Fragment4("Home");
                    fragmentTransaction.add(R.id.frame,myFragment);
                }
                else{
                    fragmentTransaction.show(myFragment);
                }
                break;
        }
        fragmentTransaction.commit();  //必须commit，否则没效果
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if (homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if (textFragment!=null){
            fragmentTransaction.hide(textFragment);
        }
        if (talkFragment!=null){
            fragmentTransaction.hide(talkFragment);
        }
        if (myFragment!=null){
            fragmentTransaction.hide(myFragment);
        }
    }
    private void setAllFalse(){
        homeLinear.setSelected(false);
        textLinear.setSelected(false);
        talkLinear.setSelected(false);
        myLinear.setSelected(false);
    }
}