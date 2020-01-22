
public class KSpriteGroupT05 extends KSpriteGroup implements KConstant {

	private		String		storyParam	= null;

	public KSpriteGroupT05(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	public void run(){

		//
		if((time % 20) == 0){
			//
			KSpriteT05 kSpriteT05 = new KSpriteT05(super.getKPanel(), storyParam);
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT05);
		}

		//
		if(time == 280){
			//
			super.getKPanel().removeSpriteGroup(this);
		}

	}

}
