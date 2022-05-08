/* Toby Furr Final Project - Prompt Generator
 * 
 * This class constructs the actual prompt that will be given to the user. 
 * -The constructor has one argument - a Party object which is used to access the ArrayLists from 
 * 	the fandom that the user has selected. 
 * -The class has four attributes: an array of characters, setting, trope, and party. Characters needs 
 *  an array so that the user has the option to use more than one character. To create the array, it is set to the 
 *  length of characters desired and then, using a for loop, each element of the array is assigned a String from the 
 *  ArrayList in Fandom, accessed through the party attribute.
 * -The methods charactersToString and toString are used to format and display the prompt in a way that is easily
 *  readable to the user.
 * 
 * */

public class Prompt {
    private String[] characters;
    private String setting;
    private String trope;
    private Party party;
    
    public Prompt(Party party) {
        /**
         * use num of characters to create characters, 
         * taking characters, setting, and trope from Fandom
         */
    	
    	this.party = party;
    	this.characters = new String[party.getNumberOfCharacters()];
    	for(int i = 0; i < party.getNumberOfCharacters(); i++) {
    		characters[i] = party.getFandom().getCharacters().get(i);
    	}
    	this.setting = party.getFandom().getSettings().get(0);
    	this.trope = party.getFandom().getTropes().get(0);
    }
    
    //toString
    
    public String charactersToString() {
    	int num = party.getNumberOfCharacters();
    	StringBuilder printCharacters = new StringBuilder();
    	
    	for(int i = 0; i < num; i++) {
    		if(i == (num - 1)) {
    			printCharacters.append(characters[i]);
    		} else {
    			printCharacters.append(characters[i] + ", ");
    		}
    	}
    	return printCharacters.toString();
    }
    public String toString() {
    	return String.format("Characters: %s\n"
    			+ "Setting: %s\n"
    			+ "Trope: %s\n", charactersToString(), setting, trope);
    }
    
    //getters and setters
    public String getTrope() {
        return trope;
    }
    public String[] getCharacters() {
        return characters;
    }
    public void setCharacters(String[] characters) {
        this.characters = characters;
    }
    public String getSetting() {
        return setting;
    }
    public void setSetting(String setting) {
        this.setting = setting;
    }
    public void setTrope(String trope) {
        this.trope = trope;
    }


}
