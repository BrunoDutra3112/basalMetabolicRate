package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;



public class MainActivity extends AppCompatActivity {

    private EditText idade, peso, altura;
    private RadioGroup genero;
    private Button calcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idade = findViewById(R.id.idade);
        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);
        genero = findViewById(R.id.genero);
        calcular = findViewById(R.id.calcular);
        resultado = findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTMB();
            }
        });
    }

    private void calcularTMB() {
        int idadePessoa = Integer.parseInt(idade.getText().toString());
        double pesoPessoa = Double.parseDouble(peso.getText().toString());
        double alturaPessoa = Double.parseDouble(altura.getText().toString());

        int selectedId = genero.getCheckedRadioButtonId();
        double tmb = 0;

        if (selectedId == R.id.masculino) {
            tmb = 88.36 + (13.4 * pesoPessoa) + (4.8 * alturaPessoa) - (5.7 * idadePessoa);
        } else if (selectedId == R.id.feminino) {
            tmb = 447.6 + (9.2 * pesoPessoa) + (3.1 * alturaPessoa) - (4.3 * idadePessoa);
        }

        resultado.setText("Sua TMB é: " + String.format("%.2f", tmb) + " kcal/dia");
    }
}
