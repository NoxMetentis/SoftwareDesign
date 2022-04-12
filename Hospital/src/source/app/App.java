package source.app;



public class App {

	public static void main(String[] args) {

		IDataList dataLists = new DataLists();
		Controller controller = new Controller(dataLists);
		Main userInterface = new Main(controller);
		userInterface.start();
	}

}
