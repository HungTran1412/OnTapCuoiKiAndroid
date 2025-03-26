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

public class Fibonacci extends AppCompatActivity {

    EditText txtFiboNhap;
    TextView lblFiboKetQua;
    Button btnFiboKiemTra, btnFiboQuayLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kiem_tra_fibonacci);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addEvents() {
        btnFiboKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(txtFiboNhap.getText().toString());

                if(checkFibonacci(n) == true) lblFiboKetQua.setText("Ket qua: La so Fibonacci");
                else lblFiboKetQua.setText("Ket qua: Khong phai la so Fibonacci");
            }
        });
        btnFiboQuayLai.setOnClickListener(v -> QuayLai.quayLai(Fibonacci.this, MainActivity.class));
    }


    private void addViews() {
        txtFiboNhap = (EditText) findViewById(R.id.txtFiboNhap);
        lblFiboKetQua = (TextView) findViewById(R.id.lblFiboKetQua);
        btnFiboKiemTra = (Button) findViewById(R.id.btnFiboKiemTra);
        btnFiboQuayLai = (Button) findViewById(R.id.btnFiboQuayLai);
    }

    private boolean checkFibonacci(int n) {
        if (n == 0 || n == 1) return true;

        int fn1 = 1, fn2 = 1, fn = 0;
        while (fn < n) {
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;

            if (fn == n) return true;
        }

        return false;
    }
}