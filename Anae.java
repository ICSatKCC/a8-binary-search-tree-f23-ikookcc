import java.util.Random;
/**Anae
* need to add string set to Ama Ama and Anea 
* you will need to make a constructor for 'Ama'ama and 'Anae 
* that take both the length and the sex in as parameters. 
* These will need to be used by the levelUp methods in Kahaha and 'Ama'ama.

String name: ‘Anae
String englishName: Striped Mullet
String scientificName: Mugil Cephalus
double maxLength: 27”
double minLength: 12”
double length variable
double weight  variable
String[] diet {zooplankton, algae, detritus,  invertebrates}
String bodyColor: silver
String finColor: silver
String sex: male or female



import java.util.Random;
/**
* Moi object class.
* This is the fourth and final phase of Moi life
* It is strictly female
* The size is 16 inches and up
* @author Lisa Miller
* @version 1.0
* @since 2/14/22
*/
public class Anae extends Ama_ama {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia.
   * This is the state record 
   * Private because not inherited.
   */
   private static final double MOI_MAX_LENGTH = 27.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double MOI_MIN_LENGTH = 12.0;
   
 
   /**
   * Constructor for making Moi with random length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the fourth phase of the species and always female
   * @throws FishSizeException if length is less than minLength
   * Must send minLength through as a temp length or throws exception
   */
   public Anae() {
      super("\'Anae", MOI_MAX_LENGTH, MOI_MIN_LENGTH, 
         MOI_MIN_LENGTH, (MOI_MIN_LENGTH * 2), DIET_ITEMS, "silver",
          "silver", "Male"); 
      //method is in superclass but will use max, min length set above
      this.initLength();  
   }
   
   /**
   * Constructor for making Moi with a given length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the fourth phase of the species and always female.
   * @param length The length of this fish.
   * @throws FishSizeException if length is less than minLength
   */
   public Anae(double length) {
      super("\'Anae", MOI_MAX_LENGTH, MOI_MIN_LENGTH, 
         length, (length * 2), DIET_ITEMS,  "silver", 
         "silver", "Male"); 
   
   }
   

   public Anae(double length, String sex) {
      super("\'Anae", MOI_MAX_LENGTH, MOI_MIN_LENGTH, 
         length, (length * 2), DIET_ITEMS,  "silver", 
         "silver", sex); 
   
   }

   //Moi do not change to another type
   //overwrite the grow method from the base class.
   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * Does not throw FishSizeException because this is the final type
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;
   
      //calculate a new length by adding a random value between 0 and growthRate
      this.length = this.length + lengthIncrease;
      this.weight = this.length * 2;
   }

   /** returns the same fish
   * Moi don't level up, this is the terminal type.
   * method is required but shouldn't do anything
   * @return the same fish
   */
   public Anae levelUp() {
   
      return this;
   
   }
}