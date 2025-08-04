package ast;

public class CReturn extends Comando{
	public int linha;
	public Exp exp;
	
	
	public CReturn(int linha,Exp exp)
	{
	  this.linha = linha;
	  this.exp = exp;
	  
	} 
	
	@Override
	public String toString() {
		return "return " + exp.toString() + " (linha " + linha + ")";
	}
	
	@Override
	public String geraCodigoJava() {
		return "return " + exp.geraCodigoJava() + ";";
	}
	
	@Override
	public String geraCodigoJavaMain() {
		// No main, convertemos return em System.exit
		return "System.exit((int) (" + exp.geraCodigoJava() + "));";
	}

}
