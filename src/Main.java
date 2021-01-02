import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
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
                    Student student = createStudent();// Input information of student and create a new student object
                    Book book = createBook(); // Input information of book and create a new book object
                    LibraryCard libraryCard = createLibraryCard(student, book); // Input information of library card and Create a new library card
                    libraryCardList.add(libraryCard);
                    break;

                case 2: //Show list students have borrowed book
                    for (LibraryCard e :
                            libraryCardList) {
                        System.out.println(e.getStudent().toString());
                    }
                    break;
                case 3: //Show list library card
                    for (LibraryCard e :
                            libraryCardList) {
                        System.out.println(e.toString());
                    }
                    break;
                case 4: //Show list books have end date at end of this month.
                    for (LibraryCard e :
                            libraryCardList) {
                        boolean endOfMonth = e.getEndDate().getMonth() == calendar.get(Calendar.MONTH) && e.getEndDate().getDay() > 20;
                        if (endOfMonth) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 9:
                    System.exit(0);
            }
        }
    }

    private static LibraryCard createLibraryCard(Student student, Book book) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        System.out.print("Enter the cardID: ");
        int cardID = new Scanner(System.in).nextInt();
        System.out.print("Enter start date (dd-mm-yy): ");
        String startDateStr = new Scanner(System.in).nextLine();
        Date startDate = dateFormat.parse(startDateStr);
        System.out.print("Enter end date (dd-mm-yy): ");
        String endDateStr = new Scanner(System.in).nextLine();
        Date endDate = dateFormat.parse(endDateStr);
        LibraryCard libraryCard = new LibraryCard(cardID, startDate, endDate, student, book);
        return libraryCard;
    }

    private static Book createBook() {
        System.out.print("Enter book ID: ");
        int book_ID = new Scanner(System.in).nextInt();
        System.out.print("Enter book name: ");
        String book_name = new Scanner(System.in).nextLine();
        Book book = new Book(book_ID, book_name);
        return book;
    }

    private static Student createStudent() {
        System.out.print("Enter studentID: ");
        int student_ID = new Scanner(System.in).nextInt();
        System.out.print("Enter student name: ");
        String student_name = new Scanner(System.in).nextLine();
        Student student = new Student(student_ID, student_name);
        return student;
    }
}
