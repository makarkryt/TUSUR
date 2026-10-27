import java.util.Scanner;

public class laba1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите русский текст:");
        String text = scanner.nextLine();
        
        StringBuilder lettersLine = new StringBuilder();
        StringBuilder numbersLine = new StringBuilder();
        
        // Русский алфавит (33 буквы)
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            
            if (Character.isLetter(c)) {
                int index = alphabet.indexOf(c);
                if (index != -1) {
                    int number = index + 1; // Нумерация с 1
                    
                    // Добавляем букву с отступом (2 пробела после первой)
                    if (lettersLine.length() > 0) {
                        lettersLine.append("  ");
                        numbersLine.append("  ");
                    }
                    
                    lettersLine.append(c);
                    
                    // Форматируем число: если однозначное - добавляем пробел для выравнивания
                    if (number < 10) {
                        numbersLine.append(" ").append(number);
                    } else {
                        numbersLine.append(number);
                    }
                }
            } else if (c == ' ') {
                // Сохраняем пробелы как есть
                lettersLine.append("  ");
                numbersLine.append("  ");
            }
        }
        
        System.out.println(lettersLine.toString());
        System.out.println(numbersLine.toString());
        
        scanner.close();
    }
}