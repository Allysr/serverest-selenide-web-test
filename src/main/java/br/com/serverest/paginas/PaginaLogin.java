package br.com.serverest.paginas;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class PaginaLogin {
    private SelenideElement botaoCadastrar =  $(byAttribute("data-testid", "cadastrar"));

    public PaginaLogin clicarBotaoCadastrar(){
        botaoCadastrar.click();
        return this;
    }
}
