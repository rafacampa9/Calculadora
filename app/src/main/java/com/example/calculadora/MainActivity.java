package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNum1, txtNum2, txtResult;
    private RadioButton rbSumar, rbRestar, rbMultiplicar, rbDividir, rbPotencia, rbRaiz;
    private Button btnGuardar, btnMostrar, btnLimpiar, btnCalcular;

    private Double store1, store2, storeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ligamos los editText
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txtResult = findViewById(R.id.txtResult);
        txtResult.setEnabled(false);

        // Ligamos los RadioButton y el ButtonGroup
        rbSumar = findViewById(R.id.rbSumar);
        rbRestar = findViewById(R.id.rbRestar);
        rbMultiplicar = findViewById(R.id.rbMultiplicar);
        rbDividir = findViewById(R.id.rbDividir);
        rbPotencia = findViewById(R.id.rbPotencia);
        rbRaiz = findViewById(R.id.rbRaiz);


        // Ligamos los botones
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnMostrar = findViewById(R.id.btnMostrar);

        // Activamos los RadioButtons
        rbSumar.setOnClickListener(this);
        rbRestar.setOnClickListener(this);
        rbMultiplicar.setOnClickListener(this);
        rbDividir.setOnClickListener(this);
        rbPotencia.setOnClickListener(this);
        rbRaiz.setOnClickListener(this);

        //Activamos los Botones
        btnMostrar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
        btnCalcular.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
    }

    public void mostrarMensaje(String mensaje, String titulo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        Double num1, num2, resultado;


        if (v.getId() == R.id.btnCalcular){
            if (rbSumar.isChecked()){
                if (txtNum1.getText().toString().isEmpty() || txtNum2.getText().toString().isEmpty()
                        || txtNum1.getText().toString().equals("-") || txtNum1.getText().toString().equals(".") ||
                        txtNum2.getText().toString().equals("-") || txtNum2.getText().toString().equals(".") ||
                        txtNum1.getText().toString().equals("+") || txtNum2.getText().toString().equals("+")){
                    mostrarMensaje(
                            "Por favor, rellene los campos",
                            "ERROR"
                    );
                } else {
                    num1 = Double.parseDouble(String.valueOf(txtNum1.getText()));
                    num2 = Double.parseDouble(String.valueOf(txtNum2.getText()));
                    resultado = num1 + num2;
                    txtResult.setText(String.valueOf(resultado));
                }


            } else if(rbRestar.isChecked()){
                if (txtNum1.getText().toString().isEmpty() || txtNum2.getText().toString().isEmpty()
                        || txtNum1.getText().toString().equals("-") || txtNum1.getText().toString().equals(".") ||
                        txtNum2.getText().toString().equals("-") || txtNum2.getText().toString().equals(".") ||
                        txtNum1.getText().toString().equals("+") || txtNum2.getText().toString().equals("+")) {
                    mostrarMensaje(
                            "Por favor, rellene los campos",
                            "ERROR"
                    );
                } else{
                    num1 = Double.parseDouble(String.valueOf(txtNum1.getText()));
                    num2 = Double.parseDouble(String.valueOf(txtNum2.getText()));
                    resultado = num1 - num2;
                    txtResult.setText(String.valueOf(resultado));
                }
            } else if(rbMultiplicar.isChecked()){
                if (txtNum1.getText().toString().isEmpty() ||  txtNum2.getText().toString().isEmpty()
                        || txtNum1.getText().toString().equals("-") || txtNum1.getText().toString().equals(".") ||
                        txtNum2.getText().toString().equals("-") || txtNum2.getText().toString().equals(".") ||
                        txtNum1.getText().toString().equals("+") || txtNum2.getText().toString().equals("+")) {
                    mostrarMensaje(
                            "Por favor, rellene los campos",
                            "ERROR"
                    );

                } else{
                    num1 = Double.parseDouble(String.valueOf(txtNum1.getText()));
                    num2 = Double.parseDouble(String.valueOf(txtNum2.getText()));
                    resultado = num1 * num2;
                    txtResult.setText(String.valueOf(resultado));
                }
            } else if (rbDividir.isChecked()){
                if (txtNum1.getText().toString().isEmpty() || txtNum2.getText().toString().isEmpty()
                        || txtNum1.getText().toString().equals("-") || txtNum1.getText().toString().equals(".") ||
                        txtNum2.getText().toString().equals("-") || txtNum2.getText().toString().equals(".") ||
                        txtNum1.getText().toString().equals("+") || txtNum2.getText().toString().equals("+")) {
                    mostrarMensaje(
                            "Por favor, rellene los campos",
                            "ERROR"
                    );

                } else{
                    num1 = Double.parseDouble(String.valueOf(txtNum1.getText()));
                    num2 = Double.parseDouble(String.valueOf(txtNum2.getText()));
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        txtResult.setText(String.valueOf(resultado));
                    } else {
                        mostrarMensaje(
                                "No se puede dividir por cero",
                                "ERROR"
                        );
                    }
                }


            } else if (rbPotencia.isChecked()){
                if (txtNum1.getText().toString().isEmpty() ||  txtNum2.getText().toString().isEmpty()
                        || txtNum1.getText().toString().equals("-") || txtNum1.getText().toString().equals(".") ||
                        txtNum2.getText().toString().equals("-") || txtNum2.getText().toString().equals(".") ||
                        txtNum1.getText().toString().equals("+") || txtNum2.getText().toString().equals("+")) {
                    mostrarMensaje(
                            "Por favor, rellene los campos",
                            "ERROR"
                    );

                } else {
                    num1 = Double.parseDouble(String.valueOf(txtNum1.getText()));
                    num2 = Double.parseDouble(String.valueOf(txtNum2.getText()));
                    if (num1 != 0 || num2 != 0){
                        resultado = Math.pow(num1, num2);
                        txtResult.setText(String.valueOf(resultado));
                    } else {
                        mostrarMensaje(
                                "Indeterminación",
                                "ERROR"
                        );
                    }
                }

            } else if (rbRaiz.isChecked()) {
                if (txtNum1.getText().toString().isEmpty() || txtNum2.getText().toString().isEmpty()
                        || txtNum1.getText().toString().equals("-") || txtNum1.getText().toString().equals(".") ||
                        txtNum2.getText().toString().equals("-") || txtNum2.getText().toString().equals(".") ||
                        txtNum1.getText().toString().equals("+") || txtNum2.getText().toString().equals("+")) {
                    mostrarMensaje(
                            "Por favor, rellene los campos",
                            "ERROR"
                    );

                } else {
                    num1 = Double.parseDouble(String.valueOf(txtNum1.getText()));
                    num2 = Double.parseDouble(String.valueOf(txtNum2.getText()));
                    if (num2%2 == 0 && num1 < 0){
                        mostrarMensaje(
                                "En el conjunto de los números reales, no existe la raíz " +
                                        "con exponente par de un número negativo",
                                "WARNING"
                        );
                    } else if (num2%2 != 0 && num1 < 0){
                        resultado = Math.pow((-num1), 1 / num2);
                        resultado = resultado - 2*resultado;
                        txtResult.setText(String.valueOf(resultado));
                    } else {
                        resultado = Math.pow(num1, 1/num2);
                        txtResult.setText(String.valueOf(resultado));
                    }
                }

            } else{
                mostrarMensaje(
                        "Por favor, rellene todos los campos",
                        "ERROR"
                );
            }

        }

        if (v.getId() == R.id.btnLimpiar){
            txtNum1.setText(null);
            txtNum2.setText(null);
            txtResult.setText(null);
            rbRaiz.setChecked(false);
            rbSumar.setChecked(false);
            rbRestar.setChecked(false);
            rbMultiplicar.setChecked(false);
            rbDividir.setChecked(false);
            rbPotencia.setChecked(false);

        }

        if (v.getId() == R.id.btnGuardar){
            store1 = Double.parseDouble(txtNum1.getText().toString());
            store2 = Double.parseDouble(txtNum2.getText().toString());
            storeResult = Double.parseDouble(txtResult.getText().toString());

            mostrarMensaje("Operación almacenada correctamente",
                    "Guardado");
        }

        if (v.getId() == R.id.btnMostrar){
            if (store1 != null && store2 != null && storeResult!= null){
                txtNum1.setText(String.valueOf(store1));
                txtNum2.setText(String.valueOf(store2));
                txtResult.setText(String.valueOf(storeResult));
            } else {
                mostrarMensaje(
                        "No hay ninguna operación almacenada",
                        "ERROR");
            }
        }
    }
}