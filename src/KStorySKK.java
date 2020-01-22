

public class KStorySKK extends KStory {

	public KStorySKK(KPanel panel) throws Exception{

		//
		super(panel, "KStorySKK.txt");

	}

	public KSpriteObject storyEvent(String storyEvent, String storyParam){

		KSpriteObject spriteObject = null;

		if("S01".equals(storyEvent)){
			spriteObject = new KSpriteS01(super.getKPanel());

		}else if("S02".equals(storyEvent)){
			spriteObject = new KSpriteS02(super.getKPanel());

		}else if("S03".equals(storyEvent)){
			spriteObject = new KSpriteS03(super.getKPanel());

		}else if("S04".equals(storyEvent)){
			spriteObject = new KSpriteS04(super.getKPanel());

		}else if("T01".equals(storyEvent)){
			spriteObject = new KSpriteGroupT01(super.getKPanel(), storyParam);

		}else if("T02".equals(storyEvent)){
			spriteObject = new KSpriteGroupT02(super.getKPanel(), storyParam);

		}else if("T03".equals(storyEvent)){
			spriteObject = new KSpriteGroupT03(super.getKPanel(), storyParam);

		}else if("T04".equals(storyEvent)){
			spriteObject = new KSpriteGroupT04(super.getKPanel());

		}else if("T05".equals(storyEvent)){
			spriteObject = new KSpriteGroupT05(super.getKPanel(), storyParam);

		}else if("T06".equals(storyEvent)){
			spriteObject = new KSpriteGroupT06(super.getKPanel(), storyParam);

		}else if("T07".equals(storyEvent)){
			spriteObject = new KSpriteGroupT07(super.getKPanel(), storyParam);

		}else if("T08".equals(storyEvent)){
			spriteObject = new KSpriteGroupT08(super.getKPanel());

		}else if("T09".equals(storyEvent)){
			spriteObject = new KSpriteGroupT09(super.getKPanel());

		//
		}else if("J01".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ01(super.getKPanel());

		//
		}else if("J02".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ02(super.getKPanel(), storyParam);

		//
		}else if("J03".equals(storyEvent)){
			spriteObject = new KSpriteGroupJ03(super.getKPanel(), storyParam);

		//
		}else if("C01".equals(storyEvent)){
			spriteObject = new KSpriteGroupC01(super.getKPanel());

		//
		}else if("C02".equals(storyEvent)){
			spriteObject = new KSpriteGroupC02(super.getKPanel());

		}else{

		} // end if

		//
		return spriteObject;

	} // end storyEvent

}
