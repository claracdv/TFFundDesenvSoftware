package com.claraVicente.AmigoSuite;

import com.claraVicente.AmigoSuite.Entidades.Bairro;
import com.claraVicente.AmigoSuite.Entidades.Cidade;

/**
 * AmigoSuite
 *
 */
public class App{
    public static void main( String[] args ){
        Cidade portoAlegre = new Cidade("Porto Alegre");
        Bairro partenon = new Bairro("Partenon", 100, portoAlegre);
        Bairro rioBranco = new Bairro("RioBranco", 250, portoAlegre);
        portoAlegre.adicionaBairro(partenon);
        portoAlegre.adicionaBairro(rioBranco);
    }
}
