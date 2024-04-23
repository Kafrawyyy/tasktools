package EJB;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity

public class Calculator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private int number1;
	private int number2;
	private String operation;
	private int result;
	
	public Calculator() {
		
	}
	
	public Calculator(int num1 , int num2 , String op ) {
		this.number1 = num1;
		this.number2= num2;
		this.operation=op;
	}
	
	
	public int performCalc (int num1 , int num2 , String op ) {
		int r = 0;
		if (op.equals("+") )
			 r = num1 + num2 ;
		else if (op.equals("-"))
		    	r = num1 - num2 ;
		else if (op.equals("*"))
			 r = num1 * num2 ;
		else if (op.equals("/"))
		    r = num1 / num2;
		
		return r;
		
		
	}
	
	
	
	
	
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	
	
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
	
}
