#language: pt
  #Author: Jardeson Santos
  #Encoding: UTF-8

  @regressions
  Funcionalidade: CRUD usuarios
    Eu como Administrator , quero cadastrar, buscar, atualizar e excluir usuarios do sistema.

  Cenario: Cadastrar novo usuario API Gorest
    Dado que possuo gorest token valido
    Quando envio um request de cadastro de usuario com dados validosc
    Entao o usuario deve ser criado corretamente
    E o status code deve ser 200