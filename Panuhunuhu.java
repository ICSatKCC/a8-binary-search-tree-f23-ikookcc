import java.util.Random;
/**
 * Panuhunuhu.java file.
 * Creates Panuhunuhu Objects.
 * @author Adam Bell
 * @since 10/2/2023
 */

public class Panuhunuhu extends Ohua {
   /** Constant Maximum length of Panuhunuhu. */
   private static final double PANUHUNUHU_MAX_LENGTH = 12.0;
   /** Constant Minimum length of Panuhunuhu. */
   private static final double PANUHUNUHU_MIN_LENGTH = 4.0;
   
    /**
     * Constructor for making Panuhunuhu with unknown length.
     * Uses I_a superclass constructor.
     * Uses DIET_ITEMS array from super class.
     * Uses initLength() method to randomize length.
     */
   public Panuhunuhu() {
      super("Panuhunuhu", "Scaridae", PANUHUNUHU_MAX_LENGTH, 
           PANUHUNUHU_MIN_LENGTH, PANUHUNUHU_MIN_LENGTH,
           (PANUHUNUHU_MIN_LENGTH * 2), DIET_ITEMS, "gray", "reddish gray", "female");
      this.initLength();
   }

    /**
     * Constructor for making Panuhunuhu with known length.
     * Uses I_a superclass constructor.
     * Uses DIET_ITEMS array from super class.
     * @param length assigns length to input.
     */    
   public Panuhunuhu(double length) {
      super("Panuhunuhu", "Scaridae", PANUHUNUHU_MAX_LENGTH, 
         PANUHUNUHU_MIN_LENGTH, length, (length * 2),
         DIET_ITEMS, "gray", "reddish gray", "female");
   }

    /**
     * Protected constructor for subclasses.
     * @param name Hawaiian name for the fish.
     * @param scientificName scientific name for fish.
     * @param maxLength Max length for the fish.
     * @param minLength Min length for the fish.
     * @param length length of the fish.
     * @param weight weight of the fish.
     * @param diet diet of the fish.
     * @param bodyColor body color of the fish.
     * @param finColor fin color of the fish.
     * @param sex sex of the fish.
     */
   protected Panuhunuhu(String name, String scientificName, double maxLength, 
       double minLength, double length, double weight, String[] diet, 
       String bodyColor, String finColor, String sex) {
      super(name, scientificName, maxLength, minLength, length, weight, 
          diet, bodyColor, finColor, sex);
   }

   /**
    * initSex() method.
    * Randomly initializes the sex of the fish.
    */
   public void initSex() {
      Random r = new Random();
      int i = r.nextInt(2);
      if (i == 0) {
         sex = "male";
      } else {
         sex = "female";
      }
   }
   
   /**
    * setColor() method taken from ColorChangeable interface.
    * @param bodyColor assigns bodyColor to a color relative to the fish's sex.
    * @param finColor assigns finColor to a color relative to the fish's sex.
    * @throws UnsupportedOperationException if bodyColor or finColor are not accurate
    * to Ohua.
    */
   public void setColor(String bodyColor, String finColor) throws UnsupportedOperationException {
      if (bodyColor.equals("gray")) {
         this.bodyColor = "gray";
         this.finColor = "reddish gray";
      } else if (bodyColor.equals("blue-green")) {
         this.bodyColor = "blue-green";
         this.finColor = "blue";
      } else {
         throw new UnsupportedOperationException("bodyColor must be 'gray' or 'blue-green'."
            + " Was given: " + bodyColor, null);
      }
   }

   

    /**
     * levelUp() method.
     * @return a new Uhu object using the length of
     * the current Panuhunuhu fish.
     */
   public Uhu levelUp() {
      return new Uhu(this.maxLength, this.sex);
   }
}

   
 