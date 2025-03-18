package com.example.tests.steps;

import com.example.tests.BaseTest;
import com.example.tests.modules.LoginObjects;
import com.example.tests.modules.ProfileObjects;
import com.example.tests.modules.TabbarObjects;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

public class LoginSteps extends BaseTest {

    private LoginObjects loginObjects;
    private ProfileObjects profileObjects;
    private TabbarObjects tabbarObjects;

    @Dado("que o usuário está na página de login")
    public void que_o_usuário_está_na_página_de_login() {
        driver = getDriver(); // Obtém o driver inicializado
        loginObjects = new LoginObjects(driver);
        profileObjects = new ProfileObjects(driver);
        tabbarObjects = new TabbarObjects(driver);

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
}