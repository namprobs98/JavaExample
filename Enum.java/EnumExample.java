public class EnumExample {
    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }
    //Khai báo biến enum:
    public static void main(String[] args) {
        Level myLevel = Level.MEDIUM;
        System.out.println("My level is: " + myLevel);
    }
}
