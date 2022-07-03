package rental.commands;

public interface Command {
     CommandType commandName();

     void execute();
}
