package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Button;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public double tipercentage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EditText editBillAmount = findViewById(R.id.baseBillInput);
        TextView totalAmount = findViewById(R.id.totaldisplay);
        TextView tipamount = findViewById(R.id.tipAmountDisplay);
        Button buttonCalculate = findViewById(R.id.CalButton);

        SeekBar tipPercentage = findViewById(R.id.seekBarTip);
        TextView percentageStatus = findViewById(R.id.Percentage);



        percentageStatus.setText(String.format("%.0f",tipercentage) + "%");

        tipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progess, boolean b) {
                tipercentage = progess;
                percentageStatus.setText( String.format("%.0f",tipercentage) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String billAmountStr = editBillAmount.getText().toString().trim();


                double billAmount = Double.parseDouble(billAmountStr);
                double tipAmount  =billAmount * (tipercentage / 100);
                double total = tipAmount + billAmount;

                tipamount.setText("" +tipAmount);
                totalAmount.setText("" + total);

            }
        });






    }




}