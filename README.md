# cnpj-reader
Projeto para importar a base de CNPJs da receita federal

Para gerar o executavel deve estar com o JDK instalado e com o Maven.
mvn clean compile assembly:single

# Para executar
java -jar cnpj-reader-1.0.jar <caminho para o arquivo>

java -jar target/cnpj-reader-1.0.jar /Users/murilotuvani/cnpj/5653010B.txt