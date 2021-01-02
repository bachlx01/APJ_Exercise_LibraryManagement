import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryCard {
    private int cardID;
    private Date startDate;
    private Date endDate;
    private Student student;
    private Book book;

    public LibraryCard() {
    }

    public LibraryCard(int cardID, Date startDate, Date endDate, Student student, Book book) {
        this.cardID = cardID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.student = student;
        this.book = book;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String startDate = dateFormat.format(this.startDate);
        String endDate = dateFormat.format(this.endDate);
        return "CardID: " + this.cardID + "; Start date: " + startDate + "; End date: " + endDate
                + "; Student name: " + this.student.getName() + "; Book name: " + this.book.getBookName();
    }
}
