package com.example.assignment3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.telecom.kz/");
    }

    @Test
    public void authWithValidCredential() {
        mainPage.loginButton.click();
        $("input.ui-form__input.ui-form__input__mobile").sendKeys("+77089807609");
        $("button.ui-button.ui-button--primary.ui-button--block").click();
    }

    @Test
    public void authWithInValidCredential() {
        mainPage.loginButton.click();
        $("input.ui-form__input.ui-form__input__mobile").sendKeys("+7777777777");
        $("button.ui-button.ui-button--primary.ui-button--block").click();
    }

    @Test
    public void logOut() {
        authWithValidCredential();
    }

    @Test
    public void recovery() {
        open("https://telecom.kz/en/customer/forgot-password");
        $("div.ui-form__group.ui-form__group__select").find("select").find("option[value='phone']").click();
        $("input.ui-form__input.is-valid").shouldBe(visible).sendKeys("+77089807609");
        $("button.ui-button.ui-button--primary.ui-button--block.mt-4").click();
    }

    @Test
    public void changeLanguage() {
        $("button.btn.dropdown-toggle.btn-link").click();
        $("ul.dropdown-menu.dropdown-menu-right.show").shouldBe(visible).find("li").click();
    }

    @Test
    public void recommendedMoviesDescriptionCheck() {
        open("https://telecom.kz/en/common/video-request");
        changeLanguage();
        $("a.next").click();
        $("div.carousel-3d-slide.current").shouldBe(visible).hover();
    }

    @Test
    public void searchEngine() {
        $("button.btn.btn-with-icon.main-menu__actions-search").click();
        $("input.main-menu__search-input").sendKeys("интернет");
        $("input.main-menu__search-input").pressEnter();
        $("div.search-item").shouldBe(visible);
    }

    @Test
    public void supportPage() {
        open("https://telecom.kz/en/knowledge/14");
        $("div.swiper-slide.swiper-slide-duplicate.swiper-slide-next").click();
        $("h2.knowledge__content__title.knowledge__content__title-icon").shouldBe(visible);
    }
}
