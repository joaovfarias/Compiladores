class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			// Código Máquina de Pilha Hipotética (retorna código gerado)
			CodeGen backend = new CodeGen();
			String codigo_mp = backend.geraCodigo(arv);

			// Código Interpretador (retorna resultado da execução)
			CodeInter backend = new CodeInter();
			int codigo_inter = backend.calculaCodigo(arv);
			
			// Imprime o código gerado
			System.out.println("Código gerado:\n" + codigo_mp);
			// Imprime o resultado da execução
			System.out.println("Resultado da execução:\n" + codigo_inter);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
