package ast;

import java.util.ArrayList;

public class CIf extends Comando{
	public int linha;
	public Exp exp;
	public ArrayList<Comando> bloco;
	
	public CIf(int linha,Exp exp, ArrayList<Comando> bloco)
	{
	  this.linha = linha;
	  this.exp = exp;
	  this.bloco = bloco;
	} 
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("if ").append(exp.toString()).append(" then { ");
		if (bloco != null && !bloco.isEmpty()) {
			for (Comando cmd : bloco) {
				sb.append(cmd.toString()).append("; ");
			}
		}
		sb.append("} (linha ").append(linha).append(")");
		return sb.toString();
	}
	
	@Override
	public String geraCodigoJava() {
		StringBuilder sb = new StringBuilder();
		sb.append("if (").append(exp.geraCodigoJava()).append(") {\n");
		if (bloco != null && !bloco.isEmpty()) {
			for (Comando cmd : bloco) {
				sb.append("\t\t\t").append(cmd.geraCodigoJava()).append("\n");
			}
		}
		sb.append("\t\t}");
		return sb.toString();
	}

}
