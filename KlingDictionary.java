package KlingonDictionary;
/** Add any necessary import statements here **/

import java.util.ArrayList;

import java.util.Iterator;


// This class represents a dictionary of Klingon words,
// where each word is represented by class "KlingonDictionary.KlingWord"
public class KlingDictionary {

  // one member variable that represents the dictionary as an ArrayList;
  // all methods below will add/read/remove/etc. from this variable
  public ArrayList<KlingWord> dict;

  // constructor
  public KlingDictionary () {
      dict = new ArrayList<KlingWord>();
  }

  // Helper method to build the dictionary "dict" from two String arrays
  // Returns the number of words that have been added successfully
  /*** Warning: Do NOT modify this method ***/
  public int buildDictionary() {
    // A list of Klingon words to be added to this dictionary
    String[] knWordsArray= {"adanji", "baH", "baktag", "batleth", "Bekk", "fote", "forshak", "ghoptu", "lok",	"eff", "grr",	"keshmalek",	"drumpf", "daH", "Kyamo"};
    // The corresponding English translations are stored in the same order below
    String[] enWordsArray = {"perfume", "blah", "insult", "sword", "soldier", "vote", "car", "insult", "look", "insult", "insult", "gameover", "prince", "duh", "Beautiful"};

    // Variables to be used inside the for-loop
    String knWord = "";
    String enWord = "";
    int numWords = 0;
    for(int i = 0; i < knWordsArray.length; i++) {
        knWord = knWordsArray[i];  //read the KN word
        enWord = enWordsArray[i];  //read the corresponding EN translation
        KlingWord word = new KlingWord(knWord, enWord); //create a KlingonDictionary.KlingWord object

        addWord(word); //this will only work properly after you implement addWord() below!!
        numWords++; //update word counter
    }

    return numWords;
  }

  // -------------- Assignment#1 Dictionary Methods Below -------------- //
  /* Add a new Klingon word to the dictionary member variable "dict".
  * The dictionary must NOT include duplicate Klingon words; however,
  * two (or more) Klingon words may have the same English translation (i.e. same "en").
  *
  * Return 0 if addition was successful, -1 otherwise. */
  public int addWord(KlingWord newWord) {
    //TODO: fill in code for this method (remove the TODO when you're done with a method!)

    int temp = dict.size();

    dict.add(newWord);

    if(dict.size() == temp + 1){
      return 0;

    } else {
      return -1;
    }




    // ... //
  }

  /* Check if the Klingon word in "oldWord" exists in the dictionary "dict"
  * (regardless of the English meaning), then:
  * If you do find oldWord => remove it from the dictionary then insert "newWord" in
  * the exact same location where you removed oldWorld.
  * If you don't find "oldWord" => add "newWord" normally at the end of the dictionary.
  *
  * Return 0 if a replacement did happen (i.e. you found oldWord), -1 otherwise. */
  public int replaceOrAddWord(KlingWord oldWord, KlingWord newWord) {
    //TODO: fill in code for this method

//    String oldWord = oldWord.getKN().toLowerCase();
//

      Iterator<KlingWord> iterator = dict.iterator();
      int temp = 0;
      int indexCopy = 0;


      while(iterator.hasNext()){
          KlingWord i = iterator.next(); //i is equal to the first element of our arraylist
            if(i.getKN().equals(oldWord.getKN())){
                indexCopy = dict.indexOf(i);
                iterator.remove();

            } if(dict.contains(oldWord)) {
                temp = -1;
            }
        }

        if(temp == 0){
          dict.add(indexCopy, newWord);
          return 0;
        } else {
          dict.add(newWord);
          return -1;
        }


  }






  /* Delete all Klingon words that have the English meaning given
  * in "badEN" from the dictionary "dict".
  *
  * Return the number of words that were deleted successfully. */
  public int deleteFromDict(String badEN) {
      //TODO: fill in code for this method

      Iterator<KlingWord> iterator = dict.iterator();
      int count = 0;


      while (iterator.hasNext()) {
          KlingWord i = iterator.next(); //i is equal to the first element of our arraylist
          if (i.getEN().equals(badEN)) {
              iterator.remove();
              count += 1;

          }



      }

      return count;

  }

  /* The new Klingon leader decided that long words are just stupid.
  /* Implement this law which removes any Klington word from the dictionary
  /* that is longer than 3 characters (regardless of the English translation's length) */
  public void shortDict(){
    int limit = 3;

    //TODO: fill in code for this method

      Iterator<KlingWord> iterator = dict.iterator();


      while (iterator.hasNext()) {
          KlingWord i = iterator.next(); //i is equal to the first element of our arraylist
          if (i.getKN().length() > 3) {
              iterator.remove();


          }



      }
    // ... //
  }


  /* One dictionary is not enough? Let's create another one!
  * Find all the Klingon words in "dict" whose first and last
  * characters are identical (e.g. "kwerk"). Now create a new dictionary
  * that contains these special words. Don't remove the words from the
  * original dictionary.
  *
  * Return the newly created dictionary. */
  public KlingDictionary createSubDict(){
    KlingDictionary newDict = new KlingDictionary();
    //TODO: fill in code for this method
    // ... //
    return newDict;
  }

  //*Prints all the KlingonDictionary.KlingWord objects inside the ArrayList dict.
  /* Remember: the method toString() in class KlingonDictionary.KlingWord will be invoked automatically
  /* when an object of class KlingonDictionary.KlingWord is passed to System.out.println(). */
  public void printDictionary(){
    for( KlingWord kw : dict ){
      System.out.println(kw);
    }
  }


  // Main method includes constructing your dictionary and testing its methods
  public static void main(String[] args) {
    int result;
    KlingDictionary klingdict = new KlingDictionary();

    // Build the dictionary
    result = klingdict.buildDictionary();
    System.out.println("buildDictionary() result => " + result);
    // Print dictionary
    klingdict.printDictionary();

    // Add word
    result = klingdict.addWord(new KlingWord("klingothing","nothing"));
    // Remember, '\n' below stands for: print a "new line"
    System.out.println("\naddKlingWordictoDict() result => " + result);
    klingdict.printDictionary();

    // Replace or add word
    KlingWord testword = new KlingWord("forshak","vehicle");
    KlingWord newWord = new KlingWord("gamma","beta");
    result = klingdict.replaceOrAddWord(testword, newWord);
    System.out.println("\nreplaceOrAddWord(" + testword.getKN() +
                "," + newWord.getKN() + ") result => " + result);
    klingdict.printDictionary();

    // Get special words in a new dictionary
    KlingDictionary specialDict = klingdict.createSubDict();
    System.out.println("\nCalled createSubDict()...");
    specialDict.printDictionary(); // print new dictionary with special words

    // Apply new law that requires removing long words
    klingdict.shortDict();
    System.out.println("\nApplied shortenDict()...");
    klingdict.printDictionary();

    // Delete all words that have this English meaning
    String badEN = "insult";
    result = klingdict.deleteFromDict(badEN);
    System.out.println("\ndeleteFromDict() result => " + result);
    klingdict.printDictionary();

    /* That's all folks! Enjoy! */
  }

}



