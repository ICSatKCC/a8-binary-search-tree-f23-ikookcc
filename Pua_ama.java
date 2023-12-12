

import java.util.Random;
/**
* Moi-li'i fish object class.
* Smallest type version of Moi fish
* Parent class to Moi Mana
* @author Lisa Miller
* @version 1.5
* @since 1/27/23
*/
public class Pua_ama extends I_a {

   // Constants for this fish.
   // protected will be inherited by subclasses unless replaced
   /** constant reproductive mode for this Ia. */
   protected static final String REPRODUCTIVE_MODE = "protoandrous";
   /** constant array of what the fish eats. */
   protected static final String[] DIET_ITEMS = {"zooplankton", "algae", "detritus", "invertebrates"};

   
   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PUA_MAX_LENGTH = 4.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PUA_MIN_LENGTH = 0.01;

   
   /**
   * Constructor for making Moi-li'i
   * uses I_a superclass constructor
   * randomly sets length within allowed values after calling constructor.
   * This is the juvenile of the species and has no sex determination.
   */
   public Pua_ama() {
      super("Pua'ama", "Striped Mullet", "Mugil Cephalus",PUA_MAX_LENGTH, PUA_MIN_LENGTH, 
      	0.1, 2.0, DIET_ITEMS, "silver", "silver", "none");   
         //set random allowed length after
      this.initLength();
   }
   
   /**
   * Constructor for making Moi-li'i with a specific length.
   * uses I_a superclass constructor
   * @param length The length of this fish
   * @throws FishSizeException if length > maxLength or < minLength.
   * This is the juvenile of the species and has no sex determination.
   */
  public Pua_ama(double length) {
      super("Pua'ama", "Striped Mullet", "Mugil Cephalus", PUA_MAX_LENGTH, PUA_MIN_LENGTH, 
       length, (length * 2), DIET_ITEMS, "silver", "silver", "none");   
 
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
   *@param weight This fish's weight
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length > maxLength or < minLength
   */
   protected Pua_ama(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor, 
         String finColor, String sex) {
       
      super(name, "Striped Mullet", "Mugil Cephalus", maxLength, 
      		minLength, length, weight, diet, bodyColor, finColor, sex);
   }
   
   /**
   * Sets the fish's initial length to between its max and min allowed values.
   */
   protected void initLength() {
      Random ran = new Random();
      this.length = this.minLength 
         + (this.maxLength - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   }
   
   //++++ required implementations of abstract methods ++++++++++
   
   /**
   * Sets the fish's length to newLength.
   * @param newLength the new fish length
   * @throws FishSizeException if new length not within min-max length
   */
   public void setLength(double newLength) throws FishSizeException {  
      if (newLength >= this.minLength && newLength < this.maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name + " must be within " 
            + this.minLength + " and " + this.maxLength 
            + " inches long.");
      } 
   }
   
   /**
   * Sets the fish's weight to newWeight.
   * @param newWeight The fish's new weight.
   */
   public void setWeight(double newWeight) {  
      
      this.weight = newWeight;
   
   }
   /**
   * Models eating, should call grow to cause length increases.
   * @param food A String with a potential food name
   * @throws FishFoodException if the food is not the fish's diet
   */
   public void eat(String food) {
     
      boolean isEdible = false;
      //loop through what fish eats and determine if edible
      for (int i = 0; i < DIET_ITEMS.length; i++) {
         if (food.equals(DIET_ITEMS[i])) {
            isEdible = true;
         }
      }
      if (isEdible) {
         this.grow();
      } else {
         throw new FishFoodException(this.name + " does not eat " + food);
      }
   }
   
   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * @throws FishSizeException if new length not within min-max length
   *  indicates levelUp needs to be called.
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;
   
      //calculate a new length by adding a random value between 0 and growthRate
      double newLen = this.length + lengthIncrease;
   
      //check to see if this fish needs to level up
      if (newLen > this.maxLength) {
         throw new FishSizeException("This fish has outgrown its name," 
         + " it must level up!");
      } else {
         this.length = newLen;
         this.weight = 2 * newLen; //rudimentary weight calc
      }
   }
   
   /** returns new Moi Mana version of this fish.
   * When moi-li'i reaches maxLength, it levelUps to MoiMana of minLength
   * min size of next size is always max length of this one
   * @return a new MoiMana
   */
   public Kahaha levelUp() {
   
      return new Kahaha(this.maxLength);
   
   }
}





   
  