package com.example.tests.steps;

import com.example.tests.BaseTest;
import com.example.tests.modules.LoginObjects;
import com.example.tests.modules.ProfileObjects;
import com.example.tests.modules.TabbarObjects;
import com.example.tests.modules.HomeObjects;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

public class LoginSteps extends BaseTest {

    private LoginObjects loginObjects;
    private ProfileObjects profileObjects;
    private TabbarObjects tabbarObjects;
    private HomeObjects homeObjects;

    public LoginSteps() {
        loginObjects = new LoginObjects(getDriver());
        profileObjects = new ProfileObjects(getDriver());
        tabbarObjects = new TabbarObjects(getDriver());
        homeObjects = new HomeObjects(getDriver());
    }

    private void realizarLogin(String email, String password) {
        loginObjects.enterUserEmail(email);
        loginObjects.enterPassword(password);
        loginObjects.clickSigninButton();
    }

    @Dado("que o usuário está na página de login")
    public void que_o_usuário_está_na_página_de_login() {
        driver = getDriver(); // Obtém o driver inicializado
        loginObjects.clickSkipButton();
        tabbarObjects.clickProfileTab();
        profileObjects.clickSigninButton();
    }

    @Quando("o usuário insere o nome de usuário {string} e a senha {string}")
    public void o_usuário_insere_o_nome_de_usuário_e_a_senha(String email, String password) {
        loginObjects.enterUserEmail(email);
        loginObjects.enterPassword(password);
        loginObjects.clickSigninButton();
    }

    @Então("o usuário deve ser redirecionado para a página inicial")
    public void o_usuário_deve_ser_redirecionado_para_a_página_inicial() {
        assertTrue(driver.findElement(By.id("com.example:id/home")).isDisplayed());
    }

    @Quando("o usuário insere o nome de usuário {string} e a senha {string} incorretos")
    public void o_usuário_insere_o_nome_de_usuário_e_a_senha_incorretos(String email, String password) {
        loginObjects.enterUserEmail(email);
        loginObjects.enterPassword(password);
        loginObjects.clickSigninButton();
    }

    @Então("o usuário deve ver a mensagem de erro {string}")
    public void o_usuário_deve_ver_a_mensagem_de_erro(String errorMessage) {
        assertTrue(loginObjects.getErrorMessage().contains(errorMessage));
    }

    @Dado("que o usuário está logado")
    public void que_o_usuário_está_logado() {
        driver = getDriver(); // Obtém o driver inicializado
        loginObjects.clickSkipButton();
        tabbarObjects.clickProfileTab();
        realizarLogin("osvaldocruzeirinho@test.com", "pwd123");
        homeObjects.isBackToTopVisible();
}

    @Quando("o usuário clica no botão de logout")
    public void o_usuário_clica_no_botão_de_logout() {
        tabbarObjects.clickProfileTab();
        profileObjects.clickSignoutButton();
    }

    @Então("o usuário deve ser redirecionado para a home page")
    public void o_usuário_deve_ser_redirecionado_para_a_home_page() {
        homeObjects.isBackToTopVisible();
    }
}