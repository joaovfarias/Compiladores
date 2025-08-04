package ast;


public class EFloat extends Exp{
	public float value;
	
	
	public EFloat(float value)
	{
	  this.value = value;
	  
	} 
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public String geraCodigoJava() {
		return String.valueOf(value) + "f";
	}

}
