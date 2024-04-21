 package com.fiap.producao.models;

 import com.fiap.producao.entities.UserEntity;
 import lombok.AllArgsConstructor;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;

 @NoArgsConstructor
 @AllArgsConstructor
 @Getter
 @Setter
 public class UserModel {

     private String id;

     private String nome;

     private String cpf;

     private String email;


     public UserModel(String nome, String cpf, String email) {
         this.nome = nome;
         this.cpf = cpf;
         this.email = email;
     }

     public UserModel(String userId) {
         this.id = userId;
     }

     public static UserModel fromEntity(UserEntity userEntity) {
         return new UserModel(userEntity.getId(),
                 userEntity.getNome(),
                 userEntity.getCpf(),
                 userEntity.getEmail());
     }
 }

