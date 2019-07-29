package com.stackroute.giphyservice.service;

import com.stackroute.giphyservice.domain.Gif;
import com.stackroute.giphyservice.exception.GifAlreadyExistsException;
import com.stackroute.giphyservice.exception.GifNotFoundException;
import org.slf4j.Logger;

import java.util.List;

/*
 * Service classes are used here to implement additional business logic/validation
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn't currently
 * provide any additional behavior over the @Component annotation, but it's a good idea
 * to use @Service over @Component in service-layer classes because it specifies intent
 * better. Additionally, tool support and additional behavior might rely on it in the
 * future.
 * */

public class GifServiceImpl implements GifService {


    /*
     * Autowiring should be implemented for the GifRepository. (Use
     * Constructor-based autowiring) Please note that we should not create any
     * object using the new keyword.
     */

    /*
    Create an instance for logger and use it for logging messages
     */
    private static final Logger LOGGER = null;




    /*
     * This method should be used to save a new gif.Call the corresponding
     * method of Respository interface.
     */
    public Gif saveGifToWishList(Gif gif) throws GifAlreadyExistsException {
        return null;
    }




    /*
     * This method should be used to delete a gif.Call the corresponding
     * method of Respository interface.
     */
    public boolean deleteGifFromWishList(Long gifId) throws GifNotFoundException {
       return false;
    }


    /*
     * This method should be used to update caption for existing gif.Call the corresponding
     * method of Respository interface.
     */
    public Gif updateCaptionForGif(String caption, Long gifId) throws GifNotFoundException {
        return null;
    }



    /*
     * This method should be used to get all the gifs from database.Call the corresponding
     * method of Respository interface.
     */

    public List<Gif> getAllGifsFromWishList() throws Exception {
        return null;
    }




    /*
     * This method should be used to get a gif for specific giphyId.Call the corresponding
     * method of Respository interface.
     */
    public Gif getByGiphyId(String giphyId) {
        return null;
    }
}