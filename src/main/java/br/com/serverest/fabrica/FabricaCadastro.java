package br.com.serverest.fabrica;

import br.com.serverest.dto.CadastroDTO;

import static br.com.serverest.util.GeradorDeEmail.gerarEmailAleatorio;

public class FabricaCadastro {
    public static CadastroDTO criarUsuarioValido() {
        return new CadastroDTO(
                "Alicia Souza",
                gerarEmailAleatorio(),
                "SenhaForte123"
        );
    }
}

