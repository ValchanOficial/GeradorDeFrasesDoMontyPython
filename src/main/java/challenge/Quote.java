package challenge;

public class Quote {
	private String actor;
    private String quote;

    public Quote() {
    }

    public Quote(String actor, String detail) {
        this.actor = actor;
        this.quote = detail;
    }

    public String getActor() {
		return this.actor;
	}
    
	public String getQuote() {
		return this.quote;
	}
	
    @Override
    public String toString() {
        return "Quote{" + "actor='" + actor + '\'' + ", detail='" + quote + '\'' + '}';
    }
    
    public String jsonToString() {
        return "{\r\n" + "\"actor\":\"" + actor + "\",\r\n" + "\"quote\":\"" + quote + "\"\r\n}";
    }
}