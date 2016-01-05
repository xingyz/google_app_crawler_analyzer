package com.factrus.main.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import com.factrus.main.controller.listener.view.ApplicationTileEventHandler;
import com.factrus.main.model.Application;

public class ApplicationTile extends AnchorPane {

	@FXML
	private ImageView tile_app_logo;
	@FXML
	private Label tile_app_name;
	@FXML
	private Pane hoverPane;
	
	public ApplicationTile(Application app) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/factrus/fxml/layout/custom/app_tile.fxml"));
		
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
			setTileContent(app);
			addTileListeners(app);
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	private void setTileContent(Application app){
		// Name
		Label app_name = new Label(app.getName());
		// Image Icon
		ImageView imageView = new ImageView();
		Image image = new Image(app.getIconURL(),true);
		imageView.setImage(image);
		imageView.setFitWidth(100);
		imageView.setPreserveRatio(true);
		
		tile_app_logo.setImage(imageView.getImage());
		tile_app_name.setText(app_name.getText());
	}
	
	/**
	 * Add events to the application tile
	 * @MOUSE_CLIKED: Show window with application info
	 * @MOUSE_ENTERED: Change UI to add shades
	 * @MOUSE_EXITED: Reset UI
	 */
	private void addTileListeners(Application app){
		tile_app_logo.addEventHandler(MouseEvent.MOUSE_CLICKED, 
				ApplicationTileEventHandler.newApplicationClickTileEventHandler(app));
		tile_app_logo.addEventHandler(MouseEvent.MOUSE_ENTERED, 
				ApplicationTileEventHandler.newApplicationMouseEnterTileEventHandler(hoverPane));
		tile_app_logo.addEventHandler(MouseEvent.MOUSE_EXITED, 
				ApplicationTileEventHandler.newApplicationMouseLeaveTileEventHandler(hoverPane));
	}
	
	
}
