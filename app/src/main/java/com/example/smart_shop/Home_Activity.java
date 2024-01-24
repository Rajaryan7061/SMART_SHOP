package com.example.smart_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Activity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener   {

  FrameLayout frame_layout_one;

  BottomNavigationView bottomNavigationView;
   // private BottomNavigationView.OnNavigationItemSelectedListener selectedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

      //  bottomNavigationView
           //     .setOnNavigationItemSelectedListener(this);
       // bottomNavigationView.setSelectedItemId(R.id.home_button);

       frame_layout_one=(FrameLayout) findViewById(R.id.frame_layout_one);
     bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigationView);
     bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }
    ListproductFragment listproductFragment = new ListproductFragment();
    HomeFragment homeFragment=new HomeFragment();
   // loadFragment(new HomeFragment());
    ShopFragment shopFragment = new ShopFragment();
    public  boolean onNavigationItemSelected(MenuItem item){

        int id = item.getItemId();
        if(id==R.id.home_button){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_one,homeFragment)
                    .commit();
            return  true;
        } else if(id==R.id.list_pdt) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_one,listproductFragment)
                    .commit();
            return true;


        } else if (id==R.id.make_shop) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_one,shopFragment)
                    .commit();
            return true;

        } else {
            System.out.println("raj");
        }
        return true;
    }

}