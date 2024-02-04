/**************************************************************************
 * Implementation of Prescription class:
 *
 *OverTheCounter(name,composition,dose,minAge):with-arg constructor
 *OverTheCounter(name,composition,dose,quantity,price):with-arg constructor
 *getMinAge():getter of the minimum age
 *setMinAge():setter of the minimum age
 *toString():display all the data of the overTheCounter
 *************************************************************************/

/**
 *
 * @author USER
 */
public class OverTheCounter extends Medicine {

  private int minAge; //the minimum age which the medicine is allowed to given

  //with-arg constructor
  public OverTheCounter(String name, String composition, int dose, int minAge) {
    //calling the superclass constructor to set name,composition and dose
    super(name, composition, dose, 0, 10);
    //calling the setter to set the minimum age
    setMinAge(minAge);
  }

  //with-arg constructor
  public OverTheCounter(
    String name,
    String composition,
    int dose,
    int quantity,
    double price,
    int minAge
  ) {
    //calling the superclass constructor to set name,composition,dose,quantity and price
    super(name, composition, dose, quantity, price);
    //calling the setter to set the minimum age
    setMinAge(minAge);
  }

  public int getMinAge() {
    return minAge; //getter of the minumum age
  }

  public void setMinAge(int minAge) {
    if (minAge < 0) this.minAge = 18; //default if the age is negative
    else this.minAge = minAge; //otherwise set the value to its given
  }

  @Override
  public String toString() {
    return (
      //displaying all the data of the OverTheCounter
      " Over the counter :\n" +
      super.toString() + //calling the toString method of the super class
      " \nminimum Age: " +
      minAge
    );
  }
}
