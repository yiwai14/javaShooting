import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

public class KTextShield extends KText {

	private		int		timer		= 0;

	private		int		INTERVAL	= 8;

	private		Color[]	colors		= new Color[]{
										new Color(255, 255,   0),
										new Color(240, 240,   0),
										new Color(224, 224,   0),
										new Color(208, 208,   0),
										new Color(192, 192,   0),
										new Color(160, 160,   0),
										new Color(128, 128,   0),
										new Color( 96,  96,   0),
										new Color( 64,  64,   0),
										new Color( 32,  32,   0),
										new Color(  0,   0,   0),
										new Color( 32,  32,   0),
										new Color( 64,  64,   0),
										new Color( 96,  96,   0),
										new Color(128, 128,   0),
										new Color(160, 160,   0),
										new Color(192, 192,   0),
										new Color(208, 208,   0),
										new Color(224, 224,   0),
										new Color(240, 240,   0),
										new Color(255, 255,   0)
									};

	private		int		ountColor	= colors.length;

	public KTextShield(KPanel panel, int intX, int intY){

		super(panel, intX, intY);

	}

	public void run(){

		timer++;

		if(timer >= INTERVAL * ountColor){
			timer = 0;
		}

		if(timer < 0){
			super.setForeground(Color.red);

		}else if(timer % INTERVAL == 0){
			super.setForeground(colors[timer / INTERVAL]);

		}

	} // end run

	public void damage(){
		timer = - INTERVAL * colors.length;
	}

}
