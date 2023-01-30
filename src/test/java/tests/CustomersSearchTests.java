package tests;

import org.junit.jupiter.api.Test;
import pom.CustomersPage;
import utils.Messages;
import utils.SearchDropDown;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class CustomersSearchTests extends BaseTest {

    private final CustomersPage customersPage = new CustomersPage(super.driver);

    @Test
    public void searchByPartialNameTest() {
        //Given
        final var nameValue = "Ala";
        final var resultSet = List.of("1", "Alabaster", "office@alabaster.com", "Melbourne");

        //When
        customersPage.selectDropDownValue(SearchDropDown.NAME.getValue());
        customersPage.fillSearch(nameValue);

        //Then
        assumeTrue(customersPage.getResponseColumnCount() == 4,
                Messages.NUMBER_OF_COLUMNS_ARE_NOT_AS_EXPECTED);
        verifyResultSet(resultSet, 1);
    }

    @Test
    public void searchByPartialEmailTest() {
        //Given
        final var emailValue = "cona";
        final var resultSet = List.of("2", "Postimex", "conatact@postimex.pl", "Carthage");

        //When
        customersPage.selectDropDownValue(SearchDropDown.EMAIL.getValue());
        customersPage.fillSearch(emailValue);

        //Then
        verifyResultSet(resultSet, 1);
    }

    @Test
    public void searchByPartialCityTest() {
        //Given
        final var cityValue = "Bel";
        final var resultSet = List.of("3", "Bondir", "info@bond.ir", "Belfast");

        //When
        customersPage.selectDropDownValue(SearchDropDown.CITY.getValue());
        customersPage.fillSearch(cityValue);

        //Then
        verifyResultSet(resultSet, 1);
    }

    private void verifyResultSet(List<String> resultSet, int rowNumber) {
        assertAll(
                () -> assertEquals(1, customersPage.getResponseRowCount(),
                        Messages.NUMBER_OF_RAWS_IS_NOT_AS_EXPECTED),
                () -> assertEquals(resultSet.get(0), customersPage.getResponseCellValue(rowNumber, 1),
                        Messages.ID_IS_NOT_AS_EXPECTED),
                () -> assertEquals(resultSet.get(1), customersPage.getResponseCellValue(rowNumber, 2),
                        Messages.NAME_IS_NOT_AS_EXPECTED),
                () -> assertEquals(resultSet.get(2), customersPage.getResponseCellValue(rowNumber, 3),
                        Messages.EMAIL_IS_NOT_AS_EXPECTED),
                () -> assertEquals(resultSet.get(3), customersPage.getResponseCellValue(rowNumber, 4),
                        Messages.CITY_IS_NOT_AS_EXPECTED)
        );
    }
}