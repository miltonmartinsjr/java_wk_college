package tpDB1;

import java.util.ArrayList;
import java.util.Arrays;

public class Logic {

    public class Etudiant {
        int codePermanent;

        String nom;

        int numeroDossier;

        String prenom;
    }
    //
    // public class Cours{
    // int Id_Cours;
    // String Titre;
    // }
    // public class etudiant_cours{
    // int Id_Cours;
    // int NumeroDossier;
    // double note;
    // }

    // Activer les couches Donées et Interface Utilisateur
    Requetes myBD = new Requetes();

    UserInterface myUI = new UserInterface();

    public Logic() {

    }

    public static void main(
        final String[] args) {

        new Logic().execute();

    }

    public void execute() {

        boolean boucle = true;
        while (boucle) {
            boucle = sousMenu(this.myUI.menuPrincipal());
        }
        System.out.println("Au revoir");
        this.myUI.close();
        this.myBD.close();
    }

    private boolean sousMenu(
        final int menuPrincipalChoix) {

        switch (menuPrincipalChoix) {
            case 1: {
                // 1. La liste de tous les étudiants
                this.myUI
                    .listTousLesEtudiantsAvecMoyenne(this.myBD.queryTousLesEtudiantsAvecMoyenne());
            }
                break;

            case 2: {
                // 2. Affichage de la liste des étudiants inscrits à un cours

                ArrayList<Object> selectedLine =
                    this.myUI.choix(this.myBD.queryTousLesCours(), "Choisissez un cours");
                this.myUI.listTousLesEtudiantsAvecMoyenneDansUnCours(
                    this.myBD.queryTousLesEtudiantsDunCours((int) selectedLine.get(0)),
                    (String) selectedLine.get(1));

                ArrayList<ArrayList<Object>> resultat =
                    this.myBD.queryMoyenneDunCours((int) selectedLine.get(0));
                if (resultat.get(0)
                    .get(0) != null) {
                    this.myUI.msg(
                        "Moyenne du groupe: "
                            + (double) resultat.get(0)
                                .get(0));
                } else {
                    this.myUI.msg("Pas de moyenne pour ce groupe");
                }

                ArrayList<ArrayList<Object>> Liste =
                    this.myBD.queryToutesLesNotesDunCours((int) selectedLine.get(0));
                String median = "";
                if (Liste.size() > 0) {
                    double[] notes = new double[Liste.size()];

                    for (int j = 0; j < notes.length; j++) {
                        notes[j] =
                            (double) Liste.get(j)
                                .get(0);
                    }
                    Arrays.sort(notes);
                    if (notes.length % 2 == 0) {
                        median = "" + (notes[notes.length / 2] + notes[notes.length / 2 - 1]) / 2;
                    } else {
                        median = "" + notes[notes.length / 2];
                    }
                }
                this.myUI.msg("Médiane du groupe: " + median);
                this.myUI.msg("\n---------------------------");

            }
                break;

            case 3: {
                // 3. Ajout d'un nouvel étudiant
                Etudiant unEtudiant = new Etudiant();
                this.myUI.ajouterEtudiant(unEtudiant);
                this.myBD.insertUnEtudiant(unEtudiant);
            }
                break;

            case 4: {
                // 4. Suppression d'un étudiant
                this.myUI.msg("\n---------------------------\nSuppression d'un étudiant");
                ArrayList<Object> selectedLine =
                    this.myUI.choix(
                        this.myBD.queryTousLesEtudiants(),
                        "Choisissez l'étudiant à  supprimer:");
                this.myBD.deleteUnEtudiant((int) selectedLine.get(0));

            }
                break;

            case 5: {
                // 5. Inscription d'un étudiant à  un cours
                this.myUI
                    .msg("\n---------------------------\nInscription d'un étudiant à un cours");
                ArrayList<Object> selectedStudent =
                    this.myUI.choix(
                        this.myBD.queryTousLesEtudiants(),
                        "Choisissez l'étudiant à inscrire:");
                ArrayList<Object> selectedCourse =
                    this.myUI.choix(
                        this.myBD
                            .queryTousLesCoursPourInscrireUnEtudiant((int) selectedStudent.get(0)),
                        "Choisissez le cours auquel inscrire l'étudiant:");
                this.myBD.insertInscriptionDunEtudiantAUnCours(
                    (int) selectedStudent.get(0),
                    (int) selectedCourse.get(0));
                this.myUI.msg(
                    "---------------------------\n"
                        + "étudiant "
                        + selectedStudent.get(2)
                        + ", "
                        + selectedStudent.get(3)
                        + " inscrit au cours "
                        + selectedCourse.get(1)
                        + "\n---------------------------");

            }
                break;

            case 6: {
                // Désinscription d'un étudiant d'un cours
                this.myUI
                    .msg("\n---------------------------\nDésInscription d'un étudiant d'un cours");
                ArrayList<Object> selectedStudent =
                    this.myUI.choix(
                        this.myBD.queryTousLesEtudiants(),
                        "Choisissez l'étudiant à désinscrire:");
                ArrayList<Object> selectedCourse =
                    this.myUI.choix(
                        this.myBD.queryTousLesCoursDunEtudiant((int) selectedStudent.get(0)),
                        "Choisissez le cours duquel désinscrire l'étudiant:");
                this.myBD.deleteInscriptionDunEtudiantAUnCours(
                    (int) selectedStudent.get(0),
                    (int) selectedCourse.get(0));
                this.myUI.msg(
                    "---------------------------\n"
                        + "étudiant "
                        + selectedStudent.get(2)
                        + ", "
                        + selectedStudent.get(3)
                        + " désinscrit du cours "
                        + selectedCourse.get(1)
                        + "\n---------------------------");
            }
                break;

            case 7: {
                // 7. Modification de la note d'un étudiant
                this.myUI
                    .msg("\n---------------------------\nModification de la note d'un étudiant");
                ArrayList<Object> selectedStudent =
                    this.myUI.choix(
                        this.myBD.queryTousLesEtudiants(),
                        "Choisissez l'étudiant auquel modifier la note:");
                ArrayList<Object> selectedCourse =
                    this.myUI.choix(
                        this.myBD.queryTousLesCoursDunEtudiant((int) selectedStudent.get(0)),
                        "Choisissez le cours auquel changer la note de l'étudiant:");
                Double note = this.myUI.getNote();

                this.myBD.updateNotesDunEtudiantDansUnCours(
                    (int) selectedStudent.get(0),
                    (int) selectedCourse.get(0),
                    note);
                this.myUI.msg(
                    "---------------------------\n"
                        + "étudiant "
                        + selectedStudent.get(2)
                        + ", "
                        + selectedStudent.get(3)
                        + "dans le cours "
                        + selectedCourse.get(1)
                        + " a reçu la note : "
                        + note
                        + "\n---------------------------");
            }
                break;

        } // end switch
        if (menuPrincipalChoix == 8) {
            return false;
        } else {
            String reponse = "";
            while (!reponse.equals("1")) {
                System.out.println("Entrez 1 pour retourner au menu principal");
                System.out.println();
                reponse = this.myUI.sc.nextLine();
            }
            return true;
        }
    }

}
