import java.util.List;
import java.util.Scanner;

import controller.ListModelHelper;
import model.ListModel;

public class DodgeVehicles {

		static Scanner in = new Scanner(System.in);
		static ListModelHelper lmh = new ListModelHelper();

		private static void addAModel() {
			// TODO Auto-generated method stub
			System.out.print("Enter a color: ");
			String color = in.nextLine();
			System.out.print("Enter an model: ");
			String model = in.nextLine();
			ListModel toAdd = new ListModel(color,model);
			lmh.insertModel(toAdd);

		}

		private static void deleteAModel() {
			// TODO Auto-generated method stub
			System.out.print("Enter the color to delete: ");
			String color = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			ListModel toDelete = new ListModel(color, model);
			lmh.deleteModel(toDelete);

		}

		private static void editAModel() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Color");
			System.out.println("2 : Search by Model");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListModel> foundModels;
			if (searchBy == 1) {
				System.out.print("Enter the color name: ");
				String colorName = in.nextLine();
				foundModels=lmh.searchForModelByColor(colorName);
				
			} else {
				System.out.print("Enter the model: ");
				String modelName = in.nextLine();
				foundModels=lmh.searchForModelByModel(modelName);

			}

			if (!foundModels.isEmpty()) {
				System.out.println("Found Results.");
				for (ListModel l : foundModels) {
					System.out.println(l.getYear() + " : " + l.toString());
				}
				System.out.print("Which Year to edit: ");
				int yearToEdit = in.nextInt();

				ListModel toEdit = lmh.searchForModelByYear(yearToEdit);
				System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getColor());
				System.out.println("1 : Update Color");
				System.out.println("2 : Update Model");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Color: ");
					String newColor = in.nextLine();
					toEdit.setColor(newColor);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				}

				lmh.updateModel(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runDodge();

		}

		public static void runDodge() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select a Dodge:");
				System.out.println("*  1 -- Add a Dodge");
				System.out.println("*  2 -- Edit a Dodge");
				System.out.println("*  3 -- Delete a Dodge");
				System.out.println("*  4 -- View the Dodge");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAModel();
				} else if (selection == 2) {
					editAModel();
				} else if (selection == 3) {
					deleteAModel();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lmh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListModel>allModels = lmh.showAllModels();
			for(ListModel singleModel : allModels) {
				System.out.println(singleModel.returnModelDetails());
			}

		}

	}