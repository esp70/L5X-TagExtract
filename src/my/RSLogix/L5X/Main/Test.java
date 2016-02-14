package my.RSLogix.L5X.Main;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			final ControllerTagCollector controllerTagCollector = new ControllerTagCollector("IP2 - Copy2.L5X");
			
			/* Unmarshall the .L5X file into a Tag List */
			controllerTagCollector.unmarshall();
			
			/* Controller Base Tag list to pass as needed */
			controllerTagCollector.getTagList();
			
			/* Ways of extracting a print of the tags */
			//System.out.println(controllerTagCollector.listToString(controllerTagCollector.getTagDataTypeList("REAL")));
			//System.out.println(controllerTagCollector.listToString(controllerTagCollector.getTagRootDataTypeList("COUNTER")));
			//System.out.println(controllerTagCollector.listToString(controllerTagCollector.getTagByNameList("MyStructuredTagName")));
			
			/* Access Controller details */
			//System.out.println(controllerTagCollector.getControllerDetails().toString());
			
			/* Get User Data Types */
			//System.out.println(controllerTagCollector.getUserDataTypesToString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
}
