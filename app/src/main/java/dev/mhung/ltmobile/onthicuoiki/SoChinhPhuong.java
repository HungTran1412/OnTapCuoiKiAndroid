package dev.mhung.ltmobile.onthicuoiki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SoChinhPhuong extends AppCompatActivity {

    TextView lblSoCPKetQua;
    EditText txtSoCPNhap;
    Button btnSoCPKiemTra, btnSoCPQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_so_chinh_phuong);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        lblSoCPKetQua = (TextView) findViewById(R.id.lblSoCPKetQua);
        txtSoCPNhap = (EditText) findViewById(R.id.txtSoCPNhap);
        btnSoCPKiemTra = (Button) findViewById(R.id.btnSoCPKiemTra);
        btnSoCPQuayLai = (Button) findViewById(R.id.btnSoCPQuayLai);
    }

    private void addEvents() {
        btnSoCPKiemTra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(txtSoCPNhap.getText().toString());
                if (Math.sqrt(n) % 1 == 0) {
                    lblSoCPKetQua.setText("Kết quả: Số chính phương");
                } else {
                    lblSoCPKetQua.setText("Kết quả: Không phải số chính phương");
                }
            }
        });

        btnSoCPQuayLai.setOnClickListener(v ->
                QuayLai.quayLai(SoChinhPhuong.this, MainActivity.class));
    }
}