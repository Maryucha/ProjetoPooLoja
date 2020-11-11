# Projeto Loja 

Esse projetinho vai simular as funcionalidades de uma loja em **Java**.  Ele vai rodar no terminal de foma bem simples;

# Pacotes
- Controle
	>Principal : main;
- Modelos
	>Gerencia : instancia as classes chama os métodos dos funcionários
	>Loja:  instancia as classes e chama os métodos do cliente e Compra
	 
		-Pessoa abtract
		-Funcionario is-> Pessoa
		-Gerente is-> Funcionario
		-Vendedor is-> Funcionario
		-EnumCargo
		-Cliente is-> Pessoa
		-Compra

# Execução

**MENU PRINCIPAL**

	 1. Gerencia
	 2. Loja
	 3. Sair
 
 **SUB MENU GERENCIA**
	 
		1. Cadastrar Funcionário
		2. Mostrar Vendedores
		3. Mostrar Gerentes
		4. Desvincular
		5. Calcular Inss
		6. Voltar
		
**SUB MENU LOJA**

		1. Cadastrar Cliente
		2. Mostrar Clientes
		3. Fazer Venda
		4. Calcular Divida
		5. Fechar o Caixa
		6. Validar Vendedor
		7. Buscar Compra
		8. Voltar
		 
- O sistema é bem simples a idéia é trabalhar com estrutura de dados em Java
	>- Trabalhei com uma *Lista de Funcionários*
	>- Uma *Lista de Clientes* onde cada ciente tem uma *Lista de Compras* e cada Compra tem sua 	*Lista de produtos*.

