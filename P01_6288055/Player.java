import java.util.List;

// Nithinee Trironarith 6288055 sec 2
public class Player {

	public int turn;

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	private int numSpecialTurns;

	private boolean taunted;
	private boolean slash;
	private boolean curse;
	private boolean cookie;
	private boolean tanky;


	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)
	{
		switch(_type){
			case Healer:
				maxHP = 4790;
				atk = 238;
				numSpecialTurns = 4;
				type = PlayerType.Healer;
				break;
			case Tank:
				maxHP = 5340;
				atk = 255;
				numSpecialTurns = 4;
				type = PlayerType.Tank;
				tanky = false;
				break;
			case Samurai:
				maxHP = 4005;
				atk = 368;
				numSpecialTurns = 3;
				type = PlayerType.Samurai;
				break;
			case BlackMage:
				maxHP = 4175;
				atk = 303;
				numSpecialTurns = 4;
				type = PlayerType.BlackMage;
				break;
			case Phoenix:
				maxHP = 4175;
				atk = 209;
				numSpecialTurns = 8;
				type = PlayerType.Phoenix;
				break;
			case Cherry:
				maxHP = 3560;
				atk = 198;
				numSpecialTurns = 4;
				type = PlayerType.Cherry;
				break;
		}
		this.currentHP = this.maxHP;
		turn=0;
		cookie = false;
		curse = false;
		taunted=false;
		//INSERT YOUR CODE HERE
	}
	
	/**
	 * Returns the current HP of this player
	 * @return
	 */
	public double getCurrentHP()
	{
		//INSERT YOUR CODE HERE
		return this.currentHP;
	}
	
	/**
	 * Returns type of this player
	 * @return
	 */
	public Player.PlayerType getType()
	{
		//INSERT YOUR CODE HERE
		return this.type;
	}
	
	/**
	 * Returns max HP of this player. 
	 * @return
	 */
	public double getMaxHP()
	{
		//INSERT YOUR CODE HERE
		return this.maxHP;
	}
	
	/**
	 * Returns whether this player is sleeping.
	 * @return
	 */
	public boolean isSleeping()
	{
		//INSERT YOUR CODE HERE
		if(cookie==true){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		//INSERT YOUR CODE HERE
		if(curse==true){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive()
	{
		//INSERT YOUR CODE HERE
		if(currentHP >0){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether this player is taunting the other team.
	 * @return
	 */
	public boolean isTaunting()
	{
		//INSERT YOUR CODE HERE
		if(taunted == true){
			return true;
		}
		return false;
	}

	/*public Player lowestHP(List<Player> team){
		Player target = (Player) team;
		double minhp = 1000000;
		for(Player character: team){
			if(character.currentHP<minhp) {
				minhp = character.currentHP;
				target = character;
				System.out.println(target);
			}
		}

		return target;
	}*/

	public Player lowestHP(Player[][] team){
		Player target = null;
		double minHP = 100000;
		for(int i=0;i<team.length;i++){
			for (int j=0;j<team[0].length;j++){
				if(team[i][j].currentHP<minHP){
					if(team[i][j].isAlive()){
					minHP = team[i][j].currentHP;
					target = team[i][j];
					}
				}
			}
		}return target;
	}
	public void slash(Player target){
		if(isAlive()){
			attack(target);
			attack(target);
		}
	}
	
	public void attack(Player target)
	{	
		//INSERT YOUR CODE HERE
		target.currentHP = target.currentHP - atk;
	}
	
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{	
		//INSERT YOUR CODE HERE
		//find lowest hp
		switch (this.getType()){
			case Healer:
				for(int i=0;i<myTeam.length;i++){
					for(int j=0;j<myTeam[0].length;j++){
						if(myTeam[i][j].curse){
							break;
						}
					}
				}
					lowestHP(myTeam).currentHP = lowestHP(myTeam).currentHP + (0.25 * lowestHP(myTeam).maxHP);
				break;
			case Tank:
				for(int i =0;i<theirTeam.length;i++){
					for (int j=0;j<theirTeam[0].length;j++){
						theirTeam[i][j].taunted=true;
					}
				}
				tanky=true;
				break;
			case Samurai:
				slash(lowestHP(theirTeam));
				break;
			case Phoenix:
				for(int i =0;i<myTeam.length;i++){
					for (int j=0;j<myTeam[0].length;j++){
						if(myTeam[i][j].curse){
							break;
						}
						if(myTeam[i][j].currentHP<=0){
							myTeam[i][j].currentHP=0.30*4175;
							myTeam[i][j].taunted = false;
							myTeam[i][j].curse = false;
							myTeam[i][j].turn =0;
							break;
						}
					}
				}
			case BlackMage:
				lowestHP(theirTeam).curse = true;
				break;
			case Cherry:
				for(int i =0;i<theirTeam.length;i++){
					for (int j=0;j<theirTeam[0].length;j++){
						theirTeam[i][j].cookie=true;
					}
				}
		}
	}
	
	
	/**
	 * This method is called by Arena when it is this player's turn to take an action. 
	 * By default, the player simply just "attack(target)". However, once this player has 
	 * fought for "numSpecialTurns" rounds, this player must perform "useSpecialAbility(myTeam, theirTeam)"
	 * where each player type performs his own special move. 
	 * @param arena
	 */
	public void takeAction(Arena arena) {
		//INSERT YOUR CODE HERE
		if(arena.isMemberOf(this, Arena.Team.A)){
			if(this.cookie==true){
				turn--;
			}
			else{
				if(turn==numSpecialTurns){
					useSpecialAbility(arena.getTeamA(),arena.getTeamB());
					turn = 0;
				}
				else {
					if(this.taunted){
						attack(tank(arena.getTeamB()));
					}
					else{
						attack(lowestHP(arena.getTeamB()));
					}
				}
			}
		}
		else {
			if(this.cookie==true){
				turn--;
			}
			else {
				if(turn==numSpecialTurns){
					useSpecialAbility(arena.getTeamB(),arena.getTeamA());
					turn = 0;
				}
				else {
					if(this.taunted){
						attack(tank(arena.getTeamA()));
					}
					else{
						attack(lowestHP(arena.getTeamA()));
					}
				}
			}
		}
	}

	public Player tank(Player[][] zoom){
		for(int i=0;i<zoom.length;i++){
			for (int j=0;j<zoom[0].length;j++){
				if(zoom[i][j].tanky==true){
					return zoom[i][j];
				}
			}
		}
		return null;
	}

	/**
	 * This method overrides the default Object's toString() and is already implemented for you. 
	 */
	@Override
	public String toString()
	{
		return "["+this.type.toString()+" HP:"+this.currentHP+"/"+this.maxHP+" ATK:"+this.atk+"]["
				+((this.isCursed())?"C":"")
				+((this.isTaunting())?"T":"")
				+((this.isSleeping())?"S":"")
				+"]";
	}
	
	
}
