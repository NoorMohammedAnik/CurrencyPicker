package com.anik.currencypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mynameismidori.currencypicker.CurrencyPicker;
import com.mynameismidori.currencypicker.CurrencyPickerListener;

public class MainActivity extends AppCompatActivity {


    Button btnCurrnecy;
    TextView txtCurrency;
    ImageView imgFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCurrnecy=findViewById(R.id.btn_currency);
        txtCurrency=findViewById(R.id.txt_currency);
        imgFlag=findViewById(R.id.img_flag);

        final CurrencyPicker picker = CurrencyPicker.newInstance("Select Currency");  // dialog title

        btnCurrnecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                picker.setListener(new CurrencyPickerListener() {
                    @Override
                    public void onSelectCurrency(String name, String code, String symbol, int flagDrawableResID) {
                        // Implement your code here

                        Toast.makeText(MainActivity.this, "Name:"+name+"\nCode: "+code+"\nSymbol:"+symbol, Toast.LENGTH_SHORT).show();

                        txtCurrency.setText("Name:"+name+"\nCode: "+code+"\nSymbol:"+symbol);
                        imgFlag.setImageResource(flagDrawableResID);
                        picker.dismiss();

                    }

                });
                picker.show(getSupportFragmentManager(), "CURRENCY_PICKER");
            }
        });

    }
}
