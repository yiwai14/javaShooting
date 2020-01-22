public class KSpriteGroupJ03 extends KSpriteGroup implements KConstant {

	public KSpriteGroupJ03(KPanel panel, String storyParam){
		super(panel);
	}

	public void run(){

		//
		if((time % 32) == 0){
			for(int i = 0; i < 600; i = i + 64){
				KSpriteJ03 kSpriteJ03 = new KSpriteJ03(super.getKPanel(), i);
				super.getKPanel().addSprite(LAYOUT_JIMEN, kSpriteJ03);
			}
		}

		//
		if(time >= 320){
			super.getKPanel().removeSpriteGroup(this);
		}

	}

}
