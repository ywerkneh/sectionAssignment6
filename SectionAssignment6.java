
package sectionAssignment6;

import acm.graphics.GImage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Pick Question: ");
            int qeustionNumber = scanner.nextInt();
            switch (qeustionNumber) {
                case 1:
                    imageprocessing();
                    break;
                case 2:
                    nameCounts();
                    break;
                default:
                    System.out.println("Wrong Question Number!! start again.");
            }
        }
    }

    private static void nameCounts() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> nameMap = new HashMap<>(); // Map<Name, Count>        String name;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
            if (nameMap.containsKey(name) && !name.isBlank()) {
                nameMap.put(name, nameMap.get(name) + 1);
            } else if (!name.isBlank()) {
                nameMap.put(name, 1);
            }
        } while (!name.isBlank());
        for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
            System.out.println("Entry [" + entry.getKey() + "] has count " + entry.getValue());
        }
    }

    private static void imageprocessing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Image for Horizontal flip: ");
        String fileName = scanner.nextLine();
        flipHorizontal(new GImage(fileName));
    }

    private static GImage flipHorizontal(GImage image) {
        int[][] array = image.getPixelArray();        int width = array[0].length;        for(int p1 = 0; p1 < width / 2; p1++){            int p2 = width - p1 - 1;            int [] temp = array[p1];            array[p1] = array[p2];            array[p2] = temp;        }        return new GImage(array);    }}