
public class KSpriteT08 extends KSpriteT00 implements KConstant {

	private int mX = 0;

	public KSpriteT08(KPanel panel){

		super(panel);

		//
		intX = (int)(Math.random() * (panel.getWidth() - getWidth()));

		intY = -getHeight();

		//
		mX = 4 - (int)(Math.random() * 8);

	} // end KSpriteT08

	public void run(){

		//
		intY = intY + 12;

		intX = intX + mX;

		//
		if(intY > HEIGHT){
			//
			super.removeSprite();
		}

		//
		if(intY > 396){
			setImage(KSpriteT08.class, 0);
		}else if(intY > 360){
			setImage(KSpriteT08.class, 1);
		}else if(intY > 156){
			setImage(KSpriteT08.class, 0);
		}else if(intY > 120){
			setImage(KSpriteT08.class, 1);
		}

	} // end run

	public void bomb(){

		//

	} // end bomb

}
