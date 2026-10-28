import java.util.ArrayList;
import java.util.List;

public class NumberAlphabet {

    private String text;

    public NumberAlphabet(String text){
        validateRussianText(text);
        this.text = text;
    }
    public NumberAlphabet(){
        this("Подруга дней моих суровых, Голубка дряхлая моя! Одна в глуши лесов сосновых. Давно, давно ты ждешь меня.");
    }
    public NumberAlphabet(NumberAlphabet other){
        this.text = other.text;
    }

    public String getText(){
        return this.text;
    }
    public void setText(String text){
        validateRussianText(text);
        this.text = text;
    }
    private void validateRussianText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: текст не может быть пустым!");
        }
        
        boolean hasRussian = false;
        for (char c : text.toLowerCase().toCharArray()) {
            if ((c >= 'а' && c <= 'я') || c == ' ') {
                hasRussian = true;
                break;
            }
        }
        
        if (!hasRussian) {
            throw new IllegalArgumentException("Ошибка: текст должен содержать русские буквы!");
        }
    }

    public ArrayList<String> calcAlphabet() {
        String alphabet = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        
        StringBuilder letters = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        
        for (char c : this.text.toLowerCase().toCharArray()) {
            if (c >= 'а' && c <= 'я') {
                int position = alphabet.indexOf(c) + 1;
                letters.append(c + "  ");
                
                String numStr = String.valueOf(position);
                numbers.append(numStr);
                
                for (int i = 0; i < 3 - numStr.length(); i++) {
                    numbers.append(" ");
                }
            } else if (c == ' ') {
                letters.append("   ");
                numbers.append("   ");
            }
        }
        ArrayList<String> result = new ArrayList<>(List.of(letters.toString(), numbers.toString()));
        return result;
    }
    public void result(){
        int consoleWidth = 180;
        ArrayList<String> lines = calcAlphabet();
        
        int maxLineLength = 0;
        for (String line : lines) {
            if (line.length() > maxLineLength) {
                maxLineLength = line.length();
            }
        }
        
        String blueColor = "\u001B[34m";
        String resetColor = "\u001B[0m";
        
        for (String line : lines) {
            int padding = (consoleWidth - maxLineLength) / 2;
            System.out.println(blueColor + " ".repeat(Math.max(0, padding)) + line + resetColor);
        }
    }


}