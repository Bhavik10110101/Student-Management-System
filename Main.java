import java.util.*;
import java.io.*;

class StudentDB {
    // FAST N RELIABLE - BIT-CHAR-QUICK INPUT
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // total std
    public static int t = 0;
    int enroll;
    int roll;
    String fName;
    String lName;
    String branch;

    static StudentDB createObj() throws IOException {
        t++;
        return new StudentDB();
    }

    public void create() throws IOException {
        System.out.print("Enter Student " + t + " first name : ");
        this.fName = br.readLine();
        System.out.print("Enter Student " + t + " last name : ");
        this.lName = br.readLine();
        System.out.print("Enter Student " + t + " enroll no. : ");
        this.enroll = Integer.parseInt(br.readLine());
        System.out.print("Enter Student " + t + " roll no. : ");
        this.roll = Integer.parseInt(br.readLine());
        System.out.print("Enter Student " + t + " Branch : ");
        this.branch = br.readLine();
        System.out.println(t + " student added.");
    }

    public void update(StudentDB student[]) throws IOException {
        if (t == 0) {
            System.out.println("Student data is Empty.");
        } else {
            System.out.print("Enter Enrollment of student to update : ");
            int nEnroll = Integer.parseInt(br.readLine());
            int flag = 0;
            int idx = 0;
            for (int i = 0; i < StudentDB.t; i++) {
                if (nEnroll == student[i].enroll) {
                    flag = 1;
                    idx = i;
                }
            }
            if (flag == 0) {
                System.out.println("Student not found with " + nEnroll + " enrollment number.");
            } else {
                System.out.print("1.Update fName\n2.Update lName\n3.Update Roll No\n4.Update Branch\nEnter Choice : ");
                int ch = Integer.parseInt(br.readLine());
                switch (ch) {
                    case 1:
                        System.out.print("Enter new fName : ");
                        String nfName = br.readLine();
                        student[idx].fName = nfName;
                        System.out.println("Student fName updated to " + nfName);
                        break;
                    case 2:
                        System.out.print("Enter new lName : ");
                        String nlName = br.readLine();
                        student[idx].lName = nlName;
                        System.out.println("Student lName updated to " + nlName);
                        break;
                    case 3:
                        System.out.print("Enter new Roll No. : ");
                        int nRoll = Integer.parseInt(br.readLine());
                        student[idx].roll = nRoll;
                        System.out.println("Student Roll No updated to " + nRoll);
                        break;
                    case 4:
                        System.out.print("Enter new Branch : ");
                        String nBranch = br.readLine();
                        student[idx].branch = nBranch;
                        System.out.println("Student Branch updated to " + nBranch);
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        }

    }

    public void search(StudentDB student[]) throws IOException {
        if (t == 0) {
            System.out.println("Student data is Empty.");
        } else {
            System.out.print(
                    "1.Search fName\n2.Search lName\n3.Search Roll No\n4.Search Enrollment No\n5.Search Branch\nEnter Choice : ");
            int ch = Integer.parseInt(br.readLine());
            int idx = 0, flag = 0;
            switch (ch) {
                case 1:
                    System.out.print("Enter fName : ");
                    String nfName = br.readLine();
                    for (int i = 0; i < StudentDB.t; i++) {
                        if (nfName.equalsIgnoreCase(student[i].fName)) {
                            flag = 1;
                            idx = i;
                            display(student, idx);
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Student with " + nfName + " not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter lName : ");
                    String nlName = br.readLine();
                    for (int i = 0; i < StudentDB.t; i++) {
                        if (nlName.equalsIgnoreCase(student[i].lName)) {
                            flag = 1;
                            idx = i;
                            display(student, idx);
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Student with " + nlName + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Roll No. : ");
                    int nRoll = Integer.parseInt(br.readLine());
                    for (int i = 0; i < StudentDB.t; i++) {
                        if (nRoll == student[i].roll) {
                            flag = 1;
                            idx = i;
                            display(student, idx);
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Student with " + nRoll + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Enrollment No. : ");
                    int nEnroll = Integer.parseInt(br.readLine());
                    for (int i = 0; i < StudentDB.t; i++) {
                        if (nEnroll == student[i].enroll) {
                            flag = 1;
                            idx = i;
                            display(student, idx);
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Student with " + nEnroll + " not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Branch : ");
                    String nBranch = br.readLine();
                    for (int i = 0; i < StudentDB.t; i++) {
                        if (nBranch.equalsIgnoreCase(student[i].branch)) {
                            flag = 1;
                            idx = i;
                            display(student, idx);
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Student with " + nBranch + " not found.");
                    }
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }

    }

    public void delete(StudentDB student[]) throws IOException {
        if (t == 0) {
            System.out.println("Student data is Empty.");
        } else {
            System.out.print("Enter Enrollment No of a student to delete the data : ");
            int nEnroll = Integer.parseInt(br.readLine());
            int flag = 0;
            for (int i = 0; i < StudentDB.t; i++) {
                if (student[i].enroll == nEnroll) {
                    flag = 1;
                    for (int j = i; j < (StudentDB.t) - 1; j++) {
                        student[i] = student[i + 1];
                    }
                    System.out.println("Student with Enrollment No. " + nEnroll + " deleted successully.");
                }
            }
            if (flag == 0) {
                System.out.println("Student with Enrollment No. " + nEnroll + " not found.");
            }
        }
    }

    // public String *
    public void display(StudentDB student[], int i) {
        System.out.println("\nStudent Details : \nfName : " + student[i].fName + "\nlName : " + student[i].lName
                + "\nEnrollment No. : " + student[i].enroll + "\nRoll No. : " + student[i].roll + "\nBranch : "
                + student[i].branch);
    }

    public void displayAll(StudentDB student[]) {
        if (t == 0) {
            System.out.println("Student data is Empty.");
        } else {
            for (int i = 0; i < StudentDB.t; i++) {
                System.out.println("\nStudent Details : \nfName : " + student[i].fName + "lName : " + student[i].lName
                        + "\nEnrollment No. : " + student[i].enroll + "\nRoll No. : " + student[i].roll + "Branch : "
                        + student[i].branch);
            }
        }
    }
}

class Main extends StudentDB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StudentDB student[] = new StudentDB[10];
        StudentDB ref = new StudentDB();

        int ch = 1;
        while (true) {
            System.out.print(
                    "\n*.*.*.*_M E N U_*.*.*.*\n0.Exit\n1.Create Student\n2.Update Student\n3.Search Student\n4.Delete Student\n5.Display Students\nEnter Choice : ");
            ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 1:
                    StudentDB.createObj();
                    ref = new StudentDB();
                    ref.create();
                    student[StudentDB.t - 1] = ref;
                    break;
                case 2:
                    ref.update(student);
                    break;
                case 3:
                    ref.search(student);
                    break;
                case 4:
                    ref.delete(student);
                    break;
                case 5:
                    ref.displayAll(student);
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
