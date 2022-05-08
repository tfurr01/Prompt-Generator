/* Toby Furr Final Project - Prompt Generator
 * 
 * This is the biggest class of the project, and it uses the information given by the user to create the final
 * 	presentation of prompts.
 * -Using the data given in the constructor, the class assigns values to its own attributes. The ints given
 *  for genre and fandom are converted to Strings for ease of finding the correct files later.
 * -A Fandom object is created and stored as an attribute to be used later in creating prompts
 * 
 * */

import java.io.FileNotFoundException;

public class Party {
    private int numberOfWriters;
    private int numberOfCharacters;
    private Fandom fandom;
    private String nameOfParty;
    private Prompt[] prompts;

    public Party(int numberOfWriters, int numberOfCharacters, int fandom, int genre, String nameOfParty) throws FileNotFoundException {
    	this.numberOfWriters = numberOfWriters;
    	this.numberOfCharacters = numberOfCharacters;
    	this.nameOfParty = nameOfParty;
    	
    	//assign genre based on int
    	String genreString;
    	if(genre == 1) {
    		genreString = "drama";
    	} else if(genre == 2) {
    		genreString = "romance";
    	} else {
    		genreString = "comedy";
    	}
    	
    	//assign fandom based on given info
    	String fandomString;
    	switch (fandom) {
    		case 1:
    			fandomString = "HarryPotter";
    			break;
    		case 2:
    			fandomString = "Marvel";
    			break;
    		case 3:
    			fandomString = "StarWars";
    			break;
    		case 4:
    			fandomString = "Original";
    			break;
    		default:
    			fandomString = "";
    			System.out.println("invalid fandom");
    	}
    	
    	this.fandom = new Fandom(fandomString, genreString);
    }
    
    
    //getters and setters
    
    

    public Prompt[] getPrompts() {
        return prompts;
    }

    public void setPrompts(Prompt[] prompts) {
        this.prompts = prompts;
    }

    public Fandom getFandom() {
        return fandom;
    }

    public void setFandom(Fandom fandom) {
        this.fandom = fandom;
    }

    public String getNameOfParty() {
        return nameOfParty;
    }
    public void setNameOfParty(String nameOfParty) {
        this.nameOfParty = nameOfParty;
    }
    public int getNumberOfCharacters() {
        return numberOfCharacters;
    }
    public void setNumberOfCharacters(int numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
    }
    public int getNumberOfWriters() {
        return numberOfWriters;
    }
    public void setNumberOfWriters(int numberOfWriters) {
        this.numberOfWriters = numberOfWriters;
    }
}
