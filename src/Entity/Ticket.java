package Entity;

public class Ticket {
    private Attendee attendee;
	    private Event event;
	    private String status;
	  public Ticket(Attendee attendee, Event event){
		  this.attendee=attendee;
		  this.event=event;
		  this.status="Booked";
	}
	  public void cancel() {
		  this.status="Cancelled";
	  }
	  public String getStatus() {
		  return status;
	  }
	  public String ticketDetails() {
		  return "Ticket: " + attendee.name + " - " + event.getTitle() + " - " + status;
	  }
	  

}
