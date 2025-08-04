package ast;


public abstract class Comando{
	@Override
	public abstract String toString();
	
	public abstract String geraCodigoJava();
	
	// Método para gerar código específico quando usado no main
	// Por padrão, usa o mesmo comportamento que geraCodigoJava()
	public String geraCodigoJavaMain() {
		return geraCodigoJava();
	}
}
