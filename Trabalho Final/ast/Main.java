package ast;

import java.util.ArrayList;

public class Main{

	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> coms;
	
	public Main(ArrayList<VarDecl> vars,ArrayList<Comando> coms)
	{
		this.vars = vars;
		this.coms = coms;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Main {\n");
		if (vars != null && !vars.isEmpty()) {
			sb.append("  Variáveis:\n");
			for (VarDecl var : vars) {
				sb.append("    ").append(var.toString()).append("\n");
			}
		}
		if (coms != null && !coms.isEmpty()) {
			sb.append("  Comandos:\n");
			for (Comando com : coms) {
				sb.append("    ").append(com.toString()).append("\n");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	public String geraCodigoJava() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tpublic static void main(String[] args) {\n");
		
		// Declarar variáveis
		if (vars != null && !vars.isEmpty()) {
			for (VarDecl var : vars) {
				sb.append("\t\t").append(var.geraCodigoJava()).append("\n");
			}
		}
		
		// Gerar comandos
		if (coms != null && !coms.isEmpty()) {
			for (Comando com : coms) {
				sb.append("\t\t").append(com.geraCodigoJavaMain()).append("\n");
			}
		}
		
		sb.append("\t}\n");
		return sb.toString();
	}


}
