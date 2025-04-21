package br.com.serverest.util;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class GerenciamentoDriver {

    public static void configurarDriver(String navegador) {
        switch (navegador.toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                Configuration.browserSize = "1920x1080";
                break;

            case "firefox":
                Configuration.browser = "firefox";
                Configuration.browserSize = "1920x1080";
                break;

            case "ie":
                Configuration.browser = "ie";
                Configuration.browserSize = "1920x1080";
                break;

            case "edge":
                Configuration.browser = "edge";
                Configuration.browserSize = "1920x1080";
                break;

            case "headless":
                Configuration.browser = "chrome";
                Configuration.headless = true;
                Configuration.browserSize = "1920x1080";
                break;

            default:
                throw new IllegalArgumentException("Navegador não suportado: " + navegador);
        }
    }
}

