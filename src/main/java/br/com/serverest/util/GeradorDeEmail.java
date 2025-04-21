package br.com.serverest.util;

import java.util.UUID;

public class GeradorDeEmail {

    public static String gerarEmailAleatorio() {
        String idUnico = UUID.randomUUID().toString().substring(0, 9);
        return "usuarioo_" + idUnico + "@email.com";
    }
}

