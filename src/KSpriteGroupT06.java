
public class KSpriteGroupT06 extends KSpriteGroup implements KConstant {

	private		String		storyParam	= null;

	public KSpriteGroupT06(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	public void run(){

		//
		if((time % 30) == 0){
			//
			KSpriteT06 kSpriteT06 = new KSpriteT06(super.getKPanel(), storyParam);
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT06);
		}

		//
		if(time == 300){
			super.getKPanel().removeSpriteGroup(this);
		}

	}

}
