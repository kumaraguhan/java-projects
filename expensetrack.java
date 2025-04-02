package expenseTracker;


import java.util.Scanner;

public class expensetrack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner2 = new Scanner(System.in);

        // Initialize total expense variable
        double totalExpense = 0;

        // Initialize categories and expenses
        String[] categories = new String[10]; // maximum 10 categories for simplicity
        double[] expenses = new double[10];
        int categoryCount = 0;
        
        System.out.print("Enter the Total Monthly Income:");
        double totalIncome = scanner.nextDouble();
        scanner.nextLine(); // To ignore the leftover /n

        // Allow for dynamic entry of categories and expenses
        while (true) {
            System.out.print("Enter the expense category (or type 'done' to finish): ");
            String category = scanner.nextLine();

            // If the user types 'done', end the input process
            if (category.equalsIgnoreCase("done")) {
                break;
            }

            // For "Food" category, allow entering multiple expenses until 'done' is typed
            if (category.equalsIgnoreCase("Food")) {
                double foodTotal = 0;
                while (true) {
                    System.out.print("Enter an expense for Food (or type 'done' to finish): ");
                    String expenseInput = scanner.nextLine();
                    
                    if (expenseInput.equalsIgnoreCase("done")) {
                        break;
                    }

                    try {
                        double expense = Double.parseDouble(expenseInput);
                        foodTotal += expense; // Add to the total for "Food"
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please enter a valid number.");
                    }
                }
                categories[categoryCount] = category;
                expenses[categoryCount] = foodTotal;
                categoryCount++;
            } else {
                // Input for any other categories (one-time input for each)
                System.out.print("Enter the expense amount for " + category + ": ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // consume the newline character

                categories[categoryCount] = category;
                expenses[categoryCount] = amount;
                categoryCount++;
            }
        }

        // Output the expenses for each category
        System.out.println("\n----- Monthly Expense Summary -----");
        System.out.println("Your Monthly Income :" + totalIncome);
        for (int i = 0; i < categoryCount; i++) {
            System.out.println(categories[i] + ": $" + expenses[i]);
            totalExpense += expenses[i]; // Add each category's expense to total
        }

        // Output total expense
        System.out.println("\nTotal Expense: $" + totalExpense);

        scanner.close();
    }
}



//
//import java.util.*;
//
//public class expensetrack {
//    
//    public static void main(String args[]){
//        
//        String[] expcat = new String[100];
//        
//        int[] eachexp = new int[100];
//        
//        int i = 0;
//        
//        String cat = "";
//        
//        int Totalexp = 0;
//        
//        System.out.println("Your Expense Tracker");
//        
//        Scanner inp = new Scanner(System.in);
//        
//        System.out.println("Enter your monthly income:");
//        
//        int income = inp.nextInt();
//        
//        while(cat != "done"){
//            System.out.println("Enter the Category of Expense or <done> to Finish");
//            
//            Scanner inp2 = new Scanner(System.in);
//            
//            cat = inp2.nextLine();
//        
//            if(cat != "done"){
//                
//                expcat[i] = cat;
//                
//                System.out.println("Enter the expense on it:");
//        
//                int exp = inp.nextInt();
//            
//                Totalexp += exp;
//            
//                eachexp[i] = exp;
//                
//                i++;
//            }else{
//            
//                return;
//            
//            }
//            
//        }
//        
//        
//        System.out.println("Total Income:" +income);
//        
//        System.out.println("Total Expense:" + Totalexp);
//        
//        for(int k = 0; k<i; k++){
//            System.out.println("Food Category:" + expcat[k]);
//            System.out.println("Expense on" + expcat[k] + ":" + eachexp[k]);
//        }
//        
//    }
//}
