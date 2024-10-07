package com.example.unitconverter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText inputValue;
    Spinner fromUnit, toUnit;
    Button convertButton;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputValue = findViewById(R.id.inputValue);
        fromUnit = findViewById(R.id.fromUnit);
        toUnit = findViewById(R.id.toUnit);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input = Double.parseDouble(inputValue.getText().toString());
                String from = fromUnit.getSelectedItem().toString();
                String to = toUnit.getSelectedItem().toString();
                double result = convertUnits(input, from, to);
                resultTextView.setText(String.valueOf(result));
            }
        });
    }
    private double convertUnits(double value, String from, String to) {
        if (from.equals("Centimeters") && to.equals("Meters")) {
            return value / 100;
        } else if (from.equals("Meters") && to.equals("Centimeters")) {
            return value * 100;
        } else if (from.equals("Grams") && to.equals("Kilograms")) {
            return value / 1000;
        } else if (from.equals("Kilograms") && to.equals("Grams")) {
            return value * 1000;
        } else {
            return value;
        }
    }
}
