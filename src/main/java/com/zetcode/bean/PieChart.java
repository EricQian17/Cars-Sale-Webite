package com.zetcode.bean;

public class PieChart {
	private boolean exploded;
	private float y;
	private String label;
	
	public PieChart() {}
	
	public PieChart(boolean exploded, float y, String label) {
		super();
		this.exploded = exploded;
		this.y = y;
		this.label = label;
	}

	public boolean isExploded() {
		return exploded;
	}
	public float getY() {
		return y;
	}
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return "PieChart [exploded=" + exploded + ", y=" + y + ", label=" + label + "]";
	}
	
	
	

}
