import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== โปรแกรม To-Do List ===");
        System.out.println("คำสั่งที่ใช้ได้:");
        System.out.println("  add <งาน>    - เพิ่มงานใหม่");
        System.out.println("  list         - ดูรายการงานทั้งหมด");
        System.out.println("  remove <เลข> - ลบงานตามหมายเลข");
        System.out.println("  exit         - ออกจากโปรแกรม");
        System.out.println("===========================\n");

        while (true) {
            System.out.print("กรุณาใส่คำสั่ง: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "add":
                    if (parts.length < 2) {
                        System.out.println("❌ กรุณาระบุงานที่ต้องการเพิ่ม");
                        System.out.println("   ตัวอย่าง: add อ่านหนังสือบทที่ 5\n");
                    } else {
                        addTask(parts[1]);
                    }
                    break;

                case "list":
                    listTasks();
                    break;

                case "remove":
                    if (parts.length < 2) {
                        System.out.println("❌ กรุณาระบุหมายเลขงานที่ต้องการลบ");
                        System.out.println("   ตัวอย่าง: remove 2\n");
                    } else {
                        try {
                            int index = Integer.parseInt(parts[1]);
                            removeTask(index);
                        } catch (NumberFormatException e) {
                            System.out.println("❌ กรุณาระบุหมายเลขที่ถูกต้อง\n");
                        }
                    }
                    break;

                case "exit":
                    System.out.println("👋 ขอบคุณที่ใช้งาน ลาก่อน!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ คำสั่งไม่ถูกต้อง กรุณาใช้: add, list, remove, หรือ exit\n");
            }
        }
    }

    private static void addTask(String task) {
        tasks.add(task);
        System.out.println("✅ เพิ่มงาน: \"" + task + "\" สำเร็จ\n");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📋 ไม่มีงานในรายการ\n");
        } else {
            System.out.println("\n📋 รายการงานทั้งหมด:");
            System.out.println("----------------------------");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("----------------------------");
            System.out.println("รวม " + tasks.size() + " งาน\n");
        }
    }

    private static void removeTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("❌ ไม่พบหมายเลขงาน " + index + " ในรายการ\n");
        } else {
            String removedTask = tasks.remove(index - 1);
            System.out.println("🗑️  ลบงาน: \"" + removedTask + "\" สำเร็จ\n");
        }
    }
}