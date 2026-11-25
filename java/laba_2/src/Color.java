
public class Color {
    private String value;
    public Color(){
        this("#ffffff");
    }
    public Color(String value){
        this.value = standardization(value);
    }
    public Color(Color other){
        this.value = other.value;
    }

    private String standardization(String text){
        text = text.replaceAll("\\s+", "");
        return text;
    }

    public void setColor(String value){
        this.value = value;
    }
    public String getColor(){
        return this.value;
    }

    public boolean checkHEX(){
        return this.value.matches("^#([A-Fa-f-0-9]{6}|[A-Fa-f-0-9]{3})$");
    }
    public boolean checkRGB(){
        return calcRGB(this.value);
    }

    public boolean calcRGB(String text){
        String[] rgb = text.split(",");
        if (rgb.length != 3) return false;
        for(String part : rgb){
            int i = Integer.parseInt(part);
            if(i < 0 || i > 255){
                return false;
            }
        }
        return true;
    }
}
