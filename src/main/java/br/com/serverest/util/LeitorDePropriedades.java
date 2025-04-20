package br.com.serverest.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeitorDePropriedades {

    public static String lerPropriedades(String chave) {
        String ambiente = System.getenv("AMBIENTE");
        if (ambiente == null) ambiente = "dev";

        String caminho = ambiente + ".properties";

        Properties propriedades = new Properties();

        try (InputStream input = LeitorDePropriedades.class
                .getClassLoader()
                .getResourceAsStream(caminho)) {

            if (input == null)
                throw new FileNotFoundException("Arquivo não encontrado: " + caminho);

            propriedades.load(input);

            return propriedades.getProperty(chave);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar propriedades", e);
        }
    }
}
