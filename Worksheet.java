
public class Worksheet {
	String theme;
	String title;
	int numberOfWords;
	boolean anyWordQuestion;
	int lengthOfWord;
	Object blanks;
	Object showBlanks;
	
	
	public Worksheet()
	{
		
	}
	
	public void setTitle(String titleSelection)
	{
		this.title = titleSelection;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTheme(String themeSelection)
	{
		this.theme = themeSelection;
	}
	
	public String getTheme()
	{
		return this.theme;
	}
	
	
	public void setNumberOfWords(int numberOfWordsChosen)
	{
		this.numberOfWords = numberOfWordsChosen;
	}
	
	public int getNumberOfWords()
	{
		return numberOfWords;
	}
	
	public void setAnyWordQuestion(Boolean anyWordAnswer)
	{
		this.anyWordQuestion = anyWordAnswer;
	}
	
	public Boolean getAnyWordQuestion()
	{
		return this.anyWordQuestion;
	}
	
	public void setLengthOfWord(int minimumLengthOfWordChosen)
	{
		this.lengthOfWord = minimumLengthOfWordChosen;
	}
	
	public int getLengthOfWord()
	{
		return this.lengthOfWord;
	}
	
	public void setBlanks(Object blanksSelection)
	{
		this.blanks = blanksSelection;
	}
	
	public Object getBlanks()
	{
		return this.blanks;
	}
	
	public void setShowBlanks(Object showBlanksSelection)
	{
		this.showBlanks = showBlanksSelection;
	}
	
	public Object getShowBlanks()
	{
		return this.showBlanks;
	}
	
	
	
	
	public void OneBlankAtBeginningOfWord()
	{
		
	}
	
	public void OneBlankAtEndOfWord()
	{
		
	}
	public void OneBlankAtRandomLocation()
	{
		
	}
	public void MultipleBlanksAtConsonants()
	{
		
	}
	public void MultipleBlanksAtVowels()
	{
		
	}
	public void ShowBlankLetters()
	{
		
	}
}
