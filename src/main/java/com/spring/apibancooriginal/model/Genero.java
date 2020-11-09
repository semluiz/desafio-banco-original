package com.spring.apibancooriginal.model;

import org.apache.kafka.common.protocol.types.Field;

public enum Genero {
    M("Masculino"), F("Feminino"), O("Outros");

    private String descricao;

    private Genero(String descricao){
        this.descricao = descricao;
    }

    public String toString(){
        return this.descricao;
    }
}
