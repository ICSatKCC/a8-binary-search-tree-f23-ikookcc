/**
 * Ohua.java file.
 * Creates Ohua Objects.
 * @author Adam Bell
 * @since 10/2/2023
 */

public class Ohua extends I_a implements SexChangeable, ColorChangeable {
   /**
    * Constant variables.
    */
   /** Constant Maximum length of Ohua. */
   protected static final double OHUA_MAX_LENGTH = 4;
   /** Constant Minimum length of Ohua. */
   protected static final double OHUA_MIN_LENGTH = 0.01;
   /** Constant Array Diet of Ohua. */
   protected static final String[] DIET_ITEMS = {"algae"};
   /** Constant English Name of Ohua. */
   protected static String englishName = "Parrotfish";
    
    /**
     * Constructor for making Ohua.
     * Uses I_a superclass constructor
     * For unknown length, length is randomized
     * using initLength() method.
     */
   public Ohua() {
      super("'Ohua", englishName, "Scaridae", OHUA_MAX_LENGTH, 
           OHUA_MIN_LENGTH, 0.1, 2.0, DIET_ITEMS, "gray", "reddish gray", "none");
      this.initLength();
   }
    /**
     * Constructor for making Ohua.
     * Uses I_a superclass constructor
     * @param length uses I_a constructor for 
     * known length values.
     */
   public Ohua(double length) {
      super("'Ohua", englishName, "Scaridae", OHUA_MAX_LENGTH, 
           OHUA_MIN_LENGTH, length, (length * 2),
           DIET_ITEMS, "gray", "reddish gray", "none");
   }
    
    /**
     *  initLength() method.
     *  sets this.length to random value between
     *  min length and max length.
     *  also sets weight to correct value using
     *  random length.
     */
   public void initLength() {
      this.length = (this.maxLength - this.minLength) * Math.random() 
         + this.minLength;
      this.weight = this.length * 2;
   }

    /**
     * Protected constructor for subclasses of Ohua.
     * English and Scientific names are constant and 
     * have been hard-coded.
     * @param name Hawaiian name for the fish.
     * @param scientificName scientific name for the fish.
     * @param maxLength Maximum length for fish.
     * @param minLength Minimum length for fish.
     * @param length Length of fish.
     * @param weight Weight of fish.
     * @param diet Diet for fish.
     * @param bodyColor Body color of fish.
     * @param finColor Fin color of fish.
     * @param sex Sex of fish.
     */
   protected Ohua(String name, String scientificName, double maxLength, 
         double minLength, double length, double weight, String[] diet, 
         String bodyColor, String finColor, String sex) {
      super(name, englishName, scientificName, maxLength, minLength, 
              length, weight, diet, bodyColor, finColor, sex);
   }

    /**
     * setLength() method.
     * Updates this.length to newLength value.
     * @param newLength is fish's new length.
     * @throws FishSizeException displays error messag if length
     * is not between min and max.
     */
   public void setLength(double newLength) throws FishSizeException {
      if (newLength >= this.minLength && newLength <= this.maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name + " must be between " 
         + this.minLength + " and " + this.maxLength + " inches long.");
      }
   }

    /**
    * setWeight() method.
    * Updates this.weight to newWeight value.
    * @param newWeight is fish's new weight.
    */
   public void setWeight(double newWeight) {
      this.weight = newWeight;
   }
    
    /**
     * eat() method.
     * @param food is an String array of the fish's diet.
     * @throws FishFoodException if the food is not part of the fish's diet.
     */
    
   public void eat(String food) {
      boolean isEdible = false;
      for (int i = 0; i < DIET_ITEMS.length; i++) {
         if (food.equals(DIET_ITEMS[i])) {
            isEdible = true;
            break;
         }
      }
      if (isEdible) {
         this.grow();
      } else {
         throw new FishFoodException(this.name + " does not eat " + food);
      }
   }

    /**
     * grow() method.
     * Generates a randomized length increase with respect to the fish's
     * growth rate. Then assigns new length and weight value.
     * @throws FishSizeException if fish's length exceeds maximum.
     */
   protected void grow() {
      double lengthIncrease = Math.random() * growthRate;
      double newLength = this.length + lengthIncrease;
      if (newLength > maxLength) {
         throw new FishSizeException("This fish has outgrown it's class!" 
            + " It's time for it to level up!");
      } else {
         this.length = newLength;
         this.weight = this.length * 2;
      }
   }

   /**
    * getReproductiveMode() method.
    * Reproductive mode is "protogynous" which
    * is index 0 of the REPRODUCTIVE_MODES array.
    * @return the reproductive mode of the fish.
    */
   public String getReproductiveMode() {
      return REPRODUCTIVE_MODES[0];
   }

   /**
    * changeSex() method.
    * alternates the sex of the fish.
    * @throws UnsupportedOperationException if fish doesn't change sex.
    * left blank because Ohua cannot change sex.
    */
   public void changeSex() throws UnsupportedOperationException {
      throw new UnsupportedOperationException("Ohua's sex cannot be changed");
   }


   /**
    * setColor() method taken from ColorChangeable interface.
    * @param bodyColor assigns bodyColor to a color relative to the fish's sex.
    * @param finColor assigns finColor to a color relative to the fish's sex.
    * @throws UnsupportedOperationException if bodyColor or finColor are not accurate
    * to Ohua.
    */
   public void setColor(String bodyColor, String finColor) throws UnsupportedOperationException {
      if (this.name.equals("Panuhunuhu") || this.name.equals("Uhu")) {
         this.bodyColor = bodyColor;
         this.finColor = finColor;
      } else {
         throw new UnsupportedOperationException("Ohua cannot change color.");
      }
   }

   /**
    * levelUp() method for Ohua.
    * @return new fish of the next class (Panuhunuhu).
    */ 
   public Panuhunuhu levelUp() {
      return new Panuhunuhu(this.maxLength);
   }
}
