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

public class PhuongTrinhBac2 extends AppCompatActivity {

    TextView lblPT2KetQua;
    Button btnPT2GiaiPT, btnPT2TiepTuc, btnPT2QuayLai;
    EditText txtPT2NhapA, txtPT2NhapB, txtPT2NhapC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_phuong_trinh_bac2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        lblPT2KetQua = (TextView) findViewById(R.id.lblPT2KetQua);
        txtPT2NhapA = (EditText) findViewById(R.id.txtPT2NhapA);
        txtPT2NhapB = (EditText) findViewById(R.id.txtPT2NhapB);
        txtPT2NhapC = (EditText) findViewById(R.id.txtPT2NhapC);
        btnPT2GiaiPT = (Button) findViewById(R.id.btnPT2GiaiPT);
        btnPT2TiepTuc = (Button) findViewById(R.id.btnPT2TiepTuc);
        btnPT2QuayLai = (Button) findViewById(R.id.btnPT2QuayLai);
    }

    private void addEvents() {
        btnPT2GiaiPT.setOnClickListener(v -> giaiPT());

        btnPT2TiepTuc.setOnClickListener(v -> tiepTuc());

        btnPT2QuayLai.setOnClickListener(v ->
                QuayLai.quayLai(PhuongTrinhBac2.this, MainActivity.class));
    }

    private double delta(int a, int b, int c) {
        return b * b - 4 * a * c;
    }

    private void giaiPT() {
        int a = Integer.parseInt(txtPT2NhapA.getText().toString());
        int b = Integer.parseInt(txtPT2NhapB.getText().toString());
        int c = Integer.parseInt(txtPT2NhapC.getText().toString());

        double x1 = (-b + Math.sqrt(delta(a, b, c))) / (2 * a);
        double x2 = (-b - Math.sqrt(delta(a, b, c))) / (2 * a);

        if (delta(a, b, c) < 0) lblPT2KetQua.setText("Phuong trinh vo nghiem");
        else if (delta(a, b, c) == 0)
            lblPT2KetQua.setText("Phuong trinh co nghiem kep x1 = x2 = " + (-b / (2 * a)));
        else lblPT2KetQua.setText("Phuong trinh co 2 nghiem phan biet x1 = "
                    + (Math.round(x1 * 100.0) / 100.0)
                    + " va x2 = " + (Math.round(x2 * 100.0) / 100.0));
    }

    private void tiepTuc() {
        txtPT2NhapA.setText("");
        txtPT2NhapB.setText("");
        txtPT2NhapC.setText("");
        lblPT2KetQua.setText("Ket qua:");
        txtPT2NhapA.requestFocus();
    }
}