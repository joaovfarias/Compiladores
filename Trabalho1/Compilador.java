class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			// Código Máquina de Pilha Hipotética (retorna código gerado)
			CodeGen backend_mp = new CodeGen();
			String codigo_mp = backend_mp.geraCodigo(arv);

			// Código Interpretador (retorna resultado da execução)
			CodeInter backend_inter = new CodeInter();
			int codigo_inter = backend_inter.calculaCodigo(arv);
			
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
