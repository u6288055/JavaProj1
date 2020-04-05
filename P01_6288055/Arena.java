import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Arena {

	public enum Row {Front, Back};	//enum for specifying the front or back row
	public enum Team {A, B};		//enum for specifying team A or B
	
	private Player[][] teamA = null;	//two dimensional array representing the players of Team A
	private Player[][] teamB = null;	//two dimensional array representing the players of Team B
	private int numRowPlayers = 0;		//number of players in each row
	
	public static final int MAXROUNDS = 100;	//Max number of turn
	public static final int MAXEACHTYPE = 3;	//Max number of players of each type, in each team.
	private final Path logFile = Paths.get("battle_log.txt");
	
	private int numRounds = 0;	//keep track of the number of rounds so far

	/*
	thefuckisthiswhatamisupposetodoidontgiveafuckiknowhowtodobutidontknowhowtowritemyfriendsandmysisterhelpmebutitisntenoughsomeofmyfriendcantevenhelpmeiamhelpless
	thisisnohopeshouldithrowmyscoreandgetthegradeDorshouldicopysomeoneelsetootomakethemfailwithmelikeoncemysistergot?
	iwantmyfreetimeyetidontwanttolosemyscoreyougivemenochoiceifonlyicouldcontactteacherorsomeonewhowillinglytoteachmeiwouldappreciatealot
	whynobodytheretohelpmewhyicanhelptheotherwhynobodyrespondingmewhy!ifitwasntbecauseofpandedmicrightnowiwouldburnthewholeschoolwithmyragingheadandheartandsoul
	yesiamsobadandithoughtmaybeicouldgotoamazonandgeteatenbyanyanimalatleastmyproposeisbiggerthanwhatamidoingnowwhatamigetbydoingthese?
	whyamihatethissomuchitfeellikeidonthaveanysupportmyhouseisagarbagethatdoesntevensmelliamsofrustratedyetnobodycareandstillyouwontcareforthismessageeither
	iwishyouagoodluckwiththesaltthatyougaveittomehaveabadday!!
	 */
	
	/**
	 * Constructor. 
	 * @param _numRowPlayers is the number of players in each row.
	 */
	public Arena(int _numRowPlayers)
	{	
		//INSERT YOUR CODE HERE
		teamA = new Player[2][_numRowPlayers];
		teamB = new Player[2][_numRowPlayers];
		this.numRowPlayers = _numRowPlayers;

		////Keep this block of code. You need it for initialize the log file. 
		////(You will learn how to deal with files later)
		try {
			Files.deleteIfExists(logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////
		
	}

	public Player[][] getTeamA() {
		return teamA;
	}

	public Player[][] getTeamB() {
		return teamB;
	}
	
	/**
	 * Returns true if "player" is a member of "team", false otherwise.
	 * Assumption: team can be either Team.A or Team.B
	 * @param player
	 * @param team
	 * @return
	 */
	public boolean isMemberOf(Player player, Team team)
	{
		//INSERT YOUR CODE HERE
		switch (team) {
			case A:
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < numRowPlayers; j++) {
						if (teamA[i][j].equals(player)) {
							return true;
						}
					}
				}
				break;
			case B:
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < numRowPlayers; j++) {
						if (teamB[i][j].equals(player)) {
							return true;
						}
					}
				}
				break;
		}
		return false;
	}
	
	
	
	/**
	 * This methods receives a player configuration (i.e., team, type, row, and position), 
	 * creates a new player instance, and places him at the specified position.
	 * @param team is either Team.A or Team.B
	 * @param pType is one of the Player.Type  {Healer, Tank, Samurai, BlackMage, Phoenix}
	 * @param row	either Row.Front or Row.Back
	 * @param position is the position of the player in the row. Note that position starts from 1, 2, 3....
	 */
	public void addPlayer(Team team, Player.PlayerType pType, Row row, int position)
	{	
		//INSERT YOUR CODE HERE
		Player girl = new Player(pType);
		//int theRow = row.ordinal();
		switch (team){
			case A:
				switch (row){
					case Front:
						teamA[0][position - 1] = girl;
						break;
					case Back:
						teamA[1][position - 1] = girl;
						break;
				}
				break;
			case B:
				switch (row){
					case Front:
						teamB[0][position - 1] = girl;
						break;
					case Back:
						teamB[1][position - 1] = girl;
						break;
				}
				break;
		}
	}
	
	
	/**
	 * Validate the players in both Team A and B. Returns true if all of the following conditions hold:
	 * 
	 * 1. All the positions are filled. That is, there each team must have exactly numRow*numRowPlayers players.
	 * 2. There can be at most MAXEACHTYPE players of each type in each team. For example, if MAXEACHTYPE = 3
	 * then each team can have at most 3 Healers, 3 Tanks, 3 Samurais, 3 BlackMages, and 3 Phoenixes.
	 * 
	 * Returns true if all the conditions above are satisfied, false otherwise.
	 * @return
	 */
	public boolean validatePlayers()
	{
		//INSERT YOUR CODE HERE
		int counth =0;
		int countt =0;
		int counts =0;
		int countm =0;
		int countp =0;
		int countc =0;
		for (int i=0;i<teamA.length;i++) {
			for (int j=0;j<teamA[0].length;j++) {
				if (Player.PlayerType.Healer.equals(teamA[i][j])) {
					counth++;
				} else if (Player.PlayerType.Tank.equals(teamA[i][j])) {
					countt++;
				} else if (Player.PlayerType.Samurai.equals(teamA[i][j])) {
					counts++;
				} else if (Player.PlayerType.BlackMage.equals(teamA[i][j])) {
					countm++;
				} else if (Player.PlayerType.Phoenix.equals(teamA[i][j])) {
					countp++;
				} else if (Player.PlayerType.Cherry.equals(teamA[i][j])) {
					countc++;
				}
			}
		}
		int numh =0;
		int numt =0;
		int nums =0;
		int numm =0;
		int nump =0;
		int numc =0;
		for (int i=0;i<teamB.length;i++) {
			for (int j=0;j<teamB[0].length;j++) {
				if (Player.PlayerType.Healer.equals(teamB[i][j])) {
					numh++;
				} else if (Player.PlayerType.Tank.equals(teamB[i][j])) {
					numt++;
				} else if (Player.PlayerType.Samurai.equals(teamB[i][j])) {
					nums++;
				} else if (Player.PlayerType.BlackMage.equals(teamB[i][j])) {
					numm++;
				} else if (Player.PlayerType.Phoenix.equals(teamB[i][j])) {
					nump++;
				} else if (Player.PlayerType.Cherry.equals(teamB[i][j])) {
					numc++;
				}
			}
		}
		if(numRowPlayers*2>teamA[0].length*teamA.length){
			return false;
		}
		else if(numRowPlayers*2>teamB[0].length*teamB.length){
			return false;
		}
		else if(numRowPlayers*2==teamA[0].length*teamA.length){
			if(numh>MAXEACHTYPE){
				return false;
			}
			else if(countt>MAXEACHTYPE){
				return false;
			}
			else if(counts>MAXEACHTYPE){
				return false;
			}
			else if(countm>MAXEACHTYPE){
				return false;
			}
			else if(countp>MAXEACHTYPE){
				return false;
			}
			else if(countc>MAXEACHTYPE){
				return false;
			}
		}
		else if(numRowPlayers*2==teamB[0].length*teamB.length){
			if(numh>MAXEACHTYPE){
				return false;
			}
			else if(numt>MAXEACHTYPE){
				return false;
			}
			else if(nums>MAXEACHTYPE){
				return false;
			}
			else if(numm>MAXEACHTYPE){
				return false;
			}
			else if(nump>MAXEACHTYPE){
				return false;
			}
			else if(numc>MAXEACHTYPE){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Returns the sum of HP of all the players in the given "team"
	 * @param team
	 * @return
	 */
	public static double getSumHP(Player[][] team)
	{
		//INSERT YOUR CODE HERE
		double add=0;
		for(int i=0;i<team.length;i++){
			for (int j=0;j<team[0].length;j++){
				add += team[i][j].getCurrentHP();
			}
		}
		return add;
	}
	
	/**
	 * Return the team (either teamA or teamB) whose number of alive players is higher than the other. 
	 * 
	 * If the two teams have an equal number of alive players, then the team whose sum of HP of all the
	 * players is higher is returned.
	 * 
	 * If the sums of HP of all the players of both teams are equal, return teamA.
	 * @return
	 */

	public int inTeam(Player[][] team){
		int alive=0;
		for (int i=0;i<team.length;i++){
			for (int j=0;j<team[0].length;j++){
				if(team[i][j].isAlive()){
					alive++;
				}
			}
		}
		return alive;
	}

	public Player[][] getWinningTeam()
	{
		//INSERT YOUR CODE HERE	
		if(inTeam(teamA)<inTeam(teamB)){
			return teamB;
		}
		else if(inTeam(teamA)==inTeam(teamB)){
			return teamB;
		}
		return teamA;
	}
	
	/**
	 * This method simulates the battle between teamA and teamB. The method should have a loop that signifies
	 * a round of the battle. In each round, each player in teamA invokes the method takeAction(). The players'
	 * turns are ordered by its position in the team. Once all the players in teamA have invoked takeAction(),
	 * not it is teamB's turn to do the same. 
	 * 
	 * The battle terminates if one of the following two conditions is met:
	 * 
	 * 1. All the players in a team has been eliminated.
	 * 2. The number of rounds exceeds MAXROUNDS
	 * 
	 * After the battle terminates, report the winning team, which is determined by getWinningTeam().
	 */
	public void startBattle()
	{
		//INSERT YOUR CODE HERE
		for(int m=0;m<MAXROUNDS;m++){
			if(getSumHP(teamA)<=0){
				break;
			}
			else if(getSumHP(teamB)<=0){
				break;
			}
			else{
				for(int i=0;i<teamA.length;i++){
					for (int k = 0; k < teamA[0].length; k++) {
						if(teamA[i][k].isAlive()){
							teamA[i][k].turn++;
							teamA[i][k].takeAction(this);
							numRounds++;
							m++;
							this.logAfterEachRound();
						}
					}
				}
				for(int i=0;i<teamB.length;i++){
					for (int k = 0; k < teamB[0].length; k++) {
						if(teamB[i][k].isAlive()){
							teamB[i][k].turn++;
							teamB[i][k].takeAction(this);
							numRounds++;
							m++;
							this.logAfterEachRound();
						}
					}
				}
		}
		}
	}
	
	
	
	/**
	 * This method displays the current area state, and is already implemented for you.
	 * In startBattle(), you should call this method once before the battle starts, and 
	 * after each round ends. 
	 * 
	 * @param arena
	 * @param verbose
	 */
	public static void displayArea(Arena arena, boolean verbose)
	{
		StringBuilder str = new StringBuilder();
		if(verbose)
		{
			str.append(String.format("%43s   %40s","Team A","")+"\t\t"+String.format("%-38s%-40s","","Team B")+"\n");
			str.append(String.format("%43s","BACK ROW")+String.format("%43s","FRONT ROW")+"  |  "+String.format("%-43s","FRONT ROW")+"\t"+String.format("%-43s","BACK ROW")+"\n");
			for(int i = 0; i < arena.numRowPlayers; i++)
			{
				str.append(String.format("%43s",arena.teamA[1][i])+String.format("%43s",arena.teamA[0][i])+"  |  "+String.format("%-43s",arena.teamB[0][i])+String.format("%-43s",arena.teamB[1][i])+"\n");
			}
		}
	
		str.append("@ Total HP of Team A = "+getSumHP(arena.teamA)+". @ Total HP of Team B = "+getSumHP(arena.teamB)+"\n\n");
		System.out.print(str.toString());
		
		
	}
	
	/**
	 * This method writes a log (as round number, sum of HP of teamA, and sum of HP of teamB) into the log file.
	 * You are not to modify this method, however, this method must be call by startBattle() after each round.
	 * 
	 * The output file will be tested against the auto-grader, so make sure the output look something like:
	 * 
	 * 1	47415.0	49923.0
	 * 2	44977.0	46990.0
	 * 3	42092.0	43525.0
	 * 4	44408.0	43210.0
	 * 
	 * Where the numbers of the first, second, and third columns specify round numbers, sum of HP of teamA, and sum of HP of teamB respectively. 
	 */
	private void logAfterEachRound()
	{
		try {
			Files.write(logFile, Arrays.asList(new String[]{numRounds+"\t"+getSumHP(teamA)+"\t"+getSumHP(teamB)}), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
