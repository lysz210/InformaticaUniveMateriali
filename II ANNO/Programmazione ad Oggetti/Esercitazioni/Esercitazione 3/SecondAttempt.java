class Potion
{
    public void spray( Creature aCreature )
    {
	aCreature.getSprayed( this );
    }

    public void performSpray( Creature aCreature )
    {
	System.out.println( "Potion sprayed on Creature" );
    } 
    public void performSpray( Troll aCreature )
    {
	System.out.println("Potion sprayed on Troll" );
    } 
    public void performSpray( Ant aCreature )
    {
	System.out.println("Potion sprayed on Ant" );
    } 
}

class TrollPotion extends Potion
{
    public void performSpray( Creature aCreature )
    {
	System.out.println( "TrollPotion sprayed on Creature" );
    }
    public void performSpray( Troll aCreature )
    {
	System.out.println( "TrollPotion sprayed on Troll" );
    }
    public void performSpray( Ant aCreature )
    {
	System.out.println( "TrollPotion sprayed on Ant" );
    }

}

class AntPotion extends Potion
{
    public void performSpray( Creature aCreature )
    {
	System.out.println( "AntPotion sprayed on Creature" );   
    }
    public void performSpray( Ant aCreature )
    {
	System.out.println( "AntPotion sprayed on Ant" );
    }
    public void performSpray( Troll aCreature )
    {
	System.out.println( "AntPotion sprayed on Troll" );
    }
}

class Creature 
{
    public void getSprayed( Potion aPotion )
    {
	aPotion.performSpray( this );
    }
}

class Troll extends Creature 
{
}

class Ant extends Creature 
{
}

class SecondAttempt 
{
    public static void main(String[] args)
    {

	Potion container = null;
	Creature aCreature = null;

	// test Potion on different creatures
	container = new Potion();

	aCreature = new Creature();
	container.spray( aCreature );

	aCreature = new Troll();
	container.spray( aCreature );

	aCreature = new Ant();
	container.spray( aCreature );

	// test TrollPotion on different creatures
	container = new TrollPotion();

	aCreature = new Creature();
	container.spray( aCreature );

	aCreature = new Troll();
	container.spray( aCreature );

	aCreature = new Ant();
	container.spray( aCreature );

	// test AntPotion on different creatures
	container = new AntPotion();

	aCreature = new Creature();
	container.spray( aCreature );

	aCreature = new Troll();
	container.spray( aCreature );

	aCreature = new Ant();
	container.spray( aCreature );
    }
}

