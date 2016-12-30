package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			effectively final double a = 0;
			double c = 0;
			
			VBox root = new VBox();
			Scene scene = new Scene(root,500,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			HBox topBox = new HBox();
			
			topBox.setPrefSize(500, 100);
			topBox.setPadding(new Insets(40));
			Label lbTopic = new Label("Rysuj wykres funkcji:  f(x) = ");
			lbTopic.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
			topBox.getChildren().add(lbTopic);
			
			TextField txParamA = new TextField("a");
			txParamA.setPrefWidth(40);
			topBox.getChildren().add(txParamA);
			
			topBox.getChildren().add(new Label("  x^2 + "));
			
			TextField txParamC = new TextField("c");
			txParamC.setPrefWidth(40);
			topBox.getChildren().add(txParamC);
			
			Button btnDraw = new Button("Rysuj wykres");
			
			btnDraw.setOnAction(e -> {
				a = Double.parseDouble(txParamA.getText());
				
			});
			
			topBox.getChildren().add(btnDraw);
			
			Pane drawingPane = new Pane();
			drawingPane.setStyle("-fx-background-color: white");
			
			//rysowanie osi X
			Line linXAxis = new Line(
					0,		//x start
					250,	//y start
					500,	//x end
					250);	//y end
			linXAxis.setStrokeWidth(2);
			
			//rysowanie strzałki na osi X
			Polygon polXTriangle = new Polygon(
					510, 250, 	//x and y of 1. point
					490, 257,	//x and y of 2. point
					490, 243	//x and y of 3. point
					);
			
			drawingPane.getChildren().add(linXAxis);
			drawingPane.getChildren().add(polXTriangle);
			
			//rysowanie osi Y
			Line linYAxis = new Line(
					250,
					10,
					250,
					510);
			linYAxis.setStrokeWidth(2);
			
			//rysowanie strzałki na osi Y
			Polygon polYTriangle = new Polygon(
					250, 0, 	//x and y of 1. point
					257, 20,	//x and y of 2. point
					243, 20	//x and y of 3. point
					);
			
			drawingPane.getChildren().add(linYAxis);
			drawingPane.getChildren().add(polYTriangle);
			
			// rysowanie podziałki
			for (int i=50; i < 500; i=i+50){
				Line linYScale = new Line(
						243,
						i,
						257,
						i
						);
				
				Line linXScale = new Line(
						i,
						243,
						i,
						257
						);
				drawingPane.getChildren().add(linYScale);
				drawingPane.getChildren().add(linXScale);
			}
		
			Wykres quadraChart = new Wykres(2, -1);
			drawingPane.getChildren().add(quadraChart.drawPlot());
			
			for (int i = 0; i < 9; i++) {
				
				if (i != 4){
					drawingPane.getChildren().add(quadraChart.setScale(i));
				}
				
			}
			
			
			root.getChildren().addAll(topBox, drawingPane);
			primaryStage.setTitle("Wykres f(x) kwadratowej");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
