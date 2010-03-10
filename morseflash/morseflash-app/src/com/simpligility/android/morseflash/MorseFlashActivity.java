package com.simpligility.android.morseflash;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import com.simpligility.android.morse.MorseCodeConverter;

public class MorseFlashActivity extends Activity
{
    MorseFlashApplication application;
    String message;
    Boolean repeat;
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morseflash);
        table = (TableLayout) findViewById(R.id.Table);
        table.setBackgroundColor(Color.WHITE);

        application = (MorseFlashApplication) getApplication();
        message = application.getMessage();
        repeat = application.getRepeat();

        long[] morseCode = MorseCodeConverter.pattern(message);

        for (int i =0; i< morseCode.length; i++)
        {
            table.setBackgroundColor(Color.GREEN);
        }



    }


}
