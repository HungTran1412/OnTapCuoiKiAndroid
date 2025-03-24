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

public class ChiSoBMI extends AppCompatActivity {
    EditText txtBMIFullname, txtBMIHeight, txtBMIWeight, txtBMIKetQua;
    Button btnBMITinh, btnBMIQuayLai, btnBMIXoaTrang;
    TextView lblBMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_so_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        txtBMIFullname = (EditText) findViewById(R.id.txtBMIFullname);
        txtBMIHeight = (EditText) findViewById(R.id.txtBMIHeight);
        txtBMIWeight = (EditText) findViewById(R.id.txtBMIWeight);

        txtBMIKetQua = (EditText) findViewById(R.id.txtBMIKetQua);
        txtBMIKetQua.setEnabled(false);
        txtBMIKetQua.setFocusable(false);

        lblBMIResult = (TextView) findViewById(R.id.lblBMIResult);
        btnBMITinh = (Button) findViewById(R.id.btnBMITinh);
        btnBMIQuayLai = (Button) findViewById(R.id.btnBMIQuayLai);
        btnBMIXoaTrang = (Button) findViewById(R.id.btnBMIXoaTrang);
    }

    private void addEvents() {
        btnBMITinh.setOnClickListener(v -> tinhBMI());

        btnBMIXoaTrang.setOnClickListener(v -> {
            txtBMIFullname.setText("");
            txtBMIHeight.setText("");
            txtBMIWeight.setText("");
            txtBMIKetQua.setText("");
            lblBMIResult.setText("Ket qua: ");
            txtBMIFullname.requestFocus();
        });

        btnBMIQuayLai.setOnClickListener(v ->
                QuayLai.quayLai(ChiSoBMI.this, MainActivity.class));
    }

    private void tinhBMI() {
        double w = Double.parseDouble(txtBMIWeight.getText().toString());
        double h = Double.parseDouble(txtBMIHeight.getText().toString());

        double BMI = w / (h * h);
        String str = BMI < 18 ? "Gay" :
                     BMI < 25 ? "Binh thuong" :
                     BMI < 30 ? "Beo phi cap do I" :
                     BMI < 35 ? "Beo phi cap do II" :
                                "Beo phi cap do III";
        txtBMIKetQua.setText(BMI + "");
        lblBMIResult.setText("Ket qua: " + str);
    }
}