import java.util.Arrays;

public class Testing{

    public int[] afterFour(int[] arrayIn){
        int index = -1;
        for (int i = 0; i < arrayIn.length; i++) {
            if (arrayIn[i] == 4) { index = i; }
        }
        if(index != -1) { return Arrays.copyOfRange(arrayIn, index+1, arrayIn.length); }
        else { throw new RuntimeException("В массиве отсутствует значение '4'"); }
    }

    public boolean hasOnAndFour(int[] arrayIn){
        boolean hasOneAndFour = true;
        int countFour = 0;
        int countOne = 0;

        for (int j : arrayIn) {
            if (hasOneAndFour = (j == 1)) {
                countOne++;
            } else if(hasOneAndFour = (j == 4)) {
                countFour++;
            } else {
                break;
            }
        }
        if (0 == countFour | 0 == countOne){
            return false;
        }
        return hasOneAndFour;
    }

}
