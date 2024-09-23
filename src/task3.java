import java.util.Arrays;

interface ContainerInterface {
    void sort();
    double norma();
}

class BubbleSort implements ContainerInterface {
    private int[] elements;

    public BubbleSort(int[] elements) {
        this.elements = elements;
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

    public int[] getElements() {
        return elements;
    }
}

class ChoiceSort implements ContainerInterface {
    private int[] elements;

    public ChoiceSort(int[] elements) {
        this.elements = elements;
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

    public int[] getElements() {
        return elements;
    }
}

public class task3 {
    public static void main(String[] args) {
        int[] data1 = {5, 3, 8, 1, 2};
        int[] data2 = {10, 7, 4, 6, 9};

        ContainerInterface bubbleContainer = new BubbleSort(data1);
        bubbleContainer.sort();
        System.out.println("Sorted Bubble: " + Arrays.toString(((BubbleSort) bubbleContainer).getElements()));
        System.out.println("Norma (sqrt(sum)): " + bubbleContainer.norma());

        ContainerInterface choiceContainer = new ChoiceSort(data2);
        choiceContainer.sort();
        System.out.println("Sorted Choice: " + Arrays.toString(((ChoiceSort) choiceContainer).getElements()));
        System.out.println("Norma (average): " + choiceContainer.norma());
    }
}
