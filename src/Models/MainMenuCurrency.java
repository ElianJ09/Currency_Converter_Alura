package Models;

public class MainMenuCurrency {
    private String menu = """
            ________________________________________________________________________
                                <     Currency Converter    >
            ________________________________________________________________________
            
                        Welcome to this app to currency converter!
            Instructions:
            
             A. Choose an option to convert (1 to 8)
             B. After of choose a option enter a value to convert
             C. If you want to exit the system press zero (0)
             D. Show the Conversions history (9)
            
            ************************************************************************
            
             1 - Dollar [USD]              ====>       Argentine peso [ARS]
                                                                 
             2 - Argentine peso [ARS]      ====>       Dollar [USD]
                                                                 
             3 - Dollar [USD]              ====>       Brazilian Real [BRL]
                                                     
             4 - Brazilian Real [BRL]      ====>       Dollar [USD]
                                                                 
             5 - Dollar [USD]              ====>       Colombian peso [COP]
                                                                             
             6 - Colombian peso [COP]      ====>       Dollar [USD]
                                                                             
             7 - Dollar [USD]              ====>       Euro [EUR]
                                                                             
             8 - Euro [EUR]                 ====>      Dollar [USD] 
            
            **************************************************************************
            """;

    private String byeMenu= """
            **************************************************************************
            **********   Thank you to use this app of Currency converter!  ***********
            **************************************************************************
            """;

    //Show the menu
    public void showMenu(){
        System.out.println(menu);
        System.out.println("Choose a option: ");
    }

    //Show bye to the client
    public String showByeMenu() {
        return byeMenu;
    }
}
