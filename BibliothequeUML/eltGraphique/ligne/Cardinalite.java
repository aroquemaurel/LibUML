package eltGraphique.ligne;

/**
 *
 * @author satenske
 */
public class Cardinalite {
	private String min;
	private String max;
	private boolean visible = false;

	public Cardinalite(String p_min, String p_max) {
		this.min = p_min;
		this.max = p_max;
	}

	public Cardinalite(String p_min, String p_max, boolean p_visible) {
		this.min = p_min;
		this.max = p_max;
		this.visible = p_visible;
	}

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
