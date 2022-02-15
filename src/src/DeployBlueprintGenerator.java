import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author kkadam
 *
 */
public class DeployBlueprintGenerator {

	
	public List<String> genrateBlueprints(List<SimplifiedBlueprint> simplifiedBlueprints) {
		List<String> deployBlueprints = new ArrayList<String>();
		for (SimplifiedBlueprint simplifiedBlueprint : simplifiedBlueprints) {
			BlueprintCreator creator = new BlueprintCreator();
			creator.generate(simplifiedBlueprint);
		}
		return deployBlueprints;
		
	}

}
