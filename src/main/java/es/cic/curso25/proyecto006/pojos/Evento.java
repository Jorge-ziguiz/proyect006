package es.cic.curso25.proyecto006.pojos;

public class Evento {

    private Long Id;

    private String Date;

    private String Location;

    private String Title;

    private String Description;

    public Evento(String date, String location, String title, String description) {
        Date = date;
        Location = location;
        Title = title;
        Description = description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
