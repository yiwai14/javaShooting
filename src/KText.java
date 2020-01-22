import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

public class KText {

	private Font font = new Font("�l�r �S�V�b�N", Font.PLAIN, 12);

	protected KPanel panel = null;

	protected int intX = 0;

	protected int intY = 0;

	private Color colorForeground = Color.white;

	private String strText = null;

	public KText(KPanel panel, int intX, int intY){

		this(panel, intX, intY, Color.white);

	} // end KText

	public KText(KPanel panel, int intX, int intY, Color colorForeground){

		super();

		this.panel = panel;

		this.intX = intX;

		this.intY = intY;

		this.colorForeground = colorForeground;

	} // end KText

	public void paint(Graphics g){

		//
		if(strText != null){

			//
			g.setFont(font);
			//
			g.setColor(this.colorForeground);

			//
			g.drawString(strText, intX, intY);

		} // end if

	} // end paint

	public void run(){

	}

	public int getX(){
		return this.intX;
	}

	public void setX(int x){
		this.intX = x;
	}

	public int getY(){
		return this.intY;
	}

	public void setY(int y){
		this.intY = y;
	}

	public void setText(String strText){
		//
		this.strText = strText;
	}

	public String getText(){
		//
		return strText;
	}

	public void setForeground(Color color){
		//
		this.colorForeground = color;
	}

	public void setFont(Font font){
		//
		this.font = font;
	}

	public KPanel getKPanel(){
		return panel;
	}

}
