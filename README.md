# Desafio Atlas - Github Profile and Repositories

# Acesso a aplicação
## A aplicação foi hospeda na vercel e pode ser acessada no link abaixo:
## https://atlas-desafio-imarmendes.vercel.app/


#
# Contexto
Este projeto trata-se de um desafio da Atlas GR, que preve a construção de duas páginas:
  1. Página com espaço para buscar por um usuário do github.
  2. Página para exibir o perfil e os repositórios do usuário pesquisado.

No desafio é proposto que se use como principal tecnologia o React.

## Técnologias usadas

Front-end - Desenvolvido usando: 
* React - Tecnologia principal para componentização e contrução das páginas.
* Redux toolkit - Gerenciamento de estado e troca de dados entre as páginas.
* Jest/RTL - Para testes unitários. 
* Axios - Para requisições a API externas.
* CSS3 - Estilização das páginas.
* HTML5 - Estrutura de exibição das páginas.
* Docker - Como estrutura de container.
* ESLint - Para padronização de código.

# Clonar o projeto.
> Execulte o comando abaixo no seu terminal.
```
git clone git@github.com:imarmendes/atlas_desafio.git

```

# Para execultar o projeto
## Rodando com Docker
  ```
    cd desafio_atlas/ &&
    docker build -t desafioAtlas . &&
    docker run desafioatlas
  ``` 
  - Após os comando acima acesse o endereço listado a frente da chave "On Your Network" que consta no seu terminal.
## Rodando Local
  ```
    cd desafio_atlas/ &&
    npm install &&
    npm start
  ``` 
* Acesse o link abaixo.
 > http://localhost:3000/



## Executando Testes

* Para rodar todos os testes:

  ```
    cd desafio_atlas/ &&
    npm test
  ```
  - Após o comando, é possivel que seja necessário apertar "a" no terminal para execultar todos os teste.