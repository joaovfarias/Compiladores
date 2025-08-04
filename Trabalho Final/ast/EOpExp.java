package ast;


public class EOpExp extends Exp{
	public String op;
	public Exp arg1;
	public Exp arg2;
	
	
	public EOpExp(String op, Exp arg1, Exp arg2)
	{
	  this.op = op;
	  this.arg1 = arg1;
	  this.arg2 = arg2;
	  
	} 
	
	@Override
	public String toString() {
		return "(" + arg1.toString() + " " + op + " " + arg2.toString() + ")";
	}
	
	@Override
	public String geraCodigoJava() {
		String javaOp;
		switch(op) {
			case "&&":
				javaOp = "&&";
				break;
			case "||":
				javaOp = "||";
				break;
			case "==":
				javaOp = "==";
				break;
			default:
				javaOp = op;
		}
		return "(" + arg1.geraCodigoJava() + " " + javaOp + " " + arg2.geraCodigoJava() + ")";
	}

}
