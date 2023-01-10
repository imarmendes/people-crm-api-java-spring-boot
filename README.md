# API para cadastrar pessoas e endereços 

# Acesso a aplicação
# A aplicação pode ser executada via arquivo .jar:
O arquivo está na pasta /target e pode ser executado com o comando abaixo:

```
java -jar people-crm-api-0.0.1-SNAPSHOT.jar
```



# Contexto
Esse projeto tem como objetivo criar uma aplicação onde seja possivel cadastrar pessoas e endereços, além disso, permitir que se possa estabelecer relação entre pessoas e endereços.
  

No desafio é proposto que se use como principal tecnologia o Java Spring Boot.

## Tecnologias usadas

Back-end - Desenvolvido usando: 
* Java Spring Boot - Tecnologia principal para estruturar e disponibilizar uma aplicação na forma de API.
* JPA - Ferramenta que estabece interface com os mais diversos bancos de dados.
* H2 Database - Banco de Dados em memória criado em tempo de execução. 
* Spring Tool Suite 4 - Suite de desevolvimento.
* Git/Github - Para armazenar e versionar a aplicação.

# Clonar o projeto.
 Execute o comando abaixo no seu terminal.

```
git clone git@github.com:imarmendes/people-crm-api-java-spring-boot.git

```

# Rotas
A aplicação, uma vez que esteja rodado, via arquivo .jar, que já esta presente no repositório, ou através de uma suite como Eclipse ou qualquer outro.

Teremos as rotas da aplicação.

> Rotas de teste - O arquivo abaixo esta presente na raiz da aplicação, esse arquivo pode ser importado no Postman, facilitando assim o processo de teste.

```
Teste People-Crm.postman_collection.json

```

### As Rotas disponiveis são:

#### - Rota para popular o banco de dados.

* <strong>Rota filldatabase</strong>

Essa rota serve unicamente para inserir algumas pessoas e alguns endereços. O que facilita o processo de testes. Para a inserção basta que seja feito uma requisição com o método get para a rota abaixo.


```
localhost:8080/filldatabase
```

<details>
  <summary><strong> A rota /filldatabase insere os elemento abaixo:</strong></summary><br />
	
	Pessoas:
	
```json

[
	{
		"name": "Pedro",
		"id": 1,
		"birthday": "1986-11-08",
		"mainAddress": null,
		"addresses": []
	},
	{
		"name": "João",
		"id": 2,
		"birthday": "1950-01-23",
		"mainAddress": null,
		"addresses": []
	},
	{
		"name": "Antônio",
		"id": 3,
		"birthday": "1960-02-20",
		"mainAddress": null,
		"addresses": []
	},
	{
		"name": "José",
		"id": 4,
		"birthday": "2014-12-07",
		"mainAddress": null,
		"addresses": []
	},
	{
		"name": "Jorge",
		"id": 5,
		"birthday": "2012-10-01",
		"mainAddress": null,
		"addresses": []
	}
]

```

	Endereços:
	
```json

[
	{
		"id": 1,
		"number": 12345,
		"publicPlace": "Flores",
		"cep": "62900-000"
	},
	{
		"id": 2,
		"number": 54321,
		"publicPlace": "Russas",
		"cep": "62900-000"
	},
	{
		"id": 3,
		"number": 78945,
		"publicPlace": "Ceará",
		"cep": "62900-000"
	},
	{
		"id": 4,
		"number": 85236,
		"publicPlace": "Umari",
		"cep": "62900-000"
	},
	{
		"id": 5,
		"number": 456987,
		"publicPlace": "Caixa d'agua",
		"cep": "62900-000"
	},
	{
		"id": 6,
		"number": 74126,
		"publicPlace": "Casa amarela",
		"cep": "62900-000"
	},
	{
		"id": 7,
		"number": 96385,
		"publicPlace": "Posto de saúde",
		"cep": "62900-000"
	},
	{
		"id": 8,
		"number": 65489,
		"publicPlace": "Mercadinho dois irmãos",
		"cep": "62900-000"
	}
]

```
	
</details>


#### - Rota para a entidade Pessoa.

* <strong>Rota /person</strong>

Essa rota serve para lidar com toda a manipulação da entidade pessoa, tem um CRUD completo e as rotas adicionais para tratar dos links de pessoas e endereços.


<strong>-Método GET - Buscar todas as pessoas</strong>

A rota /person usando o método GET trás todas as pessoas que estiverem no Banco de Dados.

```
localhost:8080/person
```

<strong>-Método GET com Id - Buscar uma pessoa</strong>

A rota /person/{id} usando o método GET e passando um ID válido trás as informações de uma pessoa que estiver no banco de dados.

```
localhost:8080/person/{id}
```

<strong>-Método POST - Criar uma pessoa</strong>

A rota /person/ usando o método POST envia para o banco de dados as informações de uma pessoa a ser criada.
	

```
localhost:8080/person
```

<details>
  <summary><strong> Exemplo de JSON a ser enviado para criar uma pessoa:</strong></summary><br />
	
```json
{
    "birthday": "2023-01-01",
    "name": "João"
}


```
	
</details>

.
<strong>-Método DELETE - Excluir uma pessoa</strong>

A rota /person/{id} usando o método DELETE e passando um ID válido envia para a aplicação uma ordem de deleção da pessoa a qual pertence o id.
	

```
localhost:8080/person/{id]
```

<strong>-Método PUT - Atualizar uma pessoa</strong>

A rota /person/{id} usando o método PUT e passando um ID válido, juntamente com novas informações no corpo da requisição, faz a atualização de uma pessoa.
	

```
localhost:8080/person/{id}
```

<details>
  <summary><strong> Exemplo de JSON a ser enviado para atualizar uma pessoa:</strong></summary><br />
	
```json
{
    "birthday": "2023-01-01",
    "mainAddress": null,
    "name": "João"
}


```
	
</details>

.
<strong>-Método GET - Buscar todos os endereços de uma pessoa</strong>

A rota /person/{id}/address usando o método GET e passando um ID válido de uma pessoa, retorna todos os endereços de pessoa a qual pertence o id.
	

```
localhost:8080/person/{id}/address
```

<strong>-Método PUT - Atualiza uma pessoa adicionando a ela um endereço principal</strong>

A rota /person/{personId}/mainaddress/{addressId} passando o personId válido de uma pessoa e um addressId válido de um endereço, adiciona o endereço a qual o addressId pertence como endereço principal da pessoa a qual o personId pertence.


```
localhost:8080/person/{personId}/mainaddress/{addressId}
```

<strong>-Método PUT - Atualiza uma pessoa adicionando a ela um endereço</strong>

A rota /person/{personId}/addaddress/{addressId} passando o personId válido de uma pessoa e um ID válido de um endereço, adiciona o endereço a qual o addressId pertence como um dos endereços da pessoa a qual o personId pertence.


```
localhost:8080/person/{personId}/addaddress/{addressId}
```

#### - Rota para a entidade Endereço.

* <strong>Rota /address</strong>

Essa rota serve para lidar com toda a manipulação da entidade endereço, tem um CRUD completo.

<strong>-Método GET - Buscar todos os endereços</strong>

A rota /address usando o método GET trás todos os endereços que estiverem no Banco de Dados.
	

```
localhost:8080/address
```


<strong>-Método GET com Id - Buscar uma address</strong>

A rota /address/{id} usando o método GET e passando um ID válido trás as informações de um endereço que estiver no banco de dados.

```
localhost:8080/address/{id}
```

	

<strong>-Método POST - Criar uma address</strong>

A rota /address/ usando o método POST envia para o banco de dados as informações de um endereço a ser criado.
	

```
localhost:8080/address
```

<details>
  <summary><strong> Exemplo de JSON a ser enviado para criar um endereço:</strong></summary><br />
	
```json
{
    "number": 123,
    "publicPlace": "Flores",
    "cep": "cep"
}


```
	
</details>

.
<strong>-Método DELETE - Excluir um endereço</strong>

A rota /address/{id} usando o método DELETE e passando um ID válido, envia para a aplicação uma ordem de deleção de um endereço a qual pertense o id.
	

```
localhost:8080/address/{id]
```

<strong>-Método PUT - Atualizar um endereço</strong>

A rota /address/{id} usando o método PUT e passando um ID válido, juntamente com novas informações no corpo da requisição, faz a atualização de um endereço.
	

```
localhost:8080/address/{id}
```

<details>
  <summary><strong> Exemplo de JSON a ser enviado para atualizar uma pessoa:</strong></summary><br />
	
```json
{
    "number": 123,
    "publicPlace": "Umari",
    "cep": "cep"
}


```
	
</details>

####Autor
- Francisco <strong>Imar Mendes</strong>
- Desevolvedor Fullstack
- Java - Javascrip - C#
- [Linkedin](https://www.linkedin.com/in/imarmendes/)

