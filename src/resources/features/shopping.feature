# encoding: UTF-8
# language: pt
Funcionalidade: Compras no app
  Como um cliente
  Eu quero adicionar produtos ao carrinho
  Para que eu possa realizar minhas compras

  Cenário: Adicionar um produto ao carrinho
    Dado que o cliente está na página de categorias dos produtos
    Quando o cliente escolher o notebook HP LP3065
    E Adicionar o item ao carrinho
    Então uma mensagem de sucesso deve ser exibida com o produto "HP LP3065"

  Cenário: Finalizar compra
    Dado que o cliente está na página do carrinho
    Quando o cliente clicar no botão de compra
    Então uma mensagem de sucesso deve ser exibida com o produto "HP LP3065"

  Cenário: Compra sem login
    Dado que o cliente está na página do carrinho
    Quando o cliente clicar no botão de compra sem estar logado
    Então o cliente deve ser redirecionado para um card de login

  Cenário: Compra sem cadastro
    Dado que o cliente está na página do carrinho
    Quando o cliente clicar no botão de compra sem estar logado
    Então um popup deve ser exibido com as opções de login, cadastro e continuar como convidado


