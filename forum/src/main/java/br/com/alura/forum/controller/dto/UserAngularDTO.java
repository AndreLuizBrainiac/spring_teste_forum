package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Usuario;

public class UserAngularDTO {

   private Long id;
   private String nome;
   private String email;
   private String senha;



   public UserAngularDTO( Usuario user ) {

      this.id = user.getId();
      this.nome = user.getNome();
      this.email = user.getEmail();
      this.senha = user.getSenha();
   }



   public Long getId() {
      return id;
   }



   public String getNome() {
      return nome;
   }



   public String getEmail() {
      return email;
   }



   public String getSenha() {
      return senha;
   }



}
