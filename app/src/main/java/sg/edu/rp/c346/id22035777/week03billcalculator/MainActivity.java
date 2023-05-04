package sg.edu.rp.c346.id22035777.week03billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView amountTextView, numOfPaxTextView, discountTextView, totalBillTextView, eachPaysTextView, tvDisplay1, tvDisplay2;
    EditText amountInput, numOfPaxInput, discountInput;
    RadioGroup paymentRadioGroup;
    RadioButton cashRadioButton, payNowRadioButton;
    ToggleButton svsToggle, gstToggle;
    Button splitButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountTextView = findViewById(R.id.amountTextView);
        numOfPaxTextView = findViewById(R.id.numOfPaxTextView);
        discountTextView = findViewById(R.id.discountTextView);
        totalBillTextView = findViewById(R.id.totalBillTextView);
        eachPaysTextView = findViewById(R.id.eachPaysTextView);
        amountInput = findViewById(R.id.amountInput);
        numOfPaxInput = findViewById(R.id.numOfPaxInput);
        discountInput = findViewById(R.id.discountInput);
        paymentRadioGroup = findViewById(R.id.paymentRadioGroup);
        cashRadioButton = findViewById(R.id.cashRadioButton);
        payNowRadioButton = findViewById(R.id.payNowRadioButton);
        svsToggle = findViewById(R.id.svsToggle);
        gstToggle = findViewById(R.id.gstToggle);
        splitButton = findViewById(R.id.splitButton);
        resetButton = findViewById(R.id.resetButton);
        tvDisplay1 = findViewById(R.id.totalBillTextView);
        tvDisplay2 = findViewById(R.id.eachPaysTextView);

        splitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString();
                double amount1 = Double.parseDouble(amount);
                double amountInput = 0;
                String numOfPax = numOfPaxInput.getText().toString();
                double numOfPax1 = Double.parseDouble(numOfPax);
                int numOfPaxInput = 0;
                String discount = discountInput.getText().toString();
                double discount1 = Double.parseDouble(discount);
                double discountInput = 0.0;
                double svs1 = 0.1;
                double gst1 = 0.07;
                double finalPrice = 0.0;
                if (svsToggle.isChecked() & gstToggle.isChecked()) {
                    finalPrice = amount1 * (1 - (discount1 / 100)) * (1 - svs1) * (1 - gst1);
                } else if (svsToggle.isChecked()) {
                    finalPrice = amount1 * (1 - (discount1 / 100)) * (1 - svs1);
                } else if (gstToggle.isChecked()) {
                    finalPrice = amount1 * (1 - (discount1 / 100)) * (1 - gst1);
                } else {
                    finalPrice = amount1 * (1 - (discount1 / 100));
                }
                double eachPrice = finalPrice/numOfPax1;
                String printFinal = String.format("%.2f",finalPrice);
                String printEach = String.format("%.2f",eachPrice);
                tvDisplay1.setText("Total Bill: $" + printFinal);
                tvDisplay2.setText("Each Pays: $" + printEach);
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountInput.setText("");
                numOfPaxInput.setText("");
                svsToggle.setChecked(false);
                gstToggle.setChecked(false);
                discountInput.setText("");
                paymentRadioGroup.clearCheck();
            }
        });
    }
}
