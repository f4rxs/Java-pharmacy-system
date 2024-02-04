/****************************************************************************
 * Implementation of Pharmacy class:
 *
 *Pharmacy(name):with-arg constructor
 *Pharmacy(name,composition,dose,quantity,price):with-arg constructor
 *getMaxNumberOfmedicines():getter of the Pharmacy's maxNumberOfMedicines
 *getOverTheCounterQuantity():getter of the Pharmacy's overTheCounterQuantity
 *getMedicines():getter of the Pharmacy's Medicine array
 *getPrescriptionQuantity():getter of the Pharmacy prescription quantity
 *getNumberOfMedicines():getter of the pharmacy number of medicines
 *setMaxNumberOfmedicines():setter of the Pharmacy's
  maximum number of medicines
 *setName():setter of the Pharmacy's name
 *addMedicine():add a given Medicine to the Pharmacy
 *risePrises():rise the price of all the medicines by specific percentage
 *searchByName():search a medicine by namme
 *searchByNameAndDose():search a medicine by name and dose
 *searchByComposition():search a medicine by composition
 *sellMedicine():sell a medicine
 *restock():add a new quantity to the avaliavle quantity
 *toString():display all the data of the pharmacy
 ***************************************************************************/

/**
 *
 * @author USER
 */

public class Pharmacy {

  private String name; //name of the pharmacy
  private int overTheCounterQuantity; //quantity of overTheCounter medicines
  private Medicine[] medicines; //array of medicines
  private int prescriptionQuantity; //quantity of prescription medicines
  private int numberOfMedicines; //number of medicines
  private static int maxNumberOfMedicines = 100; //maximum number of medicines

  //with-arg constructor
  public Pharmacy(String name) {
    this.name = name;
    this.overTheCounterQuantity = 0;
    this.medicines = new Medicine[maxNumberOfMedicines];
    this.prescriptionQuantity = 0;
    this.numberOfMedicines = 0;
  }

  //getters
  public static int getMaxNumberOfMedicines() {
    return maxNumberOfMedicines; //getter of Pharmacy's maxNumberofMedicines
  }

  //getter of Pharmacy's overTheCounterQuantity
  public int getOverTheCounterQuantity() {
    return overTheCounterQuantity;
  }

  public Medicine[] getMedicines() {
    return medicines; //getter of the Pharmacy's Medicine array
  }

  public int getPrescriptionQuantity() {
    return prescriptionQuantity; //getter of the Pharmacy prescription quantity
  }

  public int getNumberOfMedicines() {
    return numberOfMedicines; //getter of the pharmacy number of medicines
  }

  //setters
  //setter of the Pharmacy's maximum number of medicines
  public static void setMaxNumberOfMedicines(int maxNumberOfMedicines) {
    //defualt value if the maxNumberOfMedicines is negative
    if (maxNumberOfMedicines < 0) Pharmacy.maxNumberOfMedicines = 100;
    //otherwise set to its given  value
    else Pharmacy.maxNumberOfMedicines = maxNumberOfMedicines;
  }

  //setter of the Pharmacy's name
  public void setName(String name) {
    this.name = name;
  }

  //a method to add a given Medicine to the Pharmacy
  public void addMedicine(Medicine medicine) {
    //check if the capacity is full
    if (numberOfMedicines >= maxNumberOfMedicines) {
      System.out.println("The medicine cannot be added (Full capacity).");
      return;
    }
    //for loop to check if the medicine on which is going to be added exisits
    for (int index = 0; index < numberOfMedicines; index++) {
      if (medicines[index].equals(medicine)) {
        System.out.println("The medicine already exisits.");
        return;
      }
    }
    //other wise the madicine will be added
    medicines[numberOfMedicines] = medicine;
    numberOfMedicines++;
    //increasing  overThecounterQuantity
    if (medicine instanceof OverTheCounter) {
      overTheCounterQuantity += medicine.getQuantity();
      //increasing prescriptionQuantity
    } else if (medicine instanceof Prescription) {
      prescriptionQuantity += medicine.getQuantity();
    }
    System.out.println("New medicine is added successfully.");
  }

  //a method that rise the price of all the medicines a by specific percentage
  public void risePrises(double percentage) {
    //for loop to rise the price of all medicines in the array of medicines
    for (int index = 0; index < numberOfMedicines; index++) {
      double newPrice = medicines[index].getPrice() * (1 + percentage / 100);
      medicines[index].setPrice(newPrice); //setting the new price
    }
  }

  // a method to search the medicine by name
  public int[] searchByName(String nameOftheMedicine) {
    //name of the medicine should be lowerCase
    nameOftheMedicine = nameOftheMedicine.toLowerCase();
    int count = 0; //count the number of occurences
    int temp[] = new int[numberOfMedicines]; //temp array tp store the indices
    //for loop to check if the given name is found in the array
    for (int index = 0; index < numberOfMedicines; index++) {
      if (medicines[index].getName().equals(nameOftheMedicine)) {
        temp[count] = index;
        count++;
      }
    }
    //getting the indices from the temp array
    int[] indices = new int[count];
    for (int index = 0; index < indices.length; index++) {
      indices[index] = temp[index];
    }
    return indices; //returning the indices
  }

  //a method to search for a medicine by name and dose
  public int searchByNameAndDose(
    String nameOftheMedicine,
    int doseOftheMedicine
  ) {
    //for loop to check if the given name and dose found in the array
    for (int index = 0; index < numberOfMedicines; index++) {
      if (
        medicines[index].getName().equals(nameOftheMedicine) &&
        medicines[index].getDose() == doseOftheMedicine
      ) {
        return index; //return the index if the given name and dose found
      }
    }
    return -1; //otherwise -1
  }

  //method to search the medicine  by compstition
  public int[] searchByComposition(String compositionOfTheMedicine) {
    //composition of the medicine should be lowercase
    compositionOfTheMedicine = compositionOfTheMedicine.toLowerCase();
    int count = 0; //count the number of occurrences
    int[] temp = new int[medicines.length];
    //check if the given composition is found
    for (int index = 0; index < numberOfMedicines; index++) {
      if (medicines[index].getComposition().equals(compositionOfTheMedicine)) {
        temp[count] = index;
        count++;
      }
    }
    //getting the indices from the temp array
    int[] location = new int[count];
    for (int index = 0; index < location.length; index++) {
      location[index] = temp[index];
    }

    return location;
  }

  //method that sell a medicine
  public void sellMedicine(
    String nameOfTheMedicine,
    int doseOftheMedicine,
    int quantityOfTheMedicine
  ) {
    //calling searchByNameAndDose to use indexOfThrMedicine
    int indexOfTheMedicine = searchByNameAndDose(
      nameOfTheMedicine,
      doseOftheMedicine
    );
    //displaying for the user that the medicine not found if the index is -1
    if (indexOfTheMedicine == -1) {
      System.out.println("The medicine is not found.");
    }
    //for loop to check if the given name and dose are avaliable
    for (int index = 0; index < numberOfMedicines; index++) {
      if (
        medicines[index].getName().equals(nameOfTheMedicine) &&
        medicines[index].getDose() == doseOftheMedicine
      ) {
        //making sure that the quantity of the medicine is >= to the given one
        if (quantityOfTheMedicine <= medicines[index].getQuantity()) {
          medicines[index].setQuantity(
              medicines[index].getQuantity() - quantityOfTheMedicine
            );
          //overTheCounterQuantity shall decrease after the sell
          if (medicines[index] instanceof OverTheCounter) {
            overTheCounterQuantity -= quantityOfTheMedicine;
          }
          //PrescriptionQuantity shall decrease after the sell
          if (medicines[index] instanceof Prescription) {
            prescriptionQuantity -= quantityOfTheMedicine;
          }
          System.out.println("selling successful.");
        } //if the quantity is not enough the sell should not be taken
        else {
          System.out.println("The avaliable quantity is not enough.");
        }
        break; //to break after the sell
      }
    }
  }

  //a method restock that increases the quantity of a given medicine
  public boolean restock(
    String nameOfTheMedicine,
    int doseOfTheMedicine,
    int newQuantity
  ) {
    //calling searchByNameAndDose to use the index
    int index = searchByNameAndDose(nameOfTheMedicine, doseOfTheMedicine);

    if (index != -1) { // medicine already exists in the array
      medicines[index].setQuantity(
          medicines[index].getQuantity() + newQuantity
        );
      //chek if the given medicine is from overTheCounter type to increase
      if (medicines[index] instanceof OverTheCounter) {
        overTheCounterQuantity += newQuantity;
      } //chek if the given medicine is from overTheCounter type to increase
      else if (medicines[index] instanceof Prescription) {
        prescriptionQuantity += newQuantity;
      }
      return true; //the restoke is done
    } else {
      return false; // medicine does not exist in the array
    }
  }

  @Override
  public String toString() {
    //display all data of a Pharmacy object
    return (
      "pharmacy: " +
      name +
      "\nNumber of Medicines: " +
      numberOfMedicines +
      "\nOver the counter quantity: " +
      overTheCounterQuantity +
      "\nPrescription quantity: " +
      prescriptionQuantity
    );
  }
}
