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

public class PhuongTrinhBac1 extends AppCompatActivity {
    TextView lblPT1KetQua;
    EditText txtPT1NhapA, txtPT1NhapB;
    Button btnPT1GiaiPT, btnPT1TiepTuc, btnPT1QuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phuong_trinh_bac1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();

        addEvents();
    }

    private void addEvents() {
        btnPT1GiaiPT.setOnClickListener(v -> giaiPT());


        btnPT1TiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiepTuc();
            }
        });

        btnPT1QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuayLai.quayLai(PhuongTrinhBac1.this, MainActivity.class);
            }
        });
    }

    private void addViews() {
        lblPT1KetQua = (TextView) findViewById(R.id.lblPT1KetQua);
        txtPT1NhapA = (EditText) findViewById(R.id.txtPT1NhapA);
        txtPT1NhapB = (EditText) findViewById(R.id.txtPT1NhapB);
        btnPT1GiaiPT = (Button) findViewById(R.id.btnPT1GiaiPT);
        btnPT1TiepTuc = (Button) findViewById(R.id.btnPT1TiepTuc);
        btnPT1QuayLai = (Button) findViewById(R.id.btnPT1QuayLai);
    }

    private void giaiPT() {
        int a = Integer.parseInt(txtPT1NhapA.getText().toString());
        int b = Integer.parseInt(txtPT1NhapB.getText().toString());
        if (a == 0 && b == 0) lblPT1KetQua.setText("Phuong trinh vo so nghiem");
        else if (a == 0 && b != 0) lblPT1KetQua.setText("Phuong trinh vo nghiem");
        else lblPT1KetQua.setText("Phuong trinh co nghiem x = " + (-b / a));
    }

    private void tiepTuc() {
        txtPT1NhapA.setText("");
        txtPT1NhapB.setText("");
        lblPT1KetQua.setText("Ket qua:");
        txtPT1NhapA.requestFocus();
    }
}