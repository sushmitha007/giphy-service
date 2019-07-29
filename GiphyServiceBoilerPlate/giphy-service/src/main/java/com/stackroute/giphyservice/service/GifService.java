package com.stackroute.giphyservice.service;

import com.stackroute.giphyservice.domain.Gif;
import com.stackroute.giphyservice.exception.GifAlreadyExistsException;
import com.stackroute.giphyservice.exception.GifNotFoundException;

import java.util.List;

public interface GifService {
    /*
     * Should not modify this interface. You have to implement these methods in
     * corresponding Impl classes
     */

    Gif saveGifToWishList(Gif gif) throws GifAlreadyExistsException;

    boolean deleteGifFromWishList(Long gifId) throws GifNotFoundException;

    Gif updateCaptionForGif(String caption, Long gifId) throws GifNotFoundException;

    List<Gif> getAllGifsFromWishList() throws Exception;

    Gif getByGiphyId(String giphyId);

}
