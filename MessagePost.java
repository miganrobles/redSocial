import java.util.ArrayList;

/**
 * Write a description of class MessagePost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MessagePost
{
    // instance variables - replace the example below with your own
    // El nombre de usuario autor
    private String username;
    // guarda el texto del mensaje.
    private String message;
    // guarda el momento temporal en el que fue creado
    private long timestamp;
    // guarda los me gusta el post
    private int likes;
    // guarda los comentarios de los usuarios
    private ArrayList<String> comments;

    /**
     * Constructor for objects of class MessagePost
     */
    public MessagePost(String author, String text)
    {
        username = author;
        message = text;
        comments = new ArrayList<>();
        timestamp = System.currentTimeMillis();
        likes = 0;
    }
    
    /**
     * Añade un voto positivo 
     */
    public void like() 
    {
        likes++;
    }
    
    /**
     * Da un voto negativo
     */
    public void unlike()
    {
        likes--;
        if (likes < 0) {
            likes = 0;
        }
    }
    
    /**
     * Añade los comentarios realizados por los usuarios
     */
    public void addComment(String text)
    {
        comments.add(text);
    }
    
    /**
     * Devuelve el texto del post
     */
    public String getText()
    {
        return message;
    }
    
    /**
     * Devuelve el tiempo en milisegundos entre la medianoche del 1 de 
     * enero de 1970 y el momento en el que se ha creado el post
     */
    public long getTimeStamp()
    {
        return timestamp;
    }
    
    /**
     * Muestra todas las caracteristicas de las entradas. 
     */
    public void display()
    {
        System.out.println("Nombre de autor: " + username);
        System.out.println("Texto del mensaje: " + message);
        System.out.println("Número de me gustas: " + likes);
        System.out.println(timeString(System.currentTimeMillis()));
        if (!comments.isEmpty()) {
            System.out.println("Comentarios de usuarios añadidos al post:");
            for (String text : comments) {;
                System.out.println(text);
            }
        }
        else {
            System.out.println("No se ha añadido ningún comentario");
        }
    }
    
    /**
     * Devuelve un String con los datos en una presentación adecuada 
     * entre la entrada del post y la hora en que se visualiza
     */
    private String timeString(long time)
    {
        final int SEGUNDOS_DIA = 86400;
        final int SEGUNDOS_HORA = 3600;
        final int SEGUNDOS_MINUTO = 60;
        long segundos = (time - timestamp) / 1000;
        String timeString = "El post se ha creado hace ";
        if (segundos / SEGUNDOS_DIA > 0) {
            timeString += (segundos / SEGUNDOS_DIA) + " día/s ";
            segundos = segundos % SEGUNDOS_DIA;
        }
        if (segundos / SEGUNDOS_HORA > 0) {
            timeString += (segundos / SEGUNDOS_HORA) +  " hora/s ";
            segundos = segundos % SEGUNDOS_HORA;
        }
        if (segundos / SEGUNDOS_MINUTO > 0) {
            timeString += (segundos / SEGUNDOS_MINUTO) + " minuto/s ";
            segundos = segundos % SEGUNDOS_MINUTO;
        }
        if (segundos > 0) {
            timeString += segundos + " segundo/s ";
        }
        return timeString;
    }
}
