package ast;

import java.util.ArrayList;

public class CChamadaFun extends Comando{
	public int linha;
	public String fun;
	public ArrayList<Exp> args;
	
	public CChamadaFun(int linha,String fun, ArrayList<Exp> args)
	{
	  this.linha = linha;
	  this.fun = fun;
	  this.args = args;
	} 
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(fun).append("(");
		if (args != null && !args.isEmpty()) {
			for (int i = 0; i < args.size(); i++) {
				if (i > 0) sb.append(", ");
				sb.append(args.get(i).toString());
			}
		}
		sb.append(") (linha ").append(linha).append(")");
		return sb.toString();
	}
	
	@Override
	public String geraCodigoJava() {
		StringBuilder sb = new StringBuilder();
		sb.append(fun).append("(");
		if (args != null && !args.isEmpty()) {
			for (int i = 0; i < args.size(); i++) {
				if (i > 0) sb.append(", ");
				sb.append(args.get(i).geraCodigoJava());
			}
		}
		sb.append(");");
		return sb.toString();
	}

}
