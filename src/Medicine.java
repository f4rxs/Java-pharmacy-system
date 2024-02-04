/************************************************************************
 * Implementation of Medicine class:
 *
 * Medicine(name,composition,dose):with-arg constructor
 * Medicine(name,composition,dose,quantity,price):with-arg constructor
 * getName:getter of the medicine's name
 * getComposition:getter of the medicine's composition
 * getDose:getter of the medicine's dose
 * getPrice:getter of the medicine's price
 * getQuantity:getter of the medicine's quantity
 * setName:setter of the medicine's name
 * setComposition:setter of the medicine's composition
 * setDose:setter of the medicine's  dose
 * setPrice:setter of the medicine's price
 * setQuantity:setter of the medicine's quantity
 * toString():display all data of a Medcine object
 * equals():compare Medicine objects by the name and dose
 ************************************************************************/

/**
 *
 * @author USER
 */
public class Medicine {

  private String name; // name of the Medicine
  private String composition; //composition of the Medicine
  private int dose; //dose of the Medicine, default value is 1000
  private double price; //price of the Medicine, default value is 10
  private int quantity; //quantity of the Medicine, default value is 0

  //with-arg constructor
  public Medicine(String name, String composition, int dose) {
    //instantiate a Medicine object with name,composition and dose
    this(name, composition, dose, 10, 0); //calling the full constructor
  }

  //with-arg constructor
  public Medicine(
    //instantiate a Medicine object with the all datafields
    String name,
    String composition,
    int dose,
    int quantity,
    double price
  ) {
    //calling the setters to set the medicine object
    setName(name); //set the Medicine's name
    setComposition(composition); //set the Medicine's composition
    setDose(dose); //set the Medicine's dose
    setQuantity(quantity); //set the Medicine's quantity
    setPrice(price); //set the Medicine's price
  }

  //getters
  public String getName() {
    return name; //getter of the Medicine's name
  }

  public String getComposition() {
    return composition; //getter of the Medicine's composition
  }

  public int getDose() {
    return dose; //getter of the Medicine's Dose
  }

  public double getPrice() {
    return price; //getter of the Medicine's price
  }

  public int getQuantity() {
    return quantity; //getter of the Medicine's quantity
  }

  //setters
  //setter of the Medicine's name(lowercase)
  public void setName(String name) {
    this.name = name.toLowerCase();
  }

  //setter of the Medicine's composition(lowercase)
  public void setComposition(String composition) {
    this.composition = composition.toLowerCase();
  }

  //setter of Medicine's dose
  public void setDose(int dose) {
    if (dose < 0) this.dose = 1000; //defualt if the dose is negative
    else this.dose = dose; //otherwise set the value to its given
  }

  //setter of Medicine's price
  public void setPrice(double price) {
    if (price < 0) this.price = 10; //defualt if the price is negative
    else this.price = price; //otherwise set the value to its given
  }

  //setter of Medicine's quantity
  public void setQuantity(int quantity) {
    if (quantity < 0) this.quantity = 0; //defualt if the quantity is negative
    else {
      this.quantity = quantity; //otherwise set the value to its given
    }
  }

  @Override
  public String toString() {
    //display all data of a Medicine object
    return (
      "name: " +
      name +
      "\ncompostion: " +
      composition +
      "\ndose: " +
      dose +
      "mg" +
      "\nprice: " +
      price +
      "\nquantity: " +
      quantity
    );
  }

  @Override
  public boolean equals(Object obj) {
    //compare Medicine objects by name and  dose
    Medicine medicine = (Medicine) obj;
    if (name.equals(medicine.name) && dose == medicine.dose) {
      return true;
    }
    return false;
  }
}
