package com.example.tests.steps;

import com.example.tests.BaseTest;
import com.example.tests.modules.CategoriesObjects;
import com.example.tests.modules.LoginObjects;
import com.example.tests.modules.TabbarObjects;
import com.example.tests.modules.ShoppingObjects;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

import static org.junit.Assert.assertTrue;

public class ShoppingSteps extends BaseTest {

    private CategoriesObjects categoriesObjects;
    private LoginSteps loginSteps;
    private TabbarObjects tabbarObjects;
    private ShoppingObjects shoppingObjects;
    private LoginObjects loginObjects;

    public ShoppingSteps() {
        categoriesObjects = new CategoriesObjects(getDriver());
        loginSteps = new LoginSteps();
        tabbarObjects = new TabbarObjects(getDriver());
        shoppingObjects = new ShoppingObjects(getDriver());
        loginObjects = new LoginObjects(getDriver());
    }

    @Dado("que o cliente está na página de categorias dos produtos")
    public void que_o_cliente_está_na_página_de_categorias_dos_produtos() {
        loginSteps.que_o_usuário_está_logado();
        tabbarObjects.clickCategoriesTab();
        System.out.println("Cliente está na página de categorias dos produtos.");
    }

    @Quando("o cliente escolher o notebook HP LP3065")
    public void o_cliente_escolher_o_notebook_hp_lp3065() {
        categoriesObjects.selectNotebookHP();
        System.out.println("Cliente escolheu o notebook HP LP3065.");
    }

    @Quando("Adicionar o item ao carrinho")
    public void adicionar_o_item_ao_carrinho() {
        shoppingObjects.addItemToCart();
        System.out.println("Item adicionado ao carrinho.");
    }

    @Então("uma mensagem de sucesso deve ser exibida com o produto {string}")
    public void uma_mensagem_de_sucesso_deve_ser_exibida_com_o_produto(String productName) {
        String expectedMessage = "Success: You have added " + productName + " to your shopping cart!";
        boolean isMessageDisplayed = shoppingObjects.waitForTextToAppear(expectedMessage, 10); // Aguarda até 10 segundos
        assertTrue("A mensagem de sucesso não foi exibida ou está incorreta.", isMessageDisplayed);
    }

    @Dado("que o cliente está na página do carrinho")
    public void que_o_cliente_está_na_página_do_carrinho() {
        loginSteps.que_o_usuário_está_logado();
        tabbarObjects.clickCartTab();
        System.out.println("Cliente está na página do carrinho.");
    }

    @Quando("o cliente clicar no botão de compra")
    public void o_cliente_clicar_no_botão_de_compra() {
        shoppingObjects.proceedButton();
        shoppingObjects.getBillingAddressDetails();
        shoppingObjects.selectDeliveryShippingMethod();
        shoppingObjects.proceedButton();
        shoppingObjects.selectDeliveryPayment();
        shoppingObjects.acceptConditionTerms();
        shoppingObjects.proceedButton();
    }

    @Quando("o cliente clicar no botão de compra sem estar logado")
    public void o_cliente_clicar_no_botão_de_compra_sem_estar_logado() {
        loginObjects.clickSkipButton();
        tabbarObjects.clickCategoriesTab();
        categoriesObjects.selectNotebookHP();
        shoppingObjects.addItemToCart();
        shoppingObjects.buyButton();
        shoppingObjects.proceedButton();
    }

    @Então("o cliente deve ser redirecionado para um card de login")
    public void o_cliente_deve_ser_redirecionado_para_um_card_de_login() {
        loginObjects.clickCardLogin();
    }

    @Então("um popup deve ser exibido com as opções de login, cadastro e continuar como convidado")
    public void um_popup_deve_ser_exibido_com_as_opções_de_login_cadastro_e_continuar_como_convidado() {
        loginObjects.clickCardSignup();    
    }
}