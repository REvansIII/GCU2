package vendingMachine;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.event.*;

public class DispenserConsole extends Application {

	private Label response;

	public DispenserConsole() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bpane = new BorderPane();

		bpane.setCenter(addGridPane());
		bpane.setBottom(null);
		bpane.setTop(getHbox());
		bpane.setLeft(getVbox());
		bpane.setRight(getSelection());

		Scene scene1 = new Scene(bpane);
		primaryStage.setTitle("VENDAMATIC 1.0");
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		
		
		

	}

	public GridPane addGridPane() {

		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));

		Text category = new Text("Products:");
		category.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		grid.add(category, 1, 0);

		Text status = new Text(" Available ");
		status.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		grid.add(status, 2, 0);

		ImageView image1 = new ImageView(
				"http://images.mentalfloss.com/sites/default/files/styles/insert_main_wide_image/public/istock_000012710166_small.jpg");
		image1.setFitHeight(100);
		image1.setFitWidth(100);
		grid.add(image1, 1, 5, 1, 1);

		ImageView image2 = new ImageView(
				"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSTvTiqlwp6SVfKGbOtz13hO2AVElcr5xdOz6MkfjVZZ0S-AglB");
		image2.setFitHeight(100);
		image2.setFitWidth(100);
		grid.add(image2, 2, 5);

		ImageView image3 = new ImageView("http://tavernservice.com/wp-content/uploads/2013/04/big_soda.jpg");
		image3.setFitHeight(100);
		image3.setFitWidth(100);
		grid.add(image3, 3, 5);

		return grid;

	}

	private VBox getVbox() {
		VBox vbox = new VBox(20);
		vbox.setPadding(new Insets(15, 15, 15, 15));
		vbox.setStyle("-fx-border-color: green");

		Button chips1 = new Button("Chips");
		Button candy1 = new Button("Candy");
		Button drinks1 = new Button("Drinks");
		response = new Label("");
		
		chips1.setOnAction ( (ae)  -> 
		response.setText("Doritos  .50 " + "  Fritos  .50 "+ "  Lays  .50 "+ "  Cheetos .50 ")
		
);
		candy1.setOnAction ( (ae)  -> 
		response.setText("Hershey's  .50 " + "  Mars .50 "+ "  Doublemint  .50 " +"  Big Red  .50 ")
);
		drinks1.setOnAction ( (ae)  -> 
		response.setText("Coke  .75 " + "  Mountain Dew .75 "+ "  Pepsi  .75 " +"  Fanta  .75  ")
		
);
		

		vbox.getChildren().addAll(chips1, candy1, drinks1);
		return vbox;		

	}
	
	private FlowPane getSelection(){
		FlowPane select = new FlowPane();
		select.setHgap(15);
		select.setVgap(10);
		select.setPadding(new Insets(5, 0, 5, 0));
		
		select.getChildren().add(response);
	
		
		
		return select;
		
	}
	
	

	private HBox getHbox() {
		HBox hbox = new HBox(30);
		hbox.setPadding(new Insets(15, 8, 8, 8));
		hbox.getChildren().add(new Label("Products"));

		Label[] products = { new Label("Snacks"), new Label("Drinks") };

		for (Label product : products) {
			HBox.setMargin(product, new Insets(0, 0, 0, 15));
			hbox.getChildren().add(product);
		}

		return hbox;

	}

	public static void main(String[] args) {

		Application.launch(args);
	}
}
