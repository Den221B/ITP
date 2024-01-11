public class Cla1 {
    public static void main(String[] args) {
        Classes.Movie mv= new Classes().new Movie("Title", "Author", 2020, "Director");
        Classes.Movie mv2= new Classes().new Movie("Title2", "Author2", 2021, "Director2");
        System.out.println(Classes.Movie.getMovieCount());
        System.out.println(mv.getDirector());
        System.out.println(mv.getAuthor());
        System.out.println(mv.getTitle());
        System.out.println(mv.getTitle());
        mv.printInfo();
        mv.printInfo("Все");
    }
}
