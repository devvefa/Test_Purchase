import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class WebForm extends PageObject {

    private final String Username = "dvptest2035@gmail.com";
    private final String Password = "@gmailA2";
    private final String Q = "Bilgisayar";



    @FindBy(id = "L-UserNameField")
    private WebElement user_name;

    @FindBy(id = "L-PasswordField")
    private WebElement pass_phrase;

    @FindBy(id = "gg-login-enter")
    private WebElement submit_button;


    @FindBy(className = "gekhq4-4")
    private WebElement accoun_element;




    @FindBy(className = "sc-4995aq-0")
    private WebElement searchWord;

    @FindBy(className = "sc-1bydi5r-0")
    private WebElement search_button;

    @FindBys( {@FindBy(className = "product-link")  })
    private List<WebElement> products ;

    @FindBy(id = "add-to-basket")
    private WebElement buy_button;


    @FindBy(className = "title-link")
    private WebElement product_name_in_cart;

    @FindBy(id = "sp-price-lowPrice")
    private WebElement element_price;

    @FindBy(className = "total-price")
    private WebElement cart_price;




    @FindBy(className = "amount")
    private WebElement amount;

    @FindBy(className = "btn-delete")
    private WebElement delete_product_btn;


    @FindBy(className = "new-price-box")
    private WebElement total_cart_price;



    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(){
        this.user_name.sendKeys(Username);
    }

    public void enterPassword(){
        this.pass_phrase.sendKeys(Password);
    }

    public String getAccount(){
        System.out.println(this.accoun_element.getText());
        return this.accoun_element.getText();
    }

    public void enterSearchQ(){
        this.searchWord.sendKeys(Q);
    }


    public float convertStringToFloatPrice( String s){

        s=s.replace(".","");
        s=s.replace(",",".");
        return  Float.parseFloat(s.substring(0,s.indexOf(" ")));
    }

    public float getPriceDetailPage(){


        return convertStringToFloatPrice(this.element_price.getText());
    }

    public String selectRandomProduct(){
        int maxProducts =  this.products.size();
        // get random number
        Random random = new Random();
        int randomProduct = random.nextInt(maxProducts);
        WebElement product= this.products.get(randomProduct);



        String s =product.getText() ;
        product.click();
        return s.substring(0,s.indexOf("\n"));


    }
    public String getNameCartProduct(){
        return this.product_name_in_cart.getText();

    }
    public void setAmountProduct()   {
        Select dropdown = new Select(this.amount);
        dropdown.selectByVisibleText("2");


    }

    public float getCartPrice(){
        return convertStringToFloatPrice(this.cart_price.getText());

    }
    public String testClearCart(){

            this.delete_product_btn.click();


        return this.total_cart_price.getText();
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }
    public void pressSearchButton(){
        this.search_button.click();
    }
    public void pressBuyButton(){
        this.buy_button.click();
    }

}