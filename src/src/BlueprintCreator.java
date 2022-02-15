
public class BlueprintCreator {
	
	SimplifiedBlueprint simplifiedBlueprint;
	

	public void generate(SimplifiedBlueprint simplifiedBlueprint) {
		generateResources();
		layoutResources();
		createBlueprintConfiguration();
		managePackages();
	}

	private void managePackages() {
		// TODO Auto-generated method stub
		PackageHandler packageHandler = PackageHandlerFactory.getPackageHandler("chef");
		packageHandler.handlePackages();
		
	}

	private void createBlueprintConfiguration() {
		BaseBlueptintConfigurator configurator = ConfiguratorFactory.getConfigurator(simplifiedBlueprint.getType());
		configurator.configureBlueprint();
	}

	private void layoutResources() {
		// This will generate layout of resources
		
	}

	private void generateResources() {
		// This will generate layout of resources

	}

}
