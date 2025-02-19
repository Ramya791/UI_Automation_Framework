package com.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage() {
		super();
	}

	private By products_title = By.xpath("//span[normalize-space()='Products']");

	private By add_to_cart_button = By.xpath("//button[contains(@name,'add-to-cart')]");

	private By cart_icon = By.xpath("//a[@class='shopping_cart_link']");

	public WebElement getProductsTitle() {
		return getWebElement(products_title);
	}

	public List<WebElement> getAddToCartButtons() {
		return getWebElements(add_to_cart_button);
	}

	public WebElement getCartIcon() {
		return getWebElement(cart_icon);
	}

	public boolean isLogoPresent() {
		return isElementVisible(products_title);
	}

	public void clickOnCartIcon() {
		clickElement(getCartIcon());
	}

	public void addProductsToCart(String product_names) throws InterruptedException {

		if (!product_names.isEmpty()) {
			String[] products = product_names.split(",");
			List<WebElement> add_to_cart_buttons = getAddToCartButtons();
			System.out.println(add_to_cart_buttons);

			HashMap<String, WebElement> m = new HashMap<String, WebElement>();
			for (WebElement e : add_to_cart_buttons) {
				m.put(e.getAttribute("name").replaceFirst("add-to-cart-", ""), e);
			}

			for (String product : products) {
				clickElement(m.get(product));
				System.out.println("clicked on " + product);
			}
			Thread.sleep(20);
		}

	}
}
