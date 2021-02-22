package tpDB1;

import java.util.ArrayList;

public class Requetes {
    private final ServiceBD myServiceBD;

    public Requetes() {

        this.myServiceBD = new ServiceBD();
    }

    public void close() {

        this.myServiceBD.close();
    }

    public int deleteInscriptionDunEtudiantAUnCours(
        final int numeroDossier,
        final int Id_cours) {

        String sql =
            "delete from etudiant_cours where numerodossier = "
                + numeroDossier
                + " and id_cours = "
                + Id_cours;

        return this.myServiceBD.executeUpdate(sql);
    }

    public int deleteUnEtudiant(
        final int numeroDossier) {

        String sql = "delete from etudiant where numerodossier = " + numeroDossier;
        return this.myServiceBD.executeUpdate(sql);
    }

    public int insertInscriptionDunEtudiantAUnCours(
        final int numeroDossier,
        final int Id_cours) {

        String sql =
            "insert into etudiant_cours(id_cours, numeroDossier, note) values ("
                + Id_cours
                + ","
                + numeroDossier
                + ", 0.0)";

        return this.myServiceBD.executeUpdate(sql);
    }

    public int insertUnEtudiant(
        final Logic.Etudiant e) {

        String sql =
            "insert into etudiant(numeroDossier, codePermanent, prenom, nom) values("
                + e.numeroDossier
                + ","
                + e.codePermanent
                + ",'"
                + e.prenom
                + "','"
                + e.nom
                + "')";
        return this.myServiceBD.executeUpdate(sql);
    }

    public ArrayList<ArrayList<Object>> queryMoyenneDunCours(
        final int Id_cours) {

        String sql = "select avg(note) from etudiant_cours where id_cours = " + Id_cours;

        return this.myServiceBD.executeQuery(sql);
    }

    public ArrayList<ArrayList<Object>> queryTousLesCours() {

        String sql = "select * from cours";

        return this.myServiceBD.executeQuery(sql);
    }

    public ArrayList<ArrayList<Object>> queryTousLesCoursDunEtudiant(
        final int numeroDossier) {

        String sql =
            "select c.* from etudiant_cours ec, cours c where ec.numerodossier = ec.numerodossier and ec.numeroDossier = "
                + numeroDossier;

        return this.myServiceBD.executeQuery(sql);
    }

    public ArrayList<ArrayList<Object>> queryTousLesCoursPourInscrireUnEtudiant(
        final int numeroDossier) {

        String sql =
            "select c.* from cours c where c.id_cours not in (select distinct id_cours from etudiant_cours where numeroDossier = "
                + numeroDossier
                + ")";

        return this.myServiceBD.executeQuery(sql);
    }

    public ArrayList<ArrayList<Object>> queryTousLesEtudiants() {

        String sql = "select * from etudiant ";

        return this.myServiceBD.executeQuery(sql);
    }

    public ArrayList<ArrayList<Object>> queryTousLesEtudiantsAvecMoyenne() {

        String sql =
            "SELECT e.nom, e.prenom, e.NumeroDossier, e.CodePermanent, AVG(ec.note) "
                + "FROM etudiant AS e "
                + "LEFT JOIN etudiant_cours AS ec " // *TOUS* les �tudiants,
                                                    // alors *LEFT* JOIN
                + "ON e.NumeroDossier = ec.NumeroDossier "
                + "GROUP BY e.NumeroDossier";

        return this.myServiceBD.executeQuery(sql);
    }

    public ArrayList<ArrayList<Object>> queryTousLesEtudiantsDunCours(
        final int Id_cours) {

        String sql =
            "select e.*, ec.note from etudiant e, etudiant_cours ec where e.numerodossier = ec.numerodossier and  id_cours = "
                + Id_cours;

        return this.myServiceBD.executeQuery(sql);
    }

    public ArrayList<ArrayList<Object>> queryToutesLesNotesDunCours(
        final int Id_cours) {

        String sql = "select note from etudiant_cours ec where Id_cours = " + Id_cours;

        return this.myServiceBD.executeQuery(sql);
    }

    public int updateNotesDunEtudiantDansUnCours(
        final int numeroDossier,
        final int Id_cours,
        final double note) {

        String sql =
            "update etudiant_cours set note = "
                + note
                + " where numerodossier = "
                + numeroDossier
                + " and id_cours="
                + Id_cours;

        return this.myServiceBD.executeUpdate(sql);
    }

}
