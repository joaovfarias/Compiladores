package ast;

public class CPrint extends Comando{
	public int linha;
	public Exp exp;
	
	
	public CPrint(int linha,Exp exp)
	{
	  this.linha = linha;
	  this.exp = exp;
	  
	} 
	
	@Override
	public String toString() {
		return "printLn(" + exp.toString() + ") (linha " + linha + ")";
	}
	
	@Override
	public String geraCodigoJava() {
		return "System.out.println(" + exp.geraCodigoJava() + ");";
	}

}
