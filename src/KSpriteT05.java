import java.util.*;

public class KSpriteT05 extends KSpriteT00 implements KConstant {

	//
	// �G�����������ňړ������邽�߂ɁA���낢��ƌv�Z���Ă���
	//
	private	final	int			SPRITE_WIDTH = 32;

	private final	int			MARGIN = 48;

	private final	int			RANGE = (WIDTH - MARGIN * 2) / 2;

	private final	int			CENTER = WIDTH / 2 - SPRITE_WIDTH;

	private			boolean		flgCourse = false;

	private			int			timeBeam	= -1;

	public KSpriteT05(KPanel panel, String storyParam){

		super(panel);

		//
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		//
		KSprite sprite = spriteLst.get(0);

		//
		if(sprite.getX() < WIDTH / 2){
			//
			flgCourse = true;
		}

		intY = -getHeight();

		//
		if(storyParam != null && !storyParam.equals("-1")){
			//
			timeBeam = Integer.parseInt(storyParam);
		}

	} // end KSpriteT05

	public void run(){

		//
		super.run();

		//
		intY = intY + 1;

		//
		if(intY > HEIGHT){
			//
			super.removeSprite();
		}

		//
		intX = CENTER + (int)(Math.sin(Math.toRadians((double)((intY * 2 + (flgCourse?180: 0)) % 360))) * RANGE);

		//
		if(!isBomb()){

			//
			if(intY % 6 == 0){
				//
				setImage(KSpriteT05.class, Math.abs(intY / 6) % 4);
			}

			//
			if(timeBeam != -1 && intY % timeBeam == (timeBeam - 1)){

				//
				KSpriteT99 kSpriteT99 = new KSpriteT99(super.getKPanel(), this, 6);
				super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT99);

			}

		} // end if

	} // end run

	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
