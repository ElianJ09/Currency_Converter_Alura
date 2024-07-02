package Models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencySelect {
    //Declarations Private Variables
    private final Scanner scanner = new Scanner(System.in);
    private final CurrencyCalculator coinCalculator = new CurrencyCalculator();
    private final MainMenuCurrency menu = new MainMenuCurrency();
    private final CoinsHistory coinsHistory = new CoinsHistory();

    //Function to Select a type of Currency
    public void selectCoin() {
        int option = 0;
        //Show Menu of Currency
        menu.showMenu();
        do {
            //Exception to Validate a number from the menu
            try{
                option = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Error: Select a validate number from the menu!");
                scanner.next();
                continue;
            }

            //Coin Converter with the type of Coin from the option client
            switch (option) {
                case 0:
                    //Show Bye to client!
                    System.out.println(menu.showByeMenu());
                    break;
                case 1:
                    currencyCalculatorFunction("USD", "Dólar", "ARS", "Peso argentino");
                    break;
                case 2:
                    currencyCalculatorFunction("ARS", "Peso argentino", "USD", "Dólar");
                    break;
                case 3:
                    currencyCalculatorFunction("USD", "Dólar", "BRL", "Real brasileño");
                    break;
                case 4:
                    currencyCalculatorFunction("BRL", "Real brasileño", "USD", "Dólar");
                    break;
                case 5:
                    currencyCalculatorFunction("USD", "Dólar", "COP", "Peso colombiano");
                    break;
                case 6:
                    currencyCalculatorFunction("COP", "Peso colombiano", "USD", "Dólar");
                    break;
                case 7:
                    currencyCalculatorFunction("USD", "Dólar", "EUR", "Euro");
                    break;
                case 8:
                    currencyCalculatorFunction("EUR", "Euro", "USD", "Dólar");
                    break;
                case 9:
                    //Show the currency history
                    showHistory();
                    break;
                default:
                    //If client not use a validate number
                    System.out.println("Invalid option!. Select a valid option from the menu!");
            }
        }
        while (option != 0);
        scanner.close();
    }

    private void currencyCalculatorFunction(String mainCoin, String nameMainCoin, String coinToConverter, String nameCoinToConverter) {
        double valueConverter = coinCalculator.coinsConverter(mainCoin, nameMainCoin, coinToConverter, nameCoinToConverter);

        //Log Formatter to conversions History
        String converterHistory = "Value Converter from " + nameMainCoin + "(" + mainCoin + ") to " + nameCoinToConverter + "(" + coinToConverter + "): " + valueConverter;
        System.out.println(converterHistory);
        coinsHistory.addConversionToCoinsHistory(converterHistory);
    }

    private void showHistory(){
        coinsHistory.showHistory();
    }
}
