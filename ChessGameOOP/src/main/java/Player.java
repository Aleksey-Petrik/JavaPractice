import java.util.ArrayList;

public class Player {
    private String name;
    private String email;
    private boolean white;
    private int rank = 50;
    private int age;

    private ArrayList<AbstractPiece> piecesTop = new ArrayList<>();
    private ArrayList<AbstractPiece> piecesBottom = new ArrayList<>();

    public Player(String name, String email, int age) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Обязательно игрок должен иметь имя!");
        } else {
            this.name = name;
        }

        if (email == null || email.isBlank() || email.isEmpty()) {
            throw new IllegalArgumentException("Обязательно игрок должен иметь Email!");
        } else {
            this.email = email;
        }

        if (age < 18) {
            throw new IllegalArgumentException("Игроки должны быть возрастом от 18 лет!");
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isWhite() {
        return white;
    }

    public int getRank() {
        return rank;
    }

    public int getAge() {
        return age;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public void setRank(int rank) {
        if (rank < 50 || rank > 3000) {
            throw new IllegalArgumentException("Недопустимое значение, ранк в пределах от 50 до 3000!");
        }
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", white=" + white +
                ", rank=" + rank +
                ", age=" + age +
                '}';
    }
}
