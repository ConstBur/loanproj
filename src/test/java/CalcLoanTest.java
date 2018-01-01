package cb.loanproj;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcLoanTest {
	
	private static String[] loans = {"1000", "foo", "100000000000", "random", "2000", "3000"};
	private static String[] terms = {"12", "24", "wtf", "nanana", "twenty", "48"};
	private static String[] rates = {"2.9", "3.5", "4.0", "ten", "none", "bar"};
	private static String[] errors = {"", "You entered an invalid loan amount (less than 10 million $ supported)\n",
			"You entered an invalid loan amount (less than 10 million $ supported)\nYou entered an invalid term\n",
			"You entered an invalid loan amount (less than 10 million $ supported)\nYou entered an invalid term\nYou entered an invalid interest rate (< 100% only)",
			"You entered an invalid term\nYou entered an invalid interest rate (< 100% only)",
			"You entered an invalid interest rate (< 100% only)"};
	
	private CalcLoanClass calc = new CalcLoanClass();

	@Test
	public void testCheckLoan() {
		assertEquals("Must accept 1000", true, calc.checkLoan(loans[0]));
		assertEquals("Must refuse foo", false, calc.checkLoan(loans[1]));
		assertEquals("Must refuse 100000000000", false, calc.checkLoan(loans[2]));
		assertEquals("Must refuse random", false, calc.checkLoan(loans[3]));
		assertEquals("Must accept 2000", true, calc.checkLoan(loans[4]));
		assertEquals("Must accept 3000", true, calc.checkLoan(loans[5]));
	}

	@Test
	public void testCheckTerm() {
		assertEquals("Must accept 12", true, calc.checkTerm(terms[0]));
		assertEquals("Must accept 24", true, calc.checkTerm(terms[1]));
		assertEquals("Must refuse wtf", false, calc.checkTerm(terms[2]));
		assertEquals("Must refuse nanana", false, calc.checkTerm(terms[3]));
		assertEquals("Must refuse twenty", false, calc.checkTerm(terms[4]));
		assertEquals("Must accept 48", true, calc.checkTerm(terms[5]));
	}

	@Test
	public void testCheckRate() {
		assertEquals("Must accept 2.9", true, calc.checkRate(rates[0]));
		assertEquals("Must accept 3.5", true, calc.checkRate(rates[1]));
		assertEquals("Must accept 4.0", true, calc.checkRate(rates[2]));
		assertEquals("Must refuse ten", false, calc.checkRate(rates[3]));
		assertEquals("Must refuse none", false, calc.checkRate(rates[4]));
		assertEquals("Must refuse bar", false, calc.checkRate(rates[5]));
	}

	/*@Test
	public void testErrorPrint() {
		assertEquals("No error expected", "", errors[0]);
		
	}

	@Test
	public void testToStringStringStringString() {
		fail("Not yet implemented");
	}*/

}
