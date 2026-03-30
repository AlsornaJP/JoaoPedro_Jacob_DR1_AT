package Exercicios7_12;

import Utilidades.Erros.SenhaIncorretaException;

public interface Autenticavel {
    boolean autenticar(String senha) throws SenhaIncorretaException;
}
