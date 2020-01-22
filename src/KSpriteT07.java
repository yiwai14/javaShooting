import java.util.*;

public class KSpriteT07 extends KSpriteT00 implements KConstant {

	private		int			timeBeam	= -1;

	private		int			rotate		= 0;

	private		boolean		flgLocate	= false;

	private		int			time		= 0;

	private		int			pattern		= 0;

	private		int			mX 			= 0;

	private		int			mY 			= 4;

	public KSpriteT07(KPanel panel, String storyParam){

		super(panel);

		//
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		//
		KSprite spriteShip = spriteLst.get(0);

		//
		rotate = (int)(Math.random() * 8);

		//
		if(spriteShip.getX() < WIDTH / 2){
			//
			flgLocate = true;
			intX = 540;

		//
		}else{
			//
			flgLocate = false;
			intX = 30;
		}

		intY = -getHeight();

		//
		if(storyParam != null){
			//
			timeBeam = Integer.parseInt(storyParam);
		}

	} // end KSpriteT07

	public void run(){

		//
		super.run();

		//
		intY = intY + mY;
		intX = intX + mX;

		//
		if(!isBomb()){

			//
			if(intY > 300){
				mX = (!flgLocate)?10: -10;
				mY = 1;
			}else if(intY > 270){
				mX = (!flgLocate)?8: -8;
				mY = 2;
			}else if(intY > 220){
				mX = (!flgLocate)?4: -4;
				mY = 3;
			}else if(intY > 150){
				mX = (!flgLocate)?2: -2;
				mY = 4;
			}

			//
			time++;

			//
			if(time % 3 == 0){
				rotate++;
				pattern = flgLocate?(Math.abs(rotate / 3) % 8): (7 - Math.abs(rotate / 3) % 8);
				setImage(KSpriteT07.class, pattern);
			}

			//
			if(timeBeam != -1 && time % timeBeam == 0){

				//
				double mXBeam = 0d;
				double mYBeam = 0d;

				switch(rotate % 8){

					case 0:
						mXBeam = 0d;
						mYBeam = 4d;
						break;
					case 1:
						mXBeam = -2.828d;
						mYBeam = 2.828d;
						break;
					case 2:
						mXBeam = -4d;
						mYBeam = 0d;
						break;
					case 3:
						mXBeam = -2.828d;
						mYBeam = -2.828d;
						break;
					case 4:
						mXBeam = 0d;
						mYBeam = -4d;
						break;
					case 5:
						mXBeam = 2.828d;
						mYBeam = -2.828d;
						break;
					case 6:
						mXBeam = 4d;
						mYBeam = 0d;
						break;
					case 7:
						mXBeam = 2.828d;
						mYBeam = 2.828d;
						break;
					default:
						throw new IllegalStateException("���������ł�");

				} // end switch

				//
				KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, mXBeam, mYBeam);
				super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

			}

		}

		//
		if(intX < -32 || intX > WIDTH || intY > HEIGHT){
			//
			super.removeSprite();
		}

	}

	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(200);

		super.bomb();

	} // end bomb

}
