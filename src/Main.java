/***********************************************************************
 * main(): main method to test the program
 * menu():method to display the menu of the Pharmacy for the user
 ***********************************************************************/

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the pharmacy name : ");
    String name = input.nextLine(); //pharmacy name input from the user
    Pharmacy myPharma = new Pharmacy(name); //creating pharmacy object
    System.out.println("Welcome to ''" + name + "'' pharmacy system.");
    System.out.println("------------------------------------------");
    System.out.println("Choose one the following options:");
    int choice;
    //do-while loop to display the menu by calling the method menu
    do {
      choice = menu();
      switch (choice) {
        case 1: //add a medicine
          System.out.println("\nEnter the information of th new medicine :");
          System.out.println();
          System.out.print(
            "choose O or o for over the counter medicine" +
            " and P or p for prescritption medicine : "
          );
          String type = input.next();
          System.out.print("name: ");
          String nameOfTheMedicine = input.next();
          System.out.print("composition: ");
          String composition = input.next();
          System.out.print("dose : ");
          int dose = input.nextInt();
          System.out.print("quantity: ");
          int quantity = input.nextInt();
          System.out.print("price: ");
          double price = input.nextDouble();
          if (type.equals("O") || type.equals("o")) { //check the type
            System.out.print("Enter the minimum Age for this medicine: ");
            //iputing the minAge from the user with type (O) medicine
            int age = input.nextInt();
            //addMedicine method is called and OverTheCounter object created
            myPharma.addMedicine(
              new OverTheCounter(
                nameOfTheMedicine,
                composition,
                dose,
                quantity,
                price,
                age
              )
            );

            System.out.println("----------------------------------------");
          } else if (type.equals("P") || type.equals("p")) { //check the type
            System.out.print(
              "Enter the doctor specialization for this medicine: "
            );
            //inputing the docotorSpeaciallization with type (P) medicine
            String specialization = input.next(); //
            //addMedicine method is called and Prescription object created
            myPharma.addMedicine(
              new Prescription(
                nameOfTheMedicine,
                composition,
                dose,
                quantity,
                price,
                specialization
              )
            );

            System.out.println("----------------------------------------");
          } else {
            //if the input is non of the valid options message will displayed
            System.out.println("invalid medicine type.");
            System.out.println("----------------------------------------");
          }
          break;
        case 2: //search a medicine by name
          System.out.println("\nEnter the name of the medicine to be found");
          String nameOfTheSearchMedicine = input.next();
          //creating an array of integer to store the elements of the method
          int[] medicineIndices = myPharma.searchByName(
            nameOfTheSearchMedicine
          );
          //if the array is empty the medicine is not found
          if (medicineIndices.length == 0) {
            System.out.println("The medicine is not found."); //message display
          } else { //otherwise the medice is found
            //conditional operator used to instantiate plural and singular
            System.out.println(
              medicineIndices.length == 1 ? "medicine found" : "medicines found"
            );
            //enhanced loop to get the Medicine by calling getMedicineMethod
            for (int index : medicineIndices) {
              Medicine medicine = myPharma.getMedicines()[index];
              //if the medicine is an overTheCounter type it get display
              if (medicine instanceof OverTheCounter) {
                System.out.println((index + 1) + "- " + medicine.toString());
                System.out.println("----------------------------------------");
              } //if the medicine is an Prescription type it get display
              else if (medicine instanceof Prescription) {
                System.out.println((index + 1) + medicine.toString());
                System.out.println("----------------------------------------");
              }
            }
          }
          break;
        case 3: //search for the medicine by Composition
          System.out.print("\nEnter the composition to be found: ");
          String nameOfTheSearchComposition = input.next();
          //storing the previous array by using the searchByComposition
          medicineIndices =
            myPharma.searchByComposition(nameOfTheSearchComposition);
          //if the length of the array is emepty medicine not found
          if (medicineIndices.length == 0) {
            //displaying the message
            System.out.println("The medicine is not found.");
          }
          //otherwise the medicine is found
          else {
            System.out.println(
              medicineIndices.length +
              " medicine found matching this composition."
            );
            //enhanced loop to get the Medicine by calling getMedicineMethod
            for (int index : medicineIndices) {
              Medicine medicine = myPharma.getMedicines()[index];
              //if the medicine is an overTheCounter type it get display
              if (medicine instanceof OverTheCounter) {
                System.out.println((index + 1) + "- " + medicine.toString());
                System.out.println("----------------------------------------");
              } //if the medicine is an Prescription type it get display
              else if (medicine instanceof Prescription) {
                System.out.println((index + 1) + medicine.toString());
                System.out.println("----------------------------------------");
              }
            }
          }
          break;
        case 4: //sell a medicine
          System.out.print("\nEnter the name of the medicine: ");
          String nameOftheSellingMedicine = input.next();
          System.out.print("Enter the dose: ");
          int doseOfTheSellingMedicine = input.nextInt();
          System.out.print("Enter the quantity: ");
          int quantityOftheSellingMedicine = input.nextInt();
          //calling the method sellMedicine
          myPharma.sellMedicine(
            nameOftheSellingMedicine,
            doseOfTheSellingMedicine,
            quantityOftheSellingMedicine
          );
          System.out.println("\n----------------------------------------");
          break;
        case 5: //restock a medicine
          System.out.print("\nEnter the name of the medicine: ");
          String nameOfStockMedicine = input.next();
          System.out.print("Enter the dose: ");
          int doseOfStockMedicine = input.nextInt();
          System.out.print("Enter the quantity: ");
          int quantityOfStockMedicine = input.nextInt();
          //calling the restock method to check if it is true
          if (
            myPharma.restock(
              nameOfStockMedicine,
              doseOfStockMedicine,
              quantityOfStockMedicine
            )
          ) {
            //if it is true restock is successful
            System.out.println("Restock Successful.");
            System.out.println("----------------------------------------");
          } //otherwise the restock is unsuccessful
          else {
            System.out.println("Restock Unsuccessful.");
            System.out.println("----------------------------------------");
          }
          break;
        case 6: //displaying all medicines
          //creating an array of Medicine object to store the medicines
          Medicine[] medicines = myPharma.getMedicines();
          //for loop to display the medicines
          for (
            int index = 0;
            index < myPharma.getNumberOfMedicines();
            index++
          ) {
            //displaying the medicines of Prescription by calling toString
            if (medicines[index] instanceof OverTheCounter) {
              System.out.print("\nMedicine " + (index + 1) + ":");
              System.out.println(medicines[index].toString());
            } //displaying the medicines of Prescription by calling toString
            else if (medicines[index] instanceof Prescription) {
              System.out.print("\nMedicine " + (index + 1) + ":");
              System.out.println(medicines[index].toString());
            }
            System.out.println("----");
          }
          System.out.println("----------------------------------------");
          break;
        case 7: //display information
          //calling the toString of the Pharmacy to display the info
          System.out.println("\n" + myPharma + "\n");
          System.out.println("----------------------------------------");
          break;
      }
    } while (choice != 8); //exit the loop if the input is 8
  }

  //creating a menu method to display the menu for the user
  public static int menu() {
    Scanner input = new Scanner(System.in);
    int choiceOfTheUser;
    System.out.println("1- Add a new medicine");
    System.out.println("2- Search for a medicine by name");
    System.out.println("3- Search for a medicine by composition");
    System.out.println("4- Sell a medicine");
    System.out.println("5- Restock a medicine");
    System.out.println("6- Display all medicines");
    System.out.println("7- Display information");
    System.out.println("8- Exit");
    System.out.println();
    //do-while to display the message  to enter the choice
    do {
      System.out.print("Enter your choice (between 1 and 8): ");
      choiceOfTheUser = input.nextInt();
      //the loop breaks if the input is valid
    } while (choiceOfTheUser < 1 || choiceOfTheUser > 8);

    return choiceOfTheUser; //reutring the choice of the integer
  }
}
