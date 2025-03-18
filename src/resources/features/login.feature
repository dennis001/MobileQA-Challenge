# language: pt
# encoding: UTF-8

Funcionalidade: Login

  @login-sucesso
  Cenário: Login com sucesso
    Dado que o usuário está na página de login
    Quando o usuário insere o nome de usuário "osvaldocruzeirinho@test.com" e a senha "pwd123"
    Então o usuário deve ser redirecionado para a página inicial

  @login-falha
  Esquema do Cenário: Login com falha
    Dado que o usuário está na página de login
    Quando o usuário insere o nome de usuário "<usuario>" e a senha "<senha>"
    E clica no botão de login
    Então o usuário deve ver a mensagem de erro "<mensagem>"
    |usuario|senha|         mensagem         |
    |usuario|senha|Usuário ou senha inválidos|
    |usuario|senha|     Usuário inválido     |
    |usuario|senha|      Senha inválida      |

  @logout-sucesso
  Cenário: Logout com sucesso
    Dado que o usuário está logado
    Quando o usuário clica no botão de logout
    Então o usuário deve ser redirecionado para a página de login