import java.util.Random;

/**
* Oama fish object class.
* Base class for weke/goatfish.
* Parent class to Weke'a and Weke'ula.
* Alot of this code is refrenced from MoiLi_i.java
file provided by Proffesor Miller. Thank you professor!
* @author Chiara Duyn
* @since 10/2/23
*/


public class Oama extends I_a implements ColorChangeable {

   /**Constants for Oama.
   *Protected will be inherited by subclasses unless replaced.
   */
   
/** Constant name for this Ia. 
   * Private because not inherited.
   */
   private static final String NAME = "\'Oama";
   
/** Constant english name for this Ia. 
   * Private because not inherited.
   */
   private static final String ENGLISH_NAME = "Goatfish";
   
/** Constant scientific name for this Ia. 
   * Private because not inherited.
   */  
   private static final String SCIENTIFIC_NAME = "Mulloidichthys";
   
 /** Constant max length for this Ia. 
   * Private because not inherited.
   */ 
   private static final double OAMA_MAX_LENGTH = 7.0;
   
/** Constant min length for this Ia. 
   * Private because not inherited.
   */  
   private static final double OAMA_MIN_LENGTH = 0.0;
   
 /** Constant body color for this Ia. 
   * Private because not inherited.
   */ 
   private static final String BODY_COLOR = "white with yellow stripe";
   
/** Constant fin color for this Ia. 
   * Private because not inherited.
   */  
   private static final String[] FIN_COLOR = {"yellow", "white"};
   
 /**Constant array of what Oama eats. */
   protected static final String[] DIET_ITEMS = {"worms", "mollusks", "invertebrates"};

   
   /**
   * Constructor for making Oama.
   * I_a superclass constructor.
   * Randomly sets the length within the allowed values after calling constructor.
   */

   public Oama() {
      super(NAME, ENGLISH_NAME, SCIENTIFIC_NAME, OAMA_MAX_LENGTH, OAMA_MIN_LENGTH,
         0.1, 2.0, DIET_ITEMS, BODY_COLOR, "yellow", "none");
      //sets random length 
      this.initLength();
   }
   /**
   * Constructor for making Oama with a specified length.
   * I_a superclass constructor.
   * @param length The length of this fish.
   * 
   */
   public Oama(double length) {
      super(NAME, ENGLISH_NAME, SCIENTIFIC_NAME, OAMA_MAX_LENGTH, OAMA_MIN_LENGTH,
         length, (length * 2), DIET_ITEMS, BODY_COLOR, "yellow", "none");
   }
/** 
   * Protected constructor for subclasses.
   * This allows subclass specific variables  
    to pass through to I'a superclass constructor.
  
   * In this species, the English and scientific names
   * remain the same throughout so not needed to pass from subclasses.
  
   *@param name This fish type's Hawaiian name.
   *@param englishName the fishes english name.
   *@param scientificName the fishes scientific name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's length.
   *@param weight This fish's weight
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length > maxLength or < minLength
   */
   protected Oama(String name, String englishName, String scientificName, 
        double maxLength, double minLength, double length, double weight, 
        String[] diet, String bodyColor, String finColor, String sex) {
        
      super(name, englishName, scientificName, 
         maxLength, minLength, length, weight, diet, bodyColor, finColor, sex);
   }
/**
   *Oama can dynamically change colors.
   *Sets fishes color.
   *@param bodyColor sets fishes body color.
   *@param finColor sets fishes fin color.
   */
   public void setColor(String bodyColor, String finColor) {
    // Weke'a can change color, only gets darker and does not turn red.
      this.bodyColor = bodyColor;
      
      this.finColor = finColor;
      
   }
/**
   * Sets the fishes length between its max and min allowed values.
   */
   protected void initLength() {
      Random ran = new Random();
      this.length = this.minLength 
         + (this.maxLength - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   
   }
/**
   * Sets the fish's length to newLength.
   * @param length sets the new fish length
   * @throws FishSizeException if new length not within min-max length
   */
   public void setLength(double length) throws FishSizeException {
      if (length >= OAMA_MIN_LENGTH && length < OAMA_MAX_LENGTH) {
         this.length = length;
      } else {
         throw new FishSizeException(name + " length should be within " + minLength
                        + " and " + maxLength + " inches long.");
      }
   }
 /**
   * Sets the fish's weight.
   * @param weight The fishes new weight.
   */
   public void setWeight(double weight) {
      this.weight = weight;
   }
 /**
   * Models fish eating, calls grow to cause length increases.
   * @param food A String with a possible food name
   * @throws FishFoodException if the food is not the in fish's diet
   */
   public void eat(String food) {
   
      boolean isEdible = false;
            //loops through what fish eats
      for (int i = 0; i < DIET_ITEMS.length; i++) { 
         if (food.equals(DIET_ITEMS[i])) {
            isEdible = true;
            //stops looping if edible
            break; 
         }
      }
      if (isEdible) {
         this.grow();
      } else {
         throw new FishFoodException(this.getName() + " does not eat " + food);
      }
   }
/**
   * Used by eat method to increase length of fish. 
   * Determines a new length and internally call setLength.
   * @throws FishSizeException if new length not within min-max length.
   * Indicates levelUp needs to be called.
   */
   protected void grow() {
      Random random = new Random();
      double lengthIncrease = random.nextDouble() * growthRate;
      double newLen = this.getLength() + lengthIncrease;
   
      if (newLen > this.getMaxLength()) {
         throw new FishSizeException("This fish has outgrown its name, it must level up!");
      } else {
         this.setLength(newLen);
         this.setWeight(2 * newLen); 
      }
   }
 /** Returns Weke'ula or Weke'a.   
 * When Oama reaches maxLength, it levelUps to Weke'ula
 * My code review partner Jinhwan helped me with levelUp
 and gave me permission to use lines 164-170 his code.
 *@return a Weke'ula
 *@else return a Weke'a  
 */
   public Oama levelUp() {
      Random random = new Random();
      int flip = random.nextInt(2);
   
      if (flip == 0) {
         return new Weke_ula(this.getMaxLength());
      } else {
         return new Weke_a(this.getMaxLength());
      }
   } 
}
