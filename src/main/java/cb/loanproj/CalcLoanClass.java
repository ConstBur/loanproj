//Programmer: Constantin Buruiana
//test comment added

package cb.loanproj;

import java.text.NumberFormat;

public class CalcLoanClass {
	private String error = "";
	private boolean loanCheck;
	private boolean termCheck;
	private boolean rateCheck;
	
	public boolean checkLoan(String input)
	{
		double loan = 0.0;
		try
		{
			loan = Double.parseDouble(input);
		}
		catch (NumberFormatException e)
		{
			loanCheck = false;
			return loanCheck;
		}
		//Negative or null amount exception
        if (loan <= 0.0)
        {
            error += "It is impossible to calculate payments for " +
                    "negative and null amounts.\n";
            loanCheck = false;
        }
        else if (loan >= 10000000.0)
        {
        	loanCheck = false;
        }
        else
        {
            //Passing check
            loanCheck = true;
            //Rounding to 2 decimal places
            loan = Math.round(loan * 100.0) / 100.0;
        }
		return loanCheck;
	}
	
	public boolean checkTerm(String input)
	{
		int term = 0;
		try
		{
			term = Integer.parseInt(input);
		}
		catch (NumberFormatException e)
		{
			termCheck = false;
			return termCheck;
		}
		if (term <= 0)
        {
            error += "It is impossible to calculate payments for " +
                    "negative, null and fractional terms.\n";
            termCheck = false;
        }
		else
		{
			termCheck = true;
		}
		return termCheck;
	}
	
	public boolean checkRate(String input)
	{
		double rate = 0.0;
		try
		{
			rate = Double.parseDouble(input);
			rateCheck = true;
		}
		catch (NumberFormatException e)
		{
			rateCheck = false;
		}
		if (rate <= 0.0 || rate >= 100.0)
		{
			rateCheck = false;
		}
		return rateCheck;
	}
	
	public String errorPrint(boolean loan, boolean term, boolean rate)
	{
		if (!loan)
		{
			error += "You entered an invalid loan amount (less than 10 million $ supported)\n";
		}
		if (!term)
		{
			error += "You entered an invalid term\n";
		}
		if (!rate)
		{
			error += "You entered an invalid interest rate (< 100% only)";
		}
		return error;
	}
	
	public String toString(String loan, String term, String rate)
	{
		String message = "";
		double loanAmount = 0.0;
		int loanTerm = 0;
		double interestRate = 0.0;
		String output = "";
		output += message;
		output += this.errorPrint(this.checkLoan(loan), this.checkTerm(term), this.checkRate(rate));
		if (!output.equals(""))
		{
			return output;
		}
		else
		{
			loanAmount = Double.parseDouble(loan);
			loanAmount = Math.round(loanAmount * 100.0) / 100.0;
			loanTerm = Integer.parseInt(term);
			interestRate = Double.parseDouble(rate) / 1200.0;
		}
		
		double monthlyPayment = (interestRate * loanAmount) / (1 - Math.pow(1 + interestRate, -loanTerm));
		
		String message_1 = "Loan Payment and Amortization Table";
		output += String.format("%n%13s%s%n", " ", message_1);
		
		for (int n = 0; n < (message_1.length() + 27); n++)
		{
			output += "=";
		}
		
		output += String.format("%n%5s", "Month");
        output += String.format("%11s", "Beginning");
        output += String.format("%12s", "Monthly");
        output += String.format("%11s", "Principal");
        output += String.format("%11s", "Interest");
        output += String.format("%12s" , "Ending");

        output += String.format("%n%5s", "#");
        output += String.format("%11s", "Balance");
        output += String.format("%12s", "Payment");
        output += String.format("%11s", "Paid");
        output += String.format("%11s", "Paid");
        output += String.format("%12s%n", "Balance");
        
        for (int n = 0; n < (message_1.length() + 27); n++)
		{
			output += "=";
		}
        
        double beginningBalance = loanAmount;

        double interestPaid = 0.0;
        double principalPaid = 0.0;
        double endingBalance = 0.0;

        double totalInterest = 0.0;
        int numberOfPayments = 0;
        double totalPaid = 0.0;

        for (int k = 1; k < loanTerm; k++)
        {
            interestPaid = beginningBalance * interestRate;
            principalPaid = monthlyPayment - interestPaid;
            endingBalance = beginningBalance - principalPaid;

            output += String.format("%n");
            output += String.format("%5d", k);
            output += String.format("%11.2f", beginningBalance);
            output += String.format("%12.2f", monthlyPayment);
            output += String.format("%11.2f", principalPaid);
            output += String.format("%11.2f", interestPaid);
            output += String.format("%12.2f", endingBalance);

            totalInterest += interestPaid;
            numberOfPayments++;
            beginningBalance -= principalPaid;
            totalPaid += principalPaid;
        }

        beginningBalance = loanAmount - totalPaid;

        interestPaid = beginningBalance * interestRate;
        principalPaid = beginningBalance;
        monthlyPayment = principalPaid + interestPaid;
        endingBalance = beginningBalance - principalPaid;

        output += String.format("%n");
        output += String.format("%5d", loanTerm);
        output += String.format("%11.2f", beginningBalance);
        output += String.format("%12.2f", monthlyPayment);
        output += String.format("%11.2f", principalPaid);
        output += String.format("%11.2f", interestPaid);
        output += String.format("%12.2f", endingBalance);

        totalInterest += interestPaid;
        numberOfPayments++;

        output += "\n";

        for (int j = 0; j < (message_1.length() + 27); j++)
        {
            output += "=";
        }

        output += "\n\nSummary:\n";
        for (int m = 0; m < 8; m++)
        {
            output += "=";
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        output += String.format("%n%-22s%s%n", "Loan Amount:", formatter.format(loanAmount));
        output += String.format("%-22s%s%n", "Monthly Payment:", formatter.format(monthlyPayment));
        output += String.format("%-22s%d%n", "Number of Payments:", numberOfPayments);
        output += String.format("%-22s%s%n", "Total Interest Paid:", formatter.format(totalInterest));
        output += String.format("%-22s%s%s%n", "Annual Interest Rate:", rate, "%");
		return output;
	}
}
