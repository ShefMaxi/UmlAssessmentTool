// YAN ZHANG

package compareUML;
import PackagedElements.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Comparison {

	protected HashMap<String, ArrayList<PackagedElement>> hm;
	protected ArrayList<PackagedElement> processedElements;
	
	public Comparison(ElementsPreprocessor ep){
		hm=ep.preprocessForUseCase();
		Set<String> set = hm.keySet();
		
		for (String key: set) {
			if(key.compareToIgnoreCase("Actor")==0) {
				for (PackagedElement pe : hm.get(key)) {
					pe = new ActorElement(pe.getType() , pe.getId());
				}
			}
			else if(key.compareToIgnoreCase("Usecase")==0){
				for (PackagedElement pe : hm.get(key)) {
					pe = new ActorElement(pe.getType() , pe.getId());
				}
			}
			else if(key.compareToIgnoreCase("Association")==0){
				for (PackagedElement pe : hm.get(key)) {
					pe = new ActorElement(pe.getType() , pe.getId());
				}
			} 
		
		}
	}
}
