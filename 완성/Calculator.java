package ma.homwork;

public class Calculator	{

	public double doCal (double value1, double value2, String oper){

		double result = 0;
		
		if (oper == "+") {
			result = value1 + value2;
		}
		if (oper == "-") {
			result = value1 - value2;
		}
		if (oper == "*") {
			result = value1 * value2;
		}
		if (oper == "/") {
			result = value1 / value2;
		}
		
		return result;
	}

}