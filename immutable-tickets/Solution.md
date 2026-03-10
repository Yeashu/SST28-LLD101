How I solved the issues:
In IncidentTicket set all the attributes to private final
remove all the setters , made the constructor private also made List unmodifiable
But still in TicketService we sometimes have to change priority and other fields also some of the fields in IncidentTicket are optionals Therefore we will use Builder class which will be a static class inside the IncidentTicket class , which will help to mutate the classes and in the end IncidentTicket will remain immutable.
Where we will add all setters and now IncidentTicket can only be created through builder, also it will Also take care of validation.