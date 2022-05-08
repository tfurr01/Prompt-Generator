/* Toby Furr Final Project - Prompt Generator
 * 
 * This is the class that creates the GUI interface for the prompt generator and contains the main method.
 * -In the start method, GridPane is used to display labels and textfields for number of writers, number
 *  of characters, and name. Fandom and Genre labels and ComboBox objects are also displayed in the GridPane.
 *  ComboBox provides an easy-to-use dropdown option to prevent typos from derailing the program.
 * -A submit button and a large TextArea node are also added to the GridPane.
 * -When the submit button is clicked, all input from the user is stored into variables and used to create a
 *  new Party object.
 * -The Party object is then used to generate prompts, and all results are appended to the TextArea for the user to see.
 * 
 * */

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GeneratorGUI extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			
			//create pane
			GridPane pane = new GridPane();
			pane.setPadding(new Insets(10, 10, 10, 10));
			pane.setHgap(10);
			pane.setVgap(10);
			
			//create and adjust text fields
			TextField numWriters = new TextField();
			TextField numCharacters = new TextField();
			TextField name = new TextField();
			name.setPrefColumnCount(15);
			numWriters.setPrefColumnCount(12);
			numCharacters.setPrefColumnCount(10);
			
			//create and adjust drop downs
			String fandoms[] = {"Harry Potter", "Marvel", "Star Wars", "Original/No Fandom"};
			String genres[] = {"Drama", "Romance", "Comedy"};
			
			
			ComboBox<String> fandomSelection = new ComboBox<String>(FXCollections.observableArrayList(fandoms));
			ComboBox<String> genreSelection = new ComboBox<String>(FXCollections.observableArrayList(genres));
			
			//create submit button
			Button submit = new Button("Submit");
			
			//create text area for results
			TextArea results = new TextArea();
			
			//place nodes in pane
			pane.add(new Label("Name: "), 0, 0);
			pane.add(name, 1, 0);
			pane.add(new Label("Number of Writers: "), 0, 1);
			pane.add(numWriters, 1, 1);
			pane.add(new Label("Number of Characters: "), 0, 2);
			pane.add(numCharacters, 1, 2);
			pane.add(new Label("Fandom: "), 0, 3);
			pane.add(fandomSelection, 1, 3);
			pane.add(new Label("Genre: "), 0, 4);
			pane.add(genreSelection, 1, 4);
			pane.add(submit, 0, 5);
			pane.add(new Label("Prompts:"), 0, 6);
			pane.add(results, 0, 7);
			GridPane.setColumnSpan(results, GridPane.REMAINING);
			
			
			//create handler for clicking submit
			submit.setOnAction(e -> {
				results.clear();
				String groupName = name.getText();
				int writers = Integer.parseInt(numWriters.getText());
				int characters = Integer.parseInt(numCharacters.getText());
				int groupFandom = 4;
				switch(fandomSelection.getValue()) {
					case "Harry Potter":
						groupFandom = 1;
						break;
					case "Marvel":
						groupFandom = 2;
						break;
					case "Star Wars":
						groupFandom = 3;
						break;
					case "Original/No Fandom":
						break;
				}
				int groupGenre = 1;
				switch(genreSelection.getValue()) {
					case "Drama":
						break;
					case "Romance":
						groupGenre = 2;
						break;
					case "Comedy":
						groupGenre = 3;
						break;
				}
				
				//use given info to create and display Party
				try {
					Party party = new Party(writers, characters, groupFandom, groupGenre, groupName);
					
					for(int i = 0; i < party.getNumberOfWriters(); i++) {
						results.appendText("Writer #" + (i+1) + "\n");
						results.appendText(new Prompt(party).toString());
						results.appendText("\n");
						
						//shuffle all so each user gets new prompt
						party.getFandom().shuffle(party.getFandom().getCharacters());
						party.getFandom().shuffle(party.getFandom().getSettings());
						party.getFandom().shuffle(party.getFandom().getTropes());
					}
				} catch (FileNotFoundException noFile) {
					noFile.printStackTrace();
				}
			});
			
			//create scene and place in stage
			Scene scene = new Scene(pane, 360, 450);
			primaryStage.setTitle("Prompt Generator");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}

}
