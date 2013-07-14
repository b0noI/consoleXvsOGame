public class Player {
    private String name;
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }
    public String toString() {
        return name;
    }
}
