package professeur;

public interface RegistreProfesseur {

    Professeur creer(
        Professeur professeur_);

    Professeur modifier(
        Professeur professeur_);

    Professeur obtenir(
        Professeur professeur_);

    void suprimer(
        Professeur professeur_);

}
