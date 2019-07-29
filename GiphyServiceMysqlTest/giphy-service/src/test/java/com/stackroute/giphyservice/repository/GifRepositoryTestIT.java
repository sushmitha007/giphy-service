package com.stackroute.giphyservice.repository;


import com.stackroute.giphyservice.domain.Gif;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GifRepositoryTestIT {

    @Autowired
    GifRepository gifRepository;

    private Gif gif;

    @Before
    public void setUp() {
        gif = new Gif(10l,"gif123","gif","http:url","http:details","cheeseburger","awesome","user1","g","2018-10-11");

    }

    @After
    public void tearDown() {
        gif = null;
        gifRepository.deleteAll();
    }
    @Test
    public void testSaveGifSuccess() {
        gifRepository.save(gif);
        Gif fetchGif =gifRepository.findByGiphyId(gif.getGiphyId());
        Assert.assertEquals(fetchGif.getTitle(),gif.getTitle());
    }
    @Test
    public void testSaveGifFailure() {
       Gif newGif = new Gif(20l,"gif125","gif","http:url","http:details","burgerking","awesome","user2","g","2017-03-11");
       gifRepository.save(newGif);
       gifRepository.save(gif);
       Gif fetchGif = gifRepository.findByGiphyId(gif.getGiphyId());
       Assert.assertNotEquals(fetchGif,gif);

    }
    @Test
    public void testUpdateCaptionSuccess(){
        gifRepository.save(gif);
        Gif fetchGif = gifRepository.findByGiphyId(gif.getGiphyId());
        fetchGif.setCaption("updating the caption");
        gifRepository.save(fetchGif);
        Gif newGif = gifRepository.findByGiphyId(gif.getGiphyId());
        Assert.assertEquals("updating the caption" , newGif.getCaption());
    }
    @Test
    public void testUpdateCaptionFailure() {
        gifRepository.save(gif);
        Gif fetchGif = gifRepository.findByGiphyId(gif.getGiphyId());
        fetchGif.setCaption("updating the caption");
        gifRepository.save(fetchGif);
        Assert.assertNotEquals(gif,fetchGif);
    }
    @Test
    public void testDeleteGifSuccess() {
        gifRepository.save(gif);
        Gif fetchGif = gifRepository.findByGiphyId(gif.getGiphyId());
        gifRepository.delete(fetchGif);
        Assert.assertEquals(Optional.empty(), gifRepository.findById(gif.getGifId()));
    }
    @Test
    public void testDeleteGifFailure() {
        Gif newGif = new Gif(20l,"gif125","gif","http:url","http:details","burgerking","awesome","user2","g","2017-03-11");
        gifRepository.save(newGif);
        gifRepository.save(gif);
        Gif fetchGif = gifRepository.findByGiphyId(newGif.getGiphyId());
        gifRepository.delete(fetchGif);
        System.out.println(gifRepository.findByGiphyId(gif.getGiphyId()));
        Assert.assertNotEquals(false,gifRepository.findByGiphyId(gif.getGiphyId()));
    }
    @Test
    public void testGetAllGifs() {
        Gif newGif = new Gif(20l,"gif125","gif","http:url","http:details","burgerking","awesome","user2","g","2017-03-11");
        gifRepository.save(newGif);
        gifRepository.save(gif);
        List<Gif> gifList = gifRepository.findAll();
        Assert.assertEquals(2,gifList.size());
        Assert.assertEquals("gif125",gifList.get(0).getGiphyId());

    }


}
