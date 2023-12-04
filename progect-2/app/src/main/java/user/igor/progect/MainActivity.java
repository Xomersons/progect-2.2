package user.igor.progect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    float robotCost = 35000; // стоимость робота
    float currentSavings = 700; // текущие накопления
    float monthlyAllowance = 1700; // ежемесячная стипендия
    float prohent = (float) 0.09; // годовая процентная ставка

    private TextView manyMonthOut; // поле вывода количества месяцев для накопления на робота

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manyMonthOut = findViewById(R.id.manyMonthOut); // поле вывода количества месяцев для накопления на робота

        int months = calculateMonthsToSave(robotCost, currentSavings, monthlyAllowance, prohent);
        manyMonthOut.setText("На то, чтобы накопить для робота, уйдет " + months + " месяцев");
    }

    public int calculateMonthsToSave(float robotCost, float currentSavings, float monthlyAllowance, float annualInterestRate) {
        int months = 0;
        float totalSavings = currentSavings;

        while (totalSavings < robotCost) {
            totalSavings += monthlyAllowance;
            totalSavings += (totalSavings * annualInterestRate) / 12;
            months++;
        }

        return months;
    }
}


