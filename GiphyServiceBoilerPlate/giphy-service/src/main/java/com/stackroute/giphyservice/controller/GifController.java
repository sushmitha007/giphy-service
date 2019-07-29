package com.stackroute.giphyservice.controller;


import org.slf4j.Logger;

public class GifController {
    /*
     * Autowiring should be implemented for the GifService. (Use
     * Constructor-based autowiring) Please note that we should not create any
     * object using the new keyword
     */

    //Create an instance of logger and Use logger to log the messages
    private static final Logger LOGGER = null;

    /*
     * Define a handler method which will save a gif into database
     *Please note that the giphyId has to be unique.This
     * handler method should return any one of the status messages basis on
     * different situations:
     * 1. 201(CREATED - In case of successful creation of the gif
     * 2. 409(CONFLICT) - In case of duplicate giphyId
     *
     *
     * This handler method should map to the URL "/api/v1/giphyservice/gif" using HTTP POST
     * method".
     */
    public void saveGifToWishList(){
    }



    /*
     * Define a handler method which will delete a gif from a database.
     *
     * This handler method should return any one of the status messages basis on
     * different situations: 1. 200(OK) - If the gif deleted successfully from
     * database. 2. 404(NOT FOUND) - If the gif with specified gifId is
     * not found.
     *
     * This handler method should map to the URL "/api/v1/giphyservice/gif/{gifId}" using HTTP Delete
     * method"
     */
    public void deleteGifFromWishList() {
    }




    /*
     * Define a handler method which will update caption for a specific gif
     * and save updated details in database.This handler method should return any one of the status
     * messages basis on different situations: 1. 200(OK) - If the gif updated
     * successfully. 2. 404(NOT FOUND) - If the gif with specified gifId
     * is not found.
     * This handler method should map to the URL "/api/v1/giphyservice/gif/{gifId}" using HTTP PATCH
     * method.
     */

    public void updateCaptionForGif() {
    }




    /*
     * Define a handler method which will get all gifs from the database.
     * This handler method should return any one of the status
     * messages basis on different situations: 1. 200(OK) - If the gifs are found successfully.
     * This handler method should map to the URL "/api/v1/giphyservice/gifs" using HTTP GET
     * method.
     */

    public void getAllGifsFromWishList() {

    }

}
