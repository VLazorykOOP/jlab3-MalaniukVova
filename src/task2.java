import java.util.Arrays;

abstract class Container {
    protected int[] elements;

    public Container(int[] elements) {
        this.elements = elements;
    }

    public abstract void sort();
    public abstract double norma();
}

class Bubble extends Container {
    public Bubble(int[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    // Swap
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public double norma() {
        double sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return Math.sqrt(sum);
    }
}

class Choice extends Container {
    public Choice(int[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (elements[j] > elements[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap
            int temp = elements[maxIdx];
            elements[maxIdx] = elements[i];
            elements[i] = temp;
        }
    }

    @Override
    public double norma() {
        double sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return sum / elements.length;
    }
}

public class task2 {
    public static void main(String[] args) {
        int[] data1 = {5, 3, 8, 1, 2};
        int[] data2 = {10, 7, 4, 6, 9};

        Container bubbleContainer = new Bubble(data1);
        bubbleContainer.sort();
        System.out.println("Sorted Bubble: " + Arrays.toString(bubbleContainer.elements));
        System.out.println("Norma (sqrt(sum)): " + bubbleContainer.norma());

        Container choiceContainer = new Choice(data2);
        choiceContainer.sort();
        System.out.println("Sorted Choice: " + Arrays.toString(choiceContainer.elements));
        System.out.println("Norma (average): " + choiceContainer.norma());
    }
}
