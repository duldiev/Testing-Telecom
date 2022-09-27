package com.example.assignment3;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// https://www.telecom.kz/
public class MainPage {
    public SelenideElement loginButton = $("a.btn.btn-with-icon.main-menu__actions-item.main-menu__actions-auth-link");
//    public SelenideElement toolsMenu = $x("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']");
//    public SelenideElement searchButton = $("[data-test='site-header-search-action']");
}
