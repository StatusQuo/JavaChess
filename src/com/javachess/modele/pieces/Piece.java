package com.javachess.modele.pieces;

import com.javachess.helpers.Couleur;
import com.javachess.helpers.Coup;
import com.javachess.modele.plateau.Case;
import com.javachess.modele.plateau.Echiquier;

//TODO: une piece A un mode de d�placement ? Ca pourrait �tre plus pratique...

/**
 * Cette classe repr�sente le template d'une pi�ce d'�chec. Chaque pi�ce est
 * repr�sent�e par une couleur et une position.
 * 
 * @author Ouzned
 */
public abstract class Piece {
	private Couleur color;
	private Case position;
	private Case positionInitiale;
	
	public Piece(Couleur couleur, Case position) {
		this.color = couleur;
		this.position = position;
		this.positionInitiale = position;
	}
	
	/**
	 * V�rifie si la pi�ce peut se d�placer � newPos Cette m�thode ne v�rifie
	 * pas les mouvements d'attaque d'une pi�ce (mouvement diagonal pour le pion
	 * par exemple)
	 * 
	 * @param newPos
	 * @return Vrai si la pi�ce peut se d�placer en newPos
	 */
	public abstract boolean attaquePossible(Coup coup, Echiquier echiquier);

	/**
	 * V�rifie si la pi�ce peut attaquer la case du coup sp�cifi�.
	 * 
	 * @param newPos
	 * @return Vrai si la pi�ce peut attaquer (et prendre une pi�ce adverse)
	 */
	public abstract boolean mouvementPossible(Coup coup, Echiquier echiquier);

	/**
	 * Indique si le d�placement indiquait par le coup est possible
	 * @param coup
	 * @param echiquier
	 * @param isAttaque
	 * @return
	 */
	public boolean deplacementPossible(Coup coup, Echiquier echiquier, boolean isAttaque) {
		if (isAttaque)
			return this.attaquePossible(coup, echiquier);
		else
			return this.mouvementPossible(coup, echiquier);
	}

	public Couleur getColor() {
		return color;
	}

	public void setColor(Couleur color) {
		this.color = color;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
	}

	public Case getPositionInitiale() {
		return positionInitiale;
	}

	public void setPositionInitiale(Case positionInitiale) {
		this.positionInitiale = positionInitiale;
	}
}
