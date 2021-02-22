package tpDB1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public Scanner sc = new Scanner(System.in);

    private static void clear() {

        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO()
                    .start()
                    .waitFor();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.print("\033[H\033[2J");

        }
    }

    void ajouterEtudiant(
        final Logic.Etudiant e) {

        System.out.println();
        System.out.println("---------------------------");
        System.out.println("ajout d'un étudiant\n");
        System.out.println("---------------------------");
        System.out.println();
        System.out.print("entrer le nom de l'étudiant: ");
        e.nom = this.sc.nextLine();

        System.out.print("entrer le prénom de l'étudiant: ");
        e.prenom = this.sc.nextLine();

        System.out.print("entrer le code permanent de l'étudiant: ");
        try {
            e.codePermanent = Integer.parseInt(this.sc.nextLine());
        } catch (NumberFormatException a) {
            e.codePermanent = -1;
        }
        while (e.codePermanent == -1) {
            System.out.println("Code permanent invalide. Veuillez reessayer.");
            System.out.print("entrer le code permanent de l'étudiant: ");
            try {
                e.codePermanent = Integer.parseInt(this.sc.nextLine());
            } catch (NumberFormatException a) {
                e.codePermanent = -1;
            }
        }
    }

    ArrayList<Object> choix(
        final ArrayList<ArrayList<Object>> w,
        final String titre) {

        System.out.println();
        System.out.println("---------------------------");
        System.out.println(titre);
        System.out.println("---------------------------");
        listeNumerotee(w);
        System.out.println("---------------------------");
        System.out.print("SVP, sélectionner une option de 1 à " + String.valueOf(w.size()));
        System.out.println();
        int selection;
        try {
            selection = Integer.parseInt(this.sc.nextLine());
        } catch (NumberFormatException e) {
            selection = -1;
        }
        while (selection < 1 || selection > w.size()) {
            System.out.println("Mauvaise sÃ©lection");
            System.out.print("SVP, sélectionner une option de 1 à  " + String.valueOf(w.size()));
            try {
                selection = Integer.parseInt(this.sc.nextLine());
            } catch (NumberFormatException e) {
                selection = -1;
            }
        }
        return w.get(selection - 1);
    }

    void close() {

        this.sc.close();
    }

    double getNote() {

        System.out.print("entrer la note de l'étudiant: ");
        double note;
        try {
            note = Double.parseDouble(this.sc.nextLine());
        } catch (NumberFormatException e) {
            note = -1;
        }
        while (note < 0 || note > 100) {
            System.out.println("Note invalide. Veuillez reesayer:");
            try {
                note = Double.parseDouble(this.sc.nextLine());
            } catch (NumberFormatException e) {
                note = -1;
            }
        }
        return note;
    }

    void listTousLesEtudiantsAvecMoyenne(
        final ArrayList<ArrayList<Object>> w) {

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("liste de tous les Ã©tudiants\n");
        System.out.println("Nom\t\t\tPrenom\t\tNumÃ©ro de Dossier\tCode Permanent\t\t\tMoyenne");
        System.out.println(
            "-------------------------------------------------------------------------------------------------------");
        listeNonNumerotee(w);

    }

    void listTousLesEtudiantsAvecMoyenneDansUnCours(
        final ArrayList<ArrayList<Object>> w,
        final String titreCours) {

        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("liste de tous les Ã©tudiants inscrits au cours " + titreCours);
        System.out.println("Nom\t\t\tPrenom\t\tNumÃ©ro de Dossier\tCode Permanent\t\t\tMoyenne");
        System.out.println(
            "-------------------------------------------------------------------------------------------------------");
        listeNonNumerotee(w);
        System.out.println();

    }

    int menuPrincipal() {

        UserInterface.clear();
        System.out.println();
        System.out.println("\t\tMenu principal");
        System.out.println("\t-----------------------------------------------------");
        System.out.println("\t 1. Affichage de la liste de tous les étudiants");
        System.out.println("\t 2. Affichage de la liste des étudiants inscrits à un cours");
        System.out.println("\t 3. Ajout d'un nouvel étudiant");
        System.out.println("\t 4. Suppression d'un étudiant");
        System.out.println("\t 5. Inscription d'un étudiant à un cours");
        System.out.println("\t 6. Désinscription d'un étudiant d'un cours");
        System.out.println("\t 7. Entrée ou modification de la note d'un étudiant à un cours");
        System.out.println("\t 8. Sortir de l'application");
        System.out.println("\t------------------------------------------------------");
        System.out.println();
        System.out.print("\tSVP, sélectionner une option de 1 à 8");
        System.out.println();
        System.out.println();
        int size = 8;
        int selection;
        try {
            selection = Integer.parseInt(this.sc.nextLine());
        } catch (NumberFormatException e) {
            selection = -1;
        }
        while (selection < 1 || selection > size) {
            System.out.println("Mauvaise sÃ©lection");
            System.out.print("SVP, sÃ©lectionner une option de 1 Ã " + size);
            try {
                selection = Integer.parseInt(this.sc.nextLine());
            } catch (NumberFormatException e) {
                selection = -1;
            }
        }
        return selection;

    }

    void msg(
        final String text) {

        System.out.println(text);
    }

    private void listeNonNumerotee(
        final ArrayList<ArrayList<Object>> w) {

        if (w != null) {
            for (int i = 0; i < w.size(); i++) {
                for (int j = 0; j < w.get(i)
                    .size(); j++) {
                    int blankcount;
                    if (w.get(i)
                        .get(j) != null) {
                        blankcount =
                            24
                                - w.get(i)
                                    .get(j)
                                    .toString()
                                    .length();
                        System.out.print(
                            w.get(i)
                                .get(j));
                    } else {
                        blankcount = 24;
                    }
                    for (int blank = 0; blank < blankcount; blank++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    private void listeNumerotee(
        final ArrayList<ArrayList<Object>> w) {

        if (w != null) {
            int colCount =
                w.get(0)
                    .size();
            int largeur[] = new int[colCount];
            for (int j = 0; j < colCount; j++) {
                largeur[j] = 0;
            }
            for (int i = 0; i < w.size(); i++) {
                for (int j = 0; j < colCount; j++) {
                    int len =
                        w.get(i)
                            .get(j)
                            .toString()
                            .length();
                    if (len > largeur[j]) {
                        largeur[j] = len;
                    }
                }
            }
            for (int i = 0; i < w.size(); i++) {
                System.out.print(i + 1 + ") ");
                for (int j = 0; j < w.get(i)
                    .size(); j++) {
                    int blankcount;
                    if (w.get(i)
                        .get(j) != null) {
                        blankcount =
                            largeur[j]
                                + 3
                                - w.get(i)
                                    .get(j)
                                    .toString()
                                    .length();
                        System.out.print(
                            w.get(i)
                                .get(j));
                    } else {
                        blankcount = largeur[j] + 3;
                    }
                    for (int blank = 0; blank < blankcount; blank++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

}
