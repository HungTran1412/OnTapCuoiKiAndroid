package dev.mhung.ltmobile.onthicuoiki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HinhTamGiac extends AppCompatActivity {

    EditText txtHTGNhapA, txtHTGNhapB, txtHTGNhapC, txtHTGChuVi, txtHTGDienTich;
    Button btnHTGTinh, btnHTGXoaTrang, btnHTGQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hinh_tam_giac);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addEvents() {
        btnHTGTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtHTGNhapA.getText().toString());
                double b = Double.parseDouble(txtHTGNhapB.getText().toString());
                double c = Double.parseDouble(txtHTGNhapC.getText().toString());

                HTG htg = new HTG(a,b,c);
                if (htg.kiemTraTG() == true) {
                    txtHTGChuVi.setText((Math.round(htg.tinhChuVi() * 100.0)/100.0) + "");
                    txtHTGDienTich.setText((Math.round(htg.tinhDienTich() * 100.0) / 100.0) + "");
                }else{
                    Toast.makeText(HinhTamGiac.this, "Khong phai tam giac", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHTGXoaTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHTGNhapA.setText("");
                txtHTGNhapB.setText("");
                txtHTGNhapC.setText("");
                txtHTGChuVi.setText("");
                txtHTGDienTich.setText("");
                txtHTGNhapA.requestFocus();
            }
        });

        btnHTGQuayLai.setOnClickListener(v -> QuayLai.quayLai(HinhTamGiac.this, MainActivity.class));
    }

    private void addViews() {
        txtHTGNhapA = (EditText) findViewById(R.id.txtHTGNhapA);
        txtHTGNhapB = (EditText) findViewById(R.id.txtHTGNhapB);
        txtHTGNhapC = (EditText) findViewById(R.id.txtHTGNhapC);
        txtHTGChuVi = (EditText) findViewById(R.id.txtHTGChuVi);
        txtHTGChuVi.setEnabled(false);
        txtHTGChuVi.setFocusable(false);

        txtHTGDienTich = (EditText) findViewById(R.id.txtHTGDienTich);
        txtHTGDienTich.setEnabled(false);
        txtHTGDienTich.setFocusable(false);

        btnHTGTinh = (Button) findViewById(R.id.btnHTGTinh);
        btnHTGXoaTrang = (Button) findViewById(R.id.btnHTGXoaTrang);
        btnHTGQuayLai = (Button) findViewById(R.id.btnHTGQuayLai);
    }


}