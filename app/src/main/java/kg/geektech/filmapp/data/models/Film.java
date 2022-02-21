package kg.geektech.filmapp.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("original_title")
    String originalTitle;
    @SerializedName("description")
    String description;
    @SerializedName("original_title_romanised")
    private String originalTitleRomanised;
    @SerializedName("image")
    private String image;
    @SerializedName("movie_banner")
    private String movieBanner;

    @SerializedName("director")
    private String director;
    @SerializedName("producer")
    private String producer;
    @SerializedName("release_date")
    private String releaseDate;

    public String getOriginalTitleRomanised() {
        return originalTitleRomanised;
    }

    public void setOriginalTitleRomanised(String originalTitleRomanised) {
        this.originalTitleRomanised = originalTitleRomanised;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMovieBanner() {
        return movieBanner;
    }

    public void setMovieBanner(String movieBanner) {
        this.movieBanner = movieBanner;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDescription() {
        return description;
    }
}
