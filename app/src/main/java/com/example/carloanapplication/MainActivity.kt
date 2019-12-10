package com.example.carloanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            val car_price = editTextCarPrice.text.toString()
            val down_payment = editTextDownPayment.text.toString()
            val loan_period = editTextLoanPeriod.text.toString()
            val interest_rate = editTextInterestRate.text.toString()

            val Loan:Double = car_price.toDouble() - down_payment.toDouble();
            val Interest:Double = Loan * interest_rate.toDouble() * loan_period.toDouble();
            val MonthlyRepayment:Double = (Loan + Interest) / loan_period.toDouble() / 12;

            textViewLoan.text = "Loan " + "%.2f".format(Loan)
            textViewInterest.text = "Interest " +"%.2f".format(Interest)
            textViewMonthlyRepayment.text = "Monthly Repayment " + "%.2f".format(MonthlyRepayment)
        }

        buttonReset.setOnClickListener {
            editTextCarPrice.setText("")
            editTextDownPayment.setText("")
            editTextInterestRate.setText("")
            editTextLoanPeriod.setText("")
            textViewInterest.setText("Interest:")
            textViewLoan.setText("Loan:")
            textViewMonthlyRepayment.setText("Monthly Repayment :")
        }

    }

}

