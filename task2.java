import java.util.Scanner;
import java.io.*;

class Patient {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phone;
    private String medicalCardNumber;
    private String diagnosis;

    // Конструктор
    public Patient(int id, String lastName, String firstName, String middleName,
                   String address, String phone, String medicalCardNumber, String diagnosis) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    // Методи set і get
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public String getMiddleName() { return middleName; }

    public void setAddress(String address) { this.address = address; }
    public String getAddress() { return address; }

    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return phone; }

    public void setMedicalCardNumber(String medicalCardNumber) { this.medicalCardNumber = medicalCardNumber; }
    public String getMedicalCardNumber() { return medicalCardNumber; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getDiagnosis() { return diagnosis; }

    // toString
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", Last name='" + lastName + '\'' +
                ", First Name='" + firstName + '\'' +
                ", Patronymic='" + middleName + '\'' +
                ", Address='" + address + '\'' +
                ", Phone='" + phone + '\'' +
                ", Medical card number='" + medicalCardNumber + '\'' +
                ", Diagnosis='" + diagnosis + '\'' +
                '}';
    }
}

public class task2 {
    // Метод для виведення пацієнтів за діагнозом
    public static void printPatientsByDiagnosis(Patient[] patients, String diagnosis) {
        System.out.println("\nPatients with a diagnosis: " + diagnosis);
        boolean found = false;
        for (Patient p : patients) {
            if (p.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients with this diagnosis were found.");
        }
    }

    // Метод для виведення пацієнтів за інтервалом номерів медичних карт
    public static void printPatientsByMedicalCardRange(Patient[] patients, String minCard, String maxCard) {
        System.out.println("\nPatients with medical card numbers in range [" + minCard + " - " + maxCard + "]:");
        boolean found = false;
        for (Patient p : patients) {
            String cardNumber = p.getMedicalCardNumber();
            // Порівнюємо номери карт лексикографічно (як рядки)
            if (cardNumber.compareTo(minCard) >= 0 && cardNumber.compareTo(maxCard) <= 0) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients with medical card numbers in this range were found.");
        }
    }

    public static void main(String[] args) {
        // Створимо масив пацієнтів
        Patient[] patients = new Patient[] {
                new Patient(1, "Ivanenko", "Ivan", "Ivanovych", "Kyiv, vul. Lesi Ukrainky 10", "0501234567", "MC001", "Flu"),
                new Patient(2, "Petrenko", "Petro", "Petrovych", "Lviv, vul. Shevchenka 5", "0677654321", "MC002", "Flu"),
                new Patient(3, "Sydorenko", "Sydir", "Sydorovych", "Odesa, vul. Derybasivska 7", "0631112233", "MC003", "Sore throat"),
                new Patient(4, "Kovalchuk", "Olena", "Mykolaivna", "Kharkiv, prosp. Nauky 12", "0999876543", "MC004", "Flu"),
                new Patient(5, "Bondarenko", "Mykola", "Petrovych", "Dnipro, vul. Gagarina 20", "0505556677", "MC010", "Bronchitis"),
                new Patient(6, "Shevchenko", "Anna", "Ivanivna", "Zaporizhzhia, vul. Soborna 15", "0671234567", "MC015", "Pneumonia")
        };

        Scanner sc = new Scanner(System.in);
        
        // a) Пошук пацієнтів за діагнозом
        System.out.print("Enter a diagnosis to search: ");
        String diag = sc.nextLine();
        printPatientsByDiagnosis(patients, diag);

        System.out.println("\n" + "=".repeat(80) + "\n");

        // b) Пошук пацієнтів за інтервалом номерів медичних карт
        System.out.print("Enter the minimum medical card number: ");
        String minCard = sc.nextLine();
        
        System.out.print("Enter the maximum medical card number: ");
        String maxCard = sc.nextLine();
        
        printPatientsByMedicalCardRange(patients, minCard, maxCard);
        
        sc.close();
    }
}