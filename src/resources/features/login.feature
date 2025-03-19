# encoding: UTF-8
# language: pt
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
      | osvaldocruzeirinho@test.com |         | mensagem                      |
      |                             | pwd123  | Please Enter Correct Email ID |
      | ferreirabartolo.com         | naslan  | Please Enter Correct Email ID |
      | "!@#$%¨&*()                 | !#@$%¨% | Please Enter Correct Email ID |

  @logout-sucesso
  Cenário: Logout com sucesso
    Dado que o usuário está logado
    Quando o usuário clica no botão de logout
    Então o usuário deve ser redirecionado para a home page