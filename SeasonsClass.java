// б)

public class SeasonsClass {
    public static void main(String[] args) {
        SeasonsEnum seasonsEnum = SeasonsEnum.WINTER;
        System.out.println(seasonsEnum);

        v(SeasonsEnum.WINTER); //в)

        j();
    }

    //в)
    public static void v(SeasonsEnum seasonsEnum){
        switch (seasonsEnum) {
            case AUTUMN -> System.out.println("Я люблю осень");
            case WINTER -> System.out.println("Я люблю зиму");
            case SPRING -> System.out.println("Я люблю весну");
            case SUMMER -> System.out.println("Я люблю лето");
        }

        // ну или так:

       /* switch (seasonsEnum){
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
        }*/
    }

    // ж)
    public static void j(){
        for (SeasonsEnum i: SeasonsEnum.values()){
            System.out.println(i + " " + i.average_temp() + " " + i.getDescription());
        }
    }
}
