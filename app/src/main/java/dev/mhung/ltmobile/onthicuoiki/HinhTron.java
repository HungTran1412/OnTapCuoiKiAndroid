package dev.mhung.ltmobile.onthicuoiki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HinhTron extends AppCompatActivity {

    private static final double PI = 3.14;
    Button btnHTQuayLai, btnHTTinh;
    TextView lblHTKetQua;
    EditText txtHTNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hinh_tron);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();

    }

    private void addEvents() {
        btnHTTinh.setOnClickListener(v -> {
            double r = Double.parseDouble(txtHTNhap.getText().toString());

            lblHTKetQua.setText("Chu vi: " + chuVi(r) + "\tDiện tích: " + dienTich(r));
        });

        btnHTQuayLai.setOnClickListener(v -> QuayLai.quayLai(HinhTron.this, MainActivity.class));
    }

    private void addViews() {
        btnHTQuayLai = (Button) findViewById(R.id.btnHTQuayLai);
        btnHTTinh = (Button) findViewById(R.id.btnHTTinh);
        lblHTKetQua = (TextView) findViewById(R.id.lblHTKetQua);
        txtHTNhap = (EditText) findViewById(R.id.txtHTNhap);
    }

    private double chuVi(double r) {
        return Math.round((2 * PI * r) * 100.0) / 100.0;
    }

    private double dienTich(double r) {
        return Math.round((PI * r * r) * 100.0) / 100.0;
    }
}