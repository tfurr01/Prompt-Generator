/* Toby Furr Final Project - Prompt Generator
 * 
 * This class holds the ArrayLists of characters, tropes, and settings used to generate prompts.
 * -The constructor takes two strings to indicate the fandom and genre the user wants. These strings
 * 	are used to find the correct files in the FandomDocs folder, where the contents of the desired 
 * 	files are read and stored in ArrayLists for characters, tropes, and settings.
 * -A simple shuffle method calls Collections.shuffle() to shuffle each ArrayList, making later selections
 *  random.
 * 
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Fandom {
    private ArrayList<String> characters = new ArrayList<String>();
    private ArrayList<String> tropes = new ArrayList<String>();
    private ArrayList<String> settings = new ArrayList<String>();
    private String genre;
    
    public Fandom(String fandom, String genre) throws FileNotFoundException {
        
    	try ( //set up Scanners for each incoming doc
        	Scanner characterScanner = new Scanner(new File("FandomDocs/" + fandom + "/characters.txt"));
        	Scanner settingScanner = new Scanner(new File("FandomDocs/" + fandom + "/settings.txt"));
        	Scanner genreScanner = new Scanner(new File("FandomDocs/Tropes/" + genre + ".txt"));) {
        	
        	//add each line of characters.txt to characters
        	do {
        		characters.add(characterScanner.nextLine());
        	} while(characterScanner.hasNext());
        	
        	//add each line of settings.txt to settings
        	do {
        		settings.add(settingScanner.nextLine());
        	} while(settingScanner.hasNext());
        	
        	//add each line of trope doc to tropes
        	do {
        		tropes.add(genreScanner.nextLine());
        	} while(genreScanner.hasNext());
        	
        	//shuffle lists
        	shuffle(characters);
        	shuffle(settings);
        	shuffle(tropes);
        	
    	} catch(FileNotFoundException e) {
    		System.out.println("file not found");
    		e.printStackTrace();
    	}
    }
    
    
    //shuffle lists
    public void shuffle(ArrayList<String> list) {
    	Collections.shuffle(list);
    }
    
    
    //getters and setters

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public ArrayList<String> getCharacters() {
        return characters;
    }
    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }
    public ArrayList<String> getTropes() {
        return tropes;
    }
    public void setTropes(ArrayList<String> tropes) {
        this.tropes = tropes;
    }
    public ArrayList<String> getSettings() {
        return settings;
    }
    public void setSettings(ArrayList<String> settings) {
        this.settings = settings;
    }
}