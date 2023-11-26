import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
* JUnit test for IaTree BST
* @author Danny Luu, modified by Lisa Miller
* @since 4/21/23
*/

public class IaTreeTest {
   
   /** Constructs an output stream byte array for writing. */
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   /** Constructs a print stream. */
   private final PrintStream originalOut = System.out;
   
   /** I_a constants. */
   static final I_a PUA_AMA = new Pua_ama();
   /** I_a constants. */
   static final I_a KAHAHA = new Kahaha();
   /** I_a constants. */
   static final I_a AMA_AMA = new Ama_ama();
   /** I_a constants. */
   static final I_a ANAE = new Anae();
   /** I_a constants. */
   static final I_a OAMA = new Oama();
   /** I_a constants. */
   static final I_a WEKE_A = new Weke_a();
   /** I_a constants. */
   static final I_a WEKE_ULA = new Weke_ula();
   /** I_a constants. */
   static final I_a MOILI_I = new MoiLi_i();
   /** I_a constants. */
   static final I_a MOIMANA = new MoiMana();
   /** I_a constants. */
   static final I_a PALAMOI = new PalaMoi();
   /** I_a constants. */
   static final I_a MOI = new Moi();
      /** I_a constants. */
   static final I_a OHUA = new Ohua();
      /** I_a constants. */
   static final I_a PANUHUNUHU = new Panuhunuhu();
      /** I_a constants. */
   static final I_a UHU = new Uhu();
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Sets up print stream for use in reading system output.*/
   @Before public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
   }
   
   /** Restores print stream to origin after use.*/
   @After public void restoreStreams() {
      System.setOut(originalOut);
   }


   /** Tests if pokemon are added to the correct node position. **/
   @Test public void addTest() {
      //Creates Tree and adds pokemon
      IaTree fishbox = new IaTree();
      fishbox.add(OAMA);
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      fishbox.add(AMA_AMA);
      fishbox.add(ANAE);
      fishbox.add(WEKE_ULA);
      fishbox.add(WEKE_A);
      fishbox.add(MOILI_I);
      fishbox.add(MOIMANA);
      fishbox.add(PALAMOI);
      fishbox.add(MOI);
      fishbox.add(OHUA);
      fishbox.add(PANUHUNUHU);
      fishbox.add(UHU);
      
      //Acutal outcome
      fishbox.printIaTree();
      
      //Platform-indpendent expected output construction, adressess window's newLine issue
      StringWriter expectedStringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(expectedStringWriter);
      printWriter.println(AMA_AMA.getName() + " Count: 1");
      printWriter.println(ANAE.getName() + " Count: 1");
      printWriter.println(OAMA.getName() + " Count: 1");
      printWriter.println(OHUA.getName() + " Count: 1");
      printWriter.println(KAHAHA.getName() + " Count: 1");
      printWriter.println(MOI.getName() + " Count: 1");
      printWriter.println(MOIMANA.getName() + " Count: 1");
      printWriter.println(MOILI_I.getName() + " Count: 1");
      printWriter.println(PALAMOI.getName() + " Count: 1");
      printWriter.println(PANUHUNUHU.getName() + " Count: 1");
      printWriter.println(PUA_AMA.getName() + " Count: 1");
      printWriter.println(UHU.getName() + " Count: 1");
      printWriter.println(WEKE_A.getName() + " Count: 1");
      printWriter.println(WEKE_ULA.getName() + " Count: 1");
      printWriter.close();
      String expected = expectedStringWriter.toString();
      Assert.assertEquals(expected, outContent.toString());
   }
   
   /** Tests for the incrementation of catchCount when duplicate pokemons are added. **/
   @Test public void addDuplicateTest() {
      IaTree fishbox = new IaTree();
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      fishbox.add(AMA_AMA);
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      
      //Acutal outcome
      fishbox.printIaTree();
      
      //Platform-indpendent expected output construction, adressess window's newLine issue
      StringWriter expectedStringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(expectedStringWriter);
      printWriter.println(AMA_AMA.getName() + " Count: 1");
      printWriter.println(KAHAHA.getName() + " Count: 2");
      printWriter.println(PUA_AMA.getName() + " Count: 2");
      printWriter.close();
      String expected = expectedStringWriter.toString();
      
      Assert.assertEquals("Adding a second Pua'ama... String output not correct after.", expected, 
            outContent.toString());
   }
   
  /**
  * Test IaTeeException throwing if fish not in the tree
  */
  
  @Test(expected=IaTreeException.class)
  public void getNothingTest() {
      //Creates Tree and adds fish
      IaTree fishbox = new IaTree();
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      fishbox.add(AMA_AMA);
      
      //Checks if exception is thrown
      fishbox.get(ANAE);
   }
      

   /** Tests getting an existing node. **/
   @Test public void getTest() {
      //Creates Tree and adds pokemon
      IaTree fishbox = new IaTree();
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      fishbox.add(AMA_AMA);
      
      Assert.assertEquals("Adding Kahaha... getting Kahaha... Kahaha not found by get", 
            KAHAHA, fishbox.get(KAHAHA));
   }
   
   /** Tests removing a nonexistant node. **/
  @Test(expected=IaTreeException.class)
  public void removeNothingTest() {
      //Creates Tree and adds fish
      IaTree fishbox = new IaTree();
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      fishbox.add(AMA_AMA);
      
      //Checks if exception is thrown
      fishbox.remove(ANAE);
   }
   
   /** Tests removing an existing leaf node. 
   * 
   **/
   @Test public void removeLeafTest() {
      //Creates Tree and adds pokemon
      IaTree fishbox = new IaTree();
      fishbox.add(OAMA);
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      fishbox.add(AMA_AMA);
      fishbox.add(ANAE);
      fishbox.add(WEKE_ULA);
      fishbox.add(WEKE_A);
      fishbox.add(MOILI_I);
      fishbox.add(MOIMANA);
      
      //Remove pokemon
      fishbox.remove(WEKE_ULA);
      
      //Acutal outcome
      fishbox.printIaTree();
      
      //Platform-indpendent expected output construction, adressess window's newLine issue
      StringWriter expectedStringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(expectedStringWriter);
      printWriter.println(AMA_AMA.getName() + " Count: 1");
      printWriter.println(ANAE.getName() + " Count: 1");
      printWriter.println(OAMA.getName() + " Count: 1");
      printWriter.println(KAHAHA.getName() + " Count: 1");
      printWriter.println(MOIMANA.getName() + " Count: 1");
      printWriter.println(MOILI_I.getName() + " Count: 1");
      printWriter.println(PUA_AMA.getName() + " Count: 1");
      printWriter.println(WEKE_A.getName() + " Count: 1");
      printWriter.close();
      String expected = expectedStringWriter.toString();
      
      Assert.assertEquals("Removing 1 of 1 Weke'ula in a node with no children, printout of tree after was not correct.", expected, 
            outContent.toString());
   }
   
   /** Tests removing root node with two children. 
   * Largest item in left subtree has left child
   **/
   @Test public void removeRootTest() {
      //Creates Tree and adds pokemon
      IaTree fishbox = new IaTree();
      fishbox.add(KAHAHA);
      fishbox.add(AMA_AMA);
      fishbox.add(OHUA);
      fishbox.add(OAMA);
      fishbox.add(PUA_AMA);
      
      fishbox.add(ANAE);
      fishbox.add(WEKE_ULA);
      fishbox.add(WEKE_A);
      fishbox.add(MOILI_I);
      fishbox.add(MOIMANA);
      
      //Remove pokemon
      fishbox.remove(KAHAHA);
      
      //Acutal outcome
      fishbox.printIaTree();
      
      //Platform-indpendent expected output construction, adressess window's newLine issue
      StringWriter expectedStringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(expectedStringWriter);
      printWriter.println(AMA_AMA.getName() + " Count: 1");
      printWriter.println(ANAE.getName() + " Count: 1");
      printWriter.println(OAMA.getName() + " Count: 1");
      printWriter.println(OHUA.getName() + " Count: 1");
      printWriter.println(MOIMANA.getName() + " Count: 1");
      printWriter.println(MOILI_I.getName() + " Count: 1");
      printWriter.println(PUA_AMA.getName() + " Count: 1");
      printWriter.println(WEKE_A.getName() + " Count: 1");
      printWriter.println(WEKE_ULA.getName() + " Count: 1");
      printWriter.close();
      String expected = expectedStringWriter.toString();
      
      Assert.assertEquals("Removing 'Ohua in root. Largest in left subtree has a left child, printout of tree after was not correct.", expected, 
            outContent.toString());
   }

   
   /** Tests for the decrementation of catchCount when duplicate pokemons are removed. **/
   @Test public void removeDuplicateTest() {
      IaTree fishbox = new IaTree();
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      fishbox.add(AMA_AMA);
      fishbox.add(KAHAHA);
      fishbox.add(PUA_AMA);
      
      //Remove pokemon
      fishbox.remove(KAHAHA);
      
      //Acutal outcome
      fishbox.printIaTree();
      
      //Platform-indpendent expected output construction, adressess window's newLine issue
      StringWriter expectedStringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(expectedStringWriter);
      printWriter.println(AMA_AMA.getName() + " Count: 1");
      printWriter.println(KAHAHA.getName() + " Count: 1");
      printWriter.println(PUA_AMA.getName() + " Count: 2");
      printWriter.close();
      String expected = expectedStringWriter.toString();
      
      Assert.assertEquals("Removing 1 of 2 Kahaha... tree printout not correct after.", 
            expected, outContent.toString());
   }
}
