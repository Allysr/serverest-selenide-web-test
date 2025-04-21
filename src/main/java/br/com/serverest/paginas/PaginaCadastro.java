package br.com.serverest.paginas;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaginaCadastro {
    private SelenideElement textoCadastro = $(byText("Cadastro"));
    private SelenideElement campoNome = $(By.id("nome"));
    private SelenideElement campoEmail = $(By.id("email"));
    private SelenideElement campoSenha = $(By.id("password"));
    private SelenideElement isAdministrador = $(By.id("administrador"));
    private SelenideElement botaoCadastrar =  $(byAttribute("data-testid", "cadastrar"));
    private SelenideElement mensagemErroEmail = $(byText("Este email já está sendo usado"));


    public PaginaCadastro preencherNome(String nome) {
        campoNome.setValue(nome);
        return this;
    }

    public PaginaCadastro preencherEmail(String email) {
        campoEmail.setValue(email);
        return this;
    }

    public PaginaCadastro preencherSenha(String senha) {
        campoSenha.setValue(senha);
        return this;
    }

    public PaginaCadastro marcarAdministrador() {
        isAdministrador.click();
        return this;
    }

    public PaginaCadastro clicarBotaoCadastrar() {
        botaoCadastrar.click();
        return this;
    }

    public PaginaCadastro validarTextoCadastroVisivel() {
        textoCadastro.shouldBe(Condition.visible);
        return this;
    }

    public PaginaCadastro validarMensagemEmailJaUtilizado() {
        mensagemErroEmail.shouldBe(Condition.visible);
        mensagemErroEmail.shouldHave(Condition.text("Este email já está sendo usado"));
        return this;
    }

    public PaginaCadastro aguardarRedirecionamento(){
        WebDriverRunner.url().contains("/home");
        return this;
    }

}
