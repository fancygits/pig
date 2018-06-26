package edu.westga.cs6910.pig.view;

import java.util.Optional;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.stategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.stategies.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


/**
 * Defines a GUI for the Pig game.
 * This class was started by CS6910
 * 
 * @author James Luke Johnson
 * @version 2018.06.04
 */
public class PigPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param theGame	the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		this.theGame = theGame;
		this.pnContent = new BorderPane();
		this.addMenu(theGame);
		
		this.addFirstPlayerChooserPane(theGame);		
		
		// DONE: 1. Using the 'first player chooser pane' as a guide
		//  Create an HBox with the appropriate style, then make a human
		//	player pane and add it to the HBox. Finally add the HBox to the content pane	
		this.addHumanPlayerPane(theGame);

		// DONE: 2. Using the other panes as a guide, create and add a status pane	
		this.addStatusPane(theGame);
		
		// DONE: 3. Using the other panes as a guide, create and add a computer pane
		this.addComputerPlayerPane(theGame);
		
		this.setCenter(this.pnContent);
	}
	
	private void addMenu(Game theGame) {
		MenuPane pnMenu = new MenuPane(theGame);
		PigPane.this.setTop(pnMenu);
	}
	
	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		topBox.setAlignment(Pos.CENTER);
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		
		this.pnContent.setTop(topBox);
	}
	
	private void addHumanPlayerPane(Game theGame) {
		HBox leftBox = new HBox();
		leftBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(theGame);
		leftBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(leftBox);
	}

	private void addStatusPane(Game theGame) {
		HBox centerBox = new HBox();
		centerBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(theGame);
		centerBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(centerBox);
	}
	
	private void addComputerPlayerPane(Game theGame) {
		HBox rightBox = new HBox();
		rightBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(theGame);
		rightBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(rightBox);
	}
	
	
	/**
	 * Defines the pane of the menu, where the user can exit and 
	 * select a computer strategy
	 */
	private final class MenuPane extends MenuBar {
		private Game theGame;
		private ComputerPlayer theComputer;
		
		/**
		 * Creates a new ComputerPane that observes the specified game. 
		 * 
		 * @param theGame	the model object from which this pane gets its data
		 * 
		 * @requires 	theGame != null
		 */
		private MenuPane(Game theGame) {
			this.theGame = theGame;
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.getFileMenu();
			this.getOptionsMenu();
			this.getStrategyMenu();
			
		}
		
		private void getFileMenu() {
			Menu fileMenu = new Menu("_File");
			MenuItem newMenuItem = new MenuItem("_New");
			newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.SHORTCUT_DOWN));
			newMenuItem.setOnAction(actionEvent -> {
				try {
					this.theGame.startNewGame(this.theGame.getFirstPlayer());
					if (this.theGame.getFirstPlayer() == this.theComputer) {
						PigPane.this.pnComputerPlayer.setDisable(false);
						this.theComputer.setIsMyTurn(true);
					} else {
						PigPane.this.pnHumanPlayer.setDisable(false);
					}
				} catch (NullPointerException npe) {
					
				}
			});
			
			MenuItem exitMenuItem = new MenuItem("E_xit");
			exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));
			exitMenuItem.setOnAction(actionEvent -> System.exit(0));
			
			fileMenu.getItems().addAll(newMenuItem, exitMenuItem);
			this.getMenus().add(fileMenu);
		}
		
		private void getOptionsMenu() {
			Menu optionsMenu = new Menu("_Options");
			CheckMenuItem autoRollMenuItem = new CheckMenuItem("Auto-Roll");
			autoRollMenuItem.setOnAction(e -> 
				this.theComputer.setAutoRoll(autoRollMenuItem.isSelected()));
			MenuItem setGoalScoreMenuItem = new MenuItem("Set Goal Score");
			setGoalScoreMenuItem.setOnAction(e -> {
				TextInputDialog popup = new TextInputDialog("100");
				popup.setTitle("Set Goal Score");
				popup.setHeaderText("Set a new goal score");
				popup.setContentText("Goal Score:");
				Optional<String> result = popup.showAndWait();
				int newGoalScore = 100;
				Alert alert = new Alert(
						AlertType.ERROR, 
						"That's not a valid goal score!\nGoal score is unchanged.", 
						ButtonType.OK);
				try {
					newGoalScore = Integer.parseInt(result.get());
					if (newGoalScore < 1) {
						alert.showAndWait();
					} else {
						this.theGame.setGoalScore(newGoalScore);
					}
				} catch (NumberFormatException nfe) {
					alert.showAndWait();
				}
				
			});
			optionsMenu.getItems().addAll(autoRollMenuItem, setGoalScoreMenuItem);
			this.getMenus().add(optionsMenu);
		}
		
		private void getStrategyMenu() {
			Menu strategyMenu = new Menu("_Strategy");
			ToggleGroup strategyToggle = new ToggleGroup();
			
			RadioMenuItem cautiousMenuItem = new RadioMenuItem("_Cautious");
			cautiousMenuItem.setOnAction(event -> this.theComputer.setStrategy(new CautiousStrategy()));
			cautiousMenuItem.setToggleGroup(strategyToggle);
			cautiousMenuItem.setSelected(true);
			
			RadioMenuItem greedyMenuItem = new RadioMenuItem("_Greedy");
			greedyMenuItem.setToggleGroup(strategyToggle);
			greedyMenuItem.setOnAction(event -> this.theComputer.setStrategy(new GreedyStrategy()));
			
			RadioMenuItem randomMenuItem = new RadioMenuItem("_Random");
			randomMenuItem.setToggleGroup(strategyToggle);
			randomMenuItem.setOnAction(event -> this.theComputer.setStrategy(new RandomStrategy()));
			
			strategyMenu.getItems().addAll(cautiousMenuItem, greedyMenuItem, randomMenuItem);
			this.getMenus().add(strategyMenu);
		}
	}
	
	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());
			
			// DONE: Instantiate the computer player button and add 
			//		 ComputerFirstListener as its action listener.
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			// DONE: Create a ToggleGroup and add the 2 radio buttons to it.
			ToggleGroup radPlayers = new ToggleGroup();
			radPlayers.getToggles().addAll(this.radHumanPlayer, this.radComputerPlayer);
			// DONE: Add the 2 radio buttons to this pane.
			this.add(this.radHumanPlayer, 0, 0);
			this.add(this.radComputerPlayer, 1, 0);
		}
		
		/* 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.pnComputerPlayer.setDisable(false);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		
		/* 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/* 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				// DONE: Enable the human player pane and start a game
				//		 with the human playing first.
				PigPane.this.pnHumanPlayer.setDisable(false);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
	}
}
