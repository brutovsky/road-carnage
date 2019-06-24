package gameObjects.stuff;

public enum Levels {
    DESERT("res/roadSkins/desert" + ".png"),
    ARCTIC("res/roadSkins/arctic" + ".png"),
    JUNGLE("res/roadSkins/jungle" + ".png"),
    CITY("res/roadSkins/city" + ".png"),
    WORLD("res/roadSkins/city" + ".png");
    private String path;
    Levels(String path){
        this.path = path;
    }
    public String getPath() {
        return path;
    }
}
