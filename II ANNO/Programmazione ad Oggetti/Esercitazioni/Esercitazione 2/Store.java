package Calcolatrice;

class Store implements Instruction
{
    private int ind; 

    public Store(int ind) { this.ind = ind; }

    public boolean esegui(CE calc)
    {
	calc.RAM[ind] = calc.A;
	return false; 
    }

    public String toString()
    {
	return "Store " + ind;
    }
}
