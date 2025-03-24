package dev.mhung.ltmobile.onthicuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnPTBac1, btnPTBac2, btnSoChinhPhuong, btnChiSoBMI, btnThoat;

    Intent intent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();

        addEvents();
    }

    private void addEvents() {
        btnPTBac1.setOnClickListener(v -> btnPTBac1());
        btnPTBac2.setOnClickListener(v -> btnPTBac2());
        btnSoChinhPhuong.setOnClickListener(v -> btnSoChinhPhuong());
        btnChiSoBMI.setOnClickListener(v -> btnChiSoBMI());

        //thoat chuong trinh
        btnThoat.setOnClickListener(v -> thoatChuongTrinh());
    }

    private void addViews() {
        btnPTBac1 = (Button) findViewById(R.id.btnPTBac1);
        btnPTBac2 = (Button) findViewById(R.id.btnPTBac2);
        btnSoChinhPhuong = (Button) findViewById(R.id.btnSoChinhPhuong);
        btnChiSoBMI = (Button) findViewById(R.id.btnChiSoBMI);
        btnThoat = (Button) findViewById(R.id.btnThoat);
    }

    private void btnPTBac1() {
        intent = new Intent(MainActivity.this, PhuongTrinhBac1.class);
        startActivity(intent);
    }

    private void btnPTBac2() {
        intent = new Intent(MainActivity.this, PhuongTrinhBac2.class);
        startActivity(intent);
    }

    private void btnSoChinhPhuong() {
        intent = new Intent(MainActivity.this, SoChinhPhuong.class);
        startActivity(intent);
    }

    private void btnChiSoBMI() {
        intent = new Intent(MainActivity.this, ChiSoBMI.class);
        startActivity(intent);
    }

    //ham thoat
    private void thoatChuongTrinh() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Xác nhận")
                .setMessage("Bạn có muốn thoát không?")
                .setPositiveButton("Có", (dialog, which) -> {
                    finishAffinity();
                }).setNegativeButton("Không", (dialog, which) -> dialog.dismiss()).show();
    }
}