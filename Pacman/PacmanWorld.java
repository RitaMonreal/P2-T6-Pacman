import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PacmanWorld extends World
{
    private static final int WIDTH_WALL = 28;
    private static final int HEIGHT_WALL = 28;

    public PacmanWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Wall wall = new Wall();

        for(int x = 50; x < 560; x+= WIDTH_WALL)
        {
            wall = new Wall();
            addObject(wall,x,23);

            wall = new Wall();
            addObject(wall,x,350);
        }

        for(int y = 50; y < 200; y+= HEIGHT_WALL)
        {
            wall = new Wall();
            addObject(wall,50,y);

            wall = new Wall();
            addObject(wall,554,y);
        }

        Banana banana = new Banana();
        addObject(banana,320,129);
        BigBall bigBall = new BigBall();
        addObject(bigBall,440,272);
        BigBall bigBall2 = new BigBall();
        addObject(bigBall2,89,304);
        BigBall bigBall3 = new BigBall();
        addObject(bigBall3,499,61);
        Cherry cherry = new Cherry();
        addObject(cherry,213,213);
        Cherry cherry2 = new Cherry();
        addObject(cherry2,422,91);
        Cherry cherry3 = new Cherry();
        addObject(cherry3,532,293);
        Cherry cherry4 = new Cherry();
        addObject(cherry4,288,303);
        SmallBall smallBall = new SmallBall();
        addObject(smallBall,324,221);
        SmallBall smallBall2 = new SmallBall();
        addObject(smallBall2,484,142);
        SmallBall smallBall3 = new SmallBall();
        addObject(smallBall3,91,70);
        SmallBall smallBall4 = new SmallBall();
        addObject(smallBall4,165,296);
        Strawberry strawberry = new Strawberry();
        addObject(strawberry,218,74);
        Strawberry strawberry2 = new Strawberry();
        addObject(strawberry2,410,190);
        Strawberry strawberry3 = new Strawberry();
        addObject(strawberry3,77,247);
        Strawberry strawberry4 = new Strawberry();
        addObject(strawberry4,552,240);
        Banana banana2 = new Banana();
        addObject(banana2,250,267);
        Banana banana3 = new Banana();
        addObject(banana3,367,295);
        Banana banana4 = new Banana();
        addObject(banana4,149,180);
        Cherry cherry5 = new Cherry();
        addObject(cherry5,254,139);
        Strawberry strawberry5 = new Strawberry();
        addObject(strawberry5,258,202);
        BigBall bigBall4 = new BigBall();
        addObject(bigBall4,338,70);

        PacmanHud hud = new PacmanHud();
        addObject(hud, 0, 0);
        
        Pacman pacman = new Pacman(hud);
        addObject(pacman, 130, 110);
    }
}
