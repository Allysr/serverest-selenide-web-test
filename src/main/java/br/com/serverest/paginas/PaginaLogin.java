package br.com.serverest.paginas;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaginaLogin {
    private SelenideElement botaoCadastrar =  $(byAttribute("data-testid", "cadastrar"));
    private SelenideElement textoLogin = $(byText("Login"));
    private SelenideElement campoEmail = $(By.id("email"));
    private SelenideElement campoSenha = $(By.id("password"));
    private SelenideElement botaoLogin =  $(byAttribute("data-testid", "entrar"));


    public PaginaLogin clicarBotaoCadastrar(){
        botaoCadastrar.click();
        return this;
    }

    public PaginaLogin validarPaginaLogin() {
        textoLogin.shouldBe(Condition.visible);
        return this;
    }

    public PaginaLogin preencherEmail(String email) {
        campoEmail.setValue(email);
        return this;
    }

    public PaginaLogin preencherSenha(String senha) {
        campoSenha.setValue(senha);
        return this;
    }

    public PaginaLogin clicarBotaoLogin(){
        botaoLogin.click();
        return this;
    }
}
