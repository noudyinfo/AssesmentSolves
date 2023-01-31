package com.pageObjects.iplTeam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class IPL {

	public int foreignPlayers;
	public int wicketKeeper;
	public String jsonPath;
	
	public IPL()
	{
		this.foreignPlayers=0;
		this.wicketKeeper=0;
		this.jsonPath = System.getProperty("user.dir") + "//src//test//resources//CricketTeam.json";
	}
	
	public int getForeignPlayers() {
		return foreignPlayers;
	}

	public void setForeignPlayers(int foreignPlayers) {
		this.foreignPlayers = foreignPlayers;
	}

	public int getWicketKeeper() {
		return wicketKeeper;
	}

	public void setWicketKeeper(int wicketKeeper) {
		this.wicketKeeper = wicketKeeper;
	}

	public void getIPLDetails() throws IOException
	{
		String text = new String(Files.readAllBytes(Paths.get(this.jsonPath)), StandardCharsets.UTF_8);
        JSONObject obj = new JSONObject(text);
        JSONArray jsonArray = obj.getJSONArray("player");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject objects = jsonArray.getJSONObject(i);
            if(objects.has("country") && objects.has("role")) {
            	String country = (String)objects.get("country");
            	String role = (String)objects.get("role");
            	if(!country.equalsIgnoreCase("India")) {
            		this.foreignPlayers = this.foreignPlayers + 1;
            	}
            	if(role.equalsIgnoreCase("Wicket-keeper")) {
            		this.wicketKeeper = this.wicketKeeper + 1;
            	}
            }
        }
		
	}

}
