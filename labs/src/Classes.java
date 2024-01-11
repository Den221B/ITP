public class Classes {
    public abstract class Book {
        private String title;
        private String author;
        private int yearPublished;
        public Book() {
        }
        public Book(String title, String author, int yearPublished) {
            this.title = title;
            this.author = author;
            this.yearPublished = yearPublished;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYearPublished() {
            return yearPublished;
        }

        public void setYearPublished(int yearPublished) {
            this.yearPublished = yearPublished;
        }

        public abstract void printInfo();

        public void borrowBook() {
            System.out.println("Книга " + title + " взята в аренду.");
        }
    }

    public class Audiobook extends Book {
        private String narrator;


        public Audiobook(String title, String author, int yearPublished, String narrator) {
            super(title, author, yearPublished);
            this.narrator = narrator;
        }

        public String getNarrator() {
            return narrator;
        }

        public void setNarrator(String narrator) {
            this.narrator = narrator;
        }
        public void printInfo(String s){
            if (s=="Все") {
                System.out.println("Аудиокнига: " + getTitle() + ", Автор: " + getAuthor() + ", Рассказчик: " + narrator + ", Год публикации: " + getYearPublished() );
            }
        }
        @Override
        public void printInfo() {
            System.out.println("Аудиокнига: " + getTitle() + ", Автор: " + getAuthor() + ", Рассказчик: " + narrator);
        }
    }

    public class Movie extends Book {
        private String director;
        private static int movieCount=0;

        public Movie() {
            super();
        }

        public Movie(String title, String author, int yearPublished, String director) {
            super(title, author, yearPublished);
            this.director = director;
            movieCount+=1;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public static int getMovieCount(){
            return movieCount;
        }
        public void printInfo(String s){
            if (s=="Все") {
                System.out.println("Фильм: " + getTitle() + ", Автор: " + getAuthor() + ", Режиссер: " + director + ", Год публикации: " + getYearPublished() );
            }
        }
        @Override
        public void printInfo() {
            System.out.println("Фильм: " + getTitle() + ", Автор: " + getAuthor() + ", Режиссер: " + director);
        }
    }

    // Дочерний класс Мюзикл
    public class Musical extends Book {
        private String composer;


        public Musical(String title, String author, int yearPublished, String composer) {
            super(title, author, yearPublished);
            this.composer = composer;
        }

        public String getComposer() {
            return composer;
        }

        public void setComposer(String composer) {
            this.composer = composer;
        }
        public void printInfo(String s){
            if (s=="Все") {
                System.out.println("Мьюзикл: " + getTitle() + ", Автор: " + getAuthor() + ", Композитор: " + composer + ", Год публикации: " + getYearPublished() );
            }
        }
        @Override
        public void printInfo() {
            System.out.println("Мюзикл: " + getTitle() + ", Автор: " + getAuthor() + ", Композитор: " + composer);
        }
    }
}
