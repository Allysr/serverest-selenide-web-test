package br.com.serverest.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static br.com.serverest.util.GerenciamentoDriver.configurarDriver;
import static br.com.serverest.util.LeitorDePropriedades.lerPropriedades;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTeste {

    @BeforeEach
    public void iniciarNavegador(){
        configurarDriver(lerPropriedades("navegador"));
        open(lerPropriedades("url"));
        Configuration.timeout = 4000;
    }

    @AfterEach
    public void fecharNavegador(){
        closeWebDriver();
    }
}
