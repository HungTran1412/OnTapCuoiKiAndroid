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

public class SoNguyenTo extends AppCompatActivity {

    TextView lblSNTKetQua;
    Button btnSNTQuayLai, btnSNTKiemTra;
    EditText txtSNTNhapN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_so_nguyen_to);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        lblSNTKetQua = (TextView) findViewById(R.id.lblSNTKetQua);
        btnSNTQuayLai = (Button) findViewById(R.id.btnSNTQuayLai);
        btnSNTKiemTra = (Button) findViewById(R.id.btnSNTKiemTra);
        txtSNTNhapN = (EditText) findViewById(R.id.txtSNTNhapN);
    }

    private void addEvents() {
        btnSNTKiemTra.setOnClickListener(v->{
            int n = Integer.parseInt(txtSNTNhapN.getText().toString());

            if(kiemTraSoNguyenTo(n) == true) lblSNTKetQua.setText("Ket qua: La so nguyen to");
            else lblSNTKetQua.setText("Ket qua: Khong phai la so nguyen to");
        });
        btnSNTQuayLai.setOnClickListener(v -> QuayLai.quayLai(SoNguyenTo.this, MainActivity.class));
    }

    private boolean kiemTraSoNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;

        return true;
    }

}