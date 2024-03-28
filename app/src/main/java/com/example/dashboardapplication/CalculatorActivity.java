package com.example.dashboardapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity {

    ImageView imageView, btnBack;
    TextView title, result;
    EditText input1, input2, input3;
    Button submit;

    String type;
    int inputCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation_activity);

        type = Objects.requireNonNull(getIntent().getStringExtra("type"));

        imageView = findViewById(R.id.shape);
        result = findViewById(R.id.result);
        title = findViewById(R.id.shapeTitle);
        btnBack = findViewById(R.id.btnBack);

        input1 = findViewById(R.id.input_1);
        input2 = findViewById(R.id.input_2);
        input3 = findViewById(R.id.input_3);
        submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(this::submitClick);

        setType();
        setInput();

        btnBack.setOnClickListener(v -> onBackPressed());
    }


    private void submitClick(View v) {
        if (!cekInputTerisi()) {
            Snackbar.make(v, "Input tidak boleh kosong.", Snackbar.LENGTH_SHORT).show();
            return;
        }

        result.setText(String.format("Hasil: %.2fcm", hitungHasil()));

    }

    private boolean cekInputTerisi() {
        switch (inputCount) {
            case 1:
                return !input1.getText().toString().isEmpty() && !input1.getText().toString().equals("-");
            case 2:
                return !input1.getText().toString().isEmpty() && !input2.getText().toString().isEmpty() && !input1.getText().toString().equals("-") && !input2.getText().toString().equals("-");
            case 3:
                return !input1.getText().toString().isEmpty() && !input2.getText().toString().isEmpty() && !input3.getText().toString().isEmpty() && !input1.getText().toString().equals("-") && !input2.getText().toString().equals("-") && !input3.getText().toString().equals("-");
            default:
                return false;
        }
    }

    private double hitungHasil() {
        double angka1, angka2, angka3;
        double hasil = 0;

        switch (type) {
            case "triangle":
                angka1 = Double.parseDouble(input1.getText().toString());
                angka2 = Double.parseDouble(input2.getText().toString());
                hasil = 0.5 * angka1 * angka2;
                break;
            case "square":
                angka1 = Double.parseDouble(input1.getText().toString());
                angka2 = Double.parseDouble(input2.getText().toString());
                hasil = angka1 * angka2;
                break;
            case "circle":
                angka1 = Double.parseDouble(input1.getText().toString());
                hasil = Math.PI * Math.pow(angka1, 2);
                break;
            case "cube":
                angka1 = Double.parseDouble(input1.getText().toString());
                angka2 = Double.parseDouble(input2.getText().toString());
                angka3 = Double.parseDouble(input3.getText().toString());
                hasil = angka1 * angka2 * angka3;
                break;
            case "pyramid":
                angka1 = Double.parseDouble(input1.getText().toString());
                angka2 = Double.parseDouble(input2.getText().toString());
                hasil = 0.333 * angka1 * angka2;
                break;
            case "sphere":
                angka1 = Double.parseDouble(input1.getText().toString());
                hasil = 1.33 * Math.PI * Math.pow(angka1, 3);
                break;
        }
        return hasil;
    }

    private void setInput() {
        switch (inputCount) {
            case 1:
                input1.setVisibility(View.VISIBLE);
                input2.setVisibility(View.GONE);
                input3.setVisibility(View.GONE);
                break;
            case 2:
                input1.setVisibility(View.VISIBLE);
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.GONE);
                break;
            case 3:
                input1.setVisibility(View.VISIBLE);
                input2.setVisibility(View.VISIBLE);
                input3.setVisibility(View.VISIBLE);
                break;
            default:
                input1.setVisibility(View.GONE);
                input2.setVisibility(View.GONE);
                input3.setVisibility(View.GONE);
        }
    }


    private void setType() {
        switch (this.type) {
            case "triangle":
                title.setText("Luas Segitiga");
                imageView.setImageResource(R.drawable.triangle);
                input1.setHint("Masukan alas (cm)");
                input2.setHint("Masukan tinggi (cm)");
                inputCount = 2;
                break;
            case "square":
                title.setText("Luas Persegi/Panjang");
                imageView.setImageResource(R.drawable.square);
                input1.setHint("Masukan panjang (cm)");
                input2.setHint("Masukan lebar (cm)");
                inputCount = 2;
                break;
            case "circle":
                title.setText("Luas Lingkaran");
                imageView.setImageResource(R.drawable.circle);
                input1.setHint("Masukan jari-jari (cm)");
                inputCount = 1;
                break;
            case "cube":
                title.setText("Volume Kubus/Balok");
                imageView.setImageResource(R.drawable.cube);
                input1.setHint("Masukan panjang (cm)");
                input2.setHint("Masukan lebar (cm)");
                input3.setHint("Masukan tinggi (cm)");
                inputCount = 3;
                break;
            case "pyramid":
                title.setText("Volume Limas Segitiga");
                imageView.setImageResource(R.drawable.pyramid);
                input1.setHint("Masukan luas alas (cm²)");
                input2.setHint("Masukan keliling alas (cm)");
                input3.setHint("Masukan tinggi (cm)");
                inputCount = 2;
                break;
            case "sphere":
                title.setText("Volume Bola");
                imageView.setImageResource(R.drawable.ball);
                input1.setHint("Masukan jari-jari (cm)");
                inputCount = 1;
                break;
            default:
                title.setText("Perhitungan tidak diketahui");
                inputCount = 0;
                break;
        }
    }
}

