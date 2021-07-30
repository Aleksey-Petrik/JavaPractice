public abstract class AbstractPiece {
    private String name;
    private int id;
    private boolean white;
    private boolean killed;
    private Spot spot;

    public AbstractPiece(String name, int id, boolean white, boolean killed, Spot spot) {
        this.name = name;
        this.id = id;
        this.white = white;
        this.killed = killed;
        this.spot = spot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    @Override
    public String toString() {
        return "AbstractPiece{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", white=" + white +
                ", killed=" + killed +
                ", spot X=" + spot.getX() +
                ", spot Y=" + spot.getY() +
                '}';
    }
}
