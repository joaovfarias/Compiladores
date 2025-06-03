import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MaquinaPilha {
    
    public static void main(String[] args) throws IOException {

        BufferedReader arquivo = new BufferedReader(new FileReader("arquivoDeEntrada"));
        Stack<Integer> pilha = new Stack<>();
        String linha;

        while ((linha = arquivo.readLine()) != null){
            
            String[] arg = linha.split(" ");
            String arg1 = arg[0];
            int arg2 = 0; 
            if (arg.length > 1) {
                arg2 = Integer.parseInt(arg[1]);
            }

            switch (arg1){
                case "PUSH":
                        pilha.push(arg2);
                        break;
                case "MULT":
                        pilha.push(pilha.pop() * pilha.pop());
                        break;
                case "SUM":
                        pilha.push(pilha.pop() + pilha.pop());
                        break;
                case "SUB":
                        int b = pilha.pop();
                        int a = pilha.pop();
                        pilha.push(a - b);
                        break;
                case "DIV":
                        b = pilha.pop();
                        a = pilha.pop(); 
                        pilha.push(a / b);
                        break;
            }
        }

        arquivo.close();
        System.out.println("Resultado: " + pilha.pop());
    }        
}
