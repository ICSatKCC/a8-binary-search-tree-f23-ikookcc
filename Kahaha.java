

/**Kahaha

String name: Kahaha
String englishName: Striped Mullet
String scientificName: Mugil Cephalus
double maxLength: 8”
double minLength: 4”
double length variable
double weight  variable
String[] diet {zooplankton, algae, detritus,  invertebrates}
String bodyColor: silver
String finColor: silver
String sex: male or female



/**
* Moi Mana object class.
* This is the second phase of Moi life
* It is strictly male
* The size is 8 - 12 inches
* @author Lisa Miller
* @version 1.0
* @since 2/14/22
*/
public class Kahaha extends Pua_ama {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double KAHAHA_MAX_LENGTH = 8.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double KAHAHA_MIN_LENGTH= 4.0;
   
 
   /**
   * Constructor for making MoiMana with random length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species and is always male.
   * @throws FishSizeException if length is > maxLength or < minLength
   * Must send minLength  through as a temp length or throws exception
   */
   public Kahaha() {
      super("Kahaha", KAHAHA_MAX_LENGTH, KAHAHA_MIN_LENGTH, 
         KAHAHA_MIN_LENGTH, (KAHAHA_MIN_LENGTH * 2), DIET_ITEMS,  "silver", 
         "silver", "male"); 
      //method is in superclass but will use max, min length set above
      this.initLength();  
   }
   
   /**
   * Constructor for making MoiMana with a given length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species and is always male.
   * @param length the length for this fish
   * @throws FishSizeException if length > maxLength or < minLength
   */
   public Kahaha(double length) {
      super("Kahaha", KAHAHA_MAX_LENGTH, KAHAHA_MIN_LENGTH,
         length, (length * 2), DIET_ITEMS,  "silver", 
         "silver", "male"); 

   }
   /** 
   * Protected constructor for subclasses.
   * This allows subclass specific variables  
   * to pass through to I'a superclass constructor.
   *
   * In this species, the English and scientific names
   * remain the same throughout so not needed to pass from subclasses.
   *
   *@param name This fish type's Hawaiian name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param weight This fish's weight.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length > maxLength or < minLength
   */
   protected Kahaha(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor, 
         String finColor, String sex) {
       
      super(name, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   
    /** returns new Pala Moi version of this fish.
   * When Moi Mana reaches maxLength, it should levelUp to Pala moi min size
   * min size of next size is always max size of this one
   * @return a new MoiMana
   */
   public Ama_ama levelUp() {
   
      return new Ama_ama(this.maxLength);
   
   }
}
