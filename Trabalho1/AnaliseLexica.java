import java.io.*;

enum TokenType{ NUM,SOMA, MULT, SUB, DIV, APar,FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (char l, TokenType t)
 	{ lexema=Character.toString(l);token = t;}
 Token (String l, TokenType t)
 	{ lexema=l;token = t;}

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;	
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
				if (currchar >= '0' && currchar <= '9') {
					String s = "";
					s += currchar;
					arquivo.mark(1);

					while (true) {
						currchar1 = arquivo.read();
						if (currchar1 == eof) break;
		
						currchar = (char) currchar1;
						if (currchar >= '0' && currchar <= '9') {
							s += currchar;
							arquivo.mark(1); 
						} else {
							arquivo.reset(); 
							break;
						}
					}
		
					return new Token(s, TokenType.NUM);
				}
				else
					switch (currchar){
						case '(':
							return (new Token (currchar,TokenType.APar));
						case ')':
							return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (currchar,TokenType.SOMA));
						case '*':
							return (new Token (currchar,TokenType.MULT));
						case '-':
							return (new Token (currchar,TokenType.SUB));
						case '/':
							return (new Token (currchar,TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
		
	}
}
