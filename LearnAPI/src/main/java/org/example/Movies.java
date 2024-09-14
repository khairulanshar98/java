package org.example;

public class Movies implements Comparable {
    private String Title;
    private String imdbID;
    private int Year;

    public Movies(String title, String imdbID, int year) {
        this.Title = title;
        this.imdbID = imdbID;
        this.Year = year;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "Title='" + Title + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Year=" + Year +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }


    @Override
    public int compareTo(Object o) {
        Movies p = (Movies) o;
        return this.getTitle().compareTo(p.getTitle());
    }
}
