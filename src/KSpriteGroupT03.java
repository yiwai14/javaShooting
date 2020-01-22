
public class KSpriteGroupT03 extends KSpriteGroup implements KConstant {

	private		String		storyParam	= null;

	public KSpriteGroupT03(KPanel panel, String storyParam){
		super(panel);
		this.storyParam = storyParam;
	}

	public void run(){

		//
		if((time % 20) == 0){
			//
			KSpriteT03 kSpriteT03 = new KSpriteT03(super.getKPanel());
			//
			super.getKPanel().addSprite(LAYOUT_TEKI, kSpriteT03);
		}

		//
		if(time == 580){
			//
			super.getKPanel().removeSpriteGroup(this);
		}

	} // end run

}
