// a,г)
public enum SeasonsEnum {
    AUTUMN(8), WINTER(-14), SPRING(10), SUMMER(20){
        @Override  // е)
        public String getDescription() {
            return "Теплое время года";
        }
    };
    final int average_temp;

    // д)
    SeasonsEnum(int average_temp){
        this.average_temp = average_temp;
    }
    public int average_temp(){
        return average_temp;
    }

    // e)
    public String getDescription(){
        return "Холодное время года";
    }
};

