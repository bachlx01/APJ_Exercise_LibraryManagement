import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        List<LibraryCard> libraryCardList = new LinkedList();
        ListIterator listIterator = libraryCardList.listIterator();
        Scanner input = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        int choice = 0;
        while (choice != 9) {
            System.out.println("1. Create a new library card.");
            System.out.println("2. Show list students have borrowed book.");
            System.out.println("3. Show list library card.");
            System.out.println("4. Show list books have end date at end of this month.");
            System.out.println("9. Exit.");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1: // Create a new library card
                    // Input information of student and create a new student object
                    Student student = createStudent();
                    // Input information of book and create a new book object
                    Book book = createBook();
                    // Input information of library card and Create a new library card
                    LibraryCard libraryCard = createLibraryCard(student, book);
                    libraryCardList.add(libraryCard);
                    break;

                case 2:
                    for (LibraryCard e :
                            libraryCardList) {
                        System.out.println(e.getStudent().toString());
                    }
                    break;
                case 3:
                    for (LibraryCard e :
                            libraryCardList) {
                        System.out.println(e.toString());
                    }
                    break;
                case 4: // Functions with date time hasn't worked;
                    for (LibraryCard e :
                            libraryCardList) {
                        System.out.println(e.getEndDate().getMonth());
                        System.out.println(calendar.get(Calendar.MONTH));
                        System.out.println(e.getEndDate().getDay());
//                        boolean endOfMonth = e.getEndDate().getMonth() == calendar.get(Calendar.MONTH) && e.getEndDate().getDay() > 20;
//                        if (endOfMonth) {
//                            System.out.println(e.toString());
//                        }
                    }
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    private static LibraryCard createLibraryCard(Student student, Book book) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        int cardID = (int) Math.round(Math.random()*100);
        int randomDate = (int) Math.round(Math.random()*29)+1;
        int randomMonth = (int) Math.round(Math.random()*11)+1;
        Date startDate = dateFormat.parse(randomDate + "-" + randomMonth + "-2021");
        Date endDate = dateFormat.parse(randomDate + "-" + randomMonth + "-2021");
        LibraryCard libraryCard = new LibraryCard(cardID, startDate, endDate, student, book);
        return libraryCard;
    }

    private static Book createBook() {
        int randomID = (int) Math.round(Math.random()*100);
        Book book = new Book(randomID, "Love" + randomID);
        return book;
    }

    private static Student createStudent() {
        int randomID = (int) Math.round(Math.random()*100);
        Student student = new Student(randomID, "Bach" + randomID);
        return student;
    }
}
