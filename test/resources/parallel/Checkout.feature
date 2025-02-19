Feature: User checkout flow

 Scenario Outline: User adds product to cart and proceeds to checkout
 
 Given User logs in with the credentials "<username>" and "<password>"
 Then User is navigated to the home page of the site
 When User adds the products "<product_name>" to the cart
 And User goes to the cart
 Then List of products "<product_name>" added is displayed on the cart page
 And User clicks on the checkout button to finish the checkout
 And User enters the "<first_name>", "<last_name>", and "<zip_code>" to continue the checkout process.
 And User finishes the checkout process
 Then Order success message appears
 And User logs out
 
 Examples:
 |username|password|product_name|first_name|last_name|zip_code|
 |standard_user|secret_sauce|sauce-labs-backpack,sauce-labs-bike-light|John|O|p25|
    
    
    
 Scenario Outline: User adds product to cart and proceeds to checkout with incomplete details
 
 Given User logs in with the credentials "<username>" and "<password>"
 Then User is navigated to the home page of the site
 When User adds the products "<product_name>" to the cart
 And User goes to the cart
 Then List of products "<product_name>" added is displayed on the cart page
 And User clicks on the checkout button to finish the checkout
 And User enters the "<first_name>", "<last_name>", and "<zip_code>" to continue the checkout process.
 Then Details required message appears for the given "<first_name>", "<last_name>", "<zip_code>"
 
 Examples:
 |username|password|product_name|first_name|last_name|zip_code|
  |standard_user|secret_sauce|sauce-labs-backpack,sauce-labs-bike-light||O|p25|
    |standard_user|secret_sauce|sauce-labs-backpack,sauce-labs-bike-light|||p25|
    |standard_user|secret_sauce|sauce-labs-backpack,sauce-labs-bike-light||O||
  
   
  
 