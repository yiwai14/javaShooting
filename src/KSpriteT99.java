import java.util.*;

public class KSpriteT99 extends KSprite implements KConstant {

	private		double		doubleX = 0d;
	private		double		doubleY = 0d;

	private		double		mX 		= 0d;
	private		double		mY 		= 0d;

	public KSpriteT99(KPanel panel, KSprite sprite, int speed){

		super(panel);

		//
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		//
		KSprite spriteShip = spriteLst.get(0);

		//
		doubleX = sprite.getX();
		doubleY = sprite.getY();

		int dx = spriteShip.getX() - (int)doubleX;
		int dy = spriteShip.getY() - (int)doubleY;

		//
		double dxdy = Math.sqrt((double)(dx * dx + dy * dy));

		//
		double time = dxdy / speed;

		//
		mX = dx / time;
		mY = dy / time;

	} // end KSpriteT99

	public KSpriteT99(KPanel panel, KSprite sprite, double mX, double mY){

		super(panel);

		//
		doubleX = sprite.getX();
		doubleY = sprite.getY();

		//
		this.mX = mX;
		this.mY = mY;

	} // end KSpriteT99

	public void run(){

		doubleX = doubleX + mX;
		doubleY = doubleY + mY;

		intX = (int)doubleX;
		intY = (int)doubleY;

		if(intX < 0 || intX > WIDTH || intY < 0 || intY > HEIGHT){
			super.removeSprite();
		}

	} // end run

}
