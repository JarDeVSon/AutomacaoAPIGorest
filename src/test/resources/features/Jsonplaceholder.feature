#language: pt
  #Author: Jardeson Santos
  #Encoding: UTF-8

  @regressions
  Funcionalidade: CRUD Post jsonplaceholder
    Eu como Administrator , quero cadastrar, buscar, atualizar e excluir usuarios do sistema.

    Contexto: Authorization e Authentication
      Dado que possuo gorest token valido
      @post
  Cenario: Cadastrar novo posts API jsonplaceholder

    Quando envio um request de cadastro de posts com dados validos
    Entao o post deve ser criado corretamente
    E o status code deve ser 201

    Cenario: Consultar posts API jsonplaceholder

      Quando envio um request de consulta de posts com dados validos
      Entao o post deve ser criado corretamente
      E o status code deve ser 200

    Cenario: Alterar posts API jsonplaceholder

      Quando envio um request de alteração do posts com dados validos
      Entao o post deve ser criado corretamente
      E o status code deve ser 200

    Cenario: Deletar posts API jsonplaceholder

      Quando envio um request de deletar  posts com dados validos
      Entao o post deve ser criado corretamente
      E o status code deve ser 200