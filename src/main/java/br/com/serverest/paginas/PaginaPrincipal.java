package br.com.serverest.paginas;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class PaginaPrincipal {
    private SelenideElement tituloBemVindo = $("h1");
    private SelenideElement botaoLogout =  $(byAttribute("data-testid", "logout"));

    public PaginaPrincipal validarTextoBemVindo() {
        tituloBemVindo.shouldHave(Condition.text("Bem Vindo"));
        tituloBemVindo.shouldBe(visible);
        return this;
    }

    public PaginaPrincipal validarTextoServerest() {
        tituloBemVindo.shouldHave(Condition.text("Serverest Store"));
        tituloBemVindo.shouldBe(visible);
        return this;
    }

    public PaginaPrincipal clicarBotaoLogout() {
        botaoLogout.click();
        return this;
    }

}
