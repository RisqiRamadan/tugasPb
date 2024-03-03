package com.example.christiandior;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

public class MainActivity extends AppCompatActivity {

    private TextView kuantitasTextView, tvresult;
    private Button btnMin, btnAdd;
    private int kuantitas = 0;
    private RadioGroup radioGroup;
    private RadioButton radioBtn1, radioBtn2, radioBtn3;
    private LinearLayout llProduk1, llProduk2, llProduk3, llProduk4, llProduk5, llProduk6, llProduk7, llProduk8, llProduk9, llProduk10, llProduk11, llProduk12;


    private StringBuilder receiptBuilder = new StringBuilder();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.christiandior.R.layout.activity_main);

        tvresult = findViewById(R.id.tvresult);

        radioGroup = findViewById(R.id.radioGroup);
        radioBtn1 = findViewById(R.id.radioBtn1);
        radioBtn2 = findViewById(R.id.radioBtn2);
        radioBtn3 = findViewById(R.id.radioBtn3);

        llProduk1 = findViewById(R.id.ll_produk1);
        llProduk2 = findViewById(R.id.ll_produk2);
        llProduk3 = findViewById(R.id.ll_produk3);
        llProduk4 = findViewById(R.id.ll_produk4);
        llProduk5 = findViewById(R.id.ll_produk5);
        llProduk6 = findViewById(R.id.ll_produk6);
        llProduk7 = findViewById(R.id.ll_produk7);
        llProduk8 = findViewById(R.id.ll_produk8);
        llProduk9 = findViewById(R.id.ll_produk9);
        llProduk10 = findViewById(R.id.ll_produk10);
        llProduk11 = findViewById(R.id.ll_produk11);
        llProduk12 = findViewById(R.id.ll_produk12);


        // Menambahkan listener untuk RadioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which RadioButton is checked and filter products accordingly
                if (checkedId == R.id.radioBtn1) {
                    filterProducts("Cowo");
                } else if (checkedId == R.id.radioBtn2) {
                    filterProducts("Cewe");
                } else if (checkedId == R.id.radioBtn3) {
                    filterProducts("Kids");
                }
            }
        });



        kuantitasTextView = findViewById(R.id.kuantitas);
        btnMin = findViewById(R.id.btn_min);
        btnAdd = findViewById(R.id.btn_add);

        // Mengatur nilai awal kuantitas pada TextView
        kuantitasTextView.setText(String.valueOf(kuantitas));

        // Menambahkan fungsi klik untuk tombol kurang (btnMin)
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kurangiKuantitas();
            }
        });

        // Menambahkan fungsi klik untuk tombol tambah (btnAdd)
        btnAdd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                tambahKuantitas();

            }
        });
    }

    private void kurangiKuantitas() {
        if (kuantitas > 0) {
            kuantitas--;
            kuantitasTextView.setText(String.valueOf(kuantitas));
        }
    }

    private void tambahKuantitas() {
        kuantitas++;
        kuantitasTextView.setText(String.valueOf(kuantitas));
        hitungTotalHarga();

    }
    private void hitungTotalHarga() {
        // Mendapatkan nilai harga dari TextView
        WindowDecorActionBar.TabImpl tvHargaPerUnit;
        String hargaText = "12.600.000";

        // Menghilangkan karakter non-digit agar dapat diubah menjadi double
        hargaText = hargaText.replaceAll("[^\\d.]", "");

        // Konversi ke tipe data double
        double hargaPerUnit = Double.parseDouble(hargaText);

        // Hitung total harga
        double totalHarga = kuantitas * hargaPerUnit;

        // Tampilkan atau gunakan totalHarga sesuai kebutuhan aplikasi Anda
        Toast.makeText(this, "Total Harga: Rp " + totalHarga, Toast.LENGTH_SHORT).show();
    }

    private void filterProducts(String tag) {
        llProduk1.setVisibility(llProduk1.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk2.setVisibility(llProduk2.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk3.setVisibility(llProduk3.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk4.setVisibility(llProduk4.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk5.setVisibility(llProduk5.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk6.setVisibility(llProduk6.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk7.setVisibility(llProduk7.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk8.setVisibility(llProduk8.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk9.setVisibility(llProduk9.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk10.setVisibility(llProduk10.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk11.setVisibility(llProduk11.getTag().equals(tag) ? View.VISIBLE : View.GONE);
        llProduk12.setVisibility(llProduk12.getTag().equals(tag) ? View.VISIBLE : View.GONE);

    }
}
