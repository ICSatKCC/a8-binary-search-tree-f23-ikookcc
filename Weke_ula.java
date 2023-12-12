/**
 * Weke'ula object class.
 * Adult weke.
 * Male or Female.
 * The size is 7-30 inches.
 * Alot of this code is refrenced from MoiMana.java
 file provided by Proffesor Miller. Thank you professor!
 * @author Chiara Duyn
 * @since 10/2/23
 */
public class Weke_ula extends Oama {

    /** Constant name for this Ia. 
  * Private because not inherited.
  */
   private static final String NAME = "Weke'ula";
    /** Constant english name for this Ia. 
  * Private because not inherited.
  */
   private static final String ENGLISH_NAME = "Yellowfin Goatfish";
    /** Constant scientific name for this Ia. 
  * Private because not inherited.
  */
   private static final String SCIENTIFIC_NAME = "Mulloidichthys vanicolensis";
    /** Constant max length for this Ia. 
  * Private because not inherited.
  */
   private static final double WEKE_ULA_MAX_LENGTH = 30.0;
    /** Constant min length for this Ia. 
  * Private because not inherited.
  */
   private static final double WEKE_ULA_MIN_LENGTH = 7.0;
    /** Constant diet for this Ia. 
  * Private because not inherited.
  */
   private static final String[] DIET = {"worms", "mollusks", "invertebrates"};
    /** Constant body color for this Ia. 
  * Private because not inherited.
  */
   private static final String BODY_COLOR = "white with yellow stripe";
   
    /** Constant fin color for this Ia. 
  * Private because not inherited.
  */
   private static final String FIN_COLOR = "yellow";

   /**
  * Constructor for making Weke_ula with random length 
  * I_a superclass constructor
  * uses DIET_ITEMS array from super class
  * randomly sets length within allowed values after calling constructor.
  * @throws FishSizeException if length is > maxLength or < minLength
  * Must send minLength  through as a temp length or throws exception
  */
   public Weke_ula() {
      super(NAME, ENGLISH_NAME, SCIENTIFIC_NAME, WEKE_ULA_MAX_LENGTH, WEKE_ULA_MIN_LENGTH, 
          WEKE_ULA_MIN_LENGTH, (WEKE_ULA_MIN_LENGTH * 2), DIET_ITEMS,
          "white with yellow stripe", 
          "yellow", "male or female"); 
      //method is in superclass but will use max, min length,and sex set above
      this.initLength();
      this.initSex();  
   }
  /**
  * Constructor for making Weke_a with a given length 
  * I_a superclass constructor
  * uses DIET_ITEMS array from super class
  * randomly sets length within allowed values after calling constructor.
  * This is the second phase of the species and is always male.
  * @param length the length for this fish
  * @throws FishSizeException if length > maxLength or < minLength
  */
   public Weke_ula(double length) {
      super(NAME, ENGLISH_NAME, SCIENTIFIC_NAME, WEKE_ULA_MAX_LENGTH, WEKE_ULA_MIN_LENGTH, 
          length, (length * 2), DIET_ITEMS, "white with yellow stripe", 
          "yellow", "male or female"); 
      this.initSex(); 
   }
}
  
  //There is no level up such as in Oama since nothing levels up to Weke_ula!//
  
  
