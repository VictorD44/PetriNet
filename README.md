# Fil Rouge MAPD

Implementation of a Petri Net

## Authors

Arthur LOIZEAU

Victor DANTAS

## Code version

This project run with Eclipse 4.33.0 and a JRE build 17.0.13

## Starting 

You can create your own PetriNet : execute **org.pneditor.editor.Main.java**.

## Tests

Tests are integrated in 2 ways :

1- Each method contains tests for both the inputs and outputs

2- Each class is tested via JUnit tests

In order to run the tests, you can execute the different classes in the **org.pneditor.petrinet.tests.imta** package as JUnit Test


Code implémentant un réseau de Pétri.
Pour l'exécuter, il faut lancer la classe Main en construisant le réseau dans la fenêtre grâce aux divers outils (Transition, Place, Arc...).
Ce code fonctionne avec eclipse 4.33.0 sous JRE build 17.0.13
Des tests sont intégrés au modèle de deux manières :
  1- chaque méthode contient des tests sur les variables d'entrée et/ou sur le résultat de sortie
  2- chaque classe est testé à l'aide de fichiers JUnit dans le package test (les sous-classes de Arc sont testés directement dans TestArc)

Des modifications légères ont eu lieu entre la conception et l'implémentation :
  -changement de noms de variables/méthodes/classes afin de respecter les règles de bon usage
  -ajout de constantes minimales afin de respecter les règles de bon usage~~
  -ajouts de getters utiles pour l'adaptation
