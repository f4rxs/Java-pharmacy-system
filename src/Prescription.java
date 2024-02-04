/******************************************************************************
 * Implementation of Prescription class:
 *
 *Prescription(name,composition,dose,doctorSpecialization):with-arg constructor
 *Prescription(name,composition,dose,quantity,
 price,doctorSpeciallization):with-arg constructor
 *getDoctorSpeciallization():getter of the doctorSpeciallization
 *setDocorSpeciallization():setter of the docotorSpeciallization
 *toString():display all data of Prescription object
 ******************************************************************************/

/**
 *
 * @author USER
 */
public class Prescription extends Medicine {

  private String doctorSpecialization; //the specialization of the doctor

  //with arg constructor
  public Prescription(
    String name,
    String composition,
    int dose,
    String doctorSpecialization
  ) {
    //calling the superclass constructor to set Medicine name,composition,dose
    super(name, composition, dose, 0, 10);
    //calling the setter to set the docotorSpecializaiton
    setDoctorSpecialization(doctorSpecialization);
  }

  //with arg constructor
  public Prescription(
    String name,
    String composition,
    int dose,
    int quantity,
    double price,
    String doctorSpecialization
  ) {
    //calling the superclass constructor to set the Medicine name,composition
    //dose,quantity and price
    super(name, composition, dose, quantity, price);
    //calling the setter to set the docotorSpecializaiton
    setDoctorSpecialization(doctorSpecialization);
  }

  public String getDoctorSpecialization() {
    return doctorSpecialization; //getter of the docotorSpecialization
  }

  //setter of the doctorSpcialization
  public void setDoctorSpecialization(String doctorSpecialization) {
    this.doctorSpecialization = doctorSpecialization.toLowerCase();
  }

  @Override
  public String toString() {
    //display all the data of Prescription object
    return (
      " Prescription:\n" +
      super.toString() + //calling the toString method of the superclass
      "\ndoctor  specialization: " +
      doctorSpecialization
    );
  }
}
