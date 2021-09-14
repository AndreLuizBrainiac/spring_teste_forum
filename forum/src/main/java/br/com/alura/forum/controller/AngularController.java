package br.com.alura.forum.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.UserAngularDTO;
import br.com.alura.forum.controller.form.UserAngularForm;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.AngularRepository;

@RestController
@RequestMapping("/userAngular")
public class AngularController {

   @Autowired
   private AngularRepository angularRepository;


   @PostMapping
   public ResponseEntity<UserAngularDTO> cadastrar(@RequestBody UserAngularForm form, UriComponentsBuilder uriBuilder) {


      Usuario user = form.converterAngularUser();
      angularRepository.save( user );

      URI uri = uriBuilder.path( "/userAngular/{id}" ).buildAndExpand( user.getId()).toUri();
      return ResponseEntity.created( uri ).body( new UserAngularDTO( user ) );

   }
}
