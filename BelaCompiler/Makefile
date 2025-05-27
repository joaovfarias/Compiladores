# Arquivos
JJ_FILE = Bela.jj
JAVA_FILES = $(wildcard *.java)
CLASS_FILES = $(JAVA_FILES:.java=.class)
MAIN_CLASS = Bela
INPUT_FILE = exemplo.bel

# Alvo padrão
all: run

# Gera os arquivos .java a partir do .jj
parser: $(JJ_FILE)
	javacc $(JJ_FILE)

# Compila os arquivos .java
compile: parser
	javac $(JAVA_FILES)

# Executa a aplicação
run: compile
	java $(MAIN_CLASS) $(INPUT_FILE)

# Limpa arquivos gerados
clean:
	rm -f *.class *.java && git checkout -- $(JJ_FILE)
