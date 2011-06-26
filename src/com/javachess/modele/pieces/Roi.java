package com.javachess.modele.pieces;

import com.javachess.helpers.Couleur;
import com.javachess.helpers.Coup;
import com.javachess.helpers.PositionConverter;
import com.javachess.modele.plateau.Case;
import com.javachess.modele.plateau.Echiquier;
//TODO: le rock
//TODO: ne pas pouvoir se d�placer si le roi ennemi est sur une case adjacente
public class Roi extends Piece {

	private boolean isEchec = false;
	
	public Roi(Couleur couleur, Case position) {
		super(couleur, position);
	}

	@Override
	public boolean attaquePossible(Coup coup, Echiquier echiquier) {
		return mouvementPossible(coup, echiquier);
	}

	@Override
	public boolean mouvementPossible(Coup coup, Echiquier echiquier) {
		Case caseSrc = coup.getCaseSource();
		Case caseDest = coup.getCaseDestination();
		
		Case[] casesPossible = PositionConverter.getCasesAdjacentes(caseSrc);
		
		for (int index = 0; index < casesPossible.length; index++) {
			if (casesPossible[index].equals(caseDest))
				return true;
		}
		
		return false;
	}

	public boolean isEchec() {
		return isEchec;
	}

	public void setEchec(boolean isEchec) {
		this.isEchec = isEchec;
	}
}
