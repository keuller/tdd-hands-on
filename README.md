# tdd-hands-on

Projeto que exemplifica o uso de técnicas e práticas para desenvolvimento guiado por testes.

## Funcionalidade

Somos uma empresa de análise de aceitação de mercado e, precisamos de um cadastro de empresas, para que possamos fazer classificação e ranqueamento da satisfação no mercado.

Regras do Cadastro:
 
1. Uma empresa precisa dos seguintes atributos: nome, site, email, descrição, data da fundação e “score” inicial

2. O score é uma classificação que damos as empresas no ato de seu cadastro, conforme a especificação abaixo: 
    
    - Empresas com menos de 2 anos, não entram no cadastro;
    - Empresas de 2 a 3 anos, recebem score “C”
    - Empresas de 3 a 5 anos, recebem score “B”
    - Empresas acima de 5 anos, recebem score “A”

3. Não podemos cadastrar 2 ou mais empresas com o mesmo “site”

## Stack Utilizada

* Kotlin
* http4k
* Mockk
* Kotest
* JDBI
* SQLite
