import java.util.*;

public class KSpriteGroupT09 extends KSpriteGroup implements KConstant {

	private		int			intX		= 0;

	public KSpriteGroupT09(KPanel panel){

		super(panel);

		//
		ArrayList<KSprite> spriteLst = panel.getSpriteLst(LAYOUT_JIBUN);

		//
		KSprite spriteShip = spriteLst.get(0);

		//
		intX = ((spriteShip.getX() + spriteShip.getWidth() / 2) > (WIDTH / 2))?0: WIDTH - 48;

	}

	public void run(){

		//
		if((time % 10) == 0){
			//
			KSpriteT09 kSpriteT09 = new KSpriteT09(super.getKPanel(), intX);
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT09);
		}

		//
		if(time == 200){
			//
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
