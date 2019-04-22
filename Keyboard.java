import java.util.*;

public class Keyboard {

    public static void main(String args[]){
		
        int[][] keyboardDistances = new int[9][9];
        keyboardDistances[0] = new int[]{0, 1, 2, 1, 1, 2, 2, 2, 2};
        keyboardDistances[1] = new int[]{1, 0, 1, 1, 1, 1, 2, 2, 2};
        keyboardDistances[2] = new int[]{2, 1, 0, 2, 1, 1, 2, 2, 2};
        keyboardDistances[3] = new int[]{1, 1, 2, 0, 1, 2, 1, 1, 2};
        keyboardDistances[4] = new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1};
        keyboardDistances[5] = new int[]{2, 1, 1, 2, 1, 0, 2, 1, 1};
        keyboardDistances[6] = new int[]{2, 2, 2, 1, 1, 2, 0, 1, 2};
        keyboardDistances[7] = new int[]{2, 2, 2, 1, 1, 1, 1, 0, 1};
        keyboardDistances[8] = new int[]{2, 2, 2, 2, 1, 1, 2, 1, 0};

        int[] positions = new int[10];

        int distance = 0;
        int sequenceIndex = 0;
        int currentPosition = 0;
        int nextPosition = 0;

        String keyboardData = new String("923857614");
        String sequence = new String("423692");
        // 8

        for(int i = 0; i < keyboardData.length(); i++) {
            positions[Character.getNumericValue(keyboardData.charAt(i))] = i;
        }

        while(sequenceIndex < sequence.length() - 1) {

            // get positions
            currentPosition = positions[ Character.getNumericValue( sequence.charAt(sequenceIndex) ) ];
            nextPosition = positions[ Character.getNumericValue( sequence.charAt(sequenceIndex + 1) ) ];

            distance += getDistance(currentPosition, nextPosition, keyboardDistances);

            currentPosition = nextPosition;
            nextPosition = positions[ Character.getNumericValue( sequence.charAt(sequenceIndex + 1) ) ];

            sequenceIndex++;
        }

        System.out.println(distance);
		
    }

    public static int getDistance(int currentPosition, int nextPosition, int[][] keyboard) {
        return keyboard[currentPosition][nextPosition];
    }

}
