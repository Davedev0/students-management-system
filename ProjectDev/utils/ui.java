package ProjectDev.utils;

//Para makapag create ng table
public class ui {
    public static void printTableHeader() {
        System.out.println("+=====+========================+===========+==========+=====+");
        System.out.println("| ID  | Name                   | Course    | Section  | Age |");
        System.out.println("+=====+========================+===========+==========+=====+");
    }
    
    public static void printRowEmpty() {
        System.out.println();
        System.out.println("+=====+========================+===========+==========+=====+");
        System.out.println("| ID  | Name                   | Course    | Section  | Age |");
        System.out.println("+=====+========================+===========+==========+=====+");
        System.out.println("| #   | Student Not found.     |           |          |  0  |");
        System.out.println("+=====+========================+===========+==========+=====+");
    }

    public static void printRowSeparate() {
        System.out.println("+=====+========================+===========+==========+=====+");
    }

    public static void printSinglePerson(ProjectDev.views.Person person) {
        printTableHeader();
        System.out.println(person.toTableRow());
        printRowSeparate();
    }
}