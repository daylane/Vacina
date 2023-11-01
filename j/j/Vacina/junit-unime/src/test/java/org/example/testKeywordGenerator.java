package org.example;

import org.example.service.KeywordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class testKeywordGenerator {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 12, 21})
    @DisplayName(" teste - deve ser possivel gerar uma senha numerica com 8 digitos")
    public void testNumberKeyword(int size) throws Exception {


        //arrange

        KeywordGenerator keywordGenerator  = new KeywordGenerator();


        //act
       String generatorPassword = keywordGenerator.generatorNumberKeyword(size);

        //assert
        Assertions.assertEquals(size +1, generatorPassword.length());


    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 121, 521})
    @DisplayName(" teste - Não deve ser possivel gerar uma senha numerica essesdigitos")
    public void testNumberKeywordExceptions(int size){


        //arrange
        KeywordGenerator keywordGenerator  = new KeywordGenerator();

        //act
        Executable executable = () -> keywordGenerator.generatorNumberKeyword(size);

        //assert
        Assertions.assertThrows(Exception.class , executable);


    }
}
