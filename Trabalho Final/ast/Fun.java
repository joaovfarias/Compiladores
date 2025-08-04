package ast;

import java.util.ArrayList;

public class Fun{
	public String nome;
	public ArrayList<ParamFormalFun> params;
	public String retorno;
	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> body;
	
	public Fun(String nome,ArrayList<ParamFormalFun> params, String retorno,ArrayList<VarDecl> vars,ArrayList<Comando> body)
	{
		this.nome = nome;
		this.params = params;
		this.retorno = retorno;
		this.vars = vars;
		this.body = body;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Função ").append(nome).append(" (retorna ").append(retorno).append(") {");
		if (params != null && !params.isEmpty()) {
			sb.append("\n  Parâmetros: ");
			for (int i = 0; i < params.size(); i++) {
				if (i > 0) sb.append(", ");
				sb.append(params.get(i).toString());
			}
		}
		if (vars != null && !vars.isEmpty()) {
			sb.append("\n  Variáveis:");
			for (VarDecl var : vars) {
				sb.append("\n    ").append(var.toString());
			}
		}
		if (body != null && !body.isEmpty()) {
			sb.append("\n  Corpo:");
			for (Comando cmd : body) {
				sb.append("\n    ").append(cmd.toString());
			}
		}
		sb.append("\n}");
		return sb.toString();
	}
	
	public String geraCodigoJava() {
		StringBuilder sb = new StringBuilder();
		
		// Tipo de retorno
		String javaRetorno;
		switch(retorno) {
			case "float":
				javaRetorno = "float";
				break;
			case "bool":
				javaRetorno = "boolean";
				break;
			case "void":
				javaRetorno = "void";
				break;
			default:
				javaRetorno = retorno;
		}
		
		sb.append("\tpublic static ").append(javaRetorno).append(" ").append(nome).append("(");
		
		// Parâmetros
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				if (i > 0) sb.append(", ");
				sb.append(params.get(i).geraCodigoJava());
			}
		}
		
		sb.append(") {\n");
		
		// Variáveis locais
		if (vars != null && !vars.isEmpty()) {
			for (VarDecl var : vars) {
				sb.append("\t\t").append(var.geraCodigoJava()).append("\n");
			}
		}
		
		// Corpo da função
		if (body != null && !body.isEmpty()) {
			for (Comando cmd : body) {
				sb.append("\t\t").append(cmd.geraCodigoJava()).append("\n");
			}
		}
		
		sb.append("\t}");
		return sb.toString();
	}
}
