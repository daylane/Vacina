package org.example.service;

//gerar senhas alfanumericas
//gerar senhas numericas
//gerar senha forte

import java.util.Random;

//definir o tamanho da senha
//apenas senhas  de no minimo 4 digitos e no maximo 100 digitos
public class KeywordGenerator {

    public String generatorNumberKeyword(int size) throws Exception {
        if(size < 4 || size > 100){
            throw new Exception("Só é possivel gerar senhas com comprimetnto entre 4 e 100 digitos");
        }
        String password ="";
        Random random = new Random();

        for (int i=0; i<size;i++){
            int RandomNumber = random.nextInt(10);
            password = password.concat(String.valueOf(RandomNumber));
        }
        return password;
    }

}
