package ar.edu.utn.frba.dadm.clases2018c1.clases_2018c1;

public class Video {
    private String description;
    private double lat;
    private double lng;
    private String name;
    private String preview;

    public Video(String description, double lat, double lng, String name, String preview) {
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.preview = preview;
    }

    public String getDescription() {
        return description;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }

    public String getPreview() {
        return preview;
    }
}
