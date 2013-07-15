public class Player {
    // new lien
    private String name;
    // add spaces between code lines
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }
    // new line
    // if you overriding methods use @Override annotation
    @Override
    public String toString() {
        return name;
    }
    //new line
}
