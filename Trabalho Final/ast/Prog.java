package ast;

import java.util.ArrayList;

public class Prog{
    public Main main;
    public ArrayList<Fun> fun;
    public Prog(Main main, ArrayList<Fun> fun)
    {
        this.main = main;
        this.fun = fun;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Programa:\n");
        sb.append(main.toString());
        if (fun != null && !fun.isEmpty()) {
            sb.append("\nFunções:\n");
            for (Fun f : fun) {
                sb.append(f.toString()).append("\n");
            }
        }
        return sb.toString();
    }
    
    public String geraCodigoJava() {
        StringBuilder sb = new StringBuilder();
        sb.append("public class Programa {\n");
        
        // Gerar funções primeiro
        if (fun != null && !fun.isEmpty()) {
            for (Fun f : fun) {
                sb.append(f.geraCodigoJava()).append("\n");
            }
        }
        
        // Gerar método main
        sb.append(main.geraCodigoJava());
        
        sb.append("}");
        return sb.toString();
    }
}

