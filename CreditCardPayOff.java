
/*
* CreditCardPayOff.java
* Author: Joshua Smith
* Submission Date: 9/2/13 *
* Purpose: This program asks the user for the principal, interest rate, and monthly payment on their credit card,
  then uses that information to calculate the number of months it will take to pay off the card, along with the
  total amount that will be paid, the total interest paid, and even the over-payment amount.
* Statement of Academic Honesty: *
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with * the University of Georgia's Academic Honesty Policy and the * policies of this course. I recognize that my work is based * on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department * of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class CreditCardPayOff {

	public static void main(String[] args) {

		double totalAmountPaid, totalInterestPaid, overpayment, overpaymentRounded, monthsToPayOffRaw, monthsToPayOff,
		principal, monthlyPayment, annualInterest, monthsEquationOne, monthsEquationTwo, monthsEquationThree;
		
		System.out.println("Please enter the following information.");
		System.out.println();
		
		Scanner principalInput = new Scanner(System.in);
		System.out.print("Principal:			");
		principal = principalInput.nextDouble();
		
		Scanner annualInterestInput = new Scanner(System.in);
		System.out.print("Annual Interest Rate (%):	");
		annualInterest = annualInterestInput.nextDouble();
		
		Scanner monthlyPaymentInput = new Scanner(System.in);
		System.out.print("Monthly Payment:		");
		monthlyPayment = monthlyPaymentInput.nextDouble();
		
		//The required equation to calculate the months it will take to pay off the card is:
			// ln(monthlyPayment) - ln(monthlPayment - (annualInterest/1200.0) * principal)
			// divided by: ln((annualInterest/1200.0) + 1.0)
			//I broke the equation down into three steps, and then did a final calculation using the results of those steps.
		
		monthsEquationOne = Math.log(monthlyPayment);
		monthsEquationTwo = (Math.log((monthlyPayment) - ((annualInterest/1200.0) * (principal))));
		monthsEquationThree = (Math.log((annualInterest/1200.0) + 1.0));
		monthsToPayOffRaw = (monthsEquationOne - monthsEquationTwo) / (monthsEquationThree);
		monthsToPayOff = Math.ceil(monthsToPayOffRaw);
		
		//The over-payment can be calculated with the following formula:
		//(monthsToPayOff * monthlyPayment) - (monthsToPayOffRaw * monthlyPayment)
		//This formula takes the raw decimal number of months and subtracts it from the rounded, artificial amount.
		
		overpayment = (monthsToPayOff * monthlyPayment) - (monthsToPayOffRaw * monthlyPayment);
		overpaymentRounded = Math.round(overpayment * 100.0) / 100.0;
		
		totalAmountPaid = monthsToPayOff * monthlyPayment;
		totalInterestPaid = totalAmountPaid - principal;
		
		System.out.println();
		System.out.println("Months Needed To Pay Off:	" + (int)monthsToPayOff);
		System.out.printf("Total Amount Paid:		%.2f\n", totalAmountPaid);
		System.out.printf("Total Interest Paid		%.2f\n", totalInterestPaid);
		System.out.println("Overpayment:			" + overpaymentRounded);
		
	}

}