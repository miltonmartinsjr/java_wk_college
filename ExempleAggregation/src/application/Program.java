package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Cours;
import model.entities.Eleves;

public class Program {

    public static void main(
        final String[] args,
        final String titre,
        final int unite) {

        Scanner scan = new Scanner(System.in);
        Eleves eleves = new Eleves();
        Cours cours = new Cours(cours, titre, unite);

        List<Eleves> catolgueEleves = new ArrayList<>();
        List<Cours> catolgueCours = new ArrayList<>();

        scan.close();

    }

}
