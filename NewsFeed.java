import java.util.ArrayList;

/**
 * Write a description of class NewsFeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewsFeed
{
    // Guarda los mensajes de los post de los usuarios
    private ArrayList<MessagePost> messages;
    // Guarada las imagenes de los post
    private ArrayList<PhotoPost> photos;

    /**
     * Constructor for objects of class NewsFeed
     */
    public NewsFeed()
    {
        messages = new ArrayList<>();
        photos = new ArrayList<>();
    }

    /**
     * Añade um MessagePost a nuestra coleccion
     */
    public void addMessagePost(MessagePost message)
    {
        messages.add(message);
    }
    
    /**
     * Añade um PhotoPost a nuestra coleccion
     */
    public void addPhotoPost(PhotoPost photo)
    {
        photos.add(photo);
    }
    
    /**
     * Muestra primero los post de texto y después los post de foto 
     */
    public void show()
    {
        for (MessagePost message : messages) {
            message.display();
        }
        
        for (PhotoPost photo: photos) {
            photo.display();
        }
    }
}
