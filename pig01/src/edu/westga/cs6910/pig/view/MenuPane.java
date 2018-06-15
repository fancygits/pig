package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * Defines the pane of the menu, where the user can exit and 
 * select a computer strategy
 * 
 * @author James Luke Johnson
 * @version 2018.06.14
 */
public class MenuPane extends MenuBar {
	private Game theGame;
	private ComputerPlayer theComputer;
	
	/**
	 * Creates a new ComputerPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public MenuPane(Game theGame) {
		this.theGame = theGame;
		this.theComputer = this.theGame.getComputerPlayer();
		
		this.buildPane();
	}
	
	private void buildPane() {		
		Menu fileMenu = new Menu("_File");
		MenuItem exitMenuItem = new MenuItem("E_xit");
		exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.SHORTCUT_DOWN));
		exitMenuItem.setOnAction(actionEvent -> System.exit(0));
		
		fileMenu.getItems().addAll(exitMenuItem);
		
		Menu strategyMenu = new Menu("_Strategy");
		MenuItem cautiousMenuItem = new MenuItem("_Cautious");
		MenuItem greedyMenuItem = new MenuItem("_Greedy");
		MenuItem randomMenuItem = new MenuItem("_Random");
		strategyMenu.getItems().addAll(cautiousMenuItem, greedyMenuItem, randomMenuItem);
		
		this.getMenus().addAll(fileMenu, strategyMenu);
	}
}
