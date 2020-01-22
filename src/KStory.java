import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;

abstract public class KStory {

	private KPanel panel = null;

	public ArrayList<String> timeLst = null;

	public ArrayList<String> eventLst = null;

	public ArrayList<String> paramLst = null;

	private		int					timeStory			= 0;

	private		int					timeStoryNext		= 0;

	private		String				storyEvent			= null;

	private		String				storyParam			= null;

	private		int					indexStory			= -1;

	private		boolean				flgStart			= true;

	public KStory(KPanel panel, String fileName) throws Exception {

		this.panel = panel;

		timeLst = new ArrayList<String>(100);
		eventLst = new ArrayList<String>(100);
		paramLst = new ArrayList<String>(100);

		//
		BufferedReader br = null;

		//
		Container con = panel.getKCtrl().getParent();

		//
		if(con instanceof Applet){
			//
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));

		//
		}else{
			//
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
		}

		//
		while(true){

			//
			String strLine = br.readLine();

			//
			if(strLine == null){
				//
				break;
			}

			//
			int index = strLine.indexOf(",");

			//
			if(index == -1){
				//
				throw new IllegalStateException("==================");
			}

			//
			int index2 = strLine.indexOf("," , index + 1);

			String strTime = strLine.substring(0, index);
			String strEvent = null;
			String strParam = null;

			//
			if(index2 == -1){
				//
				strEvent = strLine.substring(index + 1);

			//
			}else{
				//
				strEvent = strLine.substring(index + 1, index2);
				strParam = strLine.substring(index2 + 1);

			} // end if

			//
			timeLst.add(strTime);
			eventLst.add(strEvent);
			paramLst.add(strParam);

		} // end while

	} // end KStory

	public int getStoryTime(){

		return timeStory;

	} // end getTimeStory

	private String getTime(){

		return timeLst.get(indexStory);

	} // end getTime

	private String getEvent(){

		return eventLst.get(indexStory);

	} // end getEvent

	private String getParam(){

		return paramLst.get(indexStory);

	} // end getParam

	public void next(){

		//
		if(flgStart){

			//
			this.timeStory++;

			//
			if(this.timeStory >= this.timeStoryNext){

				//
				if(storyEvent != null){

					//
					KSpriteObject spriteObject = storyEvent(storyEvent, storyParam);

					//
					if(spriteObject instanceof KSprite){

						//
						panel.addSprite(2, (KSprite)spriteObject);

					//
					}else if(spriteObject instanceof KSpriteGroup){

						//
						panel.addSpriteGroup((KSpriteGroup)spriteObject);

					} // end if

				} // end if

				//
				indexStory++;

				//
				timeStoryNext = Integer.parseInt(this.getTime());
				storyEvent = this.getEvent();
				storyParam = this.getParam();

			} // end if

		} // end if

	} // end next

	public KPanel getKPanel(){
		return panel;
	}

	public void start(){
		flgStart = true;
	}

	public void stop(){
		flgStart = false;
	}

	public void reset(){

		timeStory = 0;
		timeStoryNext = 0;
		indexStory =  -1;

		//
		storyEvent = null;
	}

	abstract public KSpriteObject storyEvent(String storyEvent, String storyParam);

}
