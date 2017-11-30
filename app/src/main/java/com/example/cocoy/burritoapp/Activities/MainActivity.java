package com.example.cocoy.burritoapp.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cocoy.burritoapp.Adapters.MyImageAdapter;
import com.example.cocoy.burritoapp.LoginActivity;
import com.example.cocoy.burritoapp.R;
import com.example.cocoy.burritoapp.SignupActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] imageArray= {R.drawable.irish,R.drawable.promo1,R.drawable.promo2};
    private ArrayList<Integer> imagelist = new ArrayList<Integer>();

    CardView cardQR,cardCategories,cardPromos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardCategories = (CardView) findViewById(R.id.cardCategories);
        cardPromos = (CardView) findViewById(R.id.cardPromos);
        cardQR = (CardView) findViewById(R.id.cardQR);

        cardPromos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PromotionsActivity.class);
                startActivity(intent);

            }
        });

        cardQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        cardCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CategoryActivity.class);
                startActivity(intent);

            }
        });

        init();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.optionsmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mSearch:
               // Toast.makeText(this, "You Clicked " + item.getItemId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                // do whatever
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init() {
        for(int i=0;i<imageArray.length;i++)
            imagelist.add(imageArray[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyImageAdapter(MainActivity.this,imagelist));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == imageArray.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
}
