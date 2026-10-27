public class Color {
    private String value;
    public Color(){
        this("#ffffff");
    }
    public Color(String value){
        this.value = value;
    }
    public Color(Color other){
        this.value = other.value;
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
}
