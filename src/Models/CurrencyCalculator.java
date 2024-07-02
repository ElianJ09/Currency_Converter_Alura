package Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.Scanner;

public class CurrencyCalculator {
    Gson listGsonCurrency = new GsonBuilder().setPrettyPrinting().create();
    Scanner scanner = new Scanner(System.in);

    public double coinsConverter(String coinSelected, String nameCoinSelected, String coinToConverter, String nameCoinToConverter) {
        String valueClient;

        //Obtains the elements from the json of the API
        APIConsultor query = new APIConsultor();
        String value = listGsonCurrency.toJson(query.searchCoinSelected(coinSelected));
        JsonObject jsonObject = listGsonCurrency.fromJson(value, JsonObject.class);

        //Save the selected coin from the client
        String coinSelectedClient = jsonObject.get("base_code").getAsString();

        //Value from the coin conversion
        JsonObject conversionRates= jsonObject.getAsJsonObject("conversion_rates");
        double valueCoinToConverter = conversionRates.get(coinToConverter).getAsDouble();

        //Obtain value to do a conversion
        System.out.println("Value from the "+ coinSelectedClient + " to conversion: ");
        valueClient = scanner.nextLine();
        valueClient.replace(".",",");
        Double valueCoverterToDouble = Double.parseDouble(valueClient);


        if (valueCoverterToDouble <= 0){
            System.out.println("The value is minor of 0!. Select a correct value!");
            valueCoverterToDouble = scanner.nextDouble();
        } else if (valueCoverterToDouble >= 1){
            double conversionValue = valueCoverterToDouble * valueCoinToConverter;
            String conversionValueFromDouble =   String.format("%.2f", conversionValue);
            System.out.println(valueCoverterToDouble + " " + nameCoinSelected + " " + "====>" + " " + conversionValueFromDouble + " " + nameCoinToConverter);

            System.out.println("""
            __________________________________________________________________
            Press zero (0) if you want left.");
            Press another number [1-8] to continue do convertions);
            __________________________________________________________________
            """);

            return conversionValue;
        }
        return 0.0; //Just in Case
    }
}
