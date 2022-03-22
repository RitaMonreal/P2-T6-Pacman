import greenfoot.*;  
import java.io.*;//Para leer achivos
import java.util.List;//Para listas

public class Level1 extends World
{
    //Variables del mundo
    private final int WORLD_WIDTH = getWidth();//Obtiene el ancho del área de trabajo
    private final int WORLD_HEIGHT = getHeight();//Obtiene el largo del área de trabajo

    //Variables de los actores para su creación
    Wall wallTemplate = new Wall();//Crea el objeto de pared 
    GreenfootImage wtImg = wallTemplate.getImage();//Obtiene la imagen que se le asocia la objeto

    SmallBall sBallTemplate = new SmallBall();
    GreenfootImage sBImg = sBallTemplate.getImage();

    BigBall bBallTemplate = new BigBall();
    GreenfootImage bBImg = bBallTemplate.getImage();

    Cherry cherryTemplate = new Cherry();
    GreenfootImage cImg = cherryTemplate.getImage();
    
    Strawberry strawberryTemplate = new Strawberry();
    GreenfootImage sImg = strawberryTemplate.getImage();
    
    
    //Varibles del tamaño de los actores
    private final int ITEM_HEIGHT = wtImg.getHeight();//Obtiene el ancho de la imagen la hace única y la fija al tamaño
    private final int ITEM_WIDTH = wtImg.getWidth();//Obtiene el alto de la imagen la hace única y la fija al tamaño

    //Variables tamaño del mapa y archivo
    private final int MAP_WIDTH = (int)(WORLD_WIDTH/ITEM_WIDTH);
    private final int MAP_HEIGHT = (int)(WORLD_HEIGHT/ITEM_HEIGHT);
    private final String FILE_NAME = "PacmanLevel1.txt";//El nombre del archivo que vamos a leer

    //Variables para inserttar
    private final String WALL = "X";//Lo que vamos a leer para que se cree el muro
    private final String SBALL = "b";
    private final String BBALL = "B";
    private final String CHERRY = "C";
    private final String SBERRY = "S";
    String[][] mapArray = new String[MAP_HEIGHT][MAP_WIDTH];//Cada figura tiene dos posiciones como un plano cartsiano

    public Level1() throws IOException
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(396, 308, 1); 
        mapArray = readMapFromTextFile(MAP_WIDTH, MAP_HEIGHT, FILE_NAME);
        drawFromText(ITEM_WIDTH,ITEM_HEIGHT,WALL,SBALL,BBALL,CHERRY,SBERRY,mapArray);
        //  drawWallFromTextArray(ITEM_WIDTH,ITEM_HEIGHT,SBALL_MARKER,mapArray);
        prepare();
    }

    //Método que inserta los objetos en el mundo
    public void drawFromText(int itemWidth,int itemHeight,String wall,String sball,String bball,String cherry,String sberry, String[][] mapArray)
    {
        int x = 0;
        int y = 0;

        for(y = 0; y < mapArray.length; y++)
        {
            for(x = 0; x < mapArray[y].length; x++)
            {
                int itemX = x*itemWidth - itemWidth/2;
                int itemY = y*itemHeight + itemHeight/2;
                if(mapArray[y][x].equals(wall))
                    addObject(new Wall(), itemX, itemY);
                else if(mapArray[y][x].equals(sball))
                    addObject(new SmallBall(), itemX, itemY);
                else if(mapArray[y][x].equals(bball))
                    addObject(new BigBall(), itemX, itemY);
                else if(mapArray[y][x].equals(cherry))
                    addObject(new Cherry(), itemX, itemY);
                else if(mapArray[y][x].equals(sberry))
                    addObject(new Strawberry(), itemX, itemY);
            }
        }
    }

    //Método que retorna un arreglo bidiomensional, lee el archivo
    public String[][] readMapFromTextFile(int mapWidth, int mapHeight, String fileName) throws IOException //Al leer un archivo pueden ṕasar muchas cosas mal, como tener el nombre incorrecto
    {
        BufferedReader reader = null;//Lee linea por línea el archivo, vaciamos el buffer
        String [][] mArray = new String[mapHeight][mapWidth];
        try{
            reader = new BufferedReader(new FileReader(fileName));//BufferedRead coge toda una fila de caracteres
            String line;//Representa la línea
            int mapRow = 0; //Conatdor de la filas leídas
            while((line = reader.readLine()) != null)
            {
                mArray[mapRow] = line.split("");
                mapRow++;//Aumenta la línea en donde estamos
            }
        }finally {//finally es para cerrar el archivo
            if(reader != null)
                reader.close();
        }
        return mArray;
    }
    

    private void prepare()
    {
    }
}



    