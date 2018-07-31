package com.revature.oopprinciples;

public abstract class ClothingTop {
	static int articleCount = 0;
	private int articleId;
	private boolean isClean;
	private Color color1;
	private Color color2;
	private Color color3;
	Pattern pattern;
	
	
	public ClothingTop() {
		this(Color.BLACK, null, Pattern.SOLID);
	}
	
	public ClothingTop(Pattern pattern) {
		this(Color.BLACK, null, pattern);
	}
	
	public ClothingTop(Color color1) {
		this(color1, null, Pattern.SOLID);
	}
	
	public ClothingTop(Color color1, Pattern pattern) {
		this(color1, null, pattern);
	}
	
	public ClothingTop(Color color1, Color color2, Pattern pattern) {
		super();
		articleCount++;
		this.articleId = articleCount;
		this.color1 = color1;
		this.color2 = color2;
		this.pattern = pattern;
	}

	public void Wash() {
		//Washing the garment
		this.isClean = true;
	}
	
	public void Wear() {
		this.isClean = false;
	}

	public int getArticleId() {
		return articleId;
	}

	public boolean isClean() {
		return isClean;
	}

	public Color getColor1() {
		return color1;
	}

	public Color getColor2() {
		return color2;
	}

	public Pattern getPattern() {
		return pattern;
	}
	
	
}
