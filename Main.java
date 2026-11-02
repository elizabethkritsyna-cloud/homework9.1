import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }

        }
        System.out.println("Матриця 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int evenRowsSum = 0;
        int oddRowsSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    evenRowsSum += matrix[i][j];
                } else {
                    oddRowsSum += matrix[i][j];
                }
            }
        }
        System.out.println("Сума парних рядків: " + evenRowsSum);
        System.out.println("Сума непарних рядків: " + oddRowsSum);
        long evenColumnsProduct = 1;
        long oddColumnsProduct = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (j % 2 == 0) {
                    evenColumnsProduct *= matrix[i][j];
                } else {
                    oddColumnsProduct *= matrix[i][j];
                }

            }
        }

        System.out.println("Добуток парних стовпців: " + evenColumnsProduct);
        System.out.println("Добуток непарних стовпців: " + oddColumnsProduct);
        int magicSum = 0;

        for (int j = 0; j < 4; j++) {
            magicSum += matrix[0][j];
        }

        boolean isMagic = true;

        for (int i = 0; i < 4; i++) {
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                sum += matrix[i][j];
            }

            if (sum != magicSum) {
                isMagic = false;
            }
        }

        for (int j = 0; j < 4; j++) {
            int sum = 0;

            for (int i = 0; i < 4; i++) {
                sum += matrix[i][j];
            }

            if (sum != magicSum) {
                isMagic = false;
            }
        }
        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = 0; i < 4; i++) {
            diagonal1 += matrix[i][i];
            diagonal2 += matrix[i][3 - i];
        }

        if (diagonal1 != magicSum || diagonal2 != magicSum) {
            isMagic = false;
        }

        if (isMagic) {
            System.out.println("Матриця є магічним квадратом!");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }
}
