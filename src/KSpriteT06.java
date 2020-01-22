import java.util.*;

public class KSpriteT06 extends KSpriteT00 implements KConstant {

	private		boolean		flgBeam		= false;

	private		boolean		flgPhase	= false;

	private		int			mX 		= 0;

	public KSpriteT06(KPanel panel, String storyParam){

		super(panel);

		//
		intX = (int)(Math.random() * (panel.getWidth() - getWidth()));

		intY = -getHeight();

		//
		if(storyParam != null && storyParam.equals("true")){
			//
			flgBeam = true;
		}

	} // end KSpriteT06

	public void run(){

		//
		super.run();

		//
		if(!flgPhase){

			//
			intY = intY + 4;

			//
			if(intY > HEIGHT){
				//
				super.removeSprite();
			}

			//
			ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

			//
			KSprite spriteShip = spriteLst.get(0);

			//
			if(super.getY() >= spriteShip.getY() / 2){

				//
				flgPhase = true;

				//
				int dx = spriteShip.getX() - intX;

				//
				if(dx > 100){
					mX = 3;
				}else if(dx < -100){
					mX = -3;
				}else{
					mX = 0;
				}

				//
				if(flgBeam){

					//
					flgBeam = true;

					KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 6);
					super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

				} // end if

			} // end if

		//
		}else{

			//
			intY = intY + 6;

			intX = intX + mX;

			//
			if(intY > HEIGHT){
				//
				super.removeSprite();
			}

		} // end if

	} // end run

	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(200);

		super.bomb();

	} // end bomb

}
