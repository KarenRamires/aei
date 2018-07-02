package com.aei.web.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import com.aei.web.config.MyFluentTest;
import com.aei.web.page.LoginPage;

public class LoginTest extends MyFluentTest {

    @Page
    LoginPage loginPage;

    @Test
    public void checkLoginSucceed() {
        //Given
        loginPage.go(port);
        //When
        loginPage.fillAndSubmitForm("user", "user")
                .awaitUntilFormDisappear();
        //Then
        assertThat(window().title()).isEqualTo("AEI");
    }

    @Test
    public void checkLoginFailed() {
        //Given
        loginPage.go(port);
        //When
        loginPage.fillAndSubmitForm("wrongUser", "wrongPass");
        //Then
        assertThat($(".alert")).hasSize(1);
        loginPage.isAt();
    }


}
