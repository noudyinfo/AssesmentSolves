package com.synchronoss.test;
import org.testng.annotations.Test;
import com.pageObjects.iplTeam.IPL;
import java.io.IOException;

public class IPLCricketTeamTest {
	
	@Test
	public void parseJson() throws IOException  {
		
		IPL ipl = new IPL();
		ipl.getIPLDetails();
		int foreignPlayers = ipl.getForeignPlayers();
		int wicketKeeper = ipl.getWicketKeeper();

		if(foreignPlayers == 4 && wicketKeeper >= 1) {
        	System.out.println("Test Passed, Number of foreignPlayers = "+foreignPlayers+ " and wicket keeper= "+wicketKeeper);
        } else {
        	System.out.println("Test Failed");
        }

	}

}
