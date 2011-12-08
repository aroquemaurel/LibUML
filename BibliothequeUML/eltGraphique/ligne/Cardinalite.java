package eltGraphique.ligne;

/**
 *
 * @author satenske
 */
public class Cardinalite {
	private String min;
	private String max;
	private boolean visible = false;

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
