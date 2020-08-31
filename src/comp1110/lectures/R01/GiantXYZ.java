package comp1110.lectures.R01;

public class GiantXYZ extends Bike {
    /*
      Every Giant XZY shares these attributes

      They are class fields, so they are declared static
     */
    static final int numGears = 12;
    static final int numWheels = 2;
    static final String ModelName = "Giant XZY";
    static private int warrantyPeriod;

    /*
       Each bike is has its own value for the following
     */

    final int serialNumber;
    int totalKm;

    public GiantXYZ(int serialNumber, int totalKm) {
        this.serialNumber = serialNumber;
        this.totalKm = totalKm;
    }

    public static void setWarrantyPeriod(int period) {
        warrantyPeriod = period;
    }

    public void setTotalKm(int km) {
        this.totalKm = km;
    }

    public static void main(String[] args) {
        GiantXYZ yours = new GiantXYZ(247289134, 0);
        GiantXYZ mine = new GiantXYZ(247289135, 5);
        yours.setTotalKm(120);
        mine.setTotalKm(40);
    }
}
