public class Room {
    private int length;
    private int width;
    public Room(int length, int width) {
         this.length = length;
         this.width = width;
    }

    public int getArea() {
        return length * width;
    }

}
