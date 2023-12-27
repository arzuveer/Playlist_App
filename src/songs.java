public class songs {
    private String title;
    private double duration;

    public songs(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "songs{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
