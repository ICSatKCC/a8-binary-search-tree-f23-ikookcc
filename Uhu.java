/**
 * Uhu.java file.
 * Creates Uhu Objects.
 * @author Adam Bell
 * @since 10/2/2023
 */

 /**
  * Uhu class extends from Panuhunuhu.
  */
public class Uhu extends Panuhunuhu {

   /** Constant Maximum length of Uhu. */
   protected static final double UHU_MAX_LENGTH = 30;
   /** Constant Minimum length of Uhu. */
   protected static final double UHU_MIN_LENGTH = 12;


    /**
     * Uhu constructor for unknown length.
     * The body color and fin color are determined by
     * the sex of the Panuhunuhu fish.
     * Sets length to random value between min and max.
     */
   public Uhu() {
      super("Uhu", "Scarus psittacus", UHU_MAX_LENGTH, UHU_MIN_LENGTH, 
         UHU_MIN_LENGTH, (UHU_MIN_LENGTH * 2), DIET_ITEMS, 
         "blue-green", "blue", "male");
         
      this.initLength();
        
      if (sex == "male") {
         this.setColor("blue-green", "blue");
      } else {
         this.setColor("gray", "reddish gray");
      }
   }

    /**
     * Uhu constructor for known length
     * Uses superclass constructor.
     * @param length length of fish in inches.
     */
   public Uhu(double length) {
      super("Uhu", "Scarus psittacus", UHU_MAX_LENGTH, UHU_MIN_LENGTH, 
           length, (length * 2), DIET_ITEMS, "blue-green", "blue", "male");
      if (sex == "male") {
         this.setColor("blue-green", "blue");
      } else {
         this.setColor("gray", "reddish gray");
      }
   }

   /**
    * Uhu constructor for known length, bodyColor,
    * finColor, and sex.
    * Uses superclass constructor.
    * @param length length of fish in inches.
    * @param sex sex of fish.
    */
   public Uhu(double length, String sex) {
      super("Uhu", "scarus psittacus", UHU_MAX_LENGTH, UHU_MIN_LENGTH,
            length, (length * 2), DIET_ITEMS, "gray", "reddish gray", sex);
   }

   /**
    * initSex() method.
    * if fish's sex is female,
    * sex is assigned as supermale.
    */
   public void initSex() {
      if (this.sex.equals("female")) {
         this.sex = "supermale";
         this.getBodyColor();
         this.getFinColor();
      } else {
         this.getBodyColor();
         this.getFinColor();
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
      } else if (bodyColor.equals("purple")) {
         this.bodyColor = "purple";
         this.finColor = "orange";
      } else {
         throw new UnsupportedOperationException("bodyColor must be 'gray' or 'blue-green'."
            + " Was given: " + bodyColor, null);
      }
   }
   
    /**
     * levelUp() method.
     * @return There is no next level, so the current fish object is returned.
     */
   public Uhu levelUp() {
      return this;
   }
}