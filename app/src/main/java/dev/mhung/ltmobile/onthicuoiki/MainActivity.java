package dev.mhung.ltmobile.onthicuoiki;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnPTBac1, btnPTBac2, btnSoChinhPhuong, btnChiSoBMI, btnThoat;

    private int chon = 0;

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
        btnThoat.setOnClickListener(v -> thoatChuongTrinh());
    }

    private void addViews() {
        btnPTBac1 = (Button) findViewById(R.id.btnPTBac1);
        btnPTBac2 = (Button) findViewById(R.id.btnPTBac2);
        btnSoChinhPhuong = (Button) findViewById(R.id.btnSoChinhPhuong);
        btnChiSoBMI = (Button) findViewById(R.id.btnChiSoBMI);
        btnThoat = (Button) findViewById(R.id.btnThoat);
    }

    private void thoatChuongTrinh() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Xác nhận")
                .setMessage("Bạn có muốn thoát không?")
                .setPositiveButton("Có", (dialog, which) -> {
                    finishAffinity();
                }).setNegativeButton("Không", (dialog, which) -> dialog.dismiss()).show();
    }
}