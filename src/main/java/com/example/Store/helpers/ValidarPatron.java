package com.example.Store.helpers;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class ValidarPatron {
    public static boolean evaluarPatron(String regex, String cadenaEvaluar){
        Pattern pattern=Pattern.compile(regex); // compila el patron
        Matcher matcher=pattern.matcher(cadenaEvaluar); // compara con la cadena
        return matcher.matches() ? true : false; // si hay coincidencia retorna true
    }
}
