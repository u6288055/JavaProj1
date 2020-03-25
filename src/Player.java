// Nithinee Trironarith 6288055 sec 2
public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};
	
	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player
	private int numSpecialTurns;

	private boolean taunted;
	
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
				taunted = false;
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

		return false;
	}
	
	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		//INSERT YOUR CODE HERE
		if(Player.this.isCursed()){
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
		if(getCurrentHP()>0){
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
		if(this.taunted){
			return true;
		}
		return false;
	}
	
	
	public void attack(Player target)
	{	
		//INSERT YOUR CODE HERE
		target.currentHP = target.maxHP - atk;
	}
	
	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{	
		//INSERT YOUR CODE HERE
	}
	
	
	/**
	 * This method is called by Arena when it is this player's turn to take an action. 
	 * By default, the player simply just "attack(target)". However, once this player has 
	 * fought for "numSpecialTurns" rounds, this player must perform "useSpecialAbility(myTeam, theirTeam)"
	 * where each player type performs his own special move. 
	 * @param arena
	 */
	public void takeAction(Arena arena)
	{	
		//INSERT YOUR CODE HERE
		if()
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
