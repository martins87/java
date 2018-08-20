import java.util.*;
import java.math.*;
import java.io.*;

enum STANCE { bipedal, quadrupedal; }
enum DIET { herbivore, omnivore, carnivore; }

class Dinossaur {

	String name;
	double legLength;
	double strideLength;
	double speed;
	STANCE stance;
	DIET diet;

	public void setName(String _name) {
		name = _name;
	}

	public String getName() {
		return name;
	}

	public void setLegLength(double _legLength) {
		legLength = _legLength;
	}

	public double getLegLength() {
		return legLength;
	}

	public void setStrideLength(double _strideLength) {
		strideLength = _strideLength;
	}

	public double getStrideLength() {
		return strideLength;
	}

	public void setStance(STANCE _stance) {
		stance = _stance;
	}

	public STANCE getStance() {
		return stance;
	}

	public void setDiet(DIET _diet) {
		diet = _diet;
	}

	public DIET getDiet() {
		return diet;
	}

	public double getSpeed() {
		return speed;
	}

	public void calculateSpeed() {
		speed = ((strideLength / legLength) - 1) * Math.sqrt(legLength * 9.8);
	}

	public void printDinossaur() {
		System.out.print(getName() + " ");
		System.out.print(getLegLength() + " ");
		System.out.print(getStrideLength() + " ");
		System.out.print(getStance() + " ");
		System.out.print(getDiet() + " ");
		System.out.println(getSpeed() + " ");
	}

}

class Dinossaurs {

	public static void main(String[] args) {

		Hashtable<String, Dinossaur> dinossaurs = new Hashtable<String, Dinossaur>();

		// read file daset1.csv
		readEstatistics(dinossaurs);

		// read file dataset2.csv
		readAditionalData(dinossaurs);

		// order dinossaurs by speed
		findFastestDinossaurs(dinossaurs);

	}

	public static void readEstatistics(Hashtable<String, Dinossaur> dinossaurs) {
		String line = null;

		// get NAME, LEG_LENGTH and DIET
		try {
			FileReader fr = new FileReader("dataset1.csv");
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();
			while((line = br.readLine()) != null) {
				String[] dinossaurData = line.split(",");
				Dinossaur dinossaur = new Dinossaur();

				String name = dinossaurData[0];
				double legLength =  Double.parseDouble(dinossaurData[1]);
				DIET diet = DIET.valueOf(dinossaurData[2]);

				dinossaur.setName(name);
				dinossaur.setLegLength(legLength);
				dinossaur.setDiet(diet);
				dinossaurs.put(name, dinossaur);

			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void readAditionalData(Hashtable<String, Dinossaur> dinossaurs) {
		String line = null;

		// get NAME, STRIDE_LENGTH and STANCE
		try {
			FileReader fr = new FileReader("dataset2.csv");
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();
			while((line = br.readLine()) != null) {
				String[] dinossaurData = line.split(",");

				String name = dinossaurData[0];
				double strideLength =  Double.parseDouble(dinossaurData[1]);
				STANCE stance = STANCE.valueOf(dinossaurData[2]);

				if(dinossaurs.containsKey(name)) {
					dinossaurs.get(name).setStrideLength(strideLength);
					dinossaurs.get(name).setStance(stance);
					dinossaurs.get(name).calculateSpeed();
				}

			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void quickSort(double[] arr, int low, int high, String[] names) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		double pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				double temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				String tempName = names[i];
				names[i] = names[j];
				names[j] = tempName;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j, names);

		if (high > i)
			quickSort(arr, i, high, names);
	}

	public static void findFastestDinossaurs(Hashtable<String, Dinossaur> dinossaurs) {
		int i = 0;
		int bipedals = 0;

		// find number of bipedal dinossaurs
		for(Map.Entry<String, Dinossaur> d : dinossaurs.entrySet()) {
			if(d.getValue().getStance() == STANCE.bipedal) {
				bipedals++;
			}
		}

		// add dinossaurs names and speeds to auxiliar arrays
		String[] dinossaursNames = new String[bipedals];
		double[] dinossaursSpeeds = new double[bipedals];
		for(Map.Entry<String, Dinossaur> d : dinossaurs.entrySet()) {
			if(d.getValue().getStance() == STANCE.bipedal) {
				dinossaursNames[i] = d.getKey();
				dinossaursSpeeds[i] = d.getValue().getSpeed();
				i++;
			}
		}

		// sorts dinossaurs by speed
		quickSort(dinossaursSpeeds, 0, dinossaursNames.length - 1, dinossaursNames);

		// print fastest bipedal dinossaurs
		printFastestBipedals(dinossaursNames, dinossaursSpeeds);
	}

	public static void printFastestBipedals(String[] dinossaursNames, double[] dinossaursSpeeds) {
		for(int i = dinossaursNames.length - 1; i >= 0; i-- ) {
			System.out.println(dinossaursNames[i]);
		}
	}

}
