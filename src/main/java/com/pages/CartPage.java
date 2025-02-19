package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
	public CartPage() {
		super();
	}

	private By cartPageTitle = By.xpath("//span[normalize-space()='Products']");

	private By cart_item = By.xpath("//div[@class='inventory_item_name']");

	private By checkout_button = By.xpath("//button[@name='checkout']");

	public WebElement getCartPageTitle() {
		return getWebElement(cartPageTitle);
	}

	public List<WebElement> getCartItems() {
		return getWebElements(cart_item);
	}

	public boolean isCartPageLogoPresent() {
		return isElementVisible(cartPageTitle);
	}

	public WebElement getCheckoutButton() {
		return getWebElement(checkout_button);
	}

	public boolean checkListOfProductsOnCart(String products) {

		List<WebElement> productWebElements = getCartItems();
		
		System.out.println("web elements size--"+productWebElements.size());
		

		if (products.isEmpty()) {
			return productWebElements.size() == 0;
		} else {
			String[] selected_products = products.split(",");
			List<String> products_on_cart = new ArrayList<String>();
			for (WebElement p : productWebElements) {
				products_on_cart.add(p.getText());
			}
			System.out.println("On cart " + products_on_cart);

			for (int i = 0; i < selected_products.length; i++) {
				selected_products[i] = selected_products[i].replace("-", " ");
				System.out.println("Selected " + selected_products[i]);
			}

			if (selected_products.length != products_on_cart.size()) {
				return false;
			}
			for (int i = 0; i < selected_products.length; i++) {
				if (selected_products[i].equalsIgnoreCase(products_on_cart.get(i)) == false) {
					return false;
				}

			}
			return true;
		}
	}

	public void clickOnChoeckoutButton() {
		clickElement(getCheckoutButton());
	}

}
