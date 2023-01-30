package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersPage {
    private WebDriver driver;

    @FindBy(id = "search-input")
    private WebElement search;

    @FindBy(id = "search-column")
    private WebElement dropDown;

    @FindBy(xpath = "//table/tbody")
    private WebElement responseTableBody;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillSearch(String searchValue) {
        search.sendKeys(searchValue);
    }

    public void selectDropDownValue(String dropDownValue) {
        Select select = new Select(dropDown);
        select.selectByValue(dropDownValue);
    }

    public int getResponseRowCount() {
        return responseTableBody.findElements(By.xpath(".//tr")).size();
    }

    public int getResponseColumnCount() {
        WebElement firstRow = responseTableBody.findElement(By.xpath(".//tr[1]"));
        return firstRow.findElements(By.xpath(".//td")).size();
    }

    public String getResponseCellValue(int row, int column) {
        WebElement desiredRow = responseTableBody.findElement(By.xpath(".//tr[" + row + "]"));
        WebElement desiredCell = desiredRow.findElement(By.xpath(".//td[" + column + "]"));
        return desiredCell.getText();
    }
}