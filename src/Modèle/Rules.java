/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author cbl.ho
 */
public enum Rules {

    /**
     *
     */
    FR_TWO("DEROULEMENT D'UNE PARTIE:\n"
            + "Chaque tour, le joueur choisit entre déplacer son pion ou poser une barrière (jusqu'à ce qu'il n'y en ait plus).\n\n"
            + "DEPLACEMENT DES PIONS:\n"
            + "Les pions se déplacent d'une case (horizontalement ou verticalement), en avant ou en arrière.\nLes barrières doivent être contournées.\n\n"
            + "POSE DES BARRIERES:\n"
            + "Une barrière doit être posée sur deux intercases (grises) adjacentes et alignées horizontalement ou verticalement.\n"
            + "Elle ne peut pas complètement bloquer l'accès de l'adversaire à sa ligne de but.\n\n"
            + "FACE A FACE:\n"
            + "Quand 2 pions sont sur des cases voisines (sans barrière entre les 2), le joueur dont c'est le tour peut sauter son adversaire.\n"
            + "S'il y a une barrière derrière l'adversaire, le joueur peut se placer à droite ou à gauche de son adversaire.\n\n"
            + "FIN DE LA PARTIE:\n"
            + "Le premier joueur qui atteind une des cases de la ligne opposée à son départ gagne la partie."),
    FR_FOUR("DEROULEMENT D'UNE PARTIE:\n"
            + "Chaque tour, le joueur choisit entre déplacer son pion ou poser une barrière (jusqu'à ce qu'il n'y en ait plus).\n\n"
            + "DEPLACEMENT DES PIONS:\n"
            + "Les pions se déplacent d'une case (horizontalement ou verticalement), en avant ou en arrière.\nLes barrières doivent être contournées.\n\n"
            + "POSE DES BARRIERES:\n"
            + "Une barrière doit être posée sur deux intercases (grises) adjacentes et alignées horizontalement ou verticalement.\n"
            + "Elle ne peut pas complètement bloquer l'accès de l'adversaire à sa ligne de but.\n\n"
            + "FACE A FACE:\n"
            + "Quand 2 pions sont sur des cases voisines (sans barrière entre les 2), le joueur dont c'est le tour peut sauter son adversaire (1 seul adversaire sauté par tour).\n"
            + "S'il y a une barrière derrière l'adversaire, le joueur peut se placer à droite ou à gauche de son adversaire.\n\n"
            + "FIN DE LA PARTIE:\n"
            + "Le premier joueur qui atteind une des cases de la ligne opposée à son départ gagne la partie."),
    ENG_TWO("GAMEPLAY:\n"
            + "Each player in turn, chooses to move his pawn or to put up one of his fences. When he has run out of fences, the player must move his pawn.\n\n"
            + "PAWN MOVES:\n"
            + "The pawns are moved one square at a time, horizontally or vertically, forwards or backwards.\n"
            + "The pawns must get around the fences.\n\n"
            + "POSITIONING OF THE FENCES:\n"
            + "Walls are flat two-space-wide pieces which can be placed between 2 sets of 2 squares.\n"
            + "The fences can be used to facilitate the player’s progress or to impede that of the opponent, however, an access to the goal line must always be left open.\n\n"
            + "FACE TO FACE:\n"
            + "When two pawns face each other on neighboring squares which are not separated by a fence, the player whose turn it is can jump the opponent's pawn (and place himself behind him), thus advancing an extra square.\n"
            + "If there is a fence behind the said pawn, or the square behind him is out of the board, the player can place his pawn to the left or the right of the other pawn.\n\n"
            + "END OF THE GAME:\n"
            + "The first player who reaches any of the squares opposite his base line is the winner."),
    ENG_FOUR("GAMEPLAY:\n"
            + "Each player in turn, chooses to move his pawn or to put up one of his fences. When he has run out of fences, the player must move his pawn.\n\n"
            + "PAWN MOVES:\n"
            + "The pawns are moved one square at a time, horizontally or vertically, forwards or backwards.\n"
            + "The pawns must get around the fences.\n\n"
            + "POSITIONING OF THE FENCES:\n"
            + "Walls are flat two-space-wide pieces which can be placed between 2 sets of 2 squares.\n"
            + "The fences can be used to facilitate the player’s progress or to impede that of the opponent, however, an access to the goal line must always be left open.\n\n"
            + "FACE TO FACE:\n"
            + "When two pawns face each other on neighboring squares which are not separated by a fence, the player whose turn it is can jump the opponent's pawn (and place himself behind him), thus advancing an extra square.\n"
            + "If there is a fence behind the said pawn, or the square behind him is out of the board, the player can place his pawn to the left or the right of the other pawn.\n"
            + "You can't jump more than one opponent's pawn in the same turn.\n\n"
            + "END OF THE GAME:\n"
            + "The first player who reaches any of the squares opposite his base line is the winner."),
    FR_EXTRA(""),
    ENG_EXTRA("");
    private final String desc;

    private Rules(String text) {
        this.desc = text;
    }

}
