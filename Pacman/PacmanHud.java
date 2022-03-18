import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PacmanHud extends Actor
{
    private int score;
    private int level;
    private int lifes;
    
    public void act(){
        refresh();
    }
    
    public void refresh()
    {
        getWorld().showText("Score: " + score, 150, 25);
        getWorld().showText("Level: " + level, 300, 25);
        getWorld().showText("Lifes: " + lifes, 450, 25);
    }
    
    public void setScore(int score){
        this.score = score;
    }
}
