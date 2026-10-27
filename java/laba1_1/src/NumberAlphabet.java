public class NumberAlphabet {

    private String text;

    public NumberAlphabet(String text){
        this.text = text;
    }
    public NumberAlphabet(){
        this("Подруга дней моих суровых, Голубка дряхлая моя! Одна в глуши лесов сосновых. Давно, давно ты ждешь меня.");
    }
    public NumberAlphabet(NumberAlphabet other){
        this.text = other.text;
    }

    public void result() {
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

        System.out.println(letters + "\n" + numbers);
    }

}
