package ast;


public class EFalse extends Exp{
	
	public EFalse()
	{
	  super();
	  
	} 
	
	@Override
	public String toString() {
		return "false";
	}
	
	@Override
	public String geraCodigoJava() {
		return "false";
	}

}
