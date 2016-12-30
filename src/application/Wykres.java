package application;

import java.text.DecimalFormat;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;

public class Wykres {
	
	double a, b;
	
	Wykres (double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public QuadCurve drawPlot(){
		
		QuadCurve quadraPlot = new QuadCurve(
				0,		//start x point
				0,		//start y point
				250,	//control x point
				250,	//control y point
				500,	//end x point
				0		//end y point
				);
		
		quadraPlot.setFill(null);
		quadraPlot.setStroke(Color.BLACK);
		
		if (b == 0) {
		quadraPlot.setControlY(500);
		}
		else if (b < 0){
		quadraPlot.setControlY(750);	
		}
		
		return quadraPlot;
	}
	
	public Label setScale(int i) {
		
		int sign = 0;
		Label lbl = new Label();
		Double scale = 0.0;
		
		if (b ==0){
			scale = 1.0 + i;
		}
		else {
			if (b > 0) {
				sign = 1;
				}
				else if(b < 0){
				sign = -1;
				}
				
				scale = sign *((8 * (b / 5))- (i *(b/2.5)));	
		}
		
		lbl.setText(new DecimalFormat("#0.00").format(scale));
		lbl.setTranslateX(265);
		lbl.setTranslateY(40 + i*50);
		
		return lbl;
		
	}
	
}
