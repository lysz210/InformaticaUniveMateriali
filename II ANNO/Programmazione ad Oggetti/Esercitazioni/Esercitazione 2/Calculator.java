package Calcolatrice;

class Calculator
{

    private static CE calc; 
    public static void main(String[] args)
    {
	Instruction[] test = 
	    { new Load(0), new Store(1), new Alt() };
	calc = new CE(test);
	calc.trace(0);
    }
}