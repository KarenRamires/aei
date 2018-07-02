package com.aei.web.test;

import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

import com.aei.web.config.MyFluentTest;
import com.aei.web.page.ProfilePage;

public class ProfileTest extends MyFluentTest {

	@Page
	ProfilePage profilePage;

	@Before
	public void loginUser() {
		super.loginUser();
	}

	@Test
	public void checkIsAt() {
		// Given
		profilePage.go(port);
		profilePage.isAt();

		// When
		// and
		// and

		// Then
	}

}
