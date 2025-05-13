package eventbooking;

public class Event {
	private String title;
    private int availableTickets;
    Event(String title, int availableTickets){
        this.title=title;
        this.availableTickets=availableTickets;
    }
    public boolean isAvailable(){
        return availableTickets>0;
    }
    public void setAvailableTickets(int tickets) {
    	this.availableTickets=tickets;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAvailableTickets() {
		return availableTickets;
	}
    

}

    

