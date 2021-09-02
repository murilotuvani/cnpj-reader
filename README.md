# cnpj-reader
Projeto para importar a base de CNPJs da receita federal
A base está disponível no site [Dados Públicos gov.br!](https://www.gov.br/receitafederal/pt-br/assuntos/orientacao-tributaria/cadastros/consultas/dados-publicos-cnpj)

Para gerar o executavel deve estar com o JDK instalado e com o Maven.
mvn clean compile assembly:single

# Para executar
java -jar cnpj-reader-1.0.jar <caminho para o arquivo>

java -jar target/cnpj-reader-1.0.jar /Users/murilotuvani/cnpj/5653010B.txt
