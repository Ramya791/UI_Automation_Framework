package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.NavbarPage;

import io.cucumber.java.en.And;

public class NavBarSteps
{
	private NavbarPage navbarPage=new NavbarPage();
	private LoginPage loginPage=new LoginPage();
	
	 @And("User logs out")
	public void userSelectsLogoutOptionFromNavbar()
	{
		navbarPage.userSelectsLogoutOptionFromNavbar();
		Assert.assertTrue(loginPage.isLogoPresent());
	}

}
