package com.yyh.cold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.hmv_hreat)
    HeartMapView hmv_hreat;
    @Bind(R.id.hrap)
    HeartRateGraphView hrap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        hrap.setData(new int []{20,10,90,40,50,200,50,30,55,40});
       // hrap.setCurveColor (R.color.red);
    }
}
