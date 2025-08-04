package ast;


public class ETrue extends Exp{
	
	public ETrue()
	{
	  super();
	  
	} 
	
	@Override
	public String toString() {
		return "true";
	}
	
	@Override
	public String geraCodigoJava() {
		return "true";
	}

}
