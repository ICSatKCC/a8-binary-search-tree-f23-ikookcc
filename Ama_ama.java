/**Ama_ama 


String name: ‘Ama’ama
String englishName: Striped Mullet
String scientificName: Mugil Cephalus
double maxLength: 12”
double minLength: 8”
double length variable
double weight  variable
String[] diet {zooplankton, algae, detritus,  invertebrates}
String bodyColor: silver
String finColor: silver
String sex: male or female



/**
* Pala Moi object class.
* This is the third phase of Moi life
* It is strictly a hermaphrodite (intersexed)
* The size is 12 - 16 inches
* @author Lisa Miller
* @version 1.0
* @since 2/14/22
*/
public class Ama_ama extends Kahaha {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double AMA_AMA_MAX_LENGTH = 12.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double AMA_AMA_MIN_LENGTH = 8.0;
   
 
   /**
   * Constructor for making PalaMoi with random length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the third phase of the species, is a hermaphrodite (intersexed).
   * @throws FishSizeException if length > maxLength or < minLength
   * Must send minLength through as a temp length or throws exception
   */
   public Ama_ama() {
      super("\'Ama\'ama", AMA_AMA_MAX_LENGTH, AMA_AMA_MIN_LENGTH, 
         AMA_AMA_MIN_LENGTH, (AMA_AMA_MIN_LENGTH * 2), DIET_ITEMS,  
         "silver", "silver", "Male"); 
      //method is in superclass but will use max, min length set above
      this.initLength();  
   }
   
   /**
   * Constructor for making PalaMoi with a given length 
   * uses I_a superclass constructor
   * uses DIET_ITEMS array from super class
   * Third phase of the species, always a hermaphrodite (intersexed).
   * @param length The length for this fish.
   * @throws FishSizeException if length > or < minLength
   */
   public Ama_ama(double length) {
      super("\'Ama\'ama", AMA_AMA_MAX_LENGTH, AMA_AMA_MIN_LENGTH, 
         length, (length * 2), DIET_ITEMS,  "silver", 
         "silver", "Male"); 
   }



	public Ama_ama(double length, String sex) {
	      super("\'Ama\'ama", AMA_AMA_MAX_LENGTH, AMA_AMA_MIN_LENGTH, 
	         length, (length * 2), DIET_ITEMS,  "silver", 
	         "silver", sex); 
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
   *@param length This fish's length.
   *@param weight This fish's weight.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length > maxLength or < minLength
   */
   protected Ama_ama(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor, 
         String finColor, String sex) {
       
      super(name, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   
   /** returns new Moi version of this fish.
   * When a Pala Moi reaches maxLength, it should levelUp to a Moi of  min size
   * min size of next size is always max size of this one
   * @return a new Moi
   */
   public Anae levelUp() {
   
      return new Anae(this.maxLength);
   
   }

}