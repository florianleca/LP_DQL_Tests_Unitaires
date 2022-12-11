package tp1_PointColore;

public class Point {

	private float abscisse;
	private float ordonnee;
	public static final Point POINT_ORIGINE = new Point(0.0F, 0.0F);

	public Point(float abscisse, float ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	public float getAbscisse() {
		return this.abscisse;
	}

	public float getOrdonnee() {
		return this.ordonnee;
	}

	public void translater(float tx, float ty) {
		this.abscisse += tx;
		this.ordonnee += ty;
	}

	public void mettreAEchelle(float h) throws IllegalArgumentException {
		if (h <= 0.0F)
			throw new IllegalArgumentException("facteur erroné" + h);
		this.abscisse *= h;
		this.ordonnee *= h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return Float.floatToIntBits(abscisse) == Float.floatToIntBits(other.abscisse)
				&& Float.floatToIntBits(ordonnee) == Float.floatToIntBits(other.ordonnee);
	}


}
