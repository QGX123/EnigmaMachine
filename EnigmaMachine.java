import hsa.*;
public class EnigmaMachine
{
    public static void main (String[] args)
    {
	String keyboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String labelIII = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String rotorIII = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
	String labelII = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String rotorII = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
	String labelI = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String rotorI = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	String labelReflector = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String reflector = "EJMZALYXVBWFCRQUONTSPIKHGD";
	String settings = "";

	int position = -1;
	char letter = 0;

	Stdout.print ("Please enter your initial setting:");
	settings = Stdin.readString ();

	position = labelI.indexOf (settings.charAt (0));
	labelI = labelI.substring (position) + labelI.substring (0, position);
	rotorI = rotorI.substring (position) + rotorI.substring (0, position);

	position = labelII.indexOf (settings.charAt (1));
	labelII = labelII.substring (position) + labelII.substring (0, position);
	rotorII = rotorII.substring (position) + rotorII.substring (0, position);

	position = labelIII.indexOf (settings.charAt (2));
	labelIII = labelIII.substring (position) + labelIII.substring (0, position);
	rotorIII = rotorIII.substring (position) + rotorIII.substring (0, position);

	do
	{
	    do
	    {
		do
		{
		    letter = Stdin.readChar ();

		    position = keyboard.indexOf (letter);
		    letter = rotorIII.charAt (position);
		    position = labelIII.indexOf (letter);
		    letter = rotorII.charAt (position);
		    position = labelII.indexOf (letter);
		    letter = rotorI.charAt (position);
		    position = labelI.indexOf (letter);
		    letter = reflector.charAt (position);

		    position = labelReflector.indexOf (letter);
		    letter = labelI.charAt (position);
		    position = rotorI.indexOf (letter);
		    letter = labelII.charAt (position);
		    position = rotorII.indexOf (letter);
		    letter = labelIII.charAt (position);
		    position = rotorIII.indexOf (letter);
		    letter = keyboard.charAt (position);

		    Stdout.println (letter);

		    labelIII = labelIII.substring (1) + labelIII.charAt (0);
		    rotorIII = rotorIII.substring (1) + rotorIII.charAt (0);
		}
		while (labelIII.charAt (0) != settings.charAt (2));

		labelII = labelII.substring (1) + labelII.charAt (0);
		rotorII = rotorII.substring (1) + rotorII.charAt (0);
	    }
	    while (labelII.charAt (0) != settings.charAt (1));

	    labelI = labelI.substring (1) + labelI.charAt (0);
	    rotorI = rotorI.substring (1) + rotorI.charAt (0);
	}
	while (true);
    }
}
