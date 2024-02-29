
public class Tires {
    private String thickness;
    private String material;
    private String trackPattern;
    private String size;
    private String weatherType;

    public Tires(String thickness, String material, String trackPattern, String size, String weatherType) {
        this.thickness = thickness;
        this.material = material;
        this.trackPattern = trackPattern;
        this.size = size;
        this.weatherType = weatherType;
    }

    public String toString() {
        return "Tires{" +
                "thickness='" + thickness + '\'' +
                ", material='" + material + '\'' +
                ", trackPattern='" + trackPattern + '\'' +
                ", size='" + size + '\'' +
                ", weatherType='" + weatherType + '\'' +
                '}';
    }

    public boolean equals(Tires obj) {
        return thickness.equals(obj.thickness) &&
                material.equals(obj.material) &&
                trackPattern.equals(obj.trackPattern) &&
                size.equals(obj.size) &&
                weatherType.equals(obj.weatherType);
    }
}
