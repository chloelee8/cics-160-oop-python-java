import java.util.LinkedList;

public class Mergesort {

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);

        LinkedList<Integer> sortedNumbers = sort(numbers);
        System.out.println("Sorted List: " + sortedNumbers);
    }

    public static LinkedList<Integer> sort(LinkedList<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }

        int middle = inputList.size() / 2;
        LinkedList<Integer> leftPart = makeNewList(inputList, 0, middle - 1);
        LinkedList<Integer> rightPart = makeNewList(inputList, middle, inputList.size() - 1);

        LinkedList<Integer> sortedLeft = sort(leftPart);
        LinkedList<Integer> sortedRight = sort(rightPart);

        return merge(sortedLeft, sortedRight);
    }

    public static LinkedList<Integer> makeNewList(LinkedList<Integer> originalList, int start, int end) {
        LinkedList<Integer> copiedList = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            copiedList.add(originalList.get(i));
        }
        return copiedList;
    }

    public static LinkedList<Integer> merge(LinkedList<Integer> leftList, LinkedList<Integer> rightList) {
        LinkedList<Integer> merged = new LinkedList<>();

        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            if (leftList.peekFirst() <= rightList.peekFirst()) {
                merged.add(leftList.pollFirst());
            } else {
                merged.add(rightList.pollFirst());
            }
        }

        merged.addAll(leftList);
        merged.addAll(rightList);

        return merged;
    }
}
