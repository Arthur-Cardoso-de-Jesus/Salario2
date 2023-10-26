package br.ulbra.salario2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

        RadioGroup rgopcoes;
        Button btnCalcular;
        EditText txtSalario;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            txtSalario = (EditText) findViewById(R.id.txtSalario);
            rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
            btnCalcular = (Button) findViewById(R.id.btnCalcular);
            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    double salario = Double.parseDouble(txtSalario.getText().toString());
                    int op = rgopcoes.getCheckedRadioButtonId();
                    double novo_salario = 0;
                    if (op == R.id.rb40)
                        novo_salario = salario + (salario * 0.4);

                    else if (op == R.id.rb45)
                        novo_salario = salario + (salario * 0.45);
                    else
                        novo_salario = salario + (salario * 0.5);
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("salário");
                    dialogo.setMessage("Seu novo salário é : R$" + String.valueOf(novo_salario));
                    dialogo.setNeutralButton("Ok", null);
                    dialogo.show();
                }
            });
        }
    }