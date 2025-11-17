import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

    private String text = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println("\n=== CURRENT TEXT ===");
        System.out.println(text.isEmpty() ? "(empty)" : text);
        System.out.println("====================\n");
    }

    public void write() {
        System.out.print("Masukkan teks: ");
        String newText = scanner.nextLine();

        undoStack.push(text); 
        text += newText;
        redoStack.clear(); 

        System.out.println("Teks berhasil ditambahkan.\n");
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada yang bisa di-undo.\n");
            return;
        }

        redoStack.push(text); 
        text = undoStack.pop();

        System.out.println("Undo berhasil.\n");
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada yang bisa di-redo.\n");
            return;
        }

        undoStack.push(text); 
        text = redoStack.pop();

        System.out.println("Redo berhasil.\n");
    }

    public void menu() {
        while (true) {
            System.out.println("===== TEXT EDITOR =====");
            System.out.println("1. Show Text");
            System.out.println("2. Write Text");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: show(); break;
                case 2: write(); break;
                case 3: undo(); break;
                case 4: redo(); break;
                case 5:
                    System.out.println("Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.menu();
    }
}
