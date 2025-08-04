package ast;

public class VarDecl{
   public String type;
   public String var;
   
   public VarDecl(String type,String var){
   	this.type = type;
   	this.var = var;
   }
   
   @Override
   public String toString() {
   	return type + " " + var;
   }
   
   public String geraCodigoJava() {
   	String javaType;
   	switch(type) {
   		case "float":
   			javaType = "float";
   			break;
   		case "bool":
   			javaType = "boolean";
   			break;
   		case "void":
   			javaType = "void";
   			break;
   		default:
   			javaType = type;
   	}
   	return javaType + " " + var + ";";
   }
}
